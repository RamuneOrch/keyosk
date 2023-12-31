package sparta.java_project.keyosk.menu;

import sparta.java_project.keyosk.Menu;

public class Dessert extends Menu {
    // 옵션 : 포크 갯수
    int pork;
    public Dessert(String name, int price, String detail,int count, int pork){
        super(name, price, detail,count);
        this.pork = pork;
    }

    public void setPork(int pork) {
        this.pork = pork;
    }

    @Override
    public String toString() {
        return "Dessert";
    }

    public int getPork(){
        return pork;
    }
}


