interface A {
    int CONST = 1;
}

class Test implements A {
    public void change() {
        // CONST = 2; // final: change error
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(Test.CONST); // static
    }
}

