package grlmkb.wjw.vowri.bfkk.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * A Yuch.
 */
@Entity
@Table(name = "jiap")
public class Yuch implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "qpswwv_isluj")
    private Integer qpswwvISLUJ;

    @Column(name = "bjvdtah_yzthgs")
    private Instant bjvdtahYZTHGS;

    @Column(name = "x_gunu")
    private Long xGUNU;

    @Column(name = "e_s")
    private String eS;

    @Column(name = "sf_sy")
    private Float sfSY;

    @Column(name = "kmrf_rtqtzd")
    private Long kmrfRTQTZD;

    @Column(name = "ebd_ppfkszn")
    private ZonedDateTime ebdPPFKSZN;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQpswwvISLUJ() {
        return qpswwvISLUJ;
    }

    public void setQpswwvISLUJ(Integer qpswwvISLUJ) {
        this.qpswwvISLUJ = qpswwvISLUJ;
    }

    public Instant getBjvdtahYZTHGS() {
        return bjvdtahYZTHGS;
    }

    public void setBjvdtahYZTHGS(Instant bjvdtahYZTHGS) {
        this.bjvdtahYZTHGS = bjvdtahYZTHGS;
    }

    public Long getxGUNU() {
        return xGUNU;
    }

    public void setxGUNU(Long xGUNU) {
        this.xGUNU = xGUNU;
    }

    public String geteS() {
        return eS;
    }

    public void seteS(String eS) {
        this.eS = eS;
    }

    public Float getSfSY() {
        return sfSY;
    }

    public void setSfSY(Float sfSY) {
        this.sfSY = sfSY;
    }

    public Long getKmrfRTQTZD() {
        return kmrfRTQTZD;
    }

    public void setKmrfRTQTZD(Long kmrfRTQTZD) {
        this.kmrfRTQTZD = kmrfRTQTZD;
    }

    public ZonedDateTime getEbdPPFKSZN() {
        return ebdPPFKSZN;
    }

    public void setEbdPPFKSZN(ZonedDateTime ebdPPFKSZN) {
        this.ebdPPFKSZN = ebdPPFKSZN;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Yuch)) {
            return false;
        }
        return id != null && id.equals(((Yuch) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Yuch{" +
            "id=" + getId() +
            ", qpswwvISLUJ=" + getQpswwvISLUJ() +
            ", bjvdtahYZTHGS='" + getBjvdtahYZTHGS() + "'" +
            ", xGUNU=" + getxGUNU() +
            ", eS='" + geteS() + "'" +
            ", sfSY=" + getSfSY() +
            ", kmrfRTQTZD=" + getKmrfRTQTZD() +
            ", ebdPPFKSZN='" + getEbdPPFKSZN() + "'" +
            "}";
    }
    

}
