package my.app.controller;

import my.app.domain.entity.Slave;
import my.app.domain.entity.SlaveOwner;
import my.app.service.SlaveOwnerService;
import my.app.service.SlaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Controller
@RequestMapping(value = "slave")
public class SlaveController {

    private final SlaveService slaveService;
    private final SlaveOwnerService slaveOwnerService;

    @Autowired
    public SlaveController(SlaveService slaveService, SlaveOwnerService slaveOwnerService) {
        this.slaveService = slaveService;
        this.slaveOwnerService = slaveOwnerService;
    }

    @GetMapping(value = "get/{id}")
    public @ResponseBody Slave getSlaveById(@PathVariable int id) {
        return slaveService.getSlaveById(id).orElse(null);
    }

    @GetMapping(value = "getAllSlaves")
    public @ResponseBody List<Slave> getAllSlavesList() {
        return slaveService.getAllSlaves();
    }

    @GetMapping(value = "getAllSlaveOwners")
    public @ResponseBody List<SlaveOwner> getAllSlaveOwners() {
        return slaveOwnerService.getAllSlaveOwners();
    }

    @PostMapping(value = "createRandomSlaves")
    @Transactional
    public @ResponseBody List<Slave> createRandomSlaves() {
        var slaveOwner = slaveOwnerService.createRandomSlaveOwner();
        var slaves = new ArrayList<Slave>();
        for (int i = 0; i < 5; i++) {
            slaves.add(slaveService.createRandomSlave(slaveOwner));
        }
        return slaves;
    }
}
