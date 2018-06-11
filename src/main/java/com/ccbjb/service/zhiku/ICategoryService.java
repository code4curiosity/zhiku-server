package com.ccbjb.service.zhiku;

import com.ccbjb.common.domain.TZhikuCategory;
import com.ccbjb.common.mybatis.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ICategoryService {

	Result findPage(Map<String, String> map, Integer pageNo,
                    Integer pageSize);
	void insertSelective(TZhikuCategory tZhikuCategory);

	Result deleteCategoryById(Long[] ids);

	Result selectCategoryParents();

	void deleteByPrimaryKey(Long id);
	Result selectCategoryById(Long id);
	List<TZhikuCategory> findCategoryItems(Long categoryId);

	Result uploadImage(HttpServletRequest request, MultipartFile image, Long categoryId);

	PageInfo findCategoryItemsPage(Long categoryId,Integer pageNo,
								   Integer pageSize);

}
