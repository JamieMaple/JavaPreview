package music;

public class Instrument {
    public void play(Note n) {
        print("Instrument.play()" + n);
    }
    public String toString() {
        return "Instrument";
    }
    protected void print(String s) {
        System.out.println(s);
    }
}

class Wind extends Instrument {
    @Override public void play(Note n) {
        print("Wind.play()" + n);
    }
    @Override public String toString() {
        return "Wind";
    }
}

class Percussion extends Instrument {
    @Override public void play(Note n) {
        print("Percussion.play()" + n);
    }
    @Override public String toString() {
        return "Percussion";
    }
}

class Stringed extends Instrument {
    @Override public void play(Note n) {
        print("Stringed.play()" + n);
    }
    @Override public String toString() {
        return "Stringed";
    }
}

class WoodWind extends Wind {
    @Override public void play(Note n) {
        print("WoodWind.play()" + n);
    }
    @Override public String toString() {
        return "WoodWind";
    }
}

class Brass extends Wind {
    @Override public void play(Note n) {
        print("Brass.play()" + n);
    }
    @Override public String toString() {
        return "Brass";
    }
}

