class Dog {
    String name;
    String says;
}

class HelloWorld {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        Dog d2 = new Dog();

        d1.name = "spot";
        d1.says = "Ruff!";

        Dog d3 = d1;

        d2.name = "scruffy";
        d2.says = "Wurf!";

        System.out.println(d1.name + " barking: " + d1.says);
        System.out.println(d2.name + " barking: " + d2.says);
        System.out.println(d1.equals(d3));
    }
}
