class Main {
    enum Money {
        PENNY,
        ONE,
        TEN,
        HUNDRED,
        THOUSAND,
    }
    static public void main(String[] args) {
        for (Money money: Money.values()) {
            System.out.println("money: " + money + ", " + money.ordinal());
        }
    }
}
