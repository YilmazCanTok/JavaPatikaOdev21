
public class main {
    public static void main(String[] args) {
        Fighter fighter1 = new Fighter("John",20,85,100,10,49);
        Fighter fighter2 = new Fighter("Jack",10,95,95,20,51);
        Match match1 = new Match(fighter1,fighter2,80,100);
        match1.start();
    }
}
