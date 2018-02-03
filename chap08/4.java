package entry;

class AlertStatus {}

class GreenStatus extends AlertStatus {
    public String toString() {
        return "Green";
    }
}

class YellowStatus extends AlertStatus {
    public String toString() {
        return "Yellow";
    }
}

class RedStatus extends AlertStatus {
    public String toString() {
        return "Red";
    }
}

class Starship {
    AlertStatus alertStatus = new GreenStatus();
    public void changeStatus(String color) {
        if (color.toLowerCase() == "red") {
            alertStatus = new RedStatus();
        } else if (color.toLowerCase() == "yellow") {
            alertStatus = new YellowStatus();
        } else if (color.toLowerCase() == "green") {
            alertStatus = new GreenStatus();
        }
    }
    public String toString() {
        return alertStatus.toString();
    }
}

class Main {
    public static void main(String[] args) {
        Starship starship = new Starship();
        System.out.println(starship);
        starship.changeStatus("red");
        System.out.println(starship);
    }
}

