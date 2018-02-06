import java.util.Random;

interface Game {
   void toss();
}

interface GameFactory {
   Game getGame();
}

class Coin implements Game {
   private Random random = new Random();
   public void toss() {
      if (random.nextBoolean()) {
         System.out.println("Toss Coin : 正面");
      } else {
         System.out.println("Toss Coin : 反面");
      }
   }
}

class CoinFactory implements GameFactory {
   public Game getGame() {
      return new Coin();
   }
}

class Sieve implements Game {
   private Random random = new Random();
   public void toss() {
      int num = random.nextInt(5) + 1;
      System.out.println("Toss Sieve num : " + num);
   }
}

class SieveFactory implements GameFactory {
   public Game getGame() {
      return new Sieve();
   }
}

class Main {
   public static void playGame(GameFactory gf) {
      Game g = gf.getGame();
      g.toss();
   }
   public static void main(String[] args) {
      playGame(new CoinFactory());
      playGame(new SieveFactory());
   }
}

