package com.ccbjb.service.points.impl;

import com.ccbjb.common.domain.TCuts;
import com.ccbjb.common.domain.TPoints;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultCode;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.common.utils.StringUtils;
import com.ccbjb.dao.TCutsDao;
import com.ccbjb.dao.TPointsDao;
import com.ccbjb.model.points.TPointsModel;
import com.ccbjb.service.points.IPointsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@SuppressWarnings("unchecked")
public class PointServiceImpl implements IPointsService {

	@Autowired
	TPointsDao tPointsDao;
	@Autowired
	TCutsDao tCutsDao;


	@Transactional
	@Override
	public Result insertPoint(TPointsModel model) {
		Result result = null;
		try {
			TPoints point = new TPoints();
			point.setId(model.getId());
			point.setTitle(model.getTitle());
			point.setParentId(model.getParentId());
			point.setpOrder(model.getpOrder());
			if(StringUtils.isNotBlank(model.getType())) {
				point.setType(model.getType());
			}
			if(StringUtils.isNotBlank(model.getDetail())) {
				java.sql.Blob blob = new SerialBlob(model.getDetail().getBytes("utf-8"));
				point.setDetail(blob);
			}
			if(StringUtils.isBlank(point.getId())){
				tPointsDao.save(point);
			}else{
				tPointsDao.update(point);
			}
			result = ResultGenerator.genSuccessResult("成功添加了一个知识点");
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "添加知识点报错。source[%s]");
			result = ResultGenerator.genFailResult();
		}
		return result;
	}

	@Transactional
	@Override
	public void deletePointById(Long id) {
		tPointsDao.deleteById(id);
	}

	@Transactional
	@Override
	public void updatePoint(TPoints point) {
		tPointsDao.update(point);
	}

	@Transactional
	@Override
	public Result findPage(Map<String, String> resultMap,
                           Integer pageNo, Integer pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<TPoints> list = tPointsDao.findAllPoints(resultMap);
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@Transactional
	@Override
	public Result findAllPage(Map<String, String> resultMap, Integer pageSize) {
		List<TPoints> list = tPointsDao.findAllPoints(resultMap);
		return ResultGenerator.genSuccessResult(list);
	}

	@Transactional
	@Override
	public Result selectPoint(Long id,int type) {
		TPoints point = tPointsDao.findPointById(id,type);
		TPointsModel model = new TPointsModel();
		model.setId(point.getId());
		model.setTitle(point.getTitle());
		model.setParentId(point.getParentId());
		try {
			Object detail = point.getDetail();
			model.setDetail(StringUtils.isNotBlank(detail)?new String((byte[])detail,"utf-8"):"");
		}catch (Exception e) {
		}
		model.setpOrder(point.getpOrder());
		model.setParents(tPointsDao.findParentPoints(type));
		model.setCuts(tCutsDao.findAllCuts(point.getId()));
		return ResultGenerator.genSuccessResult(model);
	}

	@Override
	public Result selectParentPoints(int type) {
		return ResultGenerator.genSuccessResult(tPointsDao.findParentPoints(type));
	}

	@Transactional
	@Override
	public Result deletePointByIds(Long[] ids) {
		Result result = null;
		try {
			int count=0;
			String resultMsg = "";

			for (Long id : ids) {
				if (tPointsDao.findHasChildPoint(id) > 0) {
					return ResultGenerator.genFailResult(ResultCode.ERR_113);
				}
				this.deletePointById(id);
				count++;
			}
			resultMsg = "成功删除"+count+"个知识点！";
			result = ResultGenerator.genSuccessResult(resultMsg);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除知识点出现错误，ids[%s]", ids);
			result = ResultGenerator.genFailResult();
		}
		return result;
	}

	@Transactional
	@Override
	public Result uploadImage(HttpServletRequest request, MultipartFile image, Long pointId){
		String path = request.getSession().getServletContext().getRealPath("upload");
//        String fileName = image.getOriginalFilename();
		String fileName = System.currentTimeMillis()+".jpg";
		File targetFile = new File(path, fileName);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		String resultPath = request.getContextPath()+"/upload/"+fileName;
		TCuts tCuts = new TCuts();
		tCuts.setCutUrl(resultPath);
		tCuts.setPointId(pointId);
		tCutsDao.save(tCuts);
		return ResultGenerator.genSuccessResult(tCuts);
	}

	@Transactional
	@Override
	public Result deleteImageById(Long id) {
		tCutsDao.deleteById(id);
		return ResultGenerator.genSuccessResult();
	}
	
}
