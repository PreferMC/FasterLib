package space.commandf1.FasterLib.api.util.utils;

import space.commandf1.FasterLib.api.util.Util;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

@SuppressWarnings("unused")
public final class WebUtils extends Util {

    public WebUtils() {
        super("WebUtils", true, false);
    }

    /**
     * 下载文件
     *
     * */
    public static void downloadFile(String url, String filePath) throws IOException {
        URL u = new URL(url);
        URLConnection uc = u.openConnection();
        BufferedInputStream in = new java.io.BufferedInputStream(uc.getInputStream());
        FileOutputStream fos = new java.io.FileOutputStream(filePath);
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        in.close();
        fos.close();
    }

    /**
     * 获取网页源码
     *
     * */
    public static String getHtml(String url) {
        StringBuilder sb = new StringBuilder();
        try {
            URL u = new URL(url);
            URLConnection uc = u.openConnection();
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(uc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                sb.append(inputLine);
            }
            in.close();
        } catch (Exception ignored) {}
        return sb.toString();
    }
}
