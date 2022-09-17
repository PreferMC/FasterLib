package space.commandf1.FasterLib.api.util.utils;

import space.commandf1.FasterLib.api.util.Util;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public final class LoggerUtils extends Util {
    private static final List<String> strings = new ArrayList<>();

    public LoggerUtils() {
        super("LoggerUtils", true, false);
    }

    /**
     * 添加一个信息
     * 这个信息被添加后
     * 一旦后台输出包含该字符的信息就不会显示
     * 类似于ConsoleSpamFix
     *
     * */
    public static void addHideMessage(String str) {
        strings.add(str);
    }

    public static List<String> getStrings() {
        return strings;
    }
}
