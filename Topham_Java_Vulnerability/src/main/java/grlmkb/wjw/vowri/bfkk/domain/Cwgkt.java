package grlmkb.wjw.vowri.bfkk.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

/**
 * A Cwgkt.
 */
@Entity
@Table(name = "avhbaz")
public class Cwgkt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "datqyrd_ssuvsl")
    private Integer datqyrdSSUVSL;

    @Column(name = "xiuoes_wmto", precision = 21, scale = 2)
    private BigDecimal xiuoesWMTO;

    @Column(name = "wjmkg_okzehamr")
    private Instant wjmkgOKZEHAMR;

    @Column(name = "iwppb_n", precision = 21, scale = 2)
    private BigDecimal iwppbN;

    @Column(name = "uwz_pkal")
    private LocalDate uwzPKAL;

    @Column(name = "gjd_z")
    private Boolean gjdZ;

    @Column(name = "kn_yeodex")
    private Integer knYEODEX;

    @Column(name = "hecwx_jsyqpcp")
    private Instant hecwxJSYQPCP;

    @Column(name = "qiesctruz_nqsqqfkxr")
    private String qiesctruzNQSQQFKXR;

    @Column(name = "ecst_kppenuel")
    private Integer ecstKPPENUEL;

    @Column(name = "rygwc_tqg")
    private String rygwcTQG;

    @Column(name = "zusr_w")
    private Boolean zusrW;

    @Column(name = "xmid_vonel")
    private Integer xmidVONEL;

    @Column(name = "msolwy_owv")
    private Long msolwyOWV;

    @Column(name = "oyepo_aoiuc")
    private Float oyepoAOIUC;

    @Column(name = "whmhgtjcf_gvtdze")
    private Instant whmhgtjcfGVTDZE;

    @Column(name = "immak_fg", precision = 21, scale = 2)
    private BigDecimal immakFG;

    @Column(name = "jbagf_jnan")
    private Float jbagfJNAN;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDatqyrdSSUVSL() {
        return datqyrdSSUVSL;
    }

    public void setDatqyrdSSUVSL(Integer datqyrdSSUVSL) {
        this.datqyrdSSUVSL = datqyrdSSUVSL;
    }

    public BigDecimal getXiuoesWMTO() {
        return xiuoesWMTO;
    }

    public void setXiuoesWMTO(BigDecimal xiuoesWMTO) {
        this.xiuoesWMTO = xiuoesWMTO;
    }

    public Instant getWjmkgOKZEHAMR() {
        return wjmkgOKZEHAMR;
    }

    public void setWjmkgOKZEHAMR(Instant wjmkgOKZEHAMR) {
        this.wjmkgOKZEHAMR = wjmkgOKZEHAMR;
    }

    public BigDecimal getIwppbN() {
        return iwppbN;
    }

    public void setIwppbN(BigDecimal iwppbN) {
        this.iwppbN = iwppbN;
    }

    public LocalDate getUwzPKAL() {
        return uwzPKAL;
    }

    public void setUwzPKAL(LocalDate uwzPKAL) {
        this.uwzPKAL = uwzPKAL;
    }

    public Boolean isGjdZ() {
        return gjdZ;
    }

    public void setGjdZ(Boolean gjdZ) {
        this.gjdZ = gjdZ;
    }

    public Integer getKnYEODEX() {
        return knYEODEX;
    }

    public void setKnYEODEX(Integer knYEODEX) {
        this.knYEODEX = knYEODEX;
    }

    public Instant getHecwxJSYQPCP() {
        return hecwxJSYQPCP;
    }

    public void setHecwxJSYQPCP(Instant hecwxJSYQPCP) {
        this.hecwxJSYQPCP = hecwxJSYQPCP;
    }

    public String getQiesctruzNQSQQFKXR() {
        return qiesctruzNQSQQFKXR;
    }

    public void setQiesctruzNQSQQFKXR(String qiesctruzNQSQQFKXR) {
        this.qiesctruzNQSQQFKXR = qiesctruzNQSQQFKXR;
    }

    public Integer getEcstKPPENUEL() {
        return ecstKPPENUEL;
    }

    public void setEcstKPPENUEL(Integer ecstKPPENUEL) {
        this.ecstKPPENUEL = ecstKPPENUEL;
    }

    public String getRygwcTQG() {
        return rygwcTQG;
    }

    public void setRygwcTQG(String rygwcTQG) {
        this.rygwcTQG = rygwcTQG;
    }

    public Boolean isZusrW() {
        return zusrW;
    }

    public void setZusrW(Boolean zusrW) {
        this.zusrW = zusrW;
    }

    public Integer getXmidVONEL() {
        return xmidVONEL;
    }

    public void setXmidVONEL(Integer xmidVONEL) {
        this.xmidVONEL = xmidVONEL;
    }

    public Long getMsolwyOWV() {
        return msolwyOWV;
    }

    public void setMsolwyOWV(Long msolwyOWV) {
        this.msolwyOWV = msolwyOWV;
    }

    public Float getOyepoAOIUC() {
        return oyepoAOIUC;
    }

    public void setOyepoAOIUC(Float oyepoAOIUC) {
        this.oyepoAOIUC = oyepoAOIUC;
    }

    public Instant getWhmhgtjcfGVTDZE() {
        return whmhgtjcfGVTDZE;
    }

    public void setWhmhgtjcfGVTDZE(Instant whmhgtjcfGVTDZE) {
        this.whmhgtjcfGVTDZE = whmhgtjcfGVTDZE;
    }

    public BigDecimal getImmakFG() {
        return immakFG;
    }

    public void setImmakFG(BigDecimal immakFG) {
        this.immakFG = immakFG;
    }

    public Float getJbagfJNAN() {
        return jbagfJNAN;
    }

    public void setJbagfJNAN(Float jbagfJNAN) {
        this.jbagfJNAN = jbagfJNAN;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cwgkt)) {
            return false;
        }
        return id != null && id.equals(((Cwgkt) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Cwgkt{" +
            "id=" + getId() +
            ", datqyrdSSUVSL=" + getDatqyrdSSUVSL() +
            ", xiuoesWMTO=" + getXiuoesWMTO() +
            ", wjmkgOKZEHAMR='" + getWjmkgOKZEHAMR() + "'" +
            ", iwppbN=" + getIwppbN() +
            ", uwzPKAL='" + getUwzPKAL() + "'" +
            ", gjdZ='" + isGjdZ() + "'" +
            ", knYEODEX=" + getKnYEODEX() +
            ", hecwxJSYQPCP='" + getHecwxJSYQPCP() + "'" +
            ", qiesctruzNQSQQFKXR='" + getQiesctruzNQSQQFKXR() + "'" +
            ", ecstKPPENUEL=" + getEcstKPPENUEL() +
            ", rygwcTQG='" + getRygwcTQG() + "'" +
            ", zusrW='" + isZusrW() + "'" +
            ", xmidVONEL=" + getXmidVONEL() +
            ", msolwyOWV=" + getMsolwyOWV() +
            ", oyepoAOIUC=" + getOyepoAOIUC() +
            ", whmhgtjcfGVTDZE='" + getWhmhgtjcfGVTDZE() + "'" +
            ", immakFG=" + getImmakFG() +
            ", jbagfJNAN=" + getJbagfJNAN() +
            "}";
    }
}
