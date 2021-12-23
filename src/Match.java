public class Match {
    Fighter f1;
    Fighter f2;
    int minwealth;
    int maxwealth;

    public Match() {
    }

    public Match(Fighter f1, Fighter f2, int minwealth, int maxwealth) {
        this.f1 = f1;
        this.f2 = f2;
        this.minwealth = minwealth;
        this.maxwealth = maxwealth;
    }

    public void start() {
        if (checkweight() == true) {
            while (f1.health > 0 && f2.health > 0) {
                if (firsthit() == false) {
                    System.out.println("New Round");
                    f2.health = f1.hit(f2);
                    if (isWin()) {
                        break;
                    }
                    f1.health = f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                    printScore();
                } else if (firsthit() == true) {
                    System.out.println("New Round");
                    f1.health = f2.hit(f1);
                    if (isWin()) {
                        break;
                    }
                    f2.health = f1.hit(f2);
                    if (isWin()) {
                        break;
                    }
                    printScore();
                }
            }
        }
    }

    public boolean checkweight() {
        return (f1.weight >= this.minwealth && f1.weight <= this.maxwealth) && (f2.weight >= this.minwealth && f2.weight <= this.maxwealth);
    }

    public boolean isWin() {
        if (f1.health == 0) {
            System.out.println(f2.name + " wins the match");
            return true;
        } else if (f2.health == 0) {
            System.out.println(f1.name + " wins the match");
            return true;
        }
        return false;
    }

    public void printScore() {
        System.out.println("****************************************************");
        System.out.println("For " + f1.name + " remaining health is : " + f1.health);
        System.out.println("For " + f2.name + " remaining health is : " + f2.health);
    }

    public boolean firsthit() {
        double randomm = Math.random() * 100;
        double randomm2 = 100 - randomm;
        randomm = f1.firsthit;
        randomm2 = f2.firsthit;
        if (f1.firsthit > f2.firsthit) {
            return true;
        } else if (f1.firsthit < f2.firsthit){
            return false;
        }
        else{
            return firsthit();
        }
    }
}
