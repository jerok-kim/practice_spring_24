package kim.jerok.practice_spring_24.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
