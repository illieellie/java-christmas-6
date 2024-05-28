package christmas;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int day = CommentIO1(); // 날짜
    }

    public static int CommentIO1(){
        int day = 0;
        OutputView.printComment1();
        while(true){
            try {
                day = InputView.inputComment1();
                if (day!=0) break;
            }catch (IllegalArgumentException e){
                OutputView.printErrorMessageDay();
            }
        }
        return day; // 날짜 반환
    }

}
