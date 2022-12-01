package my.app.domain.repository;

import my.app.domain.entity.SlaveOwner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author created by Pargev A. on 18.11.2022
 */
public interface SlaveOwnerRepository extends JpaRepository<SlaveOwner, Long> {
}
