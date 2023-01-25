package my.app.service;

import my.app.domain.entity.SlaveOwner;
import my.app.domain.repository.SlaveOwnerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

/**
 * Class for testing {@link SlaveOwnerServiceImpl}.
 *
 * Created by Pargev 25.01.2023
 */
@ExtendWith(MockitoExtension.class)
class SlaveOwnerServiceImplTest {

    @Mock
    private SlaveOwnerRepository slaveOwnerRepository;

    @Mock
    private SlaveService slaveService;

    @InjectMocks
    private SlaveOwnerServiceImpl slaveOwnerService;

    @Test
    void createRandomSlavesAndOwner() {
        var slavesCount = 4;
        var slaveOwnerCaptor = ArgumentCaptor.forClass(SlaveOwner.class);

        slaveOwnerService.createRandomSlavesAndOwner(slavesCount);
        verify(slaveOwnerRepository).save(slaveOwnerCaptor.capture());
        var slaveOwner = slaveOwnerCaptor.getValue();
        assertNotNull(slaveOwner.getName());
        assertNotNull(slaveOwner.getProvince());
        assertNotNull(slaveOwner.getOccupation());
        assertNotNull(slaveOwner.getBullshit());
        verify(slaveService).createRandomSlaves(eq(slavesCount), eq(slaveOwner));
    }
}