package kim.jerok.practice_spring_24.order;

import kim.jerok.practice_spring_24.discount.FixDiscountPolicy;
import kim.jerok.practice_spring_24.member.Grade;
import kim.jerok.practice_spring_24.member.Member;
import kim.jerok.practice_spring_24.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
