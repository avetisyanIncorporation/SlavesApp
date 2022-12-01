package my.app.domain.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import my.app.domain.enumeration.Gender;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author created by Pargev A. on 18.11.2022
 */
@Entity
@Table(name = "SLAVE")
public class Slave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "age")
    private short age;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JsonBackReference
    private SlaveOwner slaveOwner;

    public Slave() {
    }

    public Slave(String name, Gender gender, short age, int price, SlaveOwner slaveOwner) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.price = price;
        this.slaveOwner = slaveOwner;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SlaveOwner getSlaveOwner() {
        return slaveOwner;
    }

    public void setSlaveOwner(SlaveOwner slaveOwner) {
        this.slaveOwner = slaveOwner;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slave slave = (Slave) o;
        return id == slave.id;
    }

    @Override
    public String toString() {
        return "Slave{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", price=" + price + "$" +
//                ", slaveOwner=" + slaveOwner.getName() + " (" + slaveOwner.getId() + ")" +
                '}';
    }
}
