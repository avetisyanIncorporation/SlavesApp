package my.app.service;

import my.app.domain.entity.Slave;
import my.app.domain.entity.SlaveOwner;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

/**
 * @author created by Pargev A. on 18.11.2022
 */
public interface SlaveService {

    List<Slave> getAllSlaves();

    @NonNull Slave createRandomSlave(@NonNull SlaveOwner slaveOwner);

    Optional<Slave> getSlaveById(long id);

    List<Slave> getSlavesByOwnerId(long ownerId);
}
