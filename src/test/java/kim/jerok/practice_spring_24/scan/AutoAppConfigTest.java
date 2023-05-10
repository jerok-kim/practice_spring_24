package kim.jerok.practice_spring_24.scan;

import kim.jerok.practice_spring_24.AutoAppConfig;
import kim.jerok.practice_spring_24.member.MemberRepository;
import kim.jerok.practice_spring_24.member.MemberServiceImpl;
import kim.jerok.practice_spring_24.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

        OrderServiceImpl bean = ac.getBean("orderServiceImpl", OrderServiceImpl.class);
        MemberRepository memberRepository = bean.getMemberRepository();
        System.out.println("memberRepository = " + memberRepository);
    }
}
