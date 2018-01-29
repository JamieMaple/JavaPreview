class Animal {
    private String name = "Animal";

    protected void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Dog extends Animal {
    private String s;
    public void changeName(String name) {
        setName(name);
    }
}

