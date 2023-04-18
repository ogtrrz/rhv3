package wf.rh.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Evidence.
 */
@Entity
@Table(name = "evidence")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Evidence implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "training_id")
    private Long trainingId;

    @Column(name = "requirents_id")
    private Long requirentsId;

    @NotNull
    @Size(max = 500)
    @Column(name = "description", length = 500, nullable = false)
    private String description;

    @Column(name = "expiration")
    private Instant expiration;

    @Column(name = "link")
    private String link;

    @ManyToOne
    @JsonIgnoreProperties(value = { "evidences", "course", "employee" }, allowSetters = true)
    private Training training;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Evidence id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrainingId() {
        return this.trainingId;
    }

    public Evidence trainingId(Long trainingId) {
        this.setTrainingId(trainingId);
        return this;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    public Long getRequirentsId() {
        return this.requirentsId;
    }

    public Evidence requirentsId(Long requirentsId) {
        this.setRequirentsId(requirentsId);
        return this;
    }

    public void setRequirentsId(Long requirentsId) {
        this.requirentsId = requirentsId;
    }

    public String getDescription() {
        return this.description;
    }

    public Evidence description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getExpiration() {
        return this.expiration;
    }

    public Evidence expiration(Instant expiration) {
        this.setExpiration(expiration);
        return this;
    }

    public void setExpiration(Instant expiration) {
        this.expiration = expiration;
    }

    public String getLink() {
        return this.link;
    }

    public Evidence link(String link) {
        this.setLink(link);
        return this;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Training getTraining() {
        return this.training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Evidence training(Training training) {
        this.setTraining(training);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Evidence)) {
            return false;
        }
        return id != null && id.equals(((Evidence) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Evidence{" +
            "id=" + getId() +
            ", trainingId=" + getTrainingId() +
            ", requirentsId=" + getRequirentsId() +
            ", description='" + getDescription() + "'" +
            ", expiration='" + getExpiration() + "'" +
            ", link='" + getLink() + "'" +
            "}";
    }
}
