package cn.jenche.core;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Copyright Copyright (c) 2020 By www.jenche.cn
 * @Author: jenche <jenchecn@outlook.com>
 * @Date: 2020/5/12 13:17
 * @Description: 国际化支持
 */
public class LocalI18nResources {
    private static LocalI18nResources instance;

    public static LocalI18nResources getInstance() {
        if (instance == null) {
            instance = new LocalI18nResources();
        }
        return instance;
    }

    /**
     * 获取国际化信息
     */
    public String getMessage(String key, Object... params) {
        //Locale locale = LocaleContextHolder.getLocale(); //根据环境获取
        Locale locale = Locale.SIMPLIFIED_CHINESE;
        ResourceBundle message = SystemConfig.LANG_MESSAGE.get(locale.getLanguage());
        if (message == null) {
            synchronized (SystemConfig.LANG_MESSAGE) {
                //在这里读取配置信息
                message = SystemConfig.LANG_MESSAGE.get(locale.getLanguage());
                if (message == null) {
                    //注1
                    message = ResourceBundle.getBundle("i18n/messages", locale);
                    SystemConfig.LANG_MESSAGE.put(locale.getLanguage(), message);
                }
            }
        }
        //此处获取并返回message
        if (params != null) {
            String _msg = "";
            try {
                _msg = new String(message.getString(key).getBytes("ISO-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                //转换出错 msg 为空；
            }
            return String.format(_msg, params);
        }
        return message.getString(key);
    }

    /**
     * 清除国际化信息
     */
    public void flushMessage() {
        SystemConfig.LANG_MESSAGE.clear();
    }
}
