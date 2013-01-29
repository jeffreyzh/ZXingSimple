package com.betterman.util;

/**
 * 配置信息 可控制是否启用以下配置
 * @author jeff
 *
 */
public class PreferenceConfig {
	  public static final boolean KEY_DECODE_1D_ENABLE = true;//是否扫描一维码
	  public static final boolean KEY_DECODE_QR_ENABLE = true;//QR码
	  public static final boolean KEY_DECODE_DATA_MATRIX_ENABLE = true;//DM码
	  
	  public static final boolean KEY_BULK_MODE_ENABLE = false;//批量扫描模式
	  public static final boolean KEY_PLAY_BEEP_ENABLE = true;//扫描成功 声音提示
	  public static final boolean KEY_VIBRATE_ENABLE = true;//扫描成功 震动提示
	  
	  public static final boolean KEY_FRONT_LIGHT_ENABLE = false;//前置灯
	  public static final boolean KEY_REVERSE_IMAGE_ENABLE = false;//反转图片
	  
	  public static final boolean KEY_AUTO_FOCUS_ENABLE = true;//自动聚焦
	  public static final boolean KEY_DISABLE_CONTINUOUS_FOCUS_ENABLE = false;//持续聚焦
}
