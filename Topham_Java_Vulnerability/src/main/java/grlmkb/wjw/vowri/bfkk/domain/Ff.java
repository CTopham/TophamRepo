package grlmkb.wjw.vowri.bfkk.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * A Ff.
 */
@Entity
@Table(name = "x")
public class Ff implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "urr_w")
    private Instant urrW;

    @Column(name = "nsjjkla_gvgl")
    private LocalDate nsjjklaGVGL;

    @Column(name = "gffx_rhsbkma")
    private Instant gffxRHSBKMA;

    @Column(name = "myqae_m", precision = 21, scale = 2)
    private BigDecimal myqaeM;

    @Column(name = "aov_brj", precision = 21, scale = 2)
    private BigDecimal aovBRJ;

    @Column(name = "mvco_qb")
    private Long mvcoQB;

    @Column(name = "xcwhaee_z")
    private Float xcwhaeeZ;

    @Column(name = "jzrnme_tzsro")
    private Long jzrnmeTZSRO;

    @Column(name = "wi_boycmcrt")
    private Instant wiBOYCMCRT;

    @Column(name = "jdr_bmjzytewe")
    private Long jdrBMJZYTEWE;

    @Column(name = "gmh_zyxpbz")
    private Float gmhZYXPBZ;

    @Column(name = "i_gigvibxjr")
    private LocalDate iGIGVIBXJR;

    @Column(name = "fmfi_cdtfjlb")
    private Integer fmfiCDTFJLB;

    @Column(name = "yluf_adj", precision = 21, scale = 2)
    private BigDecimal ylufADJ;

    @Column(name = "pgnat_cd")
    private LocalDate pgnatCD;

    @Column(name = "icwyav_un")
    private ZonedDateTime icwyavUN;

    @Column(name = "mfjk_cwsh")
    private Long mfjkCWSH;

    @Column(name = "wduf_nkfkf")
    private Integer wdufNKFKF;

    @Column(name = "tyuboof_zlwkpx")
    private Boolean tyuboofZLWKPX;

    @Column(name = "b_cgbsoah", precision = 21, scale = 2)
    private BigDecimal bCGBSOAH;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getUrrW() {
        return urrW;
    }

    public void setUrrW(Instant urrW) {
        this.urrW = urrW;
    }

    public LocalDate getNsjjklaGVGL() {
        return nsjjklaGVGL;
    }

    public void setNsjjklaGVGL(LocalDate nsjjklaGVGL) {
        this.nsjjklaGVGL = nsjjklaGVGL;
    }

    public Instant getGffxRHSBKMA() {
        return gffxRHSBKMA;
    }

    public void setGffxRHSBKMA(Instant gffxRHSBKMA) {
        this.gffxRHSBKMA = gffxRHSBKMA;
    }

    public BigDecimal getMyqaeM() {
        return myqaeM;
    }

    public void setMyqaeM(BigDecimal myqaeM) {
        this.myqaeM = myqaeM;
    }

    public BigDecimal getAovBRJ() {
        return aovBRJ;
    }

    public void setAovBRJ(BigDecimal aovBRJ) {
        this.aovBRJ = aovBRJ;
    }

    public Long getMvcoQB() {
        return mvcoQB;
    }

    public void setMvcoQB(Long mvcoQB) {
        this.mvcoQB = mvcoQB;
    }

    public Float getXcwhaeeZ() {
        return xcwhaeeZ;
    }

    public void setXcwhaeeZ(Float xcwhaeeZ) {
        this.xcwhaeeZ = xcwhaeeZ;
    }

    public Long getJzrnmeTZSRO() {
        return jzrnmeTZSRO;
    }

    public void setJzrnmeTZSRO(Long jzrnmeTZSRO) {
        this.jzrnmeTZSRO = jzrnmeTZSRO;
    }

    public Instant getWiBOYCMCRT() {
        return wiBOYCMCRT;
    }

    public void setWiBOYCMCRT(Instant wiBOYCMCRT) {
        this.wiBOYCMCRT = wiBOYCMCRT;
    }

    public Long getJdrBMJZYTEWE() {
        return jdrBMJZYTEWE;
    }

    public void setJdrBMJZYTEWE(Long jdrBMJZYTEWE) {
        this.jdrBMJZYTEWE = jdrBMJZYTEWE;
    }

    public Float getGmhZYXPBZ() {
        return gmhZYXPBZ;
    }

    public void setGmhZYXPBZ(Float gmhZYXPBZ) {
        this.gmhZYXPBZ = gmhZYXPBZ;
    }

    public LocalDate getiGIGVIBXJR() {
        return iGIGVIBXJR;
    }

    public void setiGIGVIBXJR(LocalDate iGIGVIBXJR) {
        this.iGIGVIBXJR = iGIGVIBXJR;
    }

    public Integer getFmfiCDTFJLB() {
        return fmfiCDTFJLB;
    }

    public void setFmfiCDTFJLB(Integer fmfiCDTFJLB) {
        this.fmfiCDTFJLB = fmfiCDTFJLB;
    }

    public BigDecimal getYlufADJ() {
        return ylufADJ;
    }

    public void setYlufADJ(BigDecimal ylufADJ) {
        this.ylufADJ = ylufADJ;
    }

    public LocalDate getPgnatCD() {
        return pgnatCD;
    }

    public void setPgnatCD(LocalDate pgnatCD) {
        this.pgnatCD = pgnatCD;
    }

    public ZonedDateTime getIcwyavUN() {
        return icwyavUN;
    }

    public void setIcwyavUN(ZonedDateTime icwyavUN) {
        this.icwyavUN = icwyavUN;
    }

    public Long getMfjkCWSH() {
        return mfjkCWSH;
    }

    public void setMfjkCWSH(Long mfjkCWSH) {
        this.mfjkCWSH = mfjkCWSH;
    }

    public Integer getWdufNKFKF() {
        return wdufNKFKF;
    }

    public void setWdufNKFKF(Integer wdufNKFKF) {
        this.wdufNKFKF = wdufNKFKF;
    }

    public Boolean isTyuboofZLWKPX() {
        return tyuboofZLWKPX;
    }

    public void setTyuboofZLWKPX(Boolean tyuboofZLWKPX) {
        this.tyuboofZLWKPX = tyuboofZLWKPX;
    }

    public BigDecimal getbCGBSOAH() {
        return bCGBSOAH;
    }

    public void setbCGBSOAH(BigDecimal bCGBSOAH) {
        this.bCGBSOAH = bCGBSOAH;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ff)) {
            return false;
        }
        return id != null && id.equals(((Ff) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Ff{" +
            "id=" + getId() +
            ", urrW='" + getUrrW() + "'" +
            ", nsjjklaGVGL='" + getNsjjklaGVGL() + "'" +
            ", gffxRHSBKMA='" + getGffxRHSBKMA() + "'" +
            ", myqaeM=" + getMyqaeM() +
            ", aovBRJ=" + getAovBRJ() +
            ", mvcoQB=" + getMvcoQB() +
            ", xcwhaeeZ=" + getXcwhaeeZ() +
            ", jzrnmeTZSRO=" + getJzrnmeTZSRO() +
            ", wiBOYCMCRT='" + getWiBOYCMCRT() + "'" +
            ", jdrBMJZYTEWE=" + getJdrBMJZYTEWE() +
            ", gmhZYXPBZ=" + getGmhZYXPBZ() +
            ", iGIGVIBXJR='" + getiGIGVIBXJR() + "'" +
            ", fmfiCDTFJLB=" + getFmfiCDTFJLB() +
            ", ylufADJ=" + getYlufADJ() +
            ", pgnatCD='" + getPgnatCD() + "'" +
            ", icwyavUN='" + getIcwyavUN() + "'" +
            ", mfjkCWSH=" + getMfjkCWSH() +
            ", wdufNKFKF=" + getWdufNKFKF() +
            ", tyuboofZLWKPX='" + isTyuboofZLWKPX() + "'" +
            ", bCGBSOAH=" + getbCGBSOAH() +
            "}";
    }
}
