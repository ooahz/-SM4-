package sm4;

import cn.hutool.core.util.HexUtil;
import com.gm.sm4.SM4Helper;
import com.gm.sm4.SM4KeyHelper;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Description: SM4测试类
 * @Author: 十玖八柒
 * @CreateDate: 2021/11/22
 */
public class SM4Test {
    private static final String keyHex = "66a7dc868f37264121b266784cb65ed3";
    private static final String ivHex = "0a113196ba0824ca724bf9fa4e1b0cbe";
    /**
     * 密钥生成
     */
    @Test
    public void testGenerateKey() throws Exception {
        byte[] key = SM4KeyHelper.generateKey();
        Assert.assertNotNull("密钥生成失败", key);
        System.out.println(String.format("随机生成密钥：%s", HexUtil.encodeHexStr(key)));
    }

    /**
     * 解密
     */
    @Test
    public void decryptTest() throws Exception {
        String inputHex = "6ee7e62b656c2fdc62f71658bb740113";
//        String ivHex = null;
        //        提供填充模式
        String modeAndPadding = "SM4/ECB/PKCS7Padding";
        byte[] iv = null;
        //ECB只需要一个key，CBC模式还需要一个iv值
        if (null != ivHex) {
            iv = HexUtil.decodeHex(ivHex.toCharArray());
            modeAndPadding = "SM4/CBC/PKCS7Padding";
        }
        byte[] decryptRet = SM4Helper.decrypt(HexUtil.decodeHex(inputHex), HexUtil.decodeHex(keyHex.toCharArray()), modeAndPadding, iv);
        System.out.println(String.format("解密模式 = %s, 解密结果：%s", modeAndPadding , new String(decryptRet)));
    }

    /**
     * 加密
     */
    @Test
    public void encrypt() throws Exception {
        String inputTest = "abc";
        String inputHex = new StringtoHex().toHex(inputTest);
//        String ivHex = null;
        //        提供填充模式
        String modeAndPadding = "SM4/ECB/PKCS7Padding";
        byte[] iv = null;
        //ECB只需要一个key，CBC模式还需要一个iv值
        if (null != ivHex) {
            iv = HexUtil.decodeHex(ivHex.toCharArray());
            modeAndPadding = "SM4/CBC/PKCS7Padding";
        }
        byte[] encryptRet = SM4Helper.encrypt(inputTest.getBytes(), HexUtil.decodeHex(keyHex.toCharArray()), modeAndPadding, iv);
        String hexStr = HexUtil.encodeHexStr(encryptRet);
        System.out.println(String.format("加密模式 = %s, 密文： %s", modeAndPadding, hexStr));
    }

}
