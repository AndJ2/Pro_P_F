package spring.Pro_P_F.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.Pro_P_F.domain.Community;
import spring.Pro_P_F.domain.Member;
import spring.Pro_P_F.repository.CommunityRepository;
import spring.Pro_P_F.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommunityService {
    private final CommunityRepository communityRepository;

    // 회원가입
    @Transactional
    public Long save(Community community) {
        communityRepository.save(community);

        return community.getC_seq();
    }

    public List<Community> findAllComm() {
        return communityRepository.findAll();
    }


}
