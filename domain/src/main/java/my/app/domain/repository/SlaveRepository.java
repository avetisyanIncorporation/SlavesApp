package my.app.domain.repository;

import my.app.domain.entity.Slave;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author created by Pargev A. on 18.11.2022
 */
public interface SlaveRepository extends JpaRepository<Slave, Long> {

//    @Query("SELECT s FROM Slave s WHERE s.slaveOwner.id = :ownerId")
//    List<Slave> getSlaveBySlaveOwnerId(@Param("ownerId") long slaveOwnerId);
}
