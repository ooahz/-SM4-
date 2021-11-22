package com.gm.sm4;
/**
 * @Description: SM4测试类
 * @Author: 十玖八柒
 * @CreateDate: 2021/11/22
 */
public class StringtoHex {

    public String toHex(String inputTest){
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < inputTest.length(); i++) {
            int ch = (int) inputTest.charAt(i);
            String strHex = Integer.toHexString(ch);
            hexString.append(strHex);
        }

        return hexString.toString();
    }

}
