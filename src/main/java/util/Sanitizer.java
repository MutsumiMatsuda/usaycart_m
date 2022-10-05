package util;

public class Sanitizer {

    public static String sanitizing(String str) {

        if (null == str || "".equals(str)) {
            return str;
        }

        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");

        return str;
    }
    
    public static void main(String[] args) {
        
        String beforeStr = "<script> alert(document.cookie); </script>";
        
        String afterStr = Sanitizer.sanitizing(beforeStr);
        
        System.out.println(afterStr);
        
    }
}
