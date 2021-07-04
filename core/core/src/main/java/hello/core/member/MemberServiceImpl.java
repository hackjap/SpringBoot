package hello.core.member;

public class MemberServiceImpl implements  MemberService{

    // 관심사의 분리 (역할과 구현의 분리)
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
       return  memberRepository.findById(memberId);
    }
}
