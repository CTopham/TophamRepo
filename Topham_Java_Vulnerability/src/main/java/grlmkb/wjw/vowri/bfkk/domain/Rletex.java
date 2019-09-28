package grlmkb.wjw.vowri.bfkk.domain;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * A Rletex.
 */
@Entity
@Table(name = "clj")
public class Rletex implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "sroeih_timovoqhq")
    private Boolean sroeihTIMOVOQHQ;

    @Column(name = "lczcjl_hybzk")
    private Long lczcjlHYBZK;

    @Column(name = "xlk_jzdtgudmi")
    private Instant xlkJZDTGUDMI;

    @Column(name = "dhzewmhh_mb")
    private LocalDate dhzewmhhMB;

    @Column(name = "cltur_nt")
    private String clturNT;

    @Column(name = "kwbl_adtz")
    private Integer kwblADTZ;

    @Column(name = "mqnwb_gjx")
    private Long mqnwbGJX;

    @Column(name = "x_ozir")
    private Boolean xOZIR;

    @Column(name = "vmq_v", precision = 21, scale = 2)
    private BigDecimal vmqV;

    @Column(name = "i_gglnxldxs")
    private ZonedDateTime iGGLNXLDXS;

    @Column(name = "vksnruhc_gxviwct")
    private Boolean vksnruhcGXVIWCT;

    @Column(name = "munxna_y")
    private Float munxnaY;

    @Column(name = "qihf_hxry")
    private LocalDate qihfHXRY;

    @Column(name = "dwfucglg_xnd")
    private Long dwfucglgXND;

    @Column(name = "yo_unhreztlg")
    private String yoUNHREZTLG;

    @Column(name = "sytd_er")
    private String sytdER;

    @Column(name = "z_nbbbicyp")
    private String zNBBBICYP;

    @Column(name = "ifotjf_awxjdjif")
    private Boolean ifotjfAWXJDJIF;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isSroeihTIMOVOQHQ() {
        return sroeihTIMOVOQHQ;
    }

    public void setSroeihTIMOVOQHQ(Boolean sroeihTIMOVOQHQ) {
        this.sroeihTIMOVOQHQ = sroeihTIMOVOQHQ;
    }

    public Long getLczcjlHYBZK() {
        return lczcjlHYBZK;
    }

    public void setLczcjlHYBZK(Long lczcjlHYBZK) {
        this.lczcjlHYBZK = lczcjlHYBZK;
    }

    public Instant getXlkJZDTGUDMI() {
        return xlkJZDTGUDMI;
    }

    public void setXlkJZDTGUDMI(Instant xlkJZDTGUDMI) {
        this.xlkJZDTGUDMI = xlkJZDTGUDMI;
    }

    public LocalDate getDhzewmhhMB() {
        return dhzewmhhMB;
    }

    public void setDhzewmhhMB(LocalDate dhzewmhhMB) {
        this.dhzewmhhMB = dhzewmhhMB;
    }

    public String getClturNT() {
        return clturNT;
    }

    public void setClturNT(String clturNT) {
        this.clturNT = clturNT;
    }

    public Integer getKwblADTZ() {
        return kwblADTZ;
    }

    public void setKwblADTZ(Integer kwblADTZ) {
        this.kwblADTZ = kwblADTZ;
    }

    public Long getMqnwbGJX() {
        return mqnwbGJX;
    }

    public void setMqnwbGJX(Long mqnwbGJX) {
        this.mqnwbGJX = mqnwbGJX;
    }

    public Boolean isxOZIR() {
        return xOZIR;
    }

    public void setxOZIR(Boolean xOZIR) {
        this.xOZIR = xOZIR;
    }

    public BigDecimal getVmqV() {
        return vmqV;
    }

    public void setVmqV(BigDecimal vmqV) {
        this.vmqV = vmqV;
    }

    public ZonedDateTime getiGGLNXLDXS() {
        return iGGLNXLDXS;
    }

    public void setiGGLNXLDXS(ZonedDateTime iGGLNXLDXS) {
        this.iGGLNXLDXS = iGGLNXLDXS;
    }

    public Boolean isVksnruhcGXVIWCT() {
        return vksnruhcGXVIWCT;
    }

    public void setVksnruhcGXVIWCT(Boolean vksnruhcGXVIWCT) {
        this.vksnruhcGXVIWCT = vksnruhcGXVIWCT;
    }

    public Float getMunxnaY() {
        return munxnaY;
    }

    public void setMunxnaY(Float munxnaY) {
        this.munxnaY = munxnaY;
    }

    public LocalDate getQihfHXRY() {
        return qihfHXRY;
    }

    public void setQihfHXRY(LocalDate qihfHXRY) {
        this.qihfHXRY = qihfHXRY;
    }

    public Long getDwfucglgXND() {
        return dwfucglgXND;
    }

    public void setDwfucglgXND(Long dwfucglgXND) {
        this.dwfucglgXND = dwfucglgXND;
    }

    public String getYoUNHREZTLG() {
        return yoUNHREZTLG;
    }

    public void setYoUNHREZTLG(String yoUNHREZTLG) {
        this.yoUNHREZTLG = yoUNHREZTLG;
    }

    public String getSytdER() {
        return sytdER;
    }

    public void setSytdER(String sytdER) {
        this.sytdER = sytdER;
    }

    public String getzNBBBICYP() {
        return zNBBBICYP;
    }

    public void setzNBBBICYP(String zNBBBICYP) {
        this.zNBBBICYP = zNBBBICYP;
    }

    public Boolean isIfotjfAWXJDJIF() {
        return ifotjfAWXJDJIF;
    }

    public void setIfotjfAWXJDJIF(Boolean ifotjfAWXJDJIF) {
        this.ifotjfAWXJDJIF = ifotjfAWXJDJIF;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rletex)) {
            return false;
        }
        return id != null && id.equals(((Rletex) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Rletex{" +
            "id=" + getId() +
            ", sroeihTIMOVOQHQ='" + isSroeihTIMOVOQHQ() + "'" +
            ", lczcjlHYBZK=" + getLczcjlHYBZK() +
            ", xlkJZDTGUDMI='" + getXlkJZDTGUDMI() + "'" +
            ", dhzewmhhMB='" + getDhzewmhhMB() + "'" +
            ", clturNT='" + getClturNT() + "'" +
            ", kwblADTZ=" + getKwblADTZ() +
            ", mqnwbGJX=" + getMqnwbGJX() +
            ", xOZIR='" + isxOZIR() + "'" +
            ", vmqV=" + getVmqV() +
            ", iGGLNXLDXS='" + getiGGLNXLDXS() + "'" +
            ", vksnruhcGXVIWCT='" + isVksnruhcGXVIWCT() + "'" +
            ", munxnaY=" + getMunxnaY() +
            ", qihfHXRY='" + getQihfHXRY() + "'" +
            ", dwfucglgXND=" + getDwfucglgXND() +
            ", yoUNHREZTLG='" + getYoUNHREZTLG() + "'" +
            ", sytdER='" + getSytdER() + "'" +
            ", zNBBBICYP='" + getzNBBBICYP() + "'" +
            ", ifotjfAWXJDJIF='" + isIfotjfAWXJDJIF() + "'" +
            "}";
    }
}
