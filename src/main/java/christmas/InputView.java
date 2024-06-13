package christmas;

import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final int day1 = 1;
    private static final int day31 = 31;
    private static final int maxOrderMenu = 20;
    static Menu menu = new Menu();

    private InputView() {

    }

    // 정수, 1~31 숫자가 들어와야함 -> 아니면 exception
    public static int inputComment1() {
        while (true) {
            int day = 0;
            try {
                String s = readLine();
                day = Integer.parseInt(s);
                if (!(day1 <= day && day <= day31)) {
                    throw new IllegalArgumentException();
                }
                return day;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }

    public static Map<String, Integer> inputComment2() {
        Map<String, Integer> order = new HashMap<>(); // 주문 이름-개수 반환 예정

        while (true) {
            try {
                String s = readLine();
                String[] temp = s.split(",");

                for (int i = 0; i < temp.length; i++) {
                    String[] temp2 = temp[i].split("-"); // 타파스-1 의 형식
                    validation1(temp2, menu.findMenu(temp2[0]), order.containsKey(temp2[0]));
                    order.put(temp2[0], Integer.parseInt(temp2[1]));
                }
                validation2(order);
                return order; // 메뉴-값 반환
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }


    public static void validation1(String[] temp, boolean existMenu, boolean orderDuplicate) throws IllegalArgumentException {

        if (temp.length != 2 || !existMenu || Integer.parseInt(temp[1]) == 0 || orderDuplicate) {
            // 메뉴-가격으로 나누어지지 않으면
            // 메뉴가 없다면
            // 하나의 주문수가 0이면
            // 메뉴가 중복이면
            throw new IllegalArgumentException();
        }
    }

    public static void validation2(Map<String, Integer> order) throws IllegalArgumentException {
        int menuNumber = 0;
        int drinkNumber = 0;

        for (String key : order.keySet()) {
            menuNumber += order.get(key); // 주문 메뉴 수 (메뉴+음료)
            drinkNumber += menu.orderDrink(key); // 주문 음료 수
        }

        if (menuNumber > maxOrderMenu || menuNumber == 0 || menuNumber == drinkNumber) {
            // 메뉴가 20개 초과이면
            // 주문 메뉴가 0개면
            // 주문에 drink만 있으면
            throw new IllegalArgumentException();
        }
    }


}
