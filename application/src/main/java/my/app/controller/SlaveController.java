package my.app.controller;

import my.app.aspect.Profiling;
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
import java.util.List;

@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Controller
@RequestMapping(value = "slave")
@Profiling
public class SlaveController {

    static {
        System.out.println("SlaveController initialization");
    }
    
    private final int RANDOM_SLAVES_COUNT = 5;

    private final SlaveService slaveService;
    private final SlaveOwnerService slaveOwnerService;

    @Autowired
    public SlaveController(SlaveService slaveService, SlaveOwnerService slaveOwnerService) {
        this.slaveService = slaveService;
        this.slaveOwnerService = slaveOwnerService;
    }

    @GetMapping(value = "getSlave/{id}")
    public @ResponseBody Slave getSlaveById(@PathVariable int id) {
        return slaveService.getSlaveById(id).orElse(null);
    }

    @GetMapping(value = "getSlaveOwner/{id}")
    public @ResponseBody SlaveOwner getSlaveOwner(@PathVariable int id) {
        return slaveOwnerService.getSlaveOwnerById(id).orElse(null);
    }


    @GetMapping(value = "getSlavesByOwner/{ownerId}")
    public @ResponseBody List<Slave> getSlavesByOwnerId(@PathVariable long ownerId) {
        return slaveService.getSlavesByOwnerId(ownerId);
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
        return slaveOwnerService.createRandomSlavesAndOwner(RANDOM_SLAVES_COUNT);
    }
}
