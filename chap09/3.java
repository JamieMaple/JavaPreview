interface Interface {
    void print(String s);
    void sayHi(String name);
    int sum(int a, int b);
}

class A implements Interface {
    public void print(String s) {
        System.out.println(s);
    }
    public void sayHi(String name) {
        print("Hi, " + name + ".");
    }
    public int sum(int a, int b) {
        return a + b;
    }
}

