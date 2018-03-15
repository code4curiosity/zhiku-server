package com.ccbjb.service.points;


import com.ccbjb.common.domain.TPoints;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.model.points.TPointsModel;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IPointsService {

	Result insertPoint(TPointsModel point);

	void deletePointById(Long id);

	void updatePoint(TPoints point);

	Result selectPoint(Long id,int type);

	Result findPage(Map<String, String> resultMap, Integer pageNo,
                    Integer pageSize);

	Result findAllPage(Map<String, String> resultMap, Integer pageSize);

	Result deletePointByIds(Long[] ids);

	Result selectParentPoints(int type);

	Result uploadImage(HttpServletRequest request, MultipartFile image, Long pointId);

	Result deleteImageById(Long id);
}
