package ch9;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ch9_11 {
    public static void extraPath(String path) {
        String regex = "/?((?:\\w+/)*)(?<filename>\\w+)\\.(?<ext>\\w+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(path);
        if (matcher.matches()) {
            String dir = matcher.group(1);
            String[] directories = dir.split("/");
            String filename = matcher.group("filename");
            String ext = matcher.group("ext");
            System.out.printf("%s, file_name:%s extension:%s\n", Arrays.toString(directories), filename, ext);
        } else {
            System.out.println("Regex no match");
        }
    }

    public static void main(String[] args) {
        String path = "/home/cay/myfile.txt";
        extraPath(path);
        extraPath("a/b/cc_c/hello_world.jpc");
    }
}
