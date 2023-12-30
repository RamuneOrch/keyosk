package sparta.java_project.keyosk.menu;

import sparta.java_project.keyosk.Menu;

public class Dessert extends Menu {
    String name, detail;
    // 옵션 : 포크 갯수
    int pork;
    int price;
    public Dessert(String name, int price, String detail, int pork){
        super(name, price, detail,0);
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.pork = pork;
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


