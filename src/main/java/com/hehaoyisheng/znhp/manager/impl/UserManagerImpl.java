package com.hehaoyisheng.znhp.manager.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.hehaoyisheng.znhp.constant.TestData;
import com.hehaoyisheng.znhp.constant.ZnhpStatusCodes;
import com.hehaoyisheng.znhp.dao.DO.UserDO;
import com.hehaoyisheng.znhp.dao.UserDAO;
import com.hehaoyisheng.znhp.manager.UserManager;
import com.hehaoyisheng.znhp.utils.SendMsg;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.annotation.Resource;
import java.util.Random;

/**
 * Created by yunzhao on 2017/7/29.
 */
@Component
public class UserManagerImpl implements UserManager{
    @Resource
    private UserDAO userDAO;

    public static final String VERIFY_CODES = "0123456789";
    public static final int verifySize = 4;

    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    public UserDO login(String username, String password){
        UserDO userDO = userDAO.queryUserByUsername(username);
        if(userDO == null){
            return null;
        }
        if(StringUtils.equals(password, userDO.getPassword())){
            return userDO;
        }
        return null;
    }

    /**
     * 注册发送短信
     * @param phoneNumber
     * @return
     */
    public int registSendMsg(@Nonnull String phoneNumber) {
        UserDO userDO = userDAO.queryUserByPhoneNumber(phoneNumber);
        if(userDO != null) {
            return ZnhpStatusCodes.PHONE_HAVED.getValue();
        }
        String verifyCode = generateVerifyCode();
        SendSmsResponse sendSmsResponse = SendMsg.sendMsg(phoneNumber, verifyCode);
        if(StringUtils.isEmpty(sendSmsResponse.getCode())){
            return ZnhpStatusCodes.MESSAGE_SEND.getValue();
        }
        return Integer.valueOf(verifyCode);
    }

    /**
     * 注册时判断用户是否存在
     * @param username
     * @return
     */
    public Boolean isUserExist(String username) {
        UserDO userDO = TestData.queryByUsername(username);
        return userDO != null;
    }

    /**
     * 用户注册
     * @param userDO
     * @return
     */
    public UserDO regist(UserDO userDO) {
        return TestData.regist(userDO);
    }

    /**
     * 生成指定长度的验证码
     * @return
     */
    private static String generateVerifyCode(){
        int codesLen = VERIFY_CODES.length();
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for(int i = 0; i < verifySize; i++){
            verifyCode.append(VERIFY_CODES.charAt(rand.nextInt(codesLen-1)));
        }
        return verifyCode.toString();
    }
}
