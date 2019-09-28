package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.ZjqabApp;
import grlmkb.wjw.vowri.bfkk.domain.Ff;
import grlmkb.wjw.vowri.bfkk.repository.FfRepository;
import grlmkb.wjw.vowri.bfkk.service.FfService;
import grlmkb.wjw.vowri.bfkk.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static grlmkb.wjw.vowri.bfkk.web.rest.TestUtil.sameInstant;
import static grlmkb.wjw.vowri.bfkk.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link FfResource} REST controller.
 */
@SpringBootTest(classes = ZjqabApp.class)
public class FfResourceIT {

    private static final Instant DEFAULT_URR_W = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_URR_W = Instant.now().truncatedTo(ChronoUnit.MILLIS);
    private static final Instant SMALLER_URR_W = Instant.ofEpochMilli(-1L);

    private static final LocalDate DEFAULT_NSJJKLA_GVGL = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_NSJJKLA_GVGL = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_NSJJKLA_GVGL = LocalDate.ofEpochDay(-1L);

    private static final Instant DEFAULT_GFFX_RHSBKMA = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_GFFX_RHSBKMA = Instant.now().truncatedTo(ChronoUnit.MILLIS);
    private static final Instant SMALLER_GFFX_RHSBKMA = Instant.ofEpochMilli(-1L);

    private static final BigDecimal DEFAULT_MYQAE_M = new BigDecimal(1);
    private static final BigDecimal UPDATED_MYQAE_M = new BigDecimal(2);
    private static final BigDecimal SMALLER_MYQAE_M = new BigDecimal(1 - 1);

    private static final BigDecimal DEFAULT_AOV_BRJ = new BigDecimal(1);
    private static final BigDecimal UPDATED_AOV_BRJ = new BigDecimal(2);
    private static final BigDecimal SMALLER_AOV_BRJ = new BigDecimal(1 - 1);

    private static final Long DEFAULT_MVCO_QB = 1L;
    private static final Long UPDATED_MVCO_QB = 2L;
    private static final Long SMALLER_MVCO_QB = 1L - 1L;

    private static final Float DEFAULT_XCWHAEE_Z = 1F;
    private static final Float UPDATED_XCWHAEE_Z = 2F;
    private static final Float SMALLER_XCWHAEE_Z = 1F - 1F;

    private static final Long DEFAULT_JZRNME_TZSRO = 1L;
    private static final Long UPDATED_JZRNME_TZSRO = 2L;
    private static final Long SMALLER_JZRNME_TZSRO = 1L - 1L;

    private static final Instant DEFAULT_WI_BOYCMCRT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_WI_BOYCMCRT = Instant.now().truncatedTo(ChronoUnit.MILLIS);
    private static final Instant SMALLER_WI_BOYCMCRT = Instant.ofEpochMilli(-1L);

    private static final Long DEFAULT_JDR_BMJZYTEWE = 1L;
    private static final Long UPDATED_JDR_BMJZYTEWE = 2L;
    private static final Long SMALLER_JDR_BMJZYTEWE = 1L - 1L;

    private static final Float DEFAULT_GMH_ZYXPBZ = 1F;
    private static final Float UPDATED_GMH_ZYXPBZ = 2F;
    private static final Float SMALLER_GMH_ZYXPBZ = 1F - 1F;

    private static final LocalDate DEFAULT_I_GIGVIBXJR = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_I_GIGVIBXJR = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_I_GIGVIBXJR = LocalDate.ofEpochDay(-1L);

    private static final Integer DEFAULT_FMFI_CDTFJLB = 1;
    private static final Integer UPDATED_FMFI_CDTFJLB = 2;
    private static final Integer SMALLER_FMFI_CDTFJLB = 1 - 1;

    private static final BigDecimal DEFAULT_YLUF_ADJ = new BigDecimal(1);
    private static final BigDecimal UPDATED_YLUF_ADJ = new BigDecimal(2);
    private static final BigDecimal SMALLER_YLUF_ADJ = new BigDecimal(1 - 1);

    private static final LocalDate DEFAULT_PGNAT_CD = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_PGNAT_CD = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_PGNAT_CD = LocalDate.ofEpochDay(-1L);

    private static final ZonedDateTime DEFAULT_ICWYAV_UN = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_ICWYAV_UN = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_ICWYAV_UN = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    private static final Long DEFAULT_MFJK_CWSH = 1L;
    private static final Long UPDATED_MFJK_CWSH = 2L;
    private static final Long SMALLER_MFJK_CWSH = 1L - 1L;

    private static final Integer DEFAULT_WDUF_NKFKF = 1;
    private static final Integer UPDATED_WDUF_NKFKF = 2;
    private static final Integer SMALLER_WDUF_NKFKF = 1 - 1;

    private static final Boolean DEFAULT_TYUBOOF_ZLWKPX = false;
    private static final Boolean UPDATED_TYUBOOF_ZLWKPX = true;

    private static final BigDecimal DEFAULT_B_CGBSOAH = new BigDecimal(1);
    private static final BigDecimal UPDATED_B_CGBSOAH = new BigDecimal(2);
    private static final BigDecimal SMALLER_B_CGBSOAH = new BigDecimal(1 - 1);

    @Autowired
    private FfRepository ffRepository;

    @Autowired
    private FfService ffService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restFfMockMvc;

    private Ff ff;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final FfResource ffResource = new FfResource(ffService);
        this.restFfMockMvc = MockMvcBuilders.standaloneSetup(ffResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Ff createEntity(EntityManager em) {
        Ff ff = new Ff();
        ff.setUrrW(DEFAULT_URR_W);
        ff.setNsjjklaGVGL(DEFAULT_NSJJKLA_GVGL);
        ff.setGffxRHSBKMA(DEFAULT_GFFX_RHSBKMA);
        ff.setMyqaeM(DEFAULT_MYQAE_M);
        ff.setAovBRJ(DEFAULT_AOV_BRJ);
        ff.setMvcoQB(DEFAULT_MVCO_QB);
        ff.setXcwhaeeZ(DEFAULT_XCWHAEE_Z);
        ff.setJzrnmeTZSRO(DEFAULT_JZRNME_TZSRO);
        ff.setWiBOYCMCRT(DEFAULT_WI_BOYCMCRT);
        ff.setJdrBMJZYTEWE(DEFAULT_JDR_BMJZYTEWE);
        ff.setGmhZYXPBZ(DEFAULT_GMH_ZYXPBZ);
        ff.setiGIGVIBXJR(DEFAULT_I_GIGVIBXJR);
        ff.setFmfiCDTFJLB(DEFAULT_FMFI_CDTFJLB);
        ff.setYlufADJ(DEFAULT_YLUF_ADJ);
        ff.setPgnatCD(DEFAULT_PGNAT_CD);
        ff.setIcwyavUN(DEFAULT_ICWYAV_UN);
        ff.setMfjkCWSH(DEFAULT_MFJK_CWSH);
        ff.setWdufNKFKF(DEFAULT_WDUF_NKFKF);
        ff.setTyuboofZLWKPX(DEFAULT_TYUBOOF_ZLWKPX);
        ff.setbCGBSOAH(DEFAULT_B_CGBSOAH);
        return ff;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Ff createUpdatedEntity(EntityManager em) {
        Ff ff = new Ff();
        ff.setUrrW(UPDATED_URR_W);
        ff.setNsjjklaGVGL(UPDATED_NSJJKLA_GVGL);
        ff.setGffxRHSBKMA(UPDATED_GFFX_RHSBKMA);
        ff.setMyqaeM(UPDATED_MYQAE_M);
        ff.setAovBRJ(UPDATED_AOV_BRJ);
        ff.setMvcoQB(UPDATED_MVCO_QB);
        ff.setXcwhaeeZ(UPDATED_XCWHAEE_Z);
        ff.setJzrnmeTZSRO(UPDATED_JZRNME_TZSRO);
        ff.setWiBOYCMCRT(UPDATED_WI_BOYCMCRT);
        ff.setJdrBMJZYTEWE(UPDATED_JDR_BMJZYTEWE);
        ff.setGmhZYXPBZ(UPDATED_GMH_ZYXPBZ);
        ff.setiGIGVIBXJR(UPDATED_I_GIGVIBXJR);
        ff.setFmfiCDTFJLB(UPDATED_FMFI_CDTFJLB);
        ff.setYlufADJ(UPDATED_YLUF_ADJ);
        ff.setPgnatCD(UPDATED_PGNAT_CD);
        ff.setIcwyavUN(UPDATED_ICWYAV_UN);
        ff.setMfjkCWSH(UPDATED_MFJK_CWSH);
        ff.setWdufNKFKF(UPDATED_WDUF_NKFKF);
        ff.setTyuboofZLWKPX(UPDATED_TYUBOOF_ZLWKPX);
        ff.setbCGBSOAH(UPDATED_B_CGBSOAH);
        return ff;
    }

    @BeforeEach
    public void initTest() {
        ff = createEntity(em);
    }

    @Test
    @Transactional
    public void createFf() throws Exception {
        int databaseSizeBeforeCreate = ffRepository.findAll().size();

        // Create the Ff
        restFfMockMvc.perform(post("/api/ffs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ff)))
            .andExpect(status().isCreated());

        // Validate the Ff in the database
        List<Ff> ffList = ffRepository.findAll();
        assertThat(ffList).hasSize(databaseSizeBeforeCreate + 1);
        Ff testFf = ffList.get(ffList.size() - 1);
        assertThat(testFf.getUrrW()).isEqualTo(DEFAULT_URR_W);
        assertThat(testFf.getNsjjklaGVGL()).isEqualTo(DEFAULT_NSJJKLA_GVGL);
        assertThat(testFf.getGffxRHSBKMA()).isEqualTo(DEFAULT_GFFX_RHSBKMA);
        assertThat(testFf.getMyqaeM()).isEqualTo(DEFAULT_MYQAE_M);
        assertThat(testFf.getAovBRJ()).isEqualTo(DEFAULT_AOV_BRJ);
        assertThat(testFf.getMvcoQB()).isEqualTo(DEFAULT_MVCO_QB);
        assertThat(testFf.getXcwhaeeZ()).isEqualTo(DEFAULT_XCWHAEE_Z);
        assertThat(testFf.getJzrnmeTZSRO()).isEqualTo(DEFAULT_JZRNME_TZSRO);
        assertThat(testFf.getWiBOYCMCRT()).isEqualTo(DEFAULT_WI_BOYCMCRT);
        assertThat(testFf.getJdrBMJZYTEWE()).isEqualTo(DEFAULT_JDR_BMJZYTEWE);
        assertThat(testFf.getGmhZYXPBZ()).isEqualTo(DEFAULT_GMH_ZYXPBZ);
        assertThat(testFf.getiGIGVIBXJR()).isEqualTo(DEFAULT_I_GIGVIBXJR);
        assertThat(testFf.getFmfiCDTFJLB()).isEqualTo(DEFAULT_FMFI_CDTFJLB);
        assertThat(testFf.getYlufADJ()).isEqualTo(DEFAULT_YLUF_ADJ);
        assertThat(testFf.getPgnatCD()).isEqualTo(DEFAULT_PGNAT_CD);
        assertThat(testFf.getIcwyavUN()).isEqualTo(DEFAULT_ICWYAV_UN);
        assertThat(testFf.getMfjkCWSH()).isEqualTo(DEFAULT_MFJK_CWSH);
        assertThat(testFf.getWdufNKFKF()).isEqualTo(DEFAULT_WDUF_NKFKF);
        assertThat(testFf.isTyuboofZLWKPX()).isEqualTo(DEFAULT_TYUBOOF_ZLWKPX);
        assertThat(testFf.getbCGBSOAH()).isEqualTo(DEFAULT_B_CGBSOAH);
    }

    @Test
    @Transactional
    public void createFfWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = ffRepository.findAll().size();

        // Create the Ff with an existing ID
        ff.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restFfMockMvc.perform(post("/api/ffs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ff)))
            .andExpect(status().isBadRequest());

        // Validate the Ff in the database
        List<Ff> ffList = ffRepository.findAll();
        assertThat(ffList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllFfs() throws Exception {
        // Initialize the database
        ffRepository.saveAndFlush(ff);

        // Get all the ffList
        restFfMockMvc.perform(get("/api/ffs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(ff.getId().intValue())))
            .andExpect(jsonPath("$.[*].urrW").value(hasItem(DEFAULT_URR_W.toString())))
            .andExpect(jsonPath("$.[*].nsjjklaGVGL").value(hasItem(DEFAULT_NSJJKLA_GVGL.toString())))
            .andExpect(jsonPath("$.[*].gffxRHSBKMA").value(hasItem(DEFAULT_GFFX_RHSBKMA.toString())))
            .andExpect(jsonPath("$.[*].myqaeM").value(hasItem(DEFAULT_MYQAE_M.intValue())))
            .andExpect(jsonPath("$.[*].aovBRJ").value(hasItem(DEFAULT_AOV_BRJ.intValue())))
            .andExpect(jsonPath("$.[*].mvcoQB").value(hasItem(DEFAULT_MVCO_QB.intValue())))
            .andExpect(jsonPath("$.[*].xcwhaeeZ").value(hasItem(DEFAULT_XCWHAEE_Z.doubleValue())))
            .andExpect(jsonPath("$.[*].jzrnmeTZSRO").value(hasItem(DEFAULT_JZRNME_TZSRO.intValue())))
            .andExpect(jsonPath("$.[*].wiBOYCMCRT").value(hasItem(DEFAULT_WI_BOYCMCRT.toString())))
            .andExpect(jsonPath("$.[*].jdrBMJZYTEWE").value(hasItem(DEFAULT_JDR_BMJZYTEWE.intValue())))
            .andExpect(jsonPath("$.[*].gmhZYXPBZ").value(hasItem(DEFAULT_GMH_ZYXPBZ.doubleValue())))
            .andExpect(jsonPath("$.[*].iGIGVIBXJR").value(hasItem(DEFAULT_I_GIGVIBXJR.toString())))
            .andExpect(jsonPath("$.[*].fmfiCDTFJLB").value(hasItem(DEFAULT_FMFI_CDTFJLB)))
            .andExpect(jsonPath("$.[*].ylufADJ").value(hasItem(DEFAULT_YLUF_ADJ.intValue())))
            .andExpect(jsonPath("$.[*].pgnatCD").value(hasItem(DEFAULT_PGNAT_CD.toString())))
            .andExpect(jsonPath("$.[*].icwyavUN").value(hasItem(sameInstant(DEFAULT_ICWYAV_UN))))
            .andExpect(jsonPath("$.[*].mfjkCWSH").value(hasItem(DEFAULT_MFJK_CWSH.intValue())))
            .andExpect(jsonPath("$.[*].wdufNKFKF").value(hasItem(DEFAULT_WDUF_NKFKF)))
            .andExpect(jsonPath("$.[*].tyuboofZLWKPX").value(hasItem(DEFAULT_TYUBOOF_ZLWKPX.booleanValue())))
            .andExpect(jsonPath("$.[*].bCGBSOAH").value(hasItem(DEFAULT_B_CGBSOAH.intValue())));
    }
    
    @Test
    @Transactional
    public void getFf() throws Exception {
        // Initialize the database
        ffRepository.saveAndFlush(ff);

        // Get the ff
        restFfMockMvc.perform(get("/api/ffs/{id}", ff.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(ff.getId().intValue()))
            .andExpect(jsonPath("$.urrW").value(DEFAULT_URR_W.toString()))
            .andExpect(jsonPath("$.nsjjklaGVGL").value(DEFAULT_NSJJKLA_GVGL.toString()))
            .andExpect(jsonPath("$.gffxRHSBKMA").value(DEFAULT_GFFX_RHSBKMA.toString()))
            .andExpect(jsonPath("$.myqaeM").value(DEFAULT_MYQAE_M.intValue()))
            .andExpect(jsonPath("$.aovBRJ").value(DEFAULT_AOV_BRJ.intValue()))
            .andExpect(jsonPath("$.mvcoQB").value(DEFAULT_MVCO_QB.intValue()))
            .andExpect(jsonPath("$.xcwhaeeZ").value(DEFAULT_XCWHAEE_Z.doubleValue()))
            .andExpect(jsonPath("$.jzrnmeTZSRO").value(DEFAULT_JZRNME_TZSRO.intValue()))
            .andExpect(jsonPath("$.wiBOYCMCRT").value(DEFAULT_WI_BOYCMCRT.toString()))
            .andExpect(jsonPath("$.jdrBMJZYTEWE").value(DEFAULT_JDR_BMJZYTEWE.intValue()))
            .andExpect(jsonPath("$.gmhZYXPBZ").value(DEFAULT_GMH_ZYXPBZ.doubleValue()))
            .andExpect(jsonPath("$.iGIGVIBXJR").value(DEFAULT_I_GIGVIBXJR.toString()))
            .andExpect(jsonPath("$.fmfiCDTFJLB").value(DEFAULT_FMFI_CDTFJLB))
            .andExpect(jsonPath("$.ylufADJ").value(DEFAULT_YLUF_ADJ.intValue()))
            .andExpect(jsonPath("$.pgnatCD").value(DEFAULT_PGNAT_CD.toString()))
            .andExpect(jsonPath("$.icwyavUN").value(sameInstant(DEFAULT_ICWYAV_UN)))
            .andExpect(jsonPath("$.mfjkCWSH").value(DEFAULT_MFJK_CWSH.intValue()))
            .andExpect(jsonPath("$.wdufNKFKF").value(DEFAULT_WDUF_NKFKF))
            .andExpect(jsonPath("$.tyuboofZLWKPX").value(DEFAULT_TYUBOOF_ZLWKPX.booleanValue()))
            .andExpect(jsonPath("$.bCGBSOAH").value(DEFAULT_B_CGBSOAH.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingFf() throws Exception {
        // Get the ff
        restFfMockMvc.perform(get("/api/ffs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateFf() throws Exception {
        // Initialize the database
        ffService.save(ff);

        int databaseSizeBeforeUpdate = ffRepository.findAll().size();

        // Update the ff
        Ff updatedFf = ffRepository.findById(ff.getId()).get();
        // Disconnect from session so that the updates on updatedFf are not directly saved in db
        em.detach(updatedFf);
        updatedFf.setUrrW(UPDATED_URR_W);
        updatedFf.setNsjjklaGVGL(UPDATED_NSJJKLA_GVGL);
        updatedFf.setGffxRHSBKMA(UPDATED_GFFX_RHSBKMA);
        updatedFf.setMyqaeM(UPDATED_MYQAE_M);
        updatedFf.setAovBRJ(UPDATED_AOV_BRJ);
        updatedFf.setMvcoQB(UPDATED_MVCO_QB);
        updatedFf.setXcwhaeeZ(UPDATED_XCWHAEE_Z);
        updatedFf.setJzrnmeTZSRO(UPDATED_JZRNME_TZSRO);
        updatedFf.setWiBOYCMCRT(UPDATED_WI_BOYCMCRT);
        updatedFf.setJdrBMJZYTEWE(UPDATED_JDR_BMJZYTEWE);
        updatedFf.setGmhZYXPBZ(UPDATED_GMH_ZYXPBZ);
        updatedFf.setiGIGVIBXJR(UPDATED_I_GIGVIBXJR);
        updatedFf.setFmfiCDTFJLB(UPDATED_FMFI_CDTFJLB);
        updatedFf.setYlufADJ(UPDATED_YLUF_ADJ);
        updatedFf.setPgnatCD(UPDATED_PGNAT_CD);
        updatedFf.setIcwyavUN(UPDATED_ICWYAV_UN);
        updatedFf.setMfjkCWSH(UPDATED_MFJK_CWSH);
        updatedFf.setWdufNKFKF(UPDATED_WDUF_NKFKF);
        updatedFf.setTyuboofZLWKPX(UPDATED_TYUBOOF_ZLWKPX);
        updatedFf.setbCGBSOAH(UPDATED_B_CGBSOAH);

        restFfMockMvc.perform(put("/api/ffs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedFf)))
            .andExpect(status().isOk());

        // Validate the Ff in the database
        List<Ff> ffList = ffRepository.findAll();
        assertThat(ffList).hasSize(databaseSizeBeforeUpdate);
        Ff testFf = ffList.get(ffList.size() - 1);
        assertThat(testFf.getUrrW()).isEqualTo(UPDATED_URR_W);
        assertThat(testFf.getNsjjklaGVGL()).isEqualTo(UPDATED_NSJJKLA_GVGL);
        assertThat(testFf.getGffxRHSBKMA()).isEqualTo(UPDATED_GFFX_RHSBKMA);
        assertThat(testFf.getMyqaeM()).isEqualTo(UPDATED_MYQAE_M);
        assertThat(testFf.getAovBRJ()).isEqualTo(UPDATED_AOV_BRJ);
        assertThat(testFf.getMvcoQB()).isEqualTo(UPDATED_MVCO_QB);
        assertThat(testFf.getXcwhaeeZ()).isEqualTo(UPDATED_XCWHAEE_Z);
        assertThat(testFf.getJzrnmeTZSRO()).isEqualTo(UPDATED_JZRNME_TZSRO);
        assertThat(testFf.getWiBOYCMCRT()).isEqualTo(UPDATED_WI_BOYCMCRT);
        assertThat(testFf.getJdrBMJZYTEWE()).isEqualTo(UPDATED_JDR_BMJZYTEWE);
        assertThat(testFf.getGmhZYXPBZ()).isEqualTo(UPDATED_GMH_ZYXPBZ);
        assertThat(testFf.getiGIGVIBXJR()).isEqualTo(UPDATED_I_GIGVIBXJR);
        assertThat(testFf.getFmfiCDTFJLB()).isEqualTo(UPDATED_FMFI_CDTFJLB);
        assertThat(testFf.getYlufADJ()).isEqualTo(UPDATED_YLUF_ADJ);
        assertThat(testFf.getPgnatCD()).isEqualTo(UPDATED_PGNAT_CD);
        assertThat(testFf.getIcwyavUN()).isEqualTo(UPDATED_ICWYAV_UN);
        assertThat(testFf.getMfjkCWSH()).isEqualTo(UPDATED_MFJK_CWSH);
        assertThat(testFf.getWdufNKFKF()).isEqualTo(UPDATED_WDUF_NKFKF);
        assertThat(testFf.isTyuboofZLWKPX()).isEqualTo(UPDATED_TYUBOOF_ZLWKPX);
        assertThat(testFf.getbCGBSOAH()).isEqualTo(UPDATED_B_CGBSOAH);
    }

    @Test
    @Transactional
    public void updateNonExistingFf() throws Exception {
        int databaseSizeBeforeUpdate = ffRepository.findAll().size();

        // Create the Ff

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFfMockMvc.perform(put("/api/ffs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ff)))
            .andExpect(status().isBadRequest());

        // Validate the Ff in the database
        List<Ff> ffList = ffRepository.findAll();
        assertThat(ffList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteFf() throws Exception {
        // Initialize the database
        ffService.save(ff);

        int databaseSizeBeforeDelete = ffRepository.findAll().size();

        // Delete the ff
        restFfMockMvc.perform(delete("/api/ffs/{id}", ff.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Ff> ffList = ffRepository.findAll();
        assertThat(ffList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Ff.class);
        Ff ff1 = new Ff();
        ff1.setId(1L);
        Ff ff2 = new Ff();
        ff2.setId(ff1.getId());
        assertThat(ff1).isEqualTo(ff2);
        ff2.setId(2L);
        assertThat(ff1).isNotEqualTo(ff2);
        ff1.setId(null);
        assertThat(ff1).isNotEqualTo(ff2);
    }
}
