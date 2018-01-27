class Cleanser {
    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    public String toString() {
        return s;
    }

    static public void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();x.scrub();x.apply();
        System.out.println(x);
    }
}

class Detergent {
    private Cleanser cleanser = new Cleanser();

    public void append(String a) {
        cleanser.append(a);
    }

    public void scrub() {
        cleanser.scrub();
    }

    public void foma() {
        cleanser.append(" foma()");
    }

    public void apply() {
        cleanser.apply();
    }

    public void dilute() {
        cleanser.dilute();
    }

    public String toString() {
        return cleanser.toString();
    }
}

class Main {
    static public void main(String[] args) {
        Detergent detergent = new Detergent();
        detergent.foma();
        detergent.scrub();
        detergent.apply();
        detergent.dilute();
        System.out.println(detergent);
    }
}

