package kim.jerok.practice_spring_24;

import kim.jerok.practice_spring_24.member.Grade;
import kim.jerok.practice_spring_24.member.Member;
import kim.jerok.practice_spring_24.member.MemberService;
import kim.jerok.practice_spring_24.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }

}
