package com.ccbjb.controller.points;

import com.ccbjb.common.mybatis.Result;
import com.ccbjb.controller.common.BaseController;
import com.ccbjb.model.points.TPointsModel;
import com.ccbjb.service.points.IPointsService;
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
 * Created by Administrator on 2017/9/14.
 */
@RestController
@Scope(value="prototype")
@RequestMapping("points")
public class PointsController extends BaseController {
    @Autowired
    IPointsService pointsService;

    @RequestMapping("list")
    public Result list(Integer pageNo, String findContent, String type) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("findContent", findContent);
        map.put("type", type);
        return pointsService.findPage(map,pageNo,pageSize);
    }

    @RequestMapping("listAll")
    public Result listAll(String type) {
        Map<String,String> map = new HashMap<String,String>();
        map.put("type", type);
        return pointsService.findAllPage(map,pageSize);
    }

    /**
     * 角色添加
     * @param point
     * @return
     */
    @PostMapping(value="addPoint")
    public Result addPoint(TPointsModel point){
        return pointsService.insertPoint(point);
    }
    /**
     * 删除角色，根据ID，但是删除角色的时候，需要查询是否有赋予给用户，如果有用户在使用，那么就不能删除。
     * @param ids
     * @return
     */
    @PostMapping(value="deletePointByIds")
    public Result deletePointByIds(Long[] ids){
        return pointsService.deletePointByIds(ids);
    }
    /**
     * 删除角色，根据ID，但是删除角色的时候，需要查询是否有赋予给用户，如果有用户在使用，那么就不能删除。
     * @return
     */
    @GetMapping(value="selectPointById")
    public Result selectPointById(Long id,int type){
        return pointsService.selectPoint(id,type);
    }

    /**
     * 删除角色，根据ID，但是删除角色的时候，需要查询是否有赋予给用户，如果有用户在使用，那么就不能删除。
     * @return
     */
    @GetMapping(value="selectParentPoints")
    public Result selectParentPoints(int type){
        return pointsService.selectParentPoints(type);
    }

    @PostMapping(value = "uploadImage")
    public Result uploadImage(HttpServletRequest request, MultipartFile image, Long pointId) {

        return pointsService.uploadImage(request,image,pointId);
    }

    @PostMapping(value = "deleteImageById")
    public Result deleteImageById(Long id) {
        return pointsService.deleteImageById(id);
    }
}
