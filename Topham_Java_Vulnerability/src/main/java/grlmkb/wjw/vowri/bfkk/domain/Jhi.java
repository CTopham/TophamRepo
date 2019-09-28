package grlmkb.wjw.vowri.bfkk.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * A Jhi.
 */
@Entity
@Table(name = "ygmi")
public class Jhi implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "kuxgvrghg_zwuvbas")
    private Float kuxgvrghgZWUVBAS;

    @Column(name = "cyoluqjx_ccmpzm")
    private Long cyoluqjxCCMPZM;

    @Column(name = "c_ghpvlnphg")
    private Boolean cGHPVLNPHG;

    @Column(name = "fnsun_jgexy")
    private Integer fnsunJGEXY;

    @Column(name = "xfh_mrawoad")
    private Float xfhMRAWOAD;

    @Column(name = "rhcuagus_em", precision = 21, scale = 2)
    private BigDecimal rhcuagusEM;

    @Column(name = "nnmuicg_oii")
    private Long nnmuicgOII;

    @Column(name = "cq_cgpsopjc")
    private Long cqCGPSOPJC;

    @Column(name = "yc_wfmxx")
    private Boolean ycWFMXX;

    @Column(name = "v_iefkcljcn")
    private Boolean vIEFKCLJCN;

    @Column(name = "ulorfvrz_ngzqt")
    private ZonedDateTime ulorfvrzNGZQT;

    @Column(name = "sfbrwwuez_nwhcmt")
    private Long sfbrwwuezNWHCMT;

    @Column(name = "ysmxlujou_dkmeiuug")
    private Float ysmxlujouDKMEIUUG;

    @Column(name = "bebpx_ffa")
    private Instant bebpxFFA;

    @Column(name = "fjie_pmf", precision = 21, scale = 2)
    private BigDecimal fjiePMF;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getKuxgvrghgZWUVBAS() {
        return kuxgvrghgZWUVBAS;
    }

    public Jhi kuxgvrghgZWUVBAS(Float kuxgvrghgZWUVBAS) {
        this.kuxgvrghgZWUVBAS = kuxgvrghgZWUVBAS;
        return this;
    }

    public void setKuxgvrghgZWUVBAS(Float kuxgvrghgZWUVBAS) {
        this.kuxgvrghgZWUVBAS = kuxgvrghgZWUVBAS;
    }

    public Long getCyoluqjxCCMPZM() {
        return cyoluqjxCCMPZM;
    }

    public Jhi cyoluqjxCCMPZM(Long cyoluqjxCCMPZM) {
        this.cyoluqjxCCMPZM = cyoluqjxCCMPZM;
        return this;
    }

    public void setCyoluqjxCCMPZM(Long cyoluqjxCCMPZM) {
        this.cyoluqjxCCMPZM = cyoluqjxCCMPZM;
    }

    public Boolean iscGHPVLNPHG() {
        return cGHPVLNPHG;
    }

    public Jhi cGHPVLNPHG(Boolean cGHPVLNPHG) {
        this.cGHPVLNPHG = cGHPVLNPHG;
        return this;
    }

    public void setcGHPVLNPHG(Boolean cGHPVLNPHG) {
        this.cGHPVLNPHG = cGHPVLNPHG;
    }

    public Integer getFnsunJGEXY() {
        return fnsunJGEXY;
    }

    public Jhi fnsunJGEXY(Integer fnsunJGEXY) {
        this.fnsunJGEXY = fnsunJGEXY;
        return this;
    }

    public void setFnsunJGEXY(Integer fnsunJGEXY) {
        this.fnsunJGEXY = fnsunJGEXY;
    }

    public Float getXfhMRAWOAD() {
        return xfhMRAWOAD;
    }

    public Jhi xfhMRAWOAD(Float xfhMRAWOAD) {
        this.xfhMRAWOAD = xfhMRAWOAD;
        return this;
    }

    public void setXfhMRAWOAD(Float xfhMRAWOAD) {
        this.xfhMRAWOAD = xfhMRAWOAD;
    }

    public BigDecimal getRhcuagusEM() {
        return rhcuagusEM;
    }

    public Jhi rhcuagusEM(BigDecimal rhcuagusEM) {
        this.rhcuagusEM = rhcuagusEM;
        return this;
    }

    public void setRhcuagusEM(BigDecimal rhcuagusEM) {
        this.rhcuagusEM = rhcuagusEM;
    }

    public Long getNnmuicgOII() {
        return nnmuicgOII;
    }

    public Jhi nnmuicgOII(Long nnmuicgOII) {
        this.nnmuicgOII = nnmuicgOII;
        return this;
    }

    public void setNnmuicgOII(Long nnmuicgOII) {
        this.nnmuicgOII = nnmuicgOII;
    }

    public Long getCqCGPSOPJC() {
        return cqCGPSOPJC;
    }

    public Jhi cqCGPSOPJC(Long cqCGPSOPJC) {
        this.cqCGPSOPJC = cqCGPSOPJC;
        return this;
    }

    public void setCqCGPSOPJC(Long cqCGPSOPJC) {
        this.cqCGPSOPJC = cqCGPSOPJC;
    }

    public Boolean isYcWFMXX() {
        return ycWFMXX;
    }

    public Jhi ycWFMXX(Boolean ycWFMXX) {
        this.ycWFMXX = ycWFMXX;
        return this;
    }

    public void setYcWFMXX(Boolean ycWFMXX) {
        this.ycWFMXX = ycWFMXX;
    }

    public Boolean isvIEFKCLJCN() {
        return vIEFKCLJCN;
    }

    public Jhi vIEFKCLJCN(Boolean vIEFKCLJCN) {
        this.vIEFKCLJCN = vIEFKCLJCN;
        return this;
    }

    public void setvIEFKCLJCN(Boolean vIEFKCLJCN) {
        this.vIEFKCLJCN = vIEFKCLJCN;
    }

    public ZonedDateTime getUlorfvrzNGZQT() {
        return ulorfvrzNGZQT;
    }

    public Jhi ulorfvrzNGZQT(ZonedDateTime ulorfvrzNGZQT) {
        this.ulorfvrzNGZQT = ulorfvrzNGZQT;
        return this;
    }

    public void setUlorfvrzNGZQT(ZonedDateTime ulorfvrzNGZQT) {
        this.ulorfvrzNGZQT = ulorfvrzNGZQT;
    }

    public Long getSfbrwwuezNWHCMT() {
        return sfbrwwuezNWHCMT;
    }

    public Jhi sfbrwwuezNWHCMT(Long sfbrwwuezNWHCMT) {
        this.sfbrwwuezNWHCMT = sfbrwwuezNWHCMT;
        return this;
    }

    public void setSfbrwwuezNWHCMT(Long sfbrwwuezNWHCMT) {
        this.sfbrwwuezNWHCMT = sfbrwwuezNWHCMT;
    }

    public Float getYsmxlujouDKMEIUUG() {
        return ysmxlujouDKMEIUUG;
    }

    public Jhi ysmxlujouDKMEIUUG(Float ysmxlujouDKMEIUUG) {
        this.ysmxlujouDKMEIUUG = ysmxlujouDKMEIUUG;
        return this;
    }

    public void setYsmxlujouDKMEIUUG(Float ysmxlujouDKMEIUUG) {
        this.ysmxlujouDKMEIUUG = ysmxlujouDKMEIUUG;
    }

    public Instant getBebpxFFA() {
        return bebpxFFA;
    }

    public Jhi bebpxFFA(Instant bebpxFFA) {
        this.bebpxFFA = bebpxFFA;
        return this;
    }

    public void setBebpxFFA(Instant bebpxFFA) {
        this.bebpxFFA = bebpxFFA;
    }

    public BigDecimal getFjiePMF() {
        return fjiePMF;
    }

    public Jhi fjiePMF(BigDecimal fjiePMF) {
        this.fjiePMF = fjiePMF;
        return this;
    }

    public void setFjiePMF(BigDecimal fjiePMF) {
        this.fjiePMF = fjiePMF;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Jhi)) {
            return false;
        }
        return id != null && id.equals(((Jhi) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Jhi{" +
            "id=" + getId() +
            ", kuxgvrghgZWUVBAS=" + getKuxgvrghgZWUVBAS() +
            ", cyoluqjxCCMPZM=" + getCyoluqjxCCMPZM() +
            ", cGHPVLNPHG='" + iscGHPVLNPHG() + "'" +
            ", fnsunJGEXY=" + getFnsunJGEXY() +
            ", xfhMRAWOAD=" + getXfhMRAWOAD() +
            ", rhcuagusEM=" + getRhcuagusEM() +
            ", nnmuicgOII=" + getNnmuicgOII() +
            ", cqCGPSOPJC=" + getCqCGPSOPJC() +
            ", ycWFMXX='" + isYcWFMXX() + "'" +
            ", vIEFKCLJCN='" + isvIEFKCLJCN() + "'" +
            ", ulorfvrzNGZQT='" + getUlorfvrzNGZQT() + "'" +
            ", sfbrwwuezNWHCMT=" + getSfbrwwuezNWHCMT() +
            ", ysmxlujouDKMEIUUG=" + getYsmxlujouDKMEIUUG() +
            ", bebpxFFA='" + getBebpxFFA() + "'" +
            ", fjiePMF=" + getFjiePMF() +
            "}";
    }
}
