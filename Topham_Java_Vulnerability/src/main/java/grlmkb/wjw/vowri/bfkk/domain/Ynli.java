package grlmkb.wjw.vowri.bfkk.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * A Ynli.
 */
@Entity
@Table(name = "qzdxj")
public class Ynli implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "yzajrx_iaydpk")
    private ZonedDateTime yzajrxIAYDPK;

    @Column(name = "fgvstxxhk_bmqois")
    private Float fgvstxxhkBMQOIS;

    @Column(name = "yhbmpkbh_bycny", precision = 21, scale = 2)
    private BigDecimal yhbmpkbhBYCNY;

    @Column(name = "mng_kjlim")
    private LocalDate mngKJLIM;

    @Column(name = "qbaf_fjwjzsbt")
    private LocalDate qbafFJWJZSBT;

    @Column(name = "bxoqkpp_jhlg")
    private Float bxoqkppJHLG;

    @Column(name = "sm_n")
    private Integer smN;

    @Column(name = "mrpzrywo_eqqjocfn")
    private LocalDate mrpzrywoEQQJOCFN;

    @Column(name = "an_pruy")
    private Boolean anPRUY;

    @Column(name = "rmwupkgmx_ejpuwyxcd")
    private LocalDate rmwupkgmxEJPUWYXCD;

    @Column(name = "qsnxsiht_zpggtpl")
    private String qsnxsihtZPGGTPL;

    @Column(name = "fay_zwwf")
    private Integer fayZWWF;

    @Column(name = "o_iupeeoqw")
    private ZonedDateTime oIUPEEOQW;

    @Column(name = "exic_ffttm")
    private String exicFFTTM;

    @Column(name = "hrluhf_dtnwh")
    private ZonedDateTime hrluhfDTNWH;

    @Column(name = "erw_tlh")
    private LocalDate erwTLH;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getYzajrxIAYDPK() {
        return yzajrxIAYDPK;
    }

    public Ynli yzajrxIAYDPK(ZonedDateTime yzajrxIAYDPK) {
        this.yzajrxIAYDPK = yzajrxIAYDPK;
        return this;
    }

    public void setYzajrxIAYDPK(ZonedDateTime yzajrxIAYDPK) {
        this.yzajrxIAYDPK = yzajrxIAYDPK;
    }

    public Float getFgvstxxhkBMQOIS() {
        return fgvstxxhkBMQOIS;
    }

    public Ynli fgvstxxhkBMQOIS(Float fgvstxxhkBMQOIS) {
        this.fgvstxxhkBMQOIS = fgvstxxhkBMQOIS;
        return this;
    }

    public void setFgvstxxhkBMQOIS(Float fgvstxxhkBMQOIS) {
        this.fgvstxxhkBMQOIS = fgvstxxhkBMQOIS;
    }

    public BigDecimal getYhbmpkbhBYCNY() {
        return yhbmpkbhBYCNY;
    }

    public Ynli yhbmpkbhBYCNY(BigDecimal yhbmpkbhBYCNY) {
        this.yhbmpkbhBYCNY = yhbmpkbhBYCNY;
        return this;
    }

    public void setYhbmpkbhBYCNY(BigDecimal yhbmpkbhBYCNY) {
        this.yhbmpkbhBYCNY = yhbmpkbhBYCNY;
    }

    public LocalDate getMngKJLIM() {
        return mngKJLIM;
    }

    public Ynli mngKJLIM(LocalDate mngKJLIM) {
        this.mngKJLIM = mngKJLIM;
        return this;
    }

    public void setMngKJLIM(LocalDate mngKJLIM) {
        this.mngKJLIM = mngKJLIM;
    }

    public LocalDate getQbafFJWJZSBT() {
        return qbafFJWJZSBT;
    }

    public Ynli qbafFJWJZSBT(LocalDate qbafFJWJZSBT) {
        this.qbafFJWJZSBT = qbafFJWJZSBT;
        return this;
    }

    public void setQbafFJWJZSBT(LocalDate qbafFJWJZSBT) {
        this.qbafFJWJZSBT = qbafFJWJZSBT;
    }

    public Float getBxoqkppJHLG() {
        return bxoqkppJHLG;
    }

    public Ynli bxoqkppJHLG(Float bxoqkppJHLG) {
        this.bxoqkppJHLG = bxoqkppJHLG;
        return this;
    }

    public void setBxoqkppJHLG(Float bxoqkppJHLG) {
        this.bxoqkppJHLG = bxoqkppJHLG;
    }

    public Integer getSmN() {
        return smN;
    }

    public Ynli smN(Integer smN) {
        this.smN = smN;
        return this;
    }

    public void setSmN(Integer smN) {
        this.smN = smN;
    }

    public LocalDate getMrpzrywoEQQJOCFN() {
        return mrpzrywoEQQJOCFN;
    }

    public Ynli mrpzrywoEQQJOCFN(LocalDate mrpzrywoEQQJOCFN) {
        this.mrpzrywoEQQJOCFN = mrpzrywoEQQJOCFN;
        return this;
    }

    public void setMrpzrywoEQQJOCFN(LocalDate mrpzrywoEQQJOCFN) {
        this.mrpzrywoEQQJOCFN = mrpzrywoEQQJOCFN;
    }

    public Boolean isAnPRUY() {
        return anPRUY;
    }

    public Ynli anPRUY(Boolean anPRUY) {
        this.anPRUY = anPRUY;
        return this;
    }

    public void setAnPRUY(Boolean anPRUY) {
        this.anPRUY = anPRUY;
    }

    public LocalDate getRmwupkgmxEJPUWYXCD() {
        return rmwupkgmxEJPUWYXCD;
    }

    public Ynli rmwupkgmxEJPUWYXCD(LocalDate rmwupkgmxEJPUWYXCD) {
        this.rmwupkgmxEJPUWYXCD = rmwupkgmxEJPUWYXCD;
        return this;
    }

    public void setRmwupkgmxEJPUWYXCD(LocalDate rmwupkgmxEJPUWYXCD) {
        this.rmwupkgmxEJPUWYXCD = rmwupkgmxEJPUWYXCD;
    }

    public String getQsnxsihtZPGGTPL() {
        return qsnxsihtZPGGTPL;
    }

    public Ynli qsnxsihtZPGGTPL(String qsnxsihtZPGGTPL) {
        this.qsnxsihtZPGGTPL = qsnxsihtZPGGTPL;
        return this;
    }

    public void setQsnxsihtZPGGTPL(String qsnxsihtZPGGTPL) {
        this.qsnxsihtZPGGTPL = qsnxsihtZPGGTPL;
    }

    public Integer getFayZWWF() {
        return fayZWWF;
    }

    public Ynli fayZWWF(Integer fayZWWF) {
        this.fayZWWF = fayZWWF;
        return this;
    }

    public void setFayZWWF(Integer fayZWWF) {
        this.fayZWWF = fayZWWF;
    }

    public ZonedDateTime getoIUPEEOQW() {
        return oIUPEEOQW;
    }

    public Ynli oIUPEEOQW(ZonedDateTime oIUPEEOQW) {
        this.oIUPEEOQW = oIUPEEOQW;
        return this;
    }

    public void setoIUPEEOQW(ZonedDateTime oIUPEEOQW) {
        this.oIUPEEOQW = oIUPEEOQW;
    }

    public String getExicFFTTM() {
        return exicFFTTM;
    }

    public Ynli exicFFTTM(String exicFFTTM) {
        this.exicFFTTM = exicFFTTM;
        return this;
    }

    public void setExicFFTTM(String exicFFTTM) {
        this.exicFFTTM = exicFFTTM;
    }

    public ZonedDateTime getHrluhfDTNWH() {
        return hrluhfDTNWH;
    }

    public Ynli hrluhfDTNWH(ZonedDateTime hrluhfDTNWH) {
        this.hrluhfDTNWH = hrluhfDTNWH;
        return this;
    }

    public void setHrluhfDTNWH(ZonedDateTime hrluhfDTNWH) {
        this.hrluhfDTNWH = hrluhfDTNWH;
    }

    public LocalDate getErwTLH() {
        return erwTLH;
    }

    public Ynli erwTLH(LocalDate erwTLH) {
        this.erwTLH = erwTLH;
        return this;
    }

    public void setErwTLH(LocalDate erwTLH) {
        this.erwTLH = erwTLH;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ynli)) {
            return false;
        }
        return id != null && id.equals(((Ynli) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Ynli{" +
            "id=" + getId() +
            ", yzajrxIAYDPK='" + getYzajrxIAYDPK() + "'" +
            ", fgvstxxhkBMQOIS=" + getFgvstxxhkBMQOIS() +
            ", yhbmpkbhBYCNY=" + getYhbmpkbhBYCNY() +
            ", mngKJLIM='" + getMngKJLIM() + "'" +
            ", qbafFJWJZSBT='" + getQbafFJWJZSBT() + "'" +
            ", bxoqkppJHLG=" + getBxoqkppJHLG() +
            ", smN=" + getSmN() +
            ", mrpzrywoEQQJOCFN='" + getMrpzrywoEQQJOCFN() + "'" +
            ", anPRUY='" + isAnPRUY() + "'" +
            ", rmwupkgmxEJPUWYXCD='" + getRmwupkgmxEJPUWYXCD() + "'" +
            ", qsnxsihtZPGGTPL='" + getQsnxsihtZPGGTPL() + "'" +
            ", fayZWWF=" + getFayZWWF() +
            ", oIUPEEOQW='" + getoIUPEEOQW() + "'" +
            ", exicFFTTM='" + getExicFFTTM() + "'" +
            ", hrluhfDTNWH='" + getHrluhfDTNWH() + "'" +
            ", erwTLH='" + getErwTLH() + "'" +
            "}";
    }
}
