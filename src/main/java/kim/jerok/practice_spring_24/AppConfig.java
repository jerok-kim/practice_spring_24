package kim.jerok.practice_spring_24;

import kim.jerok.practice_spring_24.discount.DiscountPolicy;
import kim.jerok.practice_spring_24.discount.FixDiscountPolicy;
import kim.jerok.practice_spring_24.discount.RateDiscountPolicy;
import kim.jerok.practice_spring_24.member.MemberService;
import kim.jerok.practice_spring_24.member.MemberServiceImpl;
import kim.jerok.practice_spring_24.member.MemoryMemberRepository;
import kim.jerok.practice_spring_24.order.OrderService;
import kim.jerok.practice_spring_24.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository()
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
