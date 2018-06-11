package com.ccbjb.service.zhiku.impl;

import com.ccbjb.common.domain.TZhikuCategory;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultCode;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.FTPUtil;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.common.utils.PropertiesUtil;
import com.ccbjb.common.utils.StringUtils;
import com.ccbjb.dao.TZhikuCategoryDao;
import com.ccbjb.service.zhiku.ICategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	TZhikuCategoryDao zhikuCategoryDao;

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Result findPage(Map<String, String> map, Integer pageNo,
                           Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<TZhikuCategory> list = zhikuCategoryDao.findAllCategories(map);
		PageInfo pageInfo = new PageInfo(list);

		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@Override
	@Transactional
	public void insertSelective(TZhikuCategory tZhikuCategory) {
		if(StringUtils.isBlank(tZhikuCategory.getId())){
			tZhikuCategory.setCreateTime(new Date());
			tZhikuCategory.setUpdateTime(new Date());
			zhikuCategoryDao.save(tZhikuCategory);
		}else{
			tZhikuCategory.setUpdateTime(new Date());
			zhikuCategoryDao.update(tZhikuCategory);
		}
	}

	@Transactional
	@Override
	public void deleteByPrimaryKey(Long id) {
		zhikuCategoryDao.deleteById(id);
	}

	@Override
	@Transactional
	public Result selectCategoryById(Long id) {
		TZhikuCategory category = zhikuCategoryDao.findById(id);

		category.setCategoryParents(zhikuCategoryDao.findCategoryParents());

		return ResultGenerator.genSuccessResult(category);
	}

	@Override
	public List<TZhikuCategory> findCategoryItems(Long categoryId) {
		return zhikuCategoryDao.findCategoryItems(categoryId);
	}

	@Override
	public Result uploadImage(HttpServletRequest request, MultipartFile image, Long categoryId) {
		String path = request.getSession().getServletContext().getRealPath("upload");
		String fileName = image.getOriginalFilename();
		String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
		String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
		File targetFile = new File(path, uploadFileName);
		File fileParent = targetFile.getParentFile();
		if(!fileParent.exists()) {
			fileParent.mkdirs();
		}
		if(!targetFile.exists()){
			try {
				targetFile.createNewFile();
			}catch (IOException e) {
			}
		}

		//保存
		try {
			image.transferTo(targetFile);
			List<File> files = new ArrayList<>();
			files.add(targetFile);
			FTPUtil.uploadFile(files);
			//已经上传到ftp服务器上

			targetFile.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		String resultPath = request.getContextPath()+"/upload/"+uploadFileName;
		String url = PropertiesUtil.getProperty("ftp.server.http.prefix")+targetFile.getName();
		return ResultGenerator.genSuccessResult(url);
	}

	@Override
	public PageInfo findCategoryItemsPage(Long categoryId,Integer pageNo,
										  Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<TZhikuCategory> list = zhikuCategoryDao.findCategoryItems(categoryId);
		PageInfo pageInfo = new PageInfo(list);
		return pageInfo;
	}

	@Override
	public Result selectCategoryParents() {
		return ResultGenerator.genSuccessResult(zhikuCategoryDao.findCategoryParents());
	}

	@Override
	@Transactional
	public Result deleteCategoryById(Long[] ids) {
		Result result = null;
		try {
			int count=0;
			String resultMsg = "";

			for (Long id : ids) {
				List<TZhikuCategory> dicItems = zhikuCategoryDao.findCategoryItems(id);
				if(CollectionUtils.isEmpty(dicItems)){
					this.deleteByPrimaryKey(id);
					count++;
				}else {
					return ResultGenerator.genFailResult(ResultCode.ERR_113);
				}
			}
			resultMsg = "成功删除"+count+"个消息！";
			result = ResultGenerator.genSuccessResult(resultMsg);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除消息出现错误，ids[%s]", ids);
			result = ResultGenerator.genFailResult();
		}
		return result;
	}

}
