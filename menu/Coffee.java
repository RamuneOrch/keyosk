package sparta.java_project.keyosk.menu;

import sparta.java_project.keyosk.Menu;

import java.util.ArrayList;

public class Coffee extends Menu {

    // 내가 하고 싶은거
    // Main 메소드에 정의하려는 객체들을 하나의 클래스로 묶고 싶어서 삽질하는중
    // Coffee a = new Coffee();가 실행되면 Coffee안에 있는 코드가 실행이 되며 미리 정의해놓은 데이터가 메모리에 저장되도록 하는 클래스를 구현 하는중

    ArrayList<Coffee> coffList = new ArrayList<>();
    String name, detail;
    // 옵션 : 시럽의 유무
    boolean syrup;
    int price;

    public Coffee(String name, int price, String detail, boolean syrup){
        super(name, price, detail);
        this.price = price;
        this.name = name;
        this.detail = detail;
        this.syrup = syrup;
    }

    public void coffeeAdd(String name, int price, String detail){
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public int getPrice() {
        return price;
    }
}
