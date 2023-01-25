package my.app.service;

import my.app.domain.entity.Slave;
import my.app.domain.entity.SlaveOwner;
import my.app.domain.enumeration.Gender;
import my.app.domain.repository.SlaveRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Class for testing {@link SlaveServiceImpl}.
 *
 * Created by Pargev 01.12.2022
 */
@ExtendWith(MockitoExtension.class)
class SlaveServiceImplTest {

    @Mock
    private SlaveRepository slaveRepository;

    @InjectMocks
    private SlaveServiceImpl slaveService;

    @Test
    void getAllSlavesTest() {
        var steve = new Slave();
        steve.setName("Steve");
        steve.setAge((short) 21);
        var jack = new Slave();
        jack.setName("Jack");
        jack.setGender(Gender.MAN);
        var slaves = List.of(steve, jack);
        when(slaveRepository.findAll()).thenReturn(slaves);

        var result = slaveService.getAllSlaves();
        assertEquals(slaves.size(), result.size());
        assertEquals(steve.getName(), slaves.get(0).getName());
        assertEquals(steve.getAge(), slaves.get(0).getAge());
        assertEquals(jack.getName(), slaves.get(1).getName());
        assertEquals(jack.getGender(), slaves.get(1).getGender());
    }

    @Test
    void createRandomSlaveTest() {
        var slaveOwner = mock(SlaveOwner.class);
        var argumentCaptor = ArgumentCaptor.forClass(List.class);
        var slavesCount = 6;

        slaveService.createRandomSlaves(slavesCount, slaveOwner);
        verify(slaveRepository).saveAll(argumentCaptor.capture());

        var result = (List<Slave>) argumentCaptor.getValue();
        assertEquals(slavesCount, result.size());
        var slave0 = result.get(0);
        assertNotNull(slave0.getName());
        assertNotNull(slave0.getGender());
        assertEquals(slaveOwner, slave0.getSlaveOwner());
    }

}
