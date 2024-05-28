package christmas;

import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private InputView() {

    }

    // 정수가 들어와야하고 -> 문자이면 exception
    // 1~31 숫자가 들어와야하고 -> exception
    // 모두 호출한 곳으로 에러 넘기기
    public static int inputComment1() throws IllegalArgumentException {
        int day = 0;
        try {
            String s = readLine();
            day = Integer.parseInt(s);
            if (!(1 <= day && day <= 31)) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return day;
    }


    public static Map<String, Integer> inputComment2() throws IllegalArgumentException {
        Map<String, Integer> order = new HashMap<>();
        // string 형식으로 받아서 map 에 이름,개수 분리해서 넘겨줄 예정
        String s = readLine();
        int menuNumber = 0, onlyDrink = 0; // 메뉴 총량 // 0이면 음료만 주문
        // 배열로 만든 다음 map 에 넣기
        String[] temp = s.split(",");
        Menu menu = new Menu();
        validationOrder(temp.length);
        for (int i = 0; i < temp.length; i++){
            String []temp2 = temp[i].split("-"); // 타파스-1 의 형식

            validation1(temp2.length, menu.findMenu(temp2[0]), Integer.parseInt(temp2[1]),order.containsKey(temp2[0]));

            menuNumber +=Integer.parseInt(temp2[1]);
            onlyDrink+=menu.orderOnlyDrink(temp2[0]);

            order.put(temp2[0], Integer.parseInt(temp2[1]));
        }
            validation2(menuNumber,onlyDrink);
            // 음료만 주문 시 주문 할 수 없음
            return order; // 메뉴-값 반환
    }

    public static void validation1(int length, boolean existMenu, int orderNum, boolean orderDuplicate) throws IllegalArgumentException{
        if(length!=2 ||!existMenu ||orderNum==0||orderDuplicate){
            // 메뉴 가격으로 나누어지지 않으면
            // 메뉴가 없다면
            // 하나의 주문수가 0이면
            // 메뉴가 중복이면
            throw new IllegalArgumentException();
        }
    }
    public static void validation2(int menuNumber, int onlyDrink) throws IllegalArgumentException{
        if(menuNumber>20||onlyDrink==0){
            // 메뉴가 20개 이상이면
            // 주문에 drink만 있다면
            throw new IllegalArgumentException();
        }
    }

    public static void validationOrder(int num) throws IllegalArgumentException{
        if(num==0){
            throw new IllegalArgumentException();
        }
    }





}
