package com.upic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.upic.common.web.exception.WebException;
import com.upic.pay.common.web.springmvc.SpringMvcControllerSupport;
import com.upic.po.Address;
import com.upic.po.StatusClass;
import com.upic.po.User;
import com.upic.service.IAddressService;
import com.upic.service.IProvinceService;

@Controller
@RequestMapping("/address")
public class AddressController extends SpringMvcControllerSupport {
    private static Log log = LogFactory.getLog(AddressController.class);

    @Autowired
    private IProvinceService provinceService;
    @Autowired
    private IAddressService addressService;

    /**
     * 根据用户ID获取所有地址
     *
     * @param model
     * @param session
     * @param carId
     * @param shopId
     * @param shopCount
     * @param submitType
     * @return
     */
    @RequestMapping(value = "/getAllAddress")
    public String getShopByType(Model model, HttpSession session,
                                @RequestParam(value = "carId", required = false) String carId,
                                @RequestParam(value = "shopId", required = false) String shopId,
                                @RequestParam(value = "shopCount", required = false) String shopCount,
                                @RequestParam(value = "submitType", required = false) String submitType) {
        try {
            User u = (User) session.getAttribute("user");
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("userId", u.getId());
            // 获取默认地址
            List<Object> listBy = addressService.listBy(paramMap, "getByConditions");
            List<Object> listBy2 = provinceService.listBy(null, "listAll");
            model.addAttribute("addressAll", listBy);
            model.addAttribute("provinceAll", listBy2);
            model.addAttribute("submitType", submitType);
            model.addAttribute("carId", carId);
            model.addAttribute("shopId", shopId);
            model.addAttribute("shopCount", shopCount);
        } catch (WebException e) {
            log.error("== initFirstPage exception:", e);
            throw new WebException("1003", "错误信息：" + e.getMessage());
        }
        return "orgin/person/address";
    }

    /**
     * 设置默认地址
     *
     * @param model
     * @param session
     * @param addressId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/changeDefault")
    public StatusClass changeDefault(Model model, HttpSession session, @RequestParam("addressId") Integer addressId) {
        try {
            User u = (User) session.getAttribute("user");
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("userId", u.getId());
            paramMap.put("defaultAddress", 100);
            // 获取默认地址
            Address address = (Address) addressService.getBy(paramMap, "getByConditions");
            StatusClass s = new StatusClass();
            if (address == null) {
                Address ad = addressService.getById(addressId);
                if (ad == null) {
                    s.setStatus("ERROR");
                    s.setContent("获取地址失败！");
                    return s;
                }
                ad.setDefaultAddress(100);
                long result = addressService.update(ad);
                if (result == 0) {
                    s.setStatus("ERROR");
                    s.setContent("设置失败，请重试");
                    return s;
                }
                s.setStatus("SUCCESS");
                s.setContent("设置成功");
                return s;
            }
            address.setDefaultAddress(101);
            long result = addressService.update(address);
            if (result == 0) {
                s.setStatus("ERROR");
                s.setContent("设置失败，请重试");
                return s;
            }
            Address ad = addressService.getById(addressId);
            if (ad == null) {
                s.setStatus("ERROR");
                s.setContent("获取地址失败！");
                return s;
            }
            ad.setDefaultAddress(100);
            result = addressService.update(ad);
            if (result == 0) {
                s.setStatus("ERROR");
                s.setContent("设置失败，请重试");
                return s;
            }
            s.setStatus("SUCCESS");
            s.setContent("设置成功");
            return s;
        } catch (WebException e) {
            log.error("== changeDefault exception:", e);
            throw new WebException("1003", "错误信息：" + e.getMessage());
        }
    }

    /**
     * 根据地址ID删除 ajax
     *
     * @param model
     * @param addressId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAddress")
    public StatusClass deleteAddress(Model model, @RequestParam("addressId") Integer addressId) {
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("id", addressId);
            addressService.getBy(paramMap, "deleteById");
            StatusClass s = new StatusClass();
            s.setStatus("SUCCESS");
            s.setContent("删除成功");
            return s;
        } catch (WebException e) {
            log.error("== deleteAddress exception:", e);
            StatusClass s = new StatusClass();
            s.setStatus("ERROR");
            s.setContent("删除失败");
            return s;
        }
    }

    /**
     * 新增一个地址 form
     *
     * @param model
     * @param shopType
     * @return
     */
    // @RequestMapping(value = "/addAddress")
    // public String addAddress(Model model, Address address, HttpSession
    // session) {
    // try {
    // User user = (User) session.getAttribute("user");
    // address.setUserId(1);
    // address.setDefaultAddress(101);
    // long insert = addressService.insert(address);
    // if (insert == 0) {
    // throw new WebException("1003", "错误信息：添加失败");
    // }
    // } catch (WebException e) {
    // log.error("== addAddress exception:", e);
    // throw new WebException("1003", "错误信息：" + e.getMessage());
    // }
    // return "orgin/person/address";
    // }

    /**
     * 新增一个地址 form ajax
     *
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addAddress")
    public StatusClass addAddressAjax(Model model, Address address, HttpSession session) {
        try {
            User user = (User) session.getAttribute("user");
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("userId", user.getId());
            List<Object> listBy = addressService.listBy(paramMap, "getByConditions");
            address.setUserId(Integer.parseInt("" + user.getId()));
            if (listBy.isEmpty()) {
                address.setDefaultAddress(100);
            } else {
                address.setDefaultAddress(101);
            }
            long insert = addressService.insert(address);
            StatusClass s = new StatusClass();
            if (insert == 0) {
                s.setStatus("ERROR");
                s.setContent("添加失败");
                return s;
            }
            s.setStatus("SUCCESS");
            s.setContent("添加成功");
            return s;
        } catch (WebException e) {
            log.error("== addAddress exception:", e);
            StatusClass s = new StatusClass();
            s.setStatus("ERROR");
            s.setContent("添加失败");
            return s;
        }
    }

    /**
     * 地址更新准备
     *
     * @param model
     * @param session
     * @param addressId
     * @return
     */
    @RequestMapping(value = "/addressReadyUpdate")
    public String addressReadyUpdate(Model model, HttpSession session, @RequestParam("addressId") Integer addressId) {
        try {
            Address byId = addressService.getById(addressId);
            model.addAttribute("address", byId);
        } catch (WebException e) {
            log.error("== addAddress exception:", e);
            throw new WebException("1003", "错误信息：" + e.getMessage());
        }
        return "";
    }

    /**
     * 更新地址信息
     *
     * @param model
     * @param session
     * @param address
     * @return
     */
    @RequestMapping(value = "/addressUpdate")
    public String addressUpdate(Model model, HttpSession session, Address address) {
        try {
            long result = addressService.update(address);
            if (result == 0) {
                throw new WebException("1003", "错误信息：更新失败");
            }
        } catch (WebException e) {
            log.error("== addAddress exception:", e);
            throw new WebException("1003", "错误信息：" + e.getMessage());
        }
        return "";
    }

    /**********************************************20171001之后添加**********************************************/

    /**
     * 根据user获取收货地址
     *
     * @param userId
     * @return
     */
    @GetMapping("/getAddressByUser")
    private List<Address> getAddressByUser(@PathVariable("user") long userId) {
        List<Address> addressList = null;
        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("userId", userId);
            addressList = addressService.listBy(paramMap);
        } catch (Exception e) {
            log.error("== getShopByShopFarmTypeId exception:", e);
            addressList = null;
        }
        return addressList;
    }
}
