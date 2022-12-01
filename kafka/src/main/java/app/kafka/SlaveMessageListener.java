package app.kafka;

import my.app.domain.dto.SlaveOwnerDTO;
import my.app.domain.entity.SlaveOwner;
import my.app.service.SlaveOwnerService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SlaveMessageListener {

    private final SlaveOwnerService slaveOwnerService;

    @Autowired
    public SlaveMessageListener(SlaveOwnerService slaveOwnerService) {
        this.slaveOwnerService = slaveOwnerService;
    }

    @KafkaListener(topics="slave_owner")
    public void msgListener(ConsumerRecord<Long, SlaveOwnerDTO> record){
        System.out.println(record.partition());
        System.out.println(record.key());
        System.out.println(record.value());
        var slaveOwner = slaveOwnerService.saveSlaveOwner(new SlaveOwner(record.value()));
        System.out.println("Add new slaveOwner: " + slaveOwner);
    }

}
