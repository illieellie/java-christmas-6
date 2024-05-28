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
        // 배열로 만든 다음 map 에 넣기
        String[] temp = s.split(",");
        Menu menu = new Menu();
        for (int i = 0; i < temp.length; i++){
            String []temp2 = temp[i].split("-"); // 타파스-1 의 형식

            validationFormat(temp2.length);
            validationNonMenu(menu.findMenu(temp2[0]));
            validationNum(Integer.parseInt(temp2[1]));
            validaionMenuDuplicate(order.containsKey(temp2[0]));

            order.put(temp2[0], Integer.parseInt(temp2[1]));
        }
            return order; // 메뉴-값 반환
    }

    public static void validationFormat(int length) throws IllegalArgumentException{
        if(length!=2){ // 메뉴 가격으로 나누어지지 않았다면
            throw new IllegalArgumentException();
        }
    }
    public static void validationNonMenu(boolean exist) throws IllegalArgumentException{
        if(!exist){ // 메뉴가 없다면
            throw new IllegalArgumentException();
        }
    }
    public static void validationNum(int num) throws IllegalArgumentException{
        if(num<1){ // 개수가 1미만
            throw new IllegalArgumentException();
        }
    }
    public static void validaionMenuDuplicate(boolean num) throws IllegalArgumentException{
        if(num){ // 중복 메뉴
            throw new IllegalArgumentException();
        }
    }

}
