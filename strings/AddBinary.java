package strings;

class AddBinary {
    public static String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a,2) + Integer.parseInt(b,2));
    }

    public static void main(String[] args) {
        System.out.println(addBinary("100","10"));
    }
}