package utils;

import utils.IStringUtils;

import java.text.MessageFormat;

public class IUrlUtils {
    private static final MessageFormat TWO_FORMAT = new MessageFormat("{0}.{1}");

    public static String extraDomain(String url) {
        if (IStringUtils.isEmpty(url)) {
            return url;
        }
        if (!url.startsWith("http")) {
            return "";
        }
        url = url.substring(url.indexOf("//") + 2);
        int index = url.indexOf("/");
        if (index > 0) {
            url = url.substring(0, index);
        }
        int index1 = url.indexOf("?");
        if (index1 > 0) {
            url = url.substring(0, index1);
        }
        if (url.contains(":")) {
            url = url.substring(0, url.indexOf(":"));
        }
        return url;
    }


    /**
     * 根据url抽取url schema
     */
    public static String extraUrlSchema(String url) {
        if (IStringUtils.isEmpty(url)) {
            return url;
        }
        String domain = extraDomain(url);
        return extraSchema(domain);
    }

    /**
     * 根据domain提取schema
     *
     * @param domain
     * @return
     */
    public static String extraSchema(String domain) {
        String schema = "";
        if (domain.matches("\\d+\\.\\d+\\.\\d+\\.\\d+")) {
            return schema;
        }
        String[] strArr = domain.split("\\.");
        if (strArr.length >= 2) {
            schema = TWO_FORMAT.format(new Object[]{strArr[strArr.length - 2], strArr[strArr.length - 1]});
            int offset = 3;
//            while (TLDList.getInstance().contains(schema)) {
//                if (offset == strArr.length) {
//                    break;
//                }
//                schema = TWO_FORMAT.format(new Object[]{strArr[strArr.length - offset], schema});
//                offset++;
//            }
        }
        return schema;
    }
}
