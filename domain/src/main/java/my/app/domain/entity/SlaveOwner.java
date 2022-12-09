package my.app.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import my.app.domain.dto.SlaveOwnerDTO;
import my.app.domain.enumeration.Bullshit;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * @author created by Pargev A. on 18.11.2022
 */
@Entity
@Table(name = "slave_owner")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SlaveOwner implements Serializable {

    @Serial
    private static final long serialVersionUID = 1164298542623230269L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "province")
    private String province;

    @Column(name = "occupation")
    private String occupation;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "BULLSHITILITY_ID")
    private Bullshit bullshit;

    @OneToMany(mappedBy = "slaveOwner")
    @JsonManagedReference
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Slave> slaves;

    public SlaveOwner() {
    }

    public SlaveOwner(String name, String province, String occupation, Bullshit bullshit) {
        this.name = name;
        this.province = province;
        this.occupation = occupation;
        this.bullshit = bullshit;
    }

    public SlaveOwner(SlaveOwnerDTO slaveOwnerDTO) {
        this.name = slaveOwnerDTO.getName();
        this.province = slaveOwnerDTO.getProvince();
        this.occupation = slaveOwnerDTO.getOccupation();
        this.bullshit = Bullshit.of(slaveOwnerDTO.getBullshit());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Bullshit getBullshit() {
        return bullshit;
    }

    public void setBullshit(Bullshit bullshit) {
        this.bullshit = bullshit;
    }

    public Set<Slave> getSlaves() {
        return slaves;
    }

    public void setSlaves(Set<Slave> slaves) {
        this.slaves = slaves;
    }

    public void addSlave(Slave slave) {
        if (this.slaves != null) {
            this.slaves.add(slave);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SlaveOwner that = (SlaveOwner) o;
        return id == that.id;
    }

    @Override
    public String toString() {
        return "SlaveOwner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", occupation='" + occupation + '\'' +
                ", bullshit=" + bullshit +
                '}';
    }
}
