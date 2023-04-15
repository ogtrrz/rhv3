package wf.rh.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link wf.rh.domain.Evidence} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class EvidenceDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(max = 500)
    private String description;

    private Instant expiration;

    private String link;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getExpiration() {
        return expiration;
    }

    public void setExpiration(Instant expiration) {
        this.expiration = expiration;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EvidenceDTO)) {
            return false;
        }

        EvidenceDTO evidenceDTO = (EvidenceDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, evidenceDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EvidenceDTO{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            ", expiration='" + getExpiration() + "'" +
            ", link='" + getLink() + "'" +
            "}";
    }
}
