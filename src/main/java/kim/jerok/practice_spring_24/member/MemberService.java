package kim.jerok.practice_spring_24.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
