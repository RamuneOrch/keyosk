package sparta.java_project.keyosk.menu;
import sparta.java_project.keyosk.Menu;

public class Drink extends Menu {
    // 이름 , 상세설명
    String name, detail;
    // 옵션 : 탄산의 유무
    boolean carbonic;

    int price;
    public Drink(String name, int price, String detail, boolean carbonic){
        super(name, price, detail);
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.carbonic = carbonic;
    }

    public String getDetail() {
        return detail;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
