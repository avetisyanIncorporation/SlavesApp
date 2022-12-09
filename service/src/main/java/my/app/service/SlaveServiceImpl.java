package my.app.service;

import my.app.domain.entity.Slave;
import my.app.domain.entity.SlaveOwner;
import my.app.domain.enumeration.Gender;
import my.app.domain.repository.SlaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * @author created by Pargev A. on 18.11.2022
 */
@Service
@Transactional
public class SlaveServiceImpl implements SlaveService {

    private final SlaveRepository slaveRepository;

    private final List<String> AVAILABLE_SLAVE_NAMES = List.of("Jony", "Jack", "Jako", "Jackson", "Jonny", "Blacky",
            "Browny", "Litty", "Biggi", "Snoopy");

    @Autowired
    public SlaveServiceImpl(SlaveRepository slaveRepository) {
        this.slaveRepository = slaveRepository;
    }

    @Override
    public Optional<Slave> getSlaveById(long id) {
        return slaveRepository.findById(id);
    }

    @Override
    public List<Slave> getAllSlaves() {
        return slaveRepository.findAll();
    }

    @Override
    public @NonNull Slave createRandomSlave(@NonNull SlaveOwner slaveOwner) {
        Random random = new Random();
        var slave = new Slave(AVAILABLE_SLAVE_NAMES.get(random.nextInt(AVAILABLE_SLAVE_NAMES.size())),
                Gender.randomGender(random), (short) random.nextInt(100), random.nextInt(9999), slaveOwner);
        return slaveRepository.save(slave);
    }

    @Override
    @Cacheable(value = "slavesByOwnerCache", key = "#ownerId")
    public List<Slave> getSlavesByOwnerId(long ownerId) {
        return slaveRepository.getSlavesByOwnerId(ownerId);
    }
}
