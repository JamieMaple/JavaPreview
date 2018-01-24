class A {}

class Main {
    static void printArray(Object[] objects) {
        for (Object object: objects) {
            System.out.print(object + " ");
        }
        System.out.println();
    }
    static void f(int required, Object... objects) {
        System.out.print("required param: " + required + "\nargs: ");
        for (Object object: objects) {
            System.out.print("" + object + " ");
        }
        System.out.println();
    }
    static public void main(String[] args) {
        printArray(new Object[]{ 1, 2, 3 });
        printArray(new Object[]{ "string", "hello", "world" });
        printArray(new Object[]{ new A(), new A(), new A() });
        printArray(new Integer[]{ 1, 2, 3 });
        f(1, 2, 3);
        f(2, "hello", "world");
        f(3, "number", 1);
    }
}

