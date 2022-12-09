package my.app.domain.repository;

import my.app.domain.entity.Slave;
import my.app.domain.entity.SlaveOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author created by Pargev A. on 18.11.2022
 */
public interface SlaveOwnerRepository extends JpaRepository<SlaveOwner, Long> {

    @Deprecated
    @Query("SELECT so.slaves FROM SlaveOwner so WHERE so.id = :ownerId")
    List<Slave> getSlavesByOwnerId(@Param("ownerId") long ownerId);
}
