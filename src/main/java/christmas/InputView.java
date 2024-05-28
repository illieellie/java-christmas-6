package christmas;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private InputView() {

    }

    public static int inputComment1() throws IllegalArgumentException{
        int day = 0;
        try {
            String s = readLine();
            day = Integer.parseInt(s);
            if(!(1<=day&&day<=31)){
                throw new IllegalArgumentException();
            }
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
        return day;
    }
    // 정수가 들어와야하고 -> 문자이면 exception
    // 1~31 숫자가 들어와야하고 -> exception
    // 모두 호출한 곳으로 에러 넘기기
}
