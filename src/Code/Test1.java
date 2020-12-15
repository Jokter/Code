package Code;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(run());
    }

    private static String run(){
        String s = "sfad";
        char[] chars = s.toCharArray();
        System.out.println(chars.toString());
        System.out.println(new String(chars));
        System.out.println(String.valueOf(chars));
        return String.valueOf(chars);
    }
}
