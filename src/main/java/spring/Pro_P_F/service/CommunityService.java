package spring.Pro_P_F.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.Pro_P_F.domain.Community;
import spring.Pro_P_F.domain.Posting;
import spring.Pro_P_F.repository.CommunityRepository;


import java.util.List;

@Service
public class CommunityService {
    private final CommunityRepository communityRepository;

    @Autowired
    public CommunityService(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    // 모든 커뮤니티 게시물을 가져오는 메서드
    public List<Community> getAllCommunities() {
        return communityRepository.findAll();
    }

    // 특정 카테고리의 커뮤니티 게시물을 가져오는 메서드
    public List<Community> getCommunitiesByCategory(String category) {
        return communityRepository.findByCategory(category);
    }

    // 커뮤니티 게시물 저장 메서드
    public void saveCommunity(Community community) {
        communityRepository.save(community);
    }

    // 커뮤니티 게시물 삭제 메서드
    public void deleteCommunity(Long id) {
        communityRepository.deleteById(id);
    }
    public List<Community> findAllComm() {
        return communityRepository.findAll();
    }

    public List<Community> findByseq(Long id){
        return communityRepository.findByseq(id);
    }


}
