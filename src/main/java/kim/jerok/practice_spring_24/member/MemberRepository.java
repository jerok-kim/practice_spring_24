package kim.jerok.practice_spring_24.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
