package spring.Pro_P_F.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.Pro_P_F.domain.Community;
import spring.Pro_P_F.domain.Member;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class CommunityRepository {

    private final EntityManager em;

    // 커뮤니티 글 등록
    public void save(Community community) {
        em.persist(community);
    }
}
