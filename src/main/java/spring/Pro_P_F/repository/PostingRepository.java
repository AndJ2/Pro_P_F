package spring.Pro_P_F.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.Pro_P_F.domain.Community;
import spring.Pro_P_F.domain.Posting;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostingRepository {

    private final EntityManager em;

    public void save(Posting posting) {
        em.persist(posting);
    }

    public List<Posting> findAll() {
        return em.createQuery("select post from Posting post", Posting.class)
                .getResultList();
    }

}
