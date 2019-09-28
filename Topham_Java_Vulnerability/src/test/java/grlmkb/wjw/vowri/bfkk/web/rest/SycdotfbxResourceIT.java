package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.ZjqabApp;
import grlmkb.wjw.vowri.bfkk.domain.Sycdotfbx;
import grlmkb.wjw.vowri.bfkk.repository.SycdotfbxRepository;
import grlmkb.wjw.vowri.bfkk.service.SycdotfbxService;
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
 * Integration tests for the {@link SycdotfbxResource} REST controller.
 */
@SpringBootTest(classes = ZjqabApp.class)
public class SycdotfbxResourceIT {

    private static final String DEFAULT_UOERQR_WHAVSPOY = "AAAAAAAAAA";
    private static final String UPDATED_UOERQR_WHAVSPOY = "BBBBBBBBBB";

    private static final Integer DEFAULT_VTOEABLLI_MPK = 1;
    private static final Integer UPDATED_VTOEABLLI_MPK = 2;
    private static final Integer SMALLER_VTOEABLLI_MPK = 1 - 1;

    private static final String DEFAULT_GV_AUAOKYBWN = "AAAAAAAAAA";
    private static final String UPDATED_GV_AUAOKYBWN = "BBBBBBBBBB";

    private static final Instant DEFAULT_YLOOXRW_CAVWCFSFJ = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_YLOOXRW_CAVWCFSFJ = Instant.now().truncatedTo(ChronoUnit.MILLIS);
    private static final Instant SMALLER_YLOOXRW_CAVWCFSFJ = Instant.ofEpochMilli(-1L);

    private static final Instant DEFAULT_BEBOHAAN_SNOHCG = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_BEBOHAAN_SNOHCG = Instant.now().truncatedTo(ChronoUnit.MILLIS);
    private static final Instant SMALLER_BEBOHAAN_SNOHCG = Instant.ofEpochMilli(-1L);

    private static final String DEFAULT_PHNAG_MUIFEGY = "AAAAAAAAAA";
    private static final String UPDATED_PHNAG_MUIFEGY = "BBBBBBBBBB";

    private static final Boolean DEFAULT_MNDIOZ_SZG = false;
    private static final Boolean UPDATED_MNDIOZ_SZG = true;

    private static final ZonedDateTime DEFAULT_SR_TDOBHW = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_SR_TDOBHW = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_SR_TDOBHW = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    private static final Integer DEFAULT_OQHTBLWU_LMTRLPZMS = 1;
    private static final Integer UPDATED_OQHTBLWU_LMTRLPZMS = 2;
    private static final Integer SMALLER_OQHTBLWU_LMTRLPZMS = 1 - 1;

    private static final ZonedDateTime DEFAULT_M_DPGGK = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_M_DPGGK = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_M_DPGGK = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    private static final ZonedDateTime DEFAULT_DGBHXWT_LLL = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_DGBHXWT_LLL = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_DGBHXWT_LLL = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    private static final BigDecimal DEFAULT_BQGUZOAGV_FCZV = new BigDecimal(1);
    private static final BigDecimal UPDATED_BQGUZOAGV_FCZV = new BigDecimal(2);
    private static final BigDecimal SMALLER_BQGUZOAGV_FCZV = new BigDecimal(1 - 1);

    private static final String DEFAULT_JQWOMP_JVQH = "AAAAAAAAAA";
    private static final String UPDATED_JQWOMP_JVQH = "BBBBBBBBBB";

    private static final String DEFAULT_K_IMVKQBL = "AAAAAAAAAA";
    private static final String UPDATED_K_IMVKQBL = "BBBBBBBBBB";

    private static final Long DEFAULT_UTE_AXHLSH = 1L;
    private static final Long UPDATED_UTE_AXHLSH = 2L;
    private static final Long SMALLER_UTE_AXHLSH = 1L - 1L;

    private static final String DEFAULT_NNTCPJ_SMOPWFJY = "AAAAAAAAAA";
    private static final String UPDATED_NNTCPJ_SMOPWFJY = "BBBBBBBBBB";

    private static final String DEFAULT_VFXSOYG_ABWPMSUQU = "AAAAAAAAAA";
    private static final String UPDATED_VFXSOYG_ABWPMSUQU = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_FBDIG_DZKP = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_FBDIG_DZKP = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_FBDIG_DZKP = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    private static final Float DEFAULT_VIGC_COZMN = 1F;
    private static final Float UPDATED_VIGC_COZMN = 2F;
    private static final Float SMALLER_VIGC_COZMN = 1F - 1F;

    @Autowired
    private SycdotfbxRepository sycdotfbxRepository;

    @Autowired
    private SycdotfbxService sycdotfbxService;

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

    private MockMvc restSycdotfbxMockMvc;

    private Sycdotfbx sycdotfbx;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final SycdotfbxResource sycdotfbxResource = new SycdotfbxResource(sycdotfbxService);
        this.restSycdotfbxMockMvc = MockMvcBuilders.standaloneSetup(sycdotfbxResource)
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
    public static Sycdotfbx createEntity(EntityManager em) {
        Sycdotfbx sycdotfbx = new Sycdotfbx()
            .uoerqrWHAVSPOY(DEFAULT_UOERQR_WHAVSPOY)
            .vtoeablliMPK(DEFAULT_VTOEABLLI_MPK)
            .gvAUAOKYBWN(DEFAULT_GV_AUAOKYBWN)
            .ylooxrwCAVWCFSFJ(DEFAULT_YLOOXRW_CAVWCFSFJ)
            .bebohaanSNOHCG(DEFAULT_BEBOHAAN_SNOHCG)
            .phnagMUIFEGY(DEFAULT_PHNAG_MUIFEGY)
            .mndiozSZG(DEFAULT_MNDIOZ_SZG)
            .srTDOBHW(DEFAULT_SR_TDOBHW)
            .oqhtblwuLMTRLPZMS(DEFAULT_OQHTBLWU_LMTRLPZMS)
            .mDPGGK(DEFAULT_M_DPGGK)
            .dgbhxwtLLL(DEFAULT_DGBHXWT_LLL)
            .bqguzoagvFCZV(DEFAULT_BQGUZOAGV_FCZV)
            .jqwompJVQH(DEFAULT_JQWOMP_JVQH)
            .kIMVKQBL(DEFAULT_K_IMVKQBL)
            .uteAXHLSH(DEFAULT_UTE_AXHLSH)
            .nntcpjSMOPWFJY(DEFAULT_NNTCPJ_SMOPWFJY)
            .vfxsoygABWPMSUQU(DEFAULT_VFXSOYG_ABWPMSUQU)
            .fbdigDZKP(DEFAULT_FBDIG_DZKP)
            .vigcCOZMN(DEFAULT_VIGC_COZMN);
        return sycdotfbx;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Sycdotfbx createUpdatedEntity(EntityManager em) {
        Sycdotfbx sycdotfbx = new Sycdotfbx()
            .uoerqrWHAVSPOY(UPDATED_UOERQR_WHAVSPOY)
            .vtoeablliMPK(UPDATED_VTOEABLLI_MPK)
            .gvAUAOKYBWN(UPDATED_GV_AUAOKYBWN)
            .ylooxrwCAVWCFSFJ(UPDATED_YLOOXRW_CAVWCFSFJ)
            .bebohaanSNOHCG(UPDATED_BEBOHAAN_SNOHCG)
            .phnagMUIFEGY(UPDATED_PHNAG_MUIFEGY)
            .mndiozSZG(UPDATED_MNDIOZ_SZG)
            .srTDOBHW(UPDATED_SR_TDOBHW)
            .oqhtblwuLMTRLPZMS(UPDATED_OQHTBLWU_LMTRLPZMS)
            .mDPGGK(UPDATED_M_DPGGK)
            .dgbhxwtLLL(UPDATED_DGBHXWT_LLL)
            .bqguzoagvFCZV(UPDATED_BQGUZOAGV_FCZV)
            .jqwompJVQH(UPDATED_JQWOMP_JVQH)
            .kIMVKQBL(UPDATED_K_IMVKQBL)
            .uteAXHLSH(UPDATED_UTE_AXHLSH)
            .nntcpjSMOPWFJY(UPDATED_NNTCPJ_SMOPWFJY)
            .vfxsoygABWPMSUQU(UPDATED_VFXSOYG_ABWPMSUQU)
            .fbdigDZKP(UPDATED_FBDIG_DZKP)
            .vigcCOZMN(UPDATED_VIGC_COZMN);
        return sycdotfbx;
    }

    @BeforeEach
    public void initTest() {
        sycdotfbx = createEntity(em);
    }

    @Test
    @Transactional
    public void createSycdotfbx() throws Exception {
        int databaseSizeBeforeCreate = sycdotfbxRepository.findAll().size();

        // Create the Sycdotfbx
        restSycdotfbxMockMvc.perform(post("/api/sycdotfbxes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sycdotfbx)))
            .andExpect(status().isCreated());

        // Validate the Sycdotfbx in the database
        List<Sycdotfbx> sycdotfbxList = sycdotfbxRepository.findAll();
        assertThat(sycdotfbxList).hasSize(databaseSizeBeforeCreate + 1);
        Sycdotfbx testSycdotfbx = sycdotfbxList.get(sycdotfbxList.size() - 1);
        assertThat(testSycdotfbx.getUoerqrWHAVSPOY()).isEqualTo(DEFAULT_UOERQR_WHAVSPOY);
        assertThat(testSycdotfbx.getVtoeablliMPK()).isEqualTo(DEFAULT_VTOEABLLI_MPK);
        assertThat(testSycdotfbx.getGvAUAOKYBWN()).isEqualTo(DEFAULT_GV_AUAOKYBWN);
        assertThat(testSycdotfbx.getYlooxrwCAVWCFSFJ()).isEqualTo(DEFAULT_YLOOXRW_CAVWCFSFJ);
        assertThat(testSycdotfbx.getBebohaanSNOHCG()).isEqualTo(DEFAULT_BEBOHAAN_SNOHCG);
        assertThat(testSycdotfbx.getPhnagMUIFEGY()).isEqualTo(DEFAULT_PHNAG_MUIFEGY);
        assertThat(testSycdotfbx.isMndiozSZG()).isEqualTo(DEFAULT_MNDIOZ_SZG);
        assertThat(testSycdotfbx.getSrTDOBHW()).isEqualTo(DEFAULT_SR_TDOBHW);
        assertThat(testSycdotfbx.getOqhtblwuLMTRLPZMS()).isEqualTo(DEFAULT_OQHTBLWU_LMTRLPZMS);
        assertThat(testSycdotfbx.getmDPGGK()).isEqualTo(DEFAULT_M_DPGGK);
        assertThat(testSycdotfbx.getDgbhxwtLLL()).isEqualTo(DEFAULT_DGBHXWT_LLL);
        assertThat(testSycdotfbx.getBqguzoagvFCZV()).isEqualTo(DEFAULT_BQGUZOAGV_FCZV);
        assertThat(testSycdotfbx.getJqwompJVQH()).isEqualTo(DEFAULT_JQWOMP_JVQH);
        assertThat(testSycdotfbx.getkIMVKQBL()).isEqualTo(DEFAULT_K_IMVKQBL);
        assertThat(testSycdotfbx.getUteAXHLSH()).isEqualTo(DEFAULT_UTE_AXHLSH);
        assertThat(testSycdotfbx.getNntcpjSMOPWFJY()).isEqualTo(DEFAULT_NNTCPJ_SMOPWFJY);
        assertThat(testSycdotfbx.getVfxsoygABWPMSUQU()).isEqualTo(DEFAULT_VFXSOYG_ABWPMSUQU);
        assertThat(testSycdotfbx.getFbdigDZKP()).isEqualTo(DEFAULT_FBDIG_DZKP);
        assertThat(testSycdotfbx.getVigcCOZMN()).isEqualTo(DEFAULT_VIGC_COZMN);
    }

    @Test
    @Transactional
    public void createSycdotfbxWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = sycdotfbxRepository.findAll().size();

        // Create the Sycdotfbx with an existing ID
        sycdotfbx.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSycdotfbxMockMvc.perform(post("/api/sycdotfbxes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sycdotfbx)))
            .andExpect(status().isBadRequest());

        // Validate the Sycdotfbx in the database
        List<Sycdotfbx> sycdotfbxList = sycdotfbxRepository.findAll();
        assertThat(sycdotfbxList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSycdotfbxes() throws Exception {
        // Initialize the database
        sycdotfbxRepository.saveAndFlush(sycdotfbx);

        // Get all the sycdotfbxList
        restSycdotfbxMockMvc.perform(get("/api/sycdotfbxes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sycdotfbx.getId().intValue())))
            .andExpect(jsonPath("$.[*].uoerqrWHAVSPOY").value(hasItem(DEFAULT_UOERQR_WHAVSPOY.toString())))
            .andExpect(jsonPath("$.[*].vtoeablliMPK").value(hasItem(DEFAULT_VTOEABLLI_MPK)))
            .andExpect(jsonPath("$.[*].gvAUAOKYBWN").value(hasItem(DEFAULT_GV_AUAOKYBWN.toString())))
            .andExpect(jsonPath("$.[*].ylooxrwCAVWCFSFJ").value(hasItem(DEFAULT_YLOOXRW_CAVWCFSFJ.toString())))
            .andExpect(jsonPath("$.[*].bebohaanSNOHCG").value(hasItem(DEFAULT_BEBOHAAN_SNOHCG.toString())))
            .andExpect(jsonPath("$.[*].phnagMUIFEGY").value(hasItem(DEFAULT_PHNAG_MUIFEGY.toString())))
            .andExpect(jsonPath("$.[*].mndiozSZG").value(hasItem(DEFAULT_MNDIOZ_SZG.booleanValue())))
            .andExpect(jsonPath("$.[*].srTDOBHW").value(hasItem(sameInstant(DEFAULT_SR_TDOBHW))))
            .andExpect(jsonPath("$.[*].oqhtblwuLMTRLPZMS").value(hasItem(DEFAULT_OQHTBLWU_LMTRLPZMS)))
            .andExpect(jsonPath("$.[*].mDPGGK").value(hasItem(sameInstant(DEFAULT_M_DPGGK))))
            .andExpect(jsonPath("$.[*].dgbhxwtLLL").value(hasItem(sameInstant(DEFAULT_DGBHXWT_LLL))))
            .andExpect(jsonPath("$.[*].bqguzoagvFCZV").value(hasItem(DEFAULT_BQGUZOAGV_FCZV.intValue())))
            .andExpect(jsonPath("$.[*].jqwompJVQH").value(hasItem(DEFAULT_JQWOMP_JVQH.toString())))
            .andExpect(jsonPath("$.[*].kIMVKQBL").value(hasItem(DEFAULT_K_IMVKQBL.toString())))
            .andExpect(jsonPath("$.[*].uteAXHLSH").value(hasItem(DEFAULT_UTE_AXHLSH.intValue())))
            .andExpect(jsonPath("$.[*].nntcpjSMOPWFJY").value(hasItem(DEFAULT_NNTCPJ_SMOPWFJY.toString())))
            .andExpect(jsonPath("$.[*].vfxsoygABWPMSUQU").value(hasItem(DEFAULT_VFXSOYG_ABWPMSUQU.toString())))
            .andExpect(jsonPath("$.[*].fbdigDZKP").value(hasItem(sameInstant(DEFAULT_FBDIG_DZKP))))
            .andExpect(jsonPath("$.[*].vigcCOZMN").value(hasItem(DEFAULT_VIGC_COZMN.doubleValue())));
    }
    
    @Test
    @Transactional
    public void getSycdotfbx() throws Exception {
        // Initialize the database
        sycdotfbxRepository.saveAndFlush(sycdotfbx);

        // Get the sycdotfbx
        restSycdotfbxMockMvc.perform(get("/api/sycdotfbxes/{id}", sycdotfbx.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(sycdotfbx.getId().intValue()))
            .andExpect(jsonPath("$.uoerqrWHAVSPOY").value(DEFAULT_UOERQR_WHAVSPOY.toString()))
            .andExpect(jsonPath("$.vtoeablliMPK").value(DEFAULT_VTOEABLLI_MPK))
            .andExpect(jsonPath("$.gvAUAOKYBWN").value(DEFAULT_GV_AUAOKYBWN.toString()))
            .andExpect(jsonPath("$.ylooxrwCAVWCFSFJ").value(DEFAULT_YLOOXRW_CAVWCFSFJ.toString()))
            .andExpect(jsonPath("$.bebohaanSNOHCG").value(DEFAULT_BEBOHAAN_SNOHCG.toString()))
            .andExpect(jsonPath("$.phnagMUIFEGY").value(DEFAULT_PHNAG_MUIFEGY.toString()))
            .andExpect(jsonPath("$.mndiozSZG").value(DEFAULT_MNDIOZ_SZG.booleanValue()))
            .andExpect(jsonPath("$.srTDOBHW").value(sameInstant(DEFAULT_SR_TDOBHW)))
            .andExpect(jsonPath("$.oqhtblwuLMTRLPZMS").value(DEFAULT_OQHTBLWU_LMTRLPZMS))
            .andExpect(jsonPath("$.mDPGGK").value(sameInstant(DEFAULT_M_DPGGK)))
            .andExpect(jsonPath("$.dgbhxwtLLL").value(sameInstant(DEFAULT_DGBHXWT_LLL)))
            .andExpect(jsonPath("$.bqguzoagvFCZV").value(DEFAULT_BQGUZOAGV_FCZV.intValue()))
            .andExpect(jsonPath("$.jqwompJVQH").value(DEFAULT_JQWOMP_JVQH.toString()))
            .andExpect(jsonPath("$.kIMVKQBL").value(DEFAULT_K_IMVKQBL.toString()))
            .andExpect(jsonPath("$.uteAXHLSH").value(DEFAULT_UTE_AXHLSH.intValue()))
            .andExpect(jsonPath("$.nntcpjSMOPWFJY").value(DEFAULT_NNTCPJ_SMOPWFJY.toString()))
            .andExpect(jsonPath("$.vfxsoygABWPMSUQU").value(DEFAULT_VFXSOYG_ABWPMSUQU.toString()))
            .andExpect(jsonPath("$.fbdigDZKP").value(sameInstant(DEFAULT_FBDIG_DZKP)))
            .andExpect(jsonPath("$.vigcCOZMN").value(DEFAULT_VIGC_COZMN.doubleValue()));
    }

    @Test
    @Transactional
    public void getNonExistingSycdotfbx() throws Exception {
        // Get the sycdotfbx
        restSycdotfbxMockMvc.perform(get("/api/sycdotfbxes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSycdotfbx() throws Exception {
        // Initialize the database
        sycdotfbxService.save(sycdotfbx);

        int databaseSizeBeforeUpdate = sycdotfbxRepository.findAll().size();

        // Update the sycdotfbx
        Sycdotfbx updatedSycdotfbx = sycdotfbxRepository.findById(sycdotfbx.getId()).get();
        // Disconnect from session so that the updates on updatedSycdotfbx are not directly saved in db
        em.detach(updatedSycdotfbx);
        updatedSycdotfbx
            .uoerqrWHAVSPOY(UPDATED_UOERQR_WHAVSPOY)
            .vtoeablliMPK(UPDATED_VTOEABLLI_MPK)
            .gvAUAOKYBWN(UPDATED_GV_AUAOKYBWN)
            .ylooxrwCAVWCFSFJ(UPDATED_YLOOXRW_CAVWCFSFJ)
            .bebohaanSNOHCG(UPDATED_BEBOHAAN_SNOHCG)
            .phnagMUIFEGY(UPDATED_PHNAG_MUIFEGY)
            .mndiozSZG(UPDATED_MNDIOZ_SZG)
            .srTDOBHW(UPDATED_SR_TDOBHW)
            .oqhtblwuLMTRLPZMS(UPDATED_OQHTBLWU_LMTRLPZMS)
            .mDPGGK(UPDATED_M_DPGGK)
            .dgbhxwtLLL(UPDATED_DGBHXWT_LLL)
            .bqguzoagvFCZV(UPDATED_BQGUZOAGV_FCZV)
            .jqwompJVQH(UPDATED_JQWOMP_JVQH)
            .kIMVKQBL(UPDATED_K_IMVKQBL)
            .uteAXHLSH(UPDATED_UTE_AXHLSH)
            .nntcpjSMOPWFJY(UPDATED_NNTCPJ_SMOPWFJY)
            .vfxsoygABWPMSUQU(UPDATED_VFXSOYG_ABWPMSUQU)
            .fbdigDZKP(UPDATED_FBDIG_DZKP)
            .vigcCOZMN(UPDATED_VIGC_COZMN);

        restSycdotfbxMockMvc.perform(put("/api/sycdotfbxes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedSycdotfbx)))
            .andExpect(status().isOk());

        // Validate the Sycdotfbx in the database
        List<Sycdotfbx> sycdotfbxList = sycdotfbxRepository.findAll();
        assertThat(sycdotfbxList).hasSize(databaseSizeBeforeUpdate);
        Sycdotfbx testSycdotfbx = sycdotfbxList.get(sycdotfbxList.size() - 1);
        assertThat(testSycdotfbx.getUoerqrWHAVSPOY()).isEqualTo(UPDATED_UOERQR_WHAVSPOY);
        assertThat(testSycdotfbx.getVtoeablliMPK()).isEqualTo(UPDATED_VTOEABLLI_MPK);
        assertThat(testSycdotfbx.getGvAUAOKYBWN()).isEqualTo(UPDATED_GV_AUAOKYBWN);
        assertThat(testSycdotfbx.getYlooxrwCAVWCFSFJ()).isEqualTo(UPDATED_YLOOXRW_CAVWCFSFJ);
        assertThat(testSycdotfbx.getBebohaanSNOHCG()).isEqualTo(UPDATED_BEBOHAAN_SNOHCG);
        assertThat(testSycdotfbx.getPhnagMUIFEGY()).isEqualTo(UPDATED_PHNAG_MUIFEGY);
        assertThat(testSycdotfbx.isMndiozSZG()).isEqualTo(UPDATED_MNDIOZ_SZG);
        assertThat(testSycdotfbx.getSrTDOBHW()).isEqualTo(UPDATED_SR_TDOBHW);
        assertThat(testSycdotfbx.getOqhtblwuLMTRLPZMS()).isEqualTo(UPDATED_OQHTBLWU_LMTRLPZMS);
        assertThat(testSycdotfbx.getmDPGGK()).isEqualTo(UPDATED_M_DPGGK);
        assertThat(testSycdotfbx.getDgbhxwtLLL()).isEqualTo(UPDATED_DGBHXWT_LLL);
        assertThat(testSycdotfbx.getBqguzoagvFCZV()).isEqualTo(UPDATED_BQGUZOAGV_FCZV);
        assertThat(testSycdotfbx.getJqwompJVQH()).isEqualTo(UPDATED_JQWOMP_JVQH);
        assertThat(testSycdotfbx.getkIMVKQBL()).isEqualTo(UPDATED_K_IMVKQBL);
        assertThat(testSycdotfbx.getUteAXHLSH()).isEqualTo(UPDATED_UTE_AXHLSH);
        assertThat(testSycdotfbx.getNntcpjSMOPWFJY()).isEqualTo(UPDATED_NNTCPJ_SMOPWFJY);
        assertThat(testSycdotfbx.getVfxsoygABWPMSUQU()).isEqualTo(UPDATED_VFXSOYG_ABWPMSUQU);
        assertThat(testSycdotfbx.getFbdigDZKP()).isEqualTo(UPDATED_FBDIG_DZKP);
        assertThat(testSycdotfbx.getVigcCOZMN()).isEqualTo(UPDATED_VIGC_COZMN);
    }

    @Test
    @Transactional
    public void updateNonExistingSycdotfbx() throws Exception {
        int databaseSizeBeforeUpdate = sycdotfbxRepository.findAll().size();

        // Create the Sycdotfbx

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSycdotfbxMockMvc.perform(put("/api/sycdotfbxes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(sycdotfbx)))
            .andExpect(status().isBadRequest());

        // Validate the Sycdotfbx in the database
        List<Sycdotfbx> sycdotfbxList = sycdotfbxRepository.findAll();
        assertThat(sycdotfbxList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSycdotfbx() throws Exception {
        // Initialize the database
        sycdotfbxService.save(sycdotfbx);

        int databaseSizeBeforeDelete = sycdotfbxRepository.findAll().size();

        // Delete the sycdotfbx
        restSycdotfbxMockMvc.perform(delete("/api/sycdotfbxes/{id}", sycdotfbx.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Sycdotfbx> sycdotfbxList = sycdotfbxRepository.findAll();
        assertThat(sycdotfbxList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Sycdotfbx.class);
        Sycdotfbx sycdotfbx1 = new Sycdotfbx();
        sycdotfbx1.setId(1L);
        Sycdotfbx sycdotfbx2 = new Sycdotfbx();
        sycdotfbx2.setId(sycdotfbx1.getId());
        assertThat(sycdotfbx1).isEqualTo(sycdotfbx2);
        sycdotfbx2.setId(2L);
        assertThat(sycdotfbx1).isNotEqualTo(sycdotfbx2);
        sycdotfbx1.setId(null);
        assertThat(sycdotfbx1).isNotEqualTo(sycdotfbx2);
    }
}
