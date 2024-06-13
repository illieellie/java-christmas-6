package christmas;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 날짜 입력
        OutputView.printComment1();
        int orderDay = InputView.inputComment1(); // 날짜

        // 메뉴-개수 입력
        OutputView.printComment2();
        Map<String, Integer> order = InputView.inputComment2(); // 메뉴-개수

        OutputView.printOrder(order); // 주문 프린트
        Order orderService = new Order();

        // 할인 전 총 금액
        int sumPrice = orderService.sumPrice(order);
        OutputView.printPrice(sumPrice);

        // 기프트
        boolean gift = orderService.getGift(sumPrice);
        OutputView.printGift(gift);

        // 혜택내역
        Map<String, Integer> benefit = orderService.getBenefit(orderDay, sumPrice, order, gift);
        OutputView.printBenefit(benefit);

        // 총혜택 금액 print
        int sumBenefitPrice = orderService.sumBenefitPrice(benefit);
        OutputView.printBenefitPrice(sumBenefitPrice);

        // 최종 금액
        OutputView.printResultPrice(sumPrice - sumBenefitPrice);

        // 배지
        String badge = orderService.getBadge(sumBenefitPrice);
        OutputView.printBadge(badge);

    }

}
