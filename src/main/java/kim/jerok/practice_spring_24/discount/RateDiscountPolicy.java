package kim.jerok.practice_spring_24.discount;

import kim.jerok.practice_spring_24.annotation.MainDiscountPolicy;
import kim.jerok.practice_spring_24.member.Grade;
import kim.jerok.practice_spring_24.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
