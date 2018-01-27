class Composed {
    private String message;
    Composed(String s) {
        message = s;
    }

    public String toString() {
        return message;
    }
}

class ClassA {
    private Composed composed;
    public String toString() {
        if (composed == null) {
            composed = new Composed("delayed inited!");
        }
        return "Hello, " + composed;
    }
}

class Main {
    static public void main(String[] args) {
        ClassA test = new ClassA();
        System.out.println(test);
    }
}
