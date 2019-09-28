package grlmkb.wjw.vowri.bfkk.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * A Cf.
 */
@Entity
@Table(name = "wvldipa")
public class Cf implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "dszipj_lilhdgeb")
    private Float dszipjLILHDGEB;

    @Column(name = "kx_hfggg")
    private Integer kxHFGGG;

    @Column(name = "qjq_nj")
    private String qjqNJ;

    @Column(name = "uycdkngjy_ex", precision = 21, scale = 2)
    private BigDecimal uycdkngjyEX;

    @Column(name = "lttzrsukk_itst")
    private Long lttzrsukkITST;

    @Column(name = "cwf_yzveijke")
    private Float cwfYZVEIJKE;

    @Column(name = "ywuhpry_gc")
    private ZonedDateTime ywuhpryGC;

    @Column(name = "euhuyar_mvmesj")
    private Instant euhuyarMVMESJ;

    @Column(name = "zwb_rbgewzqdh", precision = 21, scale = 2)
    private BigDecimal zwbRBGEWZQDH;

    @Column(name = "yjfmrsuug_hrwgxnh")
    private LocalDate yjfmrsuugHRWGXNH;

    @Column(name = "cy_lonpourb")
    private LocalDate cyLONPOURB;

    @Column(name = "tafphc_qpqlpzb")
    private Integer tafphcQPQLPZB;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getDszipjLILHDGEB() {
        return dszipjLILHDGEB;
    }

    public void setDszipjLILHDGEB(Float dszipjLILHDGEB) {
        this.dszipjLILHDGEB = dszipjLILHDGEB;
    }

    public Integer getKxHFGGG() {
        return kxHFGGG;
    }

    public void setKxHFGGG(Integer kxHFGGG) {
        this.kxHFGGG = kxHFGGG;
    }

    public String getQjqNJ() {
        return qjqNJ;
    }

    public void setQjqNJ(String qjqNJ) {
        this.qjqNJ = qjqNJ;
    }

    public BigDecimal getUycdkngjyEX() {
        return uycdkngjyEX;
    }

    public void setUycdkngjyEX(BigDecimal uycdkngjyEX) {
        this.uycdkngjyEX = uycdkngjyEX;
    }

    public Long getLttzrsukkITST() {
        return lttzrsukkITST;
    }

    public void setLttzrsukkITST(Long lttzrsukkITST) {
        this.lttzrsukkITST = lttzrsukkITST;
    }

    public Float getCwfYZVEIJKE() {
        return cwfYZVEIJKE;
    }

    public void setCwfYZVEIJKE(Float cwfYZVEIJKE) {
        this.cwfYZVEIJKE = cwfYZVEIJKE;
    }

    public ZonedDateTime getYwuhpryGC() {
        return ywuhpryGC;
    }

    public void setYwuhpryGC(ZonedDateTime ywuhpryGC) {
        this.ywuhpryGC = ywuhpryGC;
    }

    public Instant getEuhuyarMVMESJ() {
        return euhuyarMVMESJ;
    }

    public void setEuhuyarMVMESJ(Instant euhuyarMVMESJ) {
        this.euhuyarMVMESJ = euhuyarMVMESJ;
    }

    public BigDecimal getZwbRBGEWZQDH() {
        return zwbRBGEWZQDH;
    }

    public void setZwbRBGEWZQDH(BigDecimal zwbRBGEWZQDH) {
        this.zwbRBGEWZQDH = zwbRBGEWZQDH;
    }

    public LocalDate getYjfmrsuugHRWGXNH() {
        return yjfmrsuugHRWGXNH;
    }

    public void setYjfmrsuugHRWGXNH(LocalDate yjfmrsuugHRWGXNH) {
        this.yjfmrsuugHRWGXNH = yjfmrsuugHRWGXNH;
    }

    public LocalDate getCyLONPOURB() {
        return cyLONPOURB;
    }

    public void setCyLONPOURB(LocalDate cyLONPOURB) {
        this.cyLONPOURB = cyLONPOURB;
    }

    public Integer getTafphcQPQLPZB() {
        return tafphcQPQLPZB;
    }

    public void setTafphcQPQLPZB(Integer tafphcQPQLPZB) {
        this.tafphcQPQLPZB = tafphcQPQLPZB;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cf)) {
            return false;
        }
        return id != null && id.equals(((Cf) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Cf{" +
            "id=" + getId() +
            ", dszipjLILHDGEB=" + getDszipjLILHDGEB() +
            ", kxHFGGG=" + getKxHFGGG() +
            ", qjqNJ='" + getQjqNJ() + "'" +
            ", uycdkngjyEX=" + getUycdkngjyEX() +
            ", lttzrsukkITST=" + getLttzrsukkITST() +
            ", cwfYZVEIJKE=" + getCwfYZVEIJKE() +
            ", ywuhpryGC='" + getYwuhpryGC() + "'" +
            ", euhuyarMVMESJ='" + getEuhuyarMVMESJ() + "'" +
            ", zwbRBGEWZQDH=" + getZwbRBGEWZQDH() +
            ", yjfmrsuugHRWGXNH='" + getYjfmrsuugHRWGXNH() + "'" +
            ", cyLONPOURB='" + getCyLONPOURB() + "'" +
            ", tafphcQPQLPZB=" + getTafphcQPQLPZB() +
            "}";
    }
}
