package grlmkb.wjw.vowri.bfkk.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * A Sycdotfbx.
 */
@Entity
@Table(name = "xci")
public class Sycdotfbx implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "uoerqr_whavspoy")
    private String uoerqrWHAVSPOY;

    @Column(name = "vtoeablli_mpk")
    private Integer vtoeablliMPK;

    @Column(name = "gv_auaokybwn")
    private String gvAUAOKYBWN;

    @Column(name = "ylooxrw_cavwcfsfj")
    private Instant ylooxrwCAVWCFSFJ;

    @Column(name = "bebohaan_snohcg")
    private Instant bebohaanSNOHCG;

    @Column(name = "phnag_muifegy")
    private String phnagMUIFEGY;

    @Column(name = "mndioz_szg")
    private Boolean mndiozSZG;

    @Column(name = "sr_tdobhw")
    private ZonedDateTime srTDOBHW;

    @Column(name = "oqhtblwu_lmtrlpzms")
    private Integer oqhtblwuLMTRLPZMS;

    @Column(name = "m_dpggk")
    private ZonedDateTime mDPGGK;

    @Column(name = "dgbhxwt_lll")
    private ZonedDateTime dgbhxwtLLL;

    @Column(name = "bqguzoagv_fczv", precision = 21, scale = 2)
    private BigDecimal bqguzoagvFCZV;

    @Column(name = "jqwomp_jvqh")
    private String jqwompJVQH;

    @Column(name = "k_imvkqbl")
    private String kIMVKQBL;

    @Column(name = "ute_axhlsh")
    private Long uteAXHLSH;

    @Column(name = "nntcpj_smopwfjy")
    private String nntcpjSMOPWFJY;

    @Column(name = "vfxsoyg_abwpmsuqu")
    private String vfxsoygABWPMSUQU;

    @Column(name = "fbdig_dzkp")
    private ZonedDateTime fbdigDZKP;

    @Column(name = "vigc_cozmn")
    private Float vigcCOZMN;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUoerqrWHAVSPOY() {
        return uoerqrWHAVSPOY;
    }

    public Sycdotfbx uoerqrWHAVSPOY(String uoerqrWHAVSPOY) {
        this.uoerqrWHAVSPOY = uoerqrWHAVSPOY;
        return this;
    }

    public void setUoerqrWHAVSPOY(String uoerqrWHAVSPOY) {
        this.uoerqrWHAVSPOY = uoerqrWHAVSPOY;
    }

    public Integer getVtoeablliMPK() {
        return vtoeablliMPK;
    }

    public Sycdotfbx vtoeablliMPK(Integer vtoeablliMPK) {
        this.vtoeablliMPK = vtoeablliMPK;
        return this;
    }

    public void setVtoeablliMPK(Integer vtoeablliMPK) {
        this.vtoeablliMPK = vtoeablliMPK;
    }

    public String getGvAUAOKYBWN() {
        return gvAUAOKYBWN;
    }

    public Sycdotfbx gvAUAOKYBWN(String gvAUAOKYBWN) {
        this.gvAUAOKYBWN = gvAUAOKYBWN;
        return this;
    }

    public void setGvAUAOKYBWN(String gvAUAOKYBWN) {
        this.gvAUAOKYBWN = gvAUAOKYBWN;
    }

    public Instant getYlooxrwCAVWCFSFJ() {
        return ylooxrwCAVWCFSFJ;
    }

    public Sycdotfbx ylooxrwCAVWCFSFJ(Instant ylooxrwCAVWCFSFJ) {
        this.ylooxrwCAVWCFSFJ = ylooxrwCAVWCFSFJ;
        return this;
    }

    public void setYlooxrwCAVWCFSFJ(Instant ylooxrwCAVWCFSFJ) {
        this.ylooxrwCAVWCFSFJ = ylooxrwCAVWCFSFJ;
    }

    public Instant getBebohaanSNOHCG() {
        return bebohaanSNOHCG;
    }

    public Sycdotfbx bebohaanSNOHCG(Instant bebohaanSNOHCG) {
        this.bebohaanSNOHCG = bebohaanSNOHCG;
        return this;
    }

    public void setBebohaanSNOHCG(Instant bebohaanSNOHCG) {
        this.bebohaanSNOHCG = bebohaanSNOHCG;
    }

    public String getPhnagMUIFEGY() {
        return phnagMUIFEGY;
    }

    public Sycdotfbx phnagMUIFEGY(String phnagMUIFEGY) {
        this.phnagMUIFEGY = phnagMUIFEGY;
        return this;
    }

    public void setPhnagMUIFEGY(String phnagMUIFEGY) {
        this.phnagMUIFEGY = phnagMUIFEGY;
    }

    public Boolean isMndiozSZG() {
        return mndiozSZG;
    }

    public Sycdotfbx mndiozSZG(Boolean mndiozSZG) {
        this.mndiozSZG = mndiozSZG;
        return this;
    }

    public void setMndiozSZG(Boolean mndiozSZG) {
        this.mndiozSZG = mndiozSZG;
    }

    public ZonedDateTime getSrTDOBHW() {
        return srTDOBHW;
    }

    public Sycdotfbx srTDOBHW(ZonedDateTime srTDOBHW) {
        this.srTDOBHW = srTDOBHW;
        return this;
    }

    public void setSrTDOBHW(ZonedDateTime srTDOBHW) {
        this.srTDOBHW = srTDOBHW;
    }

    public Integer getOqhtblwuLMTRLPZMS() {
        return oqhtblwuLMTRLPZMS;
    }

    public Sycdotfbx oqhtblwuLMTRLPZMS(Integer oqhtblwuLMTRLPZMS) {
        this.oqhtblwuLMTRLPZMS = oqhtblwuLMTRLPZMS;
        return this;
    }

    public void setOqhtblwuLMTRLPZMS(Integer oqhtblwuLMTRLPZMS) {
        this.oqhtblwuLMTRLPZMS = oqhtblwuLMTRLPZMS;
    }

    public ZonedDateTime getmDPGGK() {
        return mDPGGK;
    }

    public Sycdotfbx mDPGGK(ZonedDateTime mDPGGK) {
        this.mDPGGK = mDPGGK;
        return this;
    }

    public void setmDPGGK(ZonedDateTime mDPGGK) {
        this.mDPGGK = mDPGGK;
    }

    public ZonedDateTime getDgbhxwtLLL() {
        return dgbhxwtLLL;
    }

    public Sycdotfbx dgbhxwtLLL(ZonedDateTime dgbhxwtLLL) {
        this.dgbhxwtLLL = dgbhxwtLLL;
        return this;
    }

    public void setDgbhxwtLLL(ZonedDateTime dgbhxwtLLL) {
        this.dgbhxwtLLL = dgbhxwtLLL;
    }

    public BigDecimal getBqguzoagvFCZV() {
        return bqguzoagvFCZV;
    }

    public Sycdotfbx bqguzoagvFCZV(BigDecimal bqguzoagvFCZV) {
        this.bqguzoagvFCZV = bqguzoagvFCZV;
        return this;
    }

    public void setBqguzoagvFCZV(BigDecimal bqguzoagvFCZV) {
        this.bqguzoagvFCZV = bqguzoagvFCZV;
    }

    public String getJqwompJVQH() {
        return jqwompJVQH;
    }

    public Sycdotfbx jqwompJVQH(String jqwompJVQH) {
        this.jqwompJVQH = jqwompJVQH;
        return this;
    }

    public void setJqwompJVQH(String jqwompJVQH) {
        this.jqwompJVQH = jqwompJVQH;
    }

    public String getkIMVKQBL() {
        return kIMVKQBL;
    }

    public Sycdotfbx kIMVKQBL(String kIMVKQBL) {
        this.kIMVKQBL = kIMVKQBL;
        return this;
    }

    public void setkIMVKQBL(String kIMVKQBL) {
        this.kIMVKQBL = kIMVKQBL;
    }

    public Long getUteAXHLSH() {
        return uteAXHLSH;
    }

    public Sycdotfbx uteAXHLSH(Long uteAXHLSH) {
        this.uteAXHLSH = uteAXHLSH;
        return this;
    }

    public void setUteAXHLSH(Long uteAXHLSH) {
        this.uteAXHLSH = uteAXHLSH;
    }

    public String getNntcpjSMOPWFJY() {
        return nntcpjSMOPWFJY;
    }

    public Sycdotfbx nntcpjSMOPWFJY(String nntcpjSMOPWFJY) {
        this.nntcpjSMOPWFJY = nntcpjSMOPWFJY;
        return this;
    }

    public void setNntcpjSMOPWFJY(String nntcpjSMOPWFJY) {
        this.nntcpjSMOPWFJY = nntcpjSMOPWFJY;
    }

    public String getVfxsoygABWPMSUQU() {
        return vfxsoygABWPMSUQU;
    }

    public Sycdotfbx vfxsoygABWPMSUQU(String vfxsoygABWPMSUQU) {
        this.vfxsoygABWPMSUQU = vfxsoygABWPMSUQU;
        return this;
    }

    public void setVfxsoygABWPMSUQU(String vfxsoygABWPMSUQU) {
        this.vfxsoygABWPMSUQU = vfxsoygABWPMSUQU;
    }

    public ZonedDateTime getFbdigDZKP() {
        return fbdigDZKP;
    }

    public Sycdotfbx fbdigDZKP(ZonedDateTime fbdigDZKP) {
        this.fbdigDZKP = fbdigDZKP;
        return this;
    }

    public void setFbdigDZKP(ZonedDateTime fbdigDZKP) {
        this.fbdigDZKP = fbdigDZKP;
    }

    public Float getVigcCOZMN() {
        return vigcCOZMN;
    }

    public Sycdotfbx vigcCOZMN(Float vigcCOZMN) {
        this.vigcCOZMN = vigcCOZMN;
        return this;
    }

    public void setVigcCOZMN(Float vigcCOZMN) {
        this.vigcCOZMN = vigcCOZMN;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Sycdotfbx)) {
            return false;
        }
        return id != null && id.equals(((Sycdotfbx) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Sycdotfbx{" +
            "id=" + getId() +
            ", uoerqrWHAVSPOY='" + getUoerqrWHAVSPOY() + "'" +
            ", vtoeablliMPK=" + getVtoeablliMPK() +
            ", gvAUAOKYBWN='" + getGvAUAOKYBWN() + "'" +
            ", ylooxrwCAVWCFSFJ='" + getYlooxrwCAVWCFSFJ() + "'" +
            ", bebohaanSNOHCG='" + getBebohaanSNOHCG() + "'" +
            ", phnagMUIFEGY='" + getPhnagMUIFEGY() + "'" +
            ", mndiozSZG='" + isMndiozSZG() + "'" +
            ", srTDOBHW='" + getSrTDOBHW() + "'" +
            ", oqhtblwuLMTRLPZMS=" + getOqhtblwuLMTRLPZMS() +
            ", mDPGGK='" + getmDPGGK() + "'" +
            ", dgbhxwtLLL='" + getDgbhxwtLLL() + "'" +
            ", bqguzoagvFCZV=" + getBqguzoagvFCZV() +
            ", jqwompJVQH='" + getJqwompJVQH() + "'" +
            ", kIMVKQBL='" + getkIMVKQBL() + "'" +
            ", uteAXHLSH=" + getUteAXHLSH() +
            ", nntcpjSMOPWFJY='" + getNntcpjSMOPWFJY() + "'" +
            ", vfxsoygABWPMSUQU='" + getVfxsoygABWPMSUQU() + "'" +
            ", fbdigDZKP='" + getFbdigDZKP() + "'" +
            ", vigcCOZMN=" + getVigcCOZMN() +
            "}";
    }
}
