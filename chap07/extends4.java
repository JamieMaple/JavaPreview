class Game {
    Game(int i) {
        System.out.println("Game!");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("BoradGame!");
    }
}

class Chess extends BoardGame {
    Chess() {
        super(1);
        System.out.println("Chess!");
    }
}

class Main {
    public static void main(String[] args) {
        new Chess();
    }
}

