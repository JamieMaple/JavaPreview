interface Instrument {
    int VALUE = 5;
    void adjust();
}

interface Playable {
    void play();
}

class Wind implements Instrument, Playable {
    public void play() {
        System.out.println("play");
    }
    public void adjust() {
        System.out.println("adjust");
    }
}

