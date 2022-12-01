package my.app.service;

import my.app.domain.entity.SlaveOwner;
import my.app.domain.enumeration.Bullshit;
import my.app.domain.repository.SlaveOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

/**
 * @author created by Pargev A. on 18.11.2022
 */
@Service
@Transactional
public class SlaveOwnerServiceImpl implements SlaveOwnerService {

    private final SlaveOwnerRepository slaveOwnerRepository;

    private final List<String> AVAILABLE_SLAVE_OWNER_NAMES = List.of("Candy", "Melissa", "Mercedes");
    private final List<String> AVAILABLE_SLAVE_OWNER_PROVINCE = List.of("Mississippi", "Texas", "London");
    private final List<String> AVAILABLE_SLAVE_OWNER_OCCUPATION = List.of("Silk field", "Mining", "Cattle breeding");

    @Autowired
    public SlaveOwnerServiceImpl(SlaveOwnerRepository slaveOwnerRepository) {
        this.slaveOwnerRepository = slaveOwnerRepository;
    }

    @Override
    public List<SlaveOwner> getAllSlaveOwners() {
        return slaveOwnerRepository.findAll();
    }

    @Override
    public @NonNull SlaveOwner createRandomSlaveOwner() {
        Random random = new Random();
        var slaveOwner = new SlaveOwner(
                AVAILABLE_SLAVE_OWNER_NAMES.get(random.nextInt(AVAILABLE_SLAVE_OWNER_NAMES.size())),
                AVAILABLE_SLAVE_OWNER_PROVINCE.get(random.nextInt(AVAILABLE_SLAVE_OWNER_PROVINCE.size())),
                AVAILABLE_SLAVE_OWNER_OCCUPATION.get(random.nextInt(AVAILABLE_SLAVE_OWNER_OCCUPATION.size())),
                Bullshit.randomBullshit(random));
        return slaveOwnerRepository.save(slaveOwner);
    }

    @Override
    public @NonNull SlaveOwner saveSlaveOwner(@NonNull SlaveOwner slaveOwner) {
        return slaveOwnerRepository.save(slaveOwner);
    }
}
