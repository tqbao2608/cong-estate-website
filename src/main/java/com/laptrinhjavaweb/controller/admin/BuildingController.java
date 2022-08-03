package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.request.BuildingSearchDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.MessageUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {

    @Autowired
    private IBuildingService buildingService;

    @Autowired
    private IUserService userService;

    @Autowired
    private MessageUtils messageUtil;

    @RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
    public ModelAndView buildingList(@ModelAttribute("modelSearch") BuildingSearchDTO buildingDTO,HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building-list");
        initMessageResponse(mav, request);
        mav.addObject("model",buildingService.findBuilding(buildingDTO));
        mav.addObject("district", buildingService.getDistrictEnum());
        mav.addObject("typebuilding", buildingService.getTypeBuildingEnum());
        mav.addObject("staffmaps",userService.getStaffMaps());
        return  mav;
    }

    @RequestMapping(value = "/admin/building-insert", method = RequestMethod.GET)
    public ModelAndView buildingInsert(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building-edit");
        initMessageResponse(mav, request);
        mav.addObject("district", buildingService.getDistrictEnum());
        mav.addObject("typeBuilding", buildingService.getTypeBuildingEnum());
        return  mav;
    }


    @RequestMapping(value = "/admin/building-update", method = RequestMethod.GET)
    public ModelAndView buildingEdit(@RequestParam(required = false, value = "id") Long id, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building-edit");
        initMessageResponse(mav, request);
        mav.addObject("district", buildingService.getDistrictEnum());
        mav.addObject("typeBuilding", buildingService.getTypeBuildingEnum());
        mav.addObject(SystemConstant.MODEL, buildingService.findBuildingById(id));

        return  mav;
    }
    @RequestMapping(value = "/admin/building-delete", method = RequestMethod.GET)
    public ModelAndView buildingDelete(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        initMessageResponse(mav, request);
        return mav;
    }
    private void initMessageResponse(ModelAndView mav, HttpServletRequest request) {
        String message = request.getParameter("message");
        if (message != null && StringUtils.isNotEmpty(message)) {
            Map<String, String> messageMap = messageUtil.getMessage(message);
            mav.addObject(SystemConstant.ALERT, messageMap.get(SystemConstant.ALERT));
            mav.addObject(SystemConstant.MESSAGE_RESPONSE, messageMap.get("message"));
        }
    }
}
