package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
	public static boolean halfWidthNumberCheck(String str) {
        // 正規表現パターンを用意する
        String regex_half_width_number = "^[0-9]+$";

        // Javaの正規表現ライブラリで事前準備をする
        Pattern p = Pattern.compile(regex_half_width_number); // 正規表現パターンの読み込み
        Matcher m = p.matcher(str); // パターンと検査対象文字列の照合
        boolean result = m.matches(); // 照合結果をtrueまたはfalseで取得する
        return result;
    }
}
