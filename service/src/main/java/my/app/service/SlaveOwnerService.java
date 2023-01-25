package my.app.service;

import my.app.domain.entity.Slave;
import my.app.domain.entity.SlaveOwner;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

/**
 * @author created by Pargev A. on 18.11.2022
 */
public interface SlaveOwnerService {

    @NonNull Optional<SlaveOwner> getSlaveOwnerById(long id);

    List<SlaveOwner> getAllSlaveOwners();

    @NonNull List<Slave> createRandomSlavesAndOwner(int slavesCount);

    @NonNull SlaveOwner saveSlaveOwner(@NonNull SlaveOwner slaveOwner);
}
