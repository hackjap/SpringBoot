package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

/*     관심사 분리
        private final MemberRepository memberRepository = new MemoryMemberRepository();
        private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // fixDisCountPolicy(구현체)도 의존하므로 DIP 위반!*/

    private MemberRepository memoryRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memoryRepository, DiscountPolicy discountPolicy) {
        this.memoryRepository = memoryRepository;
        this.discountPolicy = discountPolicy;
    }

    // 인터페이스에만 의존하도록 구현
    //  private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // 할인정책 변경
//    private DiscountPolicy discountPolicy;


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memoryRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
        // 주문(회원id,주문명,주문가격,주문할인가격)
    }

    // 테스트 용도
    public MemberRepository getMemoryRepository() {
        return memoryRepository;
    }
}
