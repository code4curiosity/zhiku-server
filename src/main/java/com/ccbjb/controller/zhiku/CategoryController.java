package com.ccbjb.controller.zhiku;

import com.ccbjb.common.domain.TZhikuCategory;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.controller.common.BaseController;
import com.ccbjb.service.zhiku.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户权限管理
 */
@RestController
@Scope(value="prototype")
@RequestMapping("category")
public class CategoryController extends BaseController {
	
	@Autowired
	ICategoryService categoryService;

	@PostMapping(value="index")
	public Result index(String findContent, Integer pageNo){
		Map<String, String> map = new HashMap<String, String>();
		map.put("findContent", findContent);
		return categoryService.findPage(map,pageNo,pageSize);
	}

	/**
	 * 字典添加
	 * @param category
	 * @return
	 */
	@PostMapping(value="save")
	public Result save(TZhikuCategory category){
		Result result = null;
		try {
			categoryService.insertSelective(category);
			result = ResultGenerator.genSuccessResult("添加成功");
		} catch (Exception e) {
			result = ResultGenerator.genFailResult();
			LoggerUtils.fmtError(getClass(), e, "添加消息报错。source[%s]",category.toString());
		}
		return result;
	}
	/**
	 * 删除字典，根据ID，但是删除角色的时候，需要查询是否有赋予给用户，如果有用户在使用，那么就不能删除。
	 * @param ids
	 * @return
	 */
	@PostMapping(value="deleteCategoryById")
	public Result deleteDicById(Long[] ids){
		return categoryService.deleteCategoryById(ids);
	}

	@GetMapping(value="selectCategoryById")
	public Result selectDicById(Long id){
		return categoryService.selectCategoryById(id);
	}

	@GetMapping(value="selectCategoryParents")
	public Result selectDicParents(){
		return categoryService.selectCategoryParents();
	}

	@PostMapping(value = "uploadImage")
	public Result uploadImage(HttpServletRequest request, MultipartFile image, Long categoryId) {

		return categoryService.uploadImage(request,image,categoryId);
	}

}
