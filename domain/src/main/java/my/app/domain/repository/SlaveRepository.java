package my.app.domain.repository;

import my.app.domain.entity.Slave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author created by Pargev A. on 18.11.2022
 */
public interface SlaveRepository extends JpaRepository<Slave, Long> {

    @Query("SELECT s FROM Slave s WHERE s.slaveOwner.id = :ownerId")
    List<Slave> getSlavesByOwnerId(@Param("ownerId") long ownerId);
}
