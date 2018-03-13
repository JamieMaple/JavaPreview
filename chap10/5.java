package entry;

class Sequence {
    class SequenceSelector {
        public Sequence outer() {
            return Sequence.this;
        }
    }
    public String toString() {
        return "Sequnce";
    }
}

class Main {
    public static void main(String[] args) {
        Sequence s = new Sequence();
        Sequence.SequenceSelector selector = s.new SequenceSelector();

        System.out.println(selector.outer());
    }
}
