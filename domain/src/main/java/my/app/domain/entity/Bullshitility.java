package my.app.domain.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "BULLSHITILITY")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Bullshitility implements Serializable {

    @Serial
    private static final long serialVersionUID = 7181769246229109508L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private short id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Bullshitility() {
    }

    public Bullshitility(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
