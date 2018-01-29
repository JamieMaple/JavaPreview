class Amphibian {
    public void jump() {
        System.out.println("Jump!");
    }
    static public void behave(Amphibian amphibian) {
        amphibian.jump();
    }
}

class Frog extends Amphibian {
  public void jump() {
      System.out.println("Frog jump!");
  }
}

class Main {
    static public void main(String[] args) {
        Amphibian.behave(new Frog());
    }
}

