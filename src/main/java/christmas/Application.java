package christmas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int orderDay = CommentIO1(); // 날짜
        Map<String,Integer> order = CommentIO2(); // 메뉴-개수

        OutputView.printOrder(order); // 주문 프린트
        Order orderService = new Order();

        // string 을 반환 하도록 다시 수정
        int sumPrice = orderService.sumPrice(order);
        OutputView.printPrice(sumPrice);

        boolean gift = orderService.getGift(sumPrice); // 기프트
        OutputView.printGift(gift);

        // 혜택내역
        Map<String,Integer> benefit = orderService.getBenefit(orderDay,order,gift);
        OutputView.printBenefit(benefit);

        // 총혜택 금액 print
        int sumBenefitPrice = orderService.sumBenefitPrice(benefit);
        OutputView.printBenefitPrice(sumBenefitPrice);

        // 최종 금액
        OutputView.printResultPrice(sumPrice-sumBenefitPrice);

//        String badge = orderService.getBadge(discountPrice);
//        OutputView.printBadge(badge);

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

    public static Map<String,Integer> CommentIO2(){
        Map<String,Integer> order;
        OutputView.printComment2();
        while(true){
            try {
                order = InputView.inputComment2(); // map 반환
                if (order.size()!=0) break;
            }catch (IllegalArgumentException e){
                OutputView.printErrorMessageMenu();
            }
        }
       return order; // 메뉴-개수 반환
    }

}
