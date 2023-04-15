package wf.rh.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link wf.rh.domain.Training} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TrainingDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 20)
    private String code;

    private Instant date;

    private Instant expiry;

    private Set<EvidenceDTO> evidences = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Instant getExpiry() {
        return expiry;
    }

    public void setExpiry(Instant expiry) {
        this.expiry = expiry;
    }

    public Set<EvidenceDTO> getEvidences() {
        return evidences;
    }

    public void setEvidences(Set<EvidenceDTO> evidences) {
        this.evidences = evidences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TrainingDTO)) {
            return false;
        }

        TrainingDTO trainingDTO = (TrainingDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, trainingDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TrainingDTO{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", date='" + getDate() + "'" +
            ", expiry='" + getExpiry() + "'" +
            ", evidences=" + getEvidences() +
            "}";
    }
}
