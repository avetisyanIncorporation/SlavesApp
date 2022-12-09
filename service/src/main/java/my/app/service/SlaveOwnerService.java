package my.app.service;

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

    @NonNull SlaveOwner createRandomSlaveOwner();

    @NonNull SlaveOwner saveSlaveOwner(@NonNull SlaveOwner slaveOwner);
}
