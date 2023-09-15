package spring.Pro_P_F.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.Pro_P_F.domain.Community;
import spring.Pro_P_F.domain.Job;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
}
