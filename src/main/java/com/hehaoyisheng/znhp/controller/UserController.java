package com.hehaoyisheng.znhp.controller;

import com.hehaoyisheng.znhp.constant.ZnhpStatusCodes;
import com.hehaoyisheng.znhp.controller.DTO.BaseDTO;
import com.hehaoyisheng.znhp.dao.DO.AddressDO;
import com.hehaoyisheng.znhp.dao.DO.ShoppingCartDO;
import com.hehaoyisheng.znhp.dao.DO.UserDO;
import com.hehaoyisheng.znhp.manager.AddressManager;
import com.hehaoyisheng.znhp.manager.ShoppingCartManager;
import com.hehaoyisheng.znhp.manager.UserManager;
import com.hehaoyisheng.znhp.utils.CutPageUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户操作controller
 * Created by yunzhao on 2017/7/29.
 */
@Controller
@SessionAttributes("user")
public class UserController {

    @Resource
    private UserManager userManager;

    @Resource
    private ShoppingCartManager shoppingCartManager;

    @Resource
    private AddressManager addressManager;

    /**
     * 登陆
     * @param userAccount
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public BaseDTO login(String userAccount, String password){
        UserDO userDO = userManager.login(userAccount, password);
        if(userDO == null){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.LOGIN_FALSE);
        }
        return BaseDTO.createSuccessBaseDTO(userDO);
    }

    /**
     * 注册
     * @param userDO
     * @param checkCode
     * @param session
     * @return
     */
    @RequestMapping("/regist")
    @ResponseBody
    public BaseDTO regist(UserDO userDO, String checkCode, HttpSession session){
        if(StringUtils.isEmpty(checkCode)){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.DATA_NOT_FOUND);
        }
        boolean isExist = userManager.isUserExist(userDO.getUsername());
        if(isExist){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.USER_EXIST);
        }
        Object sessionCheckCode = session.getAttribute("checkCode");
        if(sessionCheckCode == null || !StringUtils.equals(checkCode, sessionCheckCode.toString())){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.CHECK_CODE_ERROR);
        }
        UserDO registResult = userManager.regist(userDO);
        return BaseDTO.createSuccessBaseDTO(registResult);
    }

    /**
     * 发送短信
     * @param phoneNumber
     * @param session
     * @return
     */
    @RequestMapping("/sendMsg")
    @ResponseBody
    public BaseDTO sendMsg(String phoneNumber, HttpSession session){
        if(StringUtils.isEmpty(phoneNumber)){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.PHONE_EXESL);
        }
        int resultCode = userManager.registSendMsg(phoneNumber);
        if(resultCode == ZnhpStatusCodes.PHONE_HAVED.getValue() || resultCode == ZnhpStatusCodes.MESSAGE_SEND.getValue()){
            BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.getType(resultCode));
        }
        session.setAttribute("checkCode", resultCode);
        return BaseDTO.createSuccessBaseDTO(null);
    }


    /**
     * 修改用户信息
     * @param userDO
     * @param session
     * @return
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public BaseDTO update(UserDO userDO, HttpSession session){
        String username = (String) session.getAttribute("user");

        userDO.getUsername();
        return null;
    }

    /**
     * 密码找回
     * @param password
     * @param check
     * @param session
     * @return
     */
    @RequestMapping("/updatePassword")
    @ResponseBody
    public BaseDTO changePass(String password, String check, HttpSession session){
        String username = (String) session.getAttribute("user");
        
        return null;
    }

    /**
     * 购买记录
     * @param user
     * @param from 分页开始位置
     * @param count 每页的数量
     * @return
     */
    @RequestMapping("/buyRecord")
    @ResponseBody
    public BaseDTO getBuyRecord(@ModelAttribute("user") UserDO user, Integer from, Integer count){
        return null;
    }

    /**
     * 购物车　
     * @param user
     * @param from 分页开始位置
     * @param count 每页的数量
     * @return
     */
    @RequestMapping("/shoppingCart")
    @ResponseBody
    public BaseDTO getShoppingCart(@ModelAttribute("user") UserDO user, Integer from, Integer count){
        if(user == null){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.USER_NOT_LOGIN);
        }
        from = CutPageUtils.getInteger(from);
        count = CutPageUtils.getCount(count);
        List<ShoppingCartDO> list = shoppingCartManager.selectShoppingDOByUserId(user.getId());
        return BaseDTO.createSuccessBaseDTO(CutPageUtils.divide(list, from, count), list.size());
    }

    /**
     * 添加购物车
     * @param user
     * @param commodityId 商品id
     * @return
     */
    @RequestMapping("/addShoppingCart")
    @ResponseBody
    public BaseDTO addShoppingCart(@ModelAttribute("user") UserDO user, Long commodityId, Integer count){
        if(user == null){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.USER_NOT_LOGIN);
        }
        shoppingCartManager.insertShoppingCartDO(user.getId(), user);
        return null;
    }

    /**
     * 删除购物车
     * @param user
     * @param commodityIdList 删除的商品id集合
     * @return
     */
    @RequestMapping("/deleteShoppingCart")
    @ResponseBody
    public BaseDTO deleteShoppingCart(@ModelAttribute("user") UserDO user, @RequestBody List<Long> commodityIdList){
        if(user == null){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.USER_NOT_LOGIN);
        }
        try {
            shoppingCartManager.deleteShoppingCartDOById(commodityIdList);
        }catch (Exception e){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.SYSTEM_ERROR);
        }
        return BaseDTO.createSuccessBaseDTO(Boolean.TRUE);
    }

    /**
     * 添加收货地址
     * @return
     */
    @RequestMapping("/addAddress")
    @ResponseBody
    public BaseDTO addAddress(@ModelAttribute("user") UserDO user, AddressDO addressDO){
        if(user == null){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.USER_NOT_LOGIN);
        }
        Long result = addressManager.insertAddress(user, addressDO);
        return result == -1 ? BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.DATA_NOT_FOUND) : BaseDTO.createSuccessBaseDTO(Boolean.TRUE);
    }

    /**
     * 修改收货地址
     * @return
     */
    @RequestMapping("/updateAddress")
    @ResponseBody
    public BaseDTO updateAddress(@ModelAttribute("user") UserDO user, AddressDO addressDO){
        if(user == null){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.USER_NOT_LOGIN);
        }
        Boolean result = addressManager.updateAddress(user, addressDO);
        return result ? BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.DATA_NOT_FOUND) : BaseDTO.createSuccessBaseDTO(result);
    }

    /**
     * 删除收货地址
     * @return
     */
    @RequestMapping("/updateAddress")
    @ResponseBody
    public BaseDTO deleteAddress(@ModelAttribute("user") UserDO user, Long id){
        if(user == null){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.USER_NOT_LOGIN);
        }
        Boolean result = addressManager.deleteAddress(id);
        return result ? BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.DATA_NOT_FOUND) : BaseDTO.createSuccessBaseDTO(result);
    }

    /**
     * 查看收货地址
     * @param user
     * @return
     */
    @RequestMapping("/getAddress")
    @ResponseBody
    public BaseDTO getAddress(@ModelAttribute("user") UserDO user){
        if(user == null){
            return BaseDTO.createErrorBaseDTO(ZnhpStatusCodes.USER_NOT_LOGIN);
        }
        List<AddressDO> addressDOList = addressManager.selectAddress(user.getId());
        return BaseDTO.createSuccessBaseDTO(addressDOList);
    }
}