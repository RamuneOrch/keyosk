package sparta.java_project.keyosk.menu;
import sparta.java_project.keyosk.Menu;

public class Drink extends Menu {
    // 옵션 : 탄산의 유무
    boolean carbonic;
    public Drink(String name, int price, String detail, int count, boolean carbonic){
        super(name, price, detail, count);
        this.carbonic = carbonic;
    }

    @Override
    public String toString() {
        return "Drink";
    }

    public boolean isCarbonic() {
        return carbonic;
    }
}
