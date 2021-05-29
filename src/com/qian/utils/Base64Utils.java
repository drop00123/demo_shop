package com.qian.utils;

import java.util.Base64;

//base64加密,解密激活邮件的时候为邮箱地址code验证码进行加密
//当回传回来后进行邮箱地址和code 的解密
public class Base64Utils {
	//加密
	public static String encode(String msg){
		return Base64.getEncoder().encodeToString(msg.getBytes());
	}
	//解密
	public static String decode(String msg){
		return new String(Base64.getDecoder().decode(msg));
	}
}
