package spring.Pro_P_F.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.Pro_P_F.domain.Community;
import spring.Pro_P_F.domain.Posting;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class PostingRepository {

    private final EntityManager em;

    public void save(Posting posting) {
        em.persist(posting);
    }
}
