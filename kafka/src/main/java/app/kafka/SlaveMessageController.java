package app.kafka;

import my.app.domain.dto.SlaveOwnerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("msg")
public class SlaveMessageController {

    @Value("${slave.slave_owner.kafka.topics}")
    private String slaveOwnerTopic;
    private final Random random = new Random();

    private final KafkaTemplate<Long, SlaveOwnerDTO> kafkaTemplateOfSlaveOwner;

    @Autowired
    public SlaveMessageController(KafkaTemplate<Long, SlaveOwnerDTO> kafkaTemplateOfSlaveOwner) {
        this.kafkaTemplateOfSlaveOwner = kafkaTemplateOfSlaveOwner;
    }

    @PostMapping(value = "createSlaveOwner")
    public ResponseEntity<?> createSlaveOwner(@RequestBody SlaveOwnerDTO slaveOwnerDTO){
        ListenableFuture<SendResult<Long, SlaveOwnerDTO>> future =
                kafkaTemplateOfSlaveOwner.send(slaveOwnerTopic, random.nextLong(), slaveOwnerDTO);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplateOfSlaveOwner.flush();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
