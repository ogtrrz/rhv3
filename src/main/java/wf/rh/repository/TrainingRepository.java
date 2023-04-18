package wf.rh.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import wf.rh.domain.Training;

/**
 * Spring Data JPA repository for the Training entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {}
