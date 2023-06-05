package spring.Pro_P_F.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.Pro_P_F.domain.Member;
import spring.Pro_P_F.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    @Transactional
    public String join(Member member) {
        memberRepository.join(member);

        return member.getM_id();
    }

    public Member findOne(String memberId) {
        return memberRepository.findOne(memberId);
    }



}
