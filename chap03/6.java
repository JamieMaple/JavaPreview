class HelloWorld {
    static void strCmp(String s1, String s2) {
        if (s1 == s2) {
            System.out.println("字符串相等：\n" + s1);
        } else {
            System.out.println("两者不相等\ns1: " + s1 + "\ns2: " + s2);
        }
    }
    public static void main(String[] args) {
        strCmp("sdf", "sdf");
    }
}
