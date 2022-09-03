package space.commandf1.FasterLib.api.color;

import org.bukkit.ChatColor;

import java.util.List;

@SuppressWarnings("unused")
public final class Color {
    private Color() {}

    /**
     * 将指定字符替换为颜色字符
     * @author commandf1
     * @param str 字符串
     * @param type 字符
     * @return 修改后的带颜色的字符串
     *
     * */
    public static String toMinecraftColor(char type, String str) {
        return ChatColor.translateAlternateColorCodes(type, str);
    }

    /**
     * 替换为颜色字符
     * @author commandf1
     * @param str 字符串
     * @return 修改后的带颜色的字符串
     *
     * */
    public static String toMinecraftColor(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    /**
     * 替换为颜色字符
     * @author commandf1
     * @param strings 字符串
     * @return 修改后的带颜色的字符串
     *
     * */
    public static List<String> toMinecraftColor(List<String> strings) {
        strings.replaceAll(Color::toMinecraftColor);
        return strings;
    }

    /**
     * 替换为颜色字符
     * @author commandf1
     * @param strings 字符串
     * @return 修改后的带颜色的字符串
     *
     * */
    public static String[] toMinecraftColor(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = toMinecraftColor(strings[i]);
        }
        return strings;
    }

}
