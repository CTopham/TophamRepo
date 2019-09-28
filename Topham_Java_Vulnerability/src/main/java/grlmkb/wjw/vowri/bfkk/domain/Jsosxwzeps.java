package grlmkb.wjw.vowri.bfkk.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A Jsosxwzeps.
 */
@Entity
@Table(name = "ps")
public class Jsosxwzeps implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "dcnzfa_kvvgz")
    private Long dcnzfaKVVGZ;

    @Column(name = "wju_pks", precision = 21, scale = 2)
    private BigDecimal wjuPKS;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDcnzfaKVVGZ() {
        return dcnzfaKVVGZ;
    }

    public Jsosxwzeps dcnzfaKVVGZ(Long dcnzfaKVVGZ) {
        this.dcnzfaKVVGZ = dcnzfaKVVGZ;
        return this;
    }

    public void setDcnzfaKVVGZ(Long dcnzfaKVVGZ) {
        this.dcnzfaKVVGZ = dcnzfaKVVGZ;
    }

    public BigDecimal getWjuPKS() {
        return wjuPKS;
    }

    public Jsosxwzeps wjuPKS(BigDecimal wjuPKS) {
        this.wjuPKS = wjuPKS;
        return this;
    }

    public void setWjuPKS(BigDecimal wjuPKS) {
        this.wjuPKS = wjuPKS;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Jsosxwzeps)) {
            return false;
        }
        return id != null && id.equals(((Jsosxwzeps) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Jsosxwzeps{" +
            "id=" + getId() +
            ", dcnzfaKVVGZ=" + getDcnzfaKVVGZ() +
            ", wjuPKS=" + getWjuPKS() +
            "}";
    }
}
