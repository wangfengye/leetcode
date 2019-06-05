package utils;

import java.io.File;

/**
 * @author maple on 2019/6/5 15:16.
 * @version v1.0
 * @see 1040441325@qq.com
 */
public class FileUtil {
    private static void changSuffix(String filePath, String suffix) {
        File root = new File(filePath);
        for (File file : root.listFiles()) {
            String s = file.getAbsolutePath();
            s = s.substring(0, s.lastIndexOf('.')) + suffix;
            System.out.println(s);
            file.renameTo(new File(s));
        }
    }
    public static void main(String[] args){
        changSuffix("D:\\cache\\apktool\\wifi_8728\\res\\drawable-hdpi-v4",".png");
    }
}
