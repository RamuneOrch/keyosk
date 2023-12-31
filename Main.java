package sparta.java_project.keyosk;

import sparta.java_project.keyosk.menu.Coffee;
import sparta.java_project.keyosk.menu.Dessert;
import sparta.java_project.keyosk.menu.Drink;
import sparta.java_project.keyosk.menuMessage.Bascket;
import sparta.java_project.keyosk.menuMessage.CancelMessage;
import sparta.java_project.keyosk.menuMessage.MainMessage;
import sparta.java_project.keyosk.menuMessage.MenuMessage;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 커피
        ArrayList<Coffee> coffList = new ArrayList<>();
        coffList.add(new Coffee("아메리카노", 1800, "물이랑 커피 섞은거", 1, false));
        coffList.add(new Coffee("카푸치노", 4000, "에스프레소를 섞은거", 1, false));
        coffList.add(new Coffee("카페라떼", 3500, "커피랑 우유 섞은거", 1, false));
        coffList.add(new Coffee("초코라떼", 3500, "초코랑 커피랑 우유 석은거", 1, false));
        coffList.add(new Coffee("바닐라 라떼", 3500, "바나나랑 우유랑 커피 섞은거", 1, false));

        // 드링크
        ArrayList<Drink> drinkList = new ArrayList<>();
        drinkList.add(new Drink("레몬에이드", 3800, "레몬이 들어감", 1, false));
        drinkList.add(new Drink("자몽에이드", 4300, "자몽이 들어감", 1, false));
        drinkList.add(new Drink("블루레몬에이드", 4000, "블루 레몬이 들어감", 1, false));
        drinkList.add(new Drink("유자에이드", 4200, "유자가 들어감", 1, false));
        drinkList.add(new Drink("딸기에이드", 4000, "딸기가 들어감", 1, false));

        // 디저트
        ArrayList<Dessert> dessertList = new ArrayList<>();
        dessertList.add(new Dessert("딸기케이크", 3500, "딸기가 들어감", 1, 1));
        dessertList.add(new Dessert("티라미수", 7500, "티라미수임", 1, 1));
        dessertList.add(new Dessert("초코파운드", 6500, "초코가 들어감", 1, 1));
        dessertList.add(new Dessert("마카롱", 3500, "마카롱임", 1, 1));
        dessertList.add(new Dessert("버터와플", 8500, "버터랑 와플", 1, 1));

        // 장바구니
        ArrayList<Menu> bascket = new ArrayList<>();
        // 전체 상품 판매 갯수
        ArrayList<Menu> globalBascket = new ArrayList<>();
        // 같은 값이 들어오면 그 값의 카운트를 늘려주는 코드를 구현하기
        // count++
        // 부모는 menu
        // 자식이 coffee, drink, dessert

        int waitingNumber = 0;
        int globalTotal = 0;
        while (true){
            MenuMessage mM = new MenuMessage();
            String menuCheck = sc.nextLine();

            // 주문한 총 금액 초기화
            int total = 0;
            switch (menuCheck) {
                case "1":
                    new MainMessage();
                    for (int i = 0; i < coffList.size(); i++) {
                        System.out.println(i + 1 + ". " + coffList.get(i).getName() + " | 가격 : " + coffList.get(i).getPrice() + " | " + coffList.get(i).getDetail());
                    }
                    String menuDetailCheck1 = sc.nextLine();
                    // 각 번호가 입력될 때 마다 그 항목에 대한 옵션 선택 UI가 나온다.
                    System.out.println("----------------------------");
                    for (Coffee a : coffList) {
                        if (coffList.get(Integer.parseInt(menuDetailCheck1) - 1) == a) {
                            System.out.println(a.getName() + "  |   가격 : " + a.getPrice() + "   |   " + a.getDetail());
                            System.out.println();
                            System.out.println("시럽이 필요하십니까?");
                            System.out.println("1. 예            2. 아니오");
                            // 왜 여기서 syrup이 바뀌지 않을까요? A.너가 -1을안써서 배열이 밀렷음
                            String optionCheck1 = sc.nextLine();
                            if (optionCheck1.equals("1")) {
                                a.setSyrup(true);
                            }
                            break;
                        }
                    }
                    if (!menuDetailCheck1.isEmpty()) {
                        // 2. 장바구니가 버어 있는지 체크 or 똑같은 주소를 가진 객체가 들어있는지 체크한다.
                        // 2-1 장바구니가 비어있거나 같은 클래스 객체가 없으면 그대로 장바구니에 넣는다.
                        // stream nonematch : 인자값의 식에 match되는 값이 없으면 true를 내뱉는다.
                        if (bascket.isEmpty() || bascket.stream().noneMatch(e -> e == coffList.get(Integer.parseInt(menuDetailCheck1) - 1))) {
                            System.out.println("check");
                            bascket.add(coffList.get(Integer.parseInt(menuDetailCheck1) - 1));
                            globalBascket.add(coffList.get(Integer.parseInt(menuDetailCheck1) - 1));
//                            System.out.println(bascket.stream().filter(e->e == coffList.get(Integer.parseInt(menuDetailCheck1) - 1)));;
                        }
                        // 2-2 장바구니가 비어있지 않을 때
                        // 2-2-1 같은 값이면 count만 ++ 해준다.
                        else if (bascket.stream().anyMatch(e -> e == coffList.get(Integer.parseInt(menuDetailCheck1) - 1))) {
                            for (Menu a : bascket) {
                                if (a == coffList.get(Integer.parseInt(menuDetailCheck1) - 1)) {
                                    a.increase();
                                }
                            }
                        }
                    }
                    break;
                case "2":
                    new MainMessage();
                    for (int i = 0; i < drinkList.size(); i++) {
                        System.out.println(i + 1 + ". " + drinkList.get(i).getName() + " | 가격 : " + drinkList.get(i).getPrice() + " | " + drinkList.get(i).getDetail());
                    }
                    String menuDetailCheck2 = sc.nextLine();
                    // 번호를 입력받는다.
                    for (Drink a : drinkList) {
                        if (drinkList.get(Integer.parseInt(menuDetailCheck2) - 1) == a) {
                            System.out.println(a.getName() + "  |   가격 : " + a.getPrice() + "   |   " + a.getDetail());
                            System.out.println();
                            System.out.println("탄산이 필요하십니까?");
                            System.out.println("1. 예            2. 아니오");
                            String optionCheck2 = sc.nextLine();
                            if (optionCheck2.equals("1")) {
                                a.setCarbonic(true);
                            }
                            break;
                        }
                    }
                    if (!menuDetailCheck2.isEmpty()) {
                        // 2. 장바구니가 버어 있는지 체크 or 똑같은 주소를 가진 객체가 들어있는지 체크한다.
                        // 2-1 장바구니가 비어있거나 같은 클래스 객체가 없으면 그대로 장바구니에 넣는다.
                        if (bascket.isEmpty() || bascket.stream().noneMatch(e -> e == drinkList.get(Integer.parseInt(menuDetailCheck2) - 1))) {
                            bascket.add(drinkList.get(Integer.parseInt(menuDetailCheck2) - 1));
                            globalBascket.add(drinkList.get(Integer.parseInt(menuDetailCheck2) - 1));
//                            System.out.println(bascket.stream().filter(e->e == drinkList.get(Integer.parseInt(menuDetailCheck2) - 1)));;
                        }
                        // 2-2 장바구니가 비어있지 않을 때
                        // 2-2-1 같은 값이면 count만 ++ 해준다.
                        else if (bascket.stream().anyMatch(e -> e == drinkList.get(Integer.parseInt(menuDetailCheck2) - 1))) {
                            for (Menu a : bascket) {
                                if (a == drinkList.get(Integer.parseInt(menuDetailCheck2) - 1)) {
                                    a.increase();
                                }
                            }
                        }
                    }
                    break;
                case "3":
                    new MainMessage();
                    for (int i = 0; i < dessertList.size(); i++) {
                        System.out.println(i + 1 + ". " + dessertList.get(i).getName() + " | 가격 : " + dessertList.get(i).getPrice() + " | " + dessertList.get(i).getDetail());
                    }
                    String menuDetailCheck3 = sc.nextLine();
                    for (Dessert a : dessertList) {
                        if (dessertList.get(Integer.parseInt(menuDetailCheck3) - 1) == a) {
                            System.out.println(a.getName() + "  |   가격 : " + a.getPrice() + "   |   " + a.getDetail());
                            System.out.println();
                            System.out.println("포크는 얼마나 필요한지 입력해주세요( 번호만 입력해 주시길 바랍니다. )");
                            String optionCheck3 = sc.nextLine();
                            if (!optionCheck3.isEmpty()) {
                                a.setPork(Integer.parseInt(optionCheck3));
                            }
                            break;
                        }
                    }
                    if (!menuDetailCheck3.isEmpty()) {
                        // 2. 장바구니가 버어 있는지 체크 or 똑같은 주소를 가진 객체가 들어있는지 체크한다.
                        // 2-1 장바구니가 비어있거나 같은 클래스 객체가 없으면 그대로 장바구니에 넣는다.
                        if (bascket.isEmpty() || bascket.stream().noneMatch(e -> e == dessertList.get(Integer.parseInt(menuDetailCheck3) - 1))) {
                            System.out.println("check");
                            bascket.add(dessertList.get(Integer.parseInt(menuDetailCheck3) - 1));
                            globalBascket.add(dessertList.get(Integer.parseInt(menuDetailCheck3) - 1));
//                            System.out.println(bascket.stream().filter(e->e == dessertList.get(Integer.parseInt(menuDetailCheck3) - 1)));;
                        }
                        // 2-2 장바구니가 비어있지 않을 때
                        // 2-2-1 같은 값이면 count만 ++ 해준다.
                        else if (bascket.stream().anyMatch(e -> e == dessertList.get(Integer.parseInt(menuDetailCheck3) - 1))) {
                            System.out.println("check");
                            for (Menu a : bascket) {
                                if (a == dessertList.get(Integer.parseInt(menuDetailCheck3) - 1)) {
                                    a.increase();
                                }
                            }
                        }
                    }
                    break;
                case "4":
                    // 장바구니가 비어있는 상태로 주문목록을 출력하면 띄워준다.
                    if (bascket.isEmpty()) {
                        System.out.println("ㅁ-----------------------ㅁ");
                        System.out.println("|  먼저 상품을 골라주세요!  |");
                        System.out.println("ㅁ-----------------------ㅁ");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        new Bascket();
                        // 여기 반복문을 stream으로 짤 수 있을거 같은데
                        // 근데 세세한 부분이 있기에 stream으로는 안될듯.
                        for (Menu menu : bascket) {
                            if (menu instanceof Coffee) {
                                System.out.println("|   " + menu.getName() + "   |   " + menu.getCount() + "개" + "   | 가격 : " + menu.getTotalPrice() + "  | " + menu.getDetail() + "    |  시럽 : " + ((Coffee) menu).getSyrup());
                            } else if (menu instanceof Drink) {
                                System.out.println("|   " + menu.getName() + "   |   " + menu.getCount() + "개" + "   | 가격 : " + menu.getTotalPrice() + "  | " + menu.getDetail() + "    |  탄산 : " + ((Drink) menu).isCarbonic());
                            } else if (menu instanceof Dessert) {
                                System.out.println("|   " + menu.getName() + "   |   " + menu.getCount() + "개" + "   | 가격 : " + menu.getTotalPrice() + "  | " + menu.getDetail() + "    |  포크 : " + ((Dessert) menu).getPork() + "개");
                            }
                        }
                        System.out.println();
                        System.out.println("[ Total ]");
                        for (Menu menu : bascket) {
                            total += menu.getTotalPrice();
                        }
                        System.out.println("총 가격 : " + total);
                        System.out.println("1. 주문          2. 메뉴판");
                        if (sc.next().equals("1")) {
                            // 총 판매금액 누적
                            globalTotal += total;
                            System.out.println("주문이 완료되었습니다!");
                            System.out.println();
                            // 대기순번 증가
                            waitingNumber++;
                            System.out.println("대기번호는 [ " + waitingNumber + " ] 번 입니다.");
                            System.out.println("3초후 메뉴판으로 돌아갑니다.");
                            bascket.clear();
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                case "5":
                    if (bascket.isEmpty()) {
                        System.out.println("ㅁ-----------------------ㅁ");
                        System.out.println("|  먼저 상품을 골라주세요!  |");
                        System.out.println("ㅁ-----------------------ㅁ");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        new CancelMessage();
                        String cancelCheck = sc.next();
                        if (cancelCheck.equals("1")) {
                            // 주문 취소하면 장바구니를 비워준다.
                            bascket.clear();
                        }
                    }
                    break;
                case "0":
                    System.out.println("[ 총 판매금액 현황 ]");
                    System.out.println("현재까지 총 판매된 금액은 [ 판매금액 : " + globalTotal + "원 ]");
                    System.out.println("---------------------------------------------------------");
                    System.out.println("[ 현재 팔린 상품 목록 ]");
                    for (Menu menu : globalBascket) {
                        if (menu instanceof Coffee) {
                            System.out.println("|   " + menu.getName() + "   |   " + menu.getCount() + "개");
                        } else if (menu instanceof Drink) {
                            System.out.println("|   " + menu.getName() + "   |   " + menu.getCount() + "개");
                        } else if (menu instanceof Dessert) {
                            System.out.println("|   " + menu.getName() + "   |   " + menu.getCount() + "개");
                        }
                    }
                    System.out.println();
                    System.out.println("1. 돌아가기");
                    boolean errNum = true;
                    while (errNum) {
                        String userInput = sc.next();
                        if (userInput.equals("1")) {
                            errNum = false;
                        } else {
                            System.out.println("잘못된 입력입니다. 1을 입력하여 돌아가세요.");
                        }
                    }
                    break;
                default:
                    System.out.println("여기는 분명 실행이 안되어야 되는데");
                    break;
            }
        }
    }
}
