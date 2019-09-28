package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.ZjqabApp;
import grlmkb.wjw.vowri.bfkk.domain.Cwgkt;
import grlmkb.wjw.vowri.bfkk.repository.CwgktRepository;
import grlmkb.wjw.vowri.bfkk.service.CwgktService;
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
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static grlmkb.wjw.vowri.bfkk.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link CwgktResource} REST controller.
 */
@SpringBootTest(classes = ZjqabApp.class)
public class CwgktResourceIT {

    private static final Integer DEFAULT_DATQYRD_SSUVSL = 1;
    private static final Integer UPDATED_DATQYRD_SSUVSL = 2;
    private static final Integer SMALLER_DATQYRD_SSUVSL = 1 - 1;

    private static final BigDecimal DEFAULT_XIUOES_WMTO = new BigDecimal(1);
    private static final BigDecimal UPDATED_XIUOES_WMTO = new BigDecimal(2);
    private static final BigDecimal SMALLER_XIUOES_WMTO = new BigDecimal(1 - 1);

    private static final Instant DEFAULT_WJMKG_OKZEHAMR = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_WJMKG_OKZEHAMR = Instant.now().truncatedTo(ChronoUnit.MILLIS);
    private static final Instant SMALLER_WJMKG_OKZEHAMR = Instant.ofEpochMilli(-1L);

    private static final BigDecimal DEFAULT_IWPPB_N = new BigDecimal(1);
    private static final BigDecimal UPDATED_IWPPB_N = new BigDecimal(2);
    private static final BigDecimal SMALLER_IWPPB_N = new BigDecimal(1 - 1);

    private static final LocalDate DEFAULT_UWZ_PKAL = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_UWZ_PKAL = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_UWZ_PKAL = LocalDate.ofEpochDay(-1L);

    private static final Boolean DEFAULT_GJD_Z = false;
    private static final Boolean UPDATED_GJD_Z = true;

    private static final Integer DEFAULT_KN_YEODEX = 1;
    private static final Integer UPDATED_KN_YEODEX = 2;
    private static final Integer SMALLER_KN_YEODEX = 1 - 1;

    private static final Instant DEFAULT_HECWX_JSYQPCP = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_HECWX_JSYQPCP = Instant.now().truncatedTo(ChronoUnit.MILLIS);
    private static final Instant SMALLER_HECWX_JSYQPCP = Instant.ofEpochMilli(-1L);

    private static final String DEFAULT_QIESCTRUZ_NQSQQFKXR = "AAAAAAAAAA";
    private static final String UPDATED_QIESCTRUZ_NQSQQFKXR = "BBBBBBBBBB";

    private static final Integer DEFAULT_ECST_KPPENUEL = 1;
    private static final Integer UPDATED_ECST_KPPENUEL = 2;
    private static final Integer SMALLER_ECST_KPPENUEL = 1 - 1;

    private static final String DEFAULT_RYGWC_TQG = "AAAAAAAAAA";
    private static final String UPDATED_RYGWC_TQG = "BBBBBBBBBB";

    private static final Boolean DEFAULT_ZUSR_W = false;
    private static final Boolean UPDATED_ZUSR_W = true;

    private static final Integer DEFAULT_XMID_VONEL = 1;
    private static final Integer UPDATED_XMID_VONEL = 2;
    private static final Integer SMALLER_XMID_VONEL = 1 - 1;

    private static final Long DEFAULT_MSOLWY_OWV = 1L;
    private static final Long UPDATED_MSOLWY_OWV = 2L;
    private static final Long SMALLER_MSOLWY_OWV = 1L - 1L;

    private static final Float DEFAULT_OYEPO_AOIUC = 1F;
    private static final Float UPDATED_OYEPO_AOIUC = 2F;
    private static final Float SMALLER_OYEPO_AOIUC = 1F - 1F;

    private static final Instant DEFAULT_WHMHGTJCF_GVTDZE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_WHMHGTJCF_GVTDZE = Instant.now().truncatedTo(ChronoUnit.MILLIS);
    private static final Instant SMALLER_WHMHGTJCF_GVTDZE = Instant.ofEpochMilli(-1L);

    private static final BigDecimal DEFAULT_IMMAK_FG = new BigDecimal(1);
    private static final BigDecimal UPDATED_IMMAK_FG = new BigDecimal(2);
    private static final BigDecimal SMALLER_IMMAK_FG = new BigDecimal(1 - 1);

    private static final Float DEFAULT_JBAGF_JNAN = 1F;
    private static final Float UPDATED_JBAGF_JNAN = 2F;
    private static final Float SMALLER_JBAGF_JNAN = 1F - 1F;

    @Autowired
    private CwgktRepository cwgktRepository;

    @Autowired
    private CwgktService cwgktService;

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

    private MockMvc restCwgktMockMvc;

    private Cwgkt cwgkt;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CwgktResource cwgktResource = new CwgktResource(cwgktService);
        this.restCwgktMockMvc = MockMvcBuilders.standaloneSetup(cwgktResource)
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
    public static Cwgkt createEntity(EntityManager em) {
        Cwgkt cwgkt = new Cwgkt();
        cwgkt.setDatqyrdSSUVSL(DEFAULT_DATQYRD_SSUVSL);
        cwgkt.setXiuoesWMTO(DEFAULT_XIUOES_WMTO);
        cwgkt.setWjmkgOKZEHAMR(DEFAULT_WJMKG_OKZEHAMR);
        cwgkt.setIwppbN(DEFAULT_IWPPB_N);
        cwgkt.setUwzPKAL(DEFAULT_UWZ_PKAL);
        cwgkt.setGjdZ(DEFAULT_GJD_Z);
        cwgkt.setKnYEODEX(DEFAULT_KN_YEODEX);
        cwgkt.setHecwxJSYQPCP(DEFAULT_HECWX_JSYQPCP);
        cwgkt.setQiesctruzNQSQQFKXR(DEFAULT_QIESCTRUZ_NQSQQFKXR);
        cwgkt.setEcstKPPENUEL(DEFAULT_ECST_KPPENUEL);
        cwgkt.setRygwcTQG(DEFAULT_RYGWC_TQG);
        cwgkt.setZusrW(DEFAULT_ZUSR_W);
        cwgkt.setXmidVONEL(DEFAULT_XMID_VONEL);
        cwgkt.setMsolwyOWV(DEFAULT_MSOLWY_OWV);
        cwgkt.setOyepoAOIUC(DEFAULT_OYEPO_AOIUC);
        cwgkt.setWhmhgtjcfGVTDZE(DEFAULT_WHMHGTJCF_GVTDZE);
        cwgkt.setImmakFG(DEFAULT_IMMAK_FG);
        cwgkt.setJbagfJNAN(DEFAULT_JBAGF_JNAN);
        return cwgkt;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Cwgkt createUpdatedEntity(EntityManager em) {
        Cwgkt cwgkt = new Cwgkt();
        cwgkt.setDatqyrdSSUVSL(UPDATED_DATQYRD_SSUVSL);
        cwgkt.setXiuoesWMTO(UPDATED_XIUOES_WMTO);
        cwgkt.setWjmkgOKZEHAMR(UPDATED_WJMKG_OKZEHAMR);
        cwgkt.setIwppbN(UPDATED_IWPPB_N);
        cwgkt.setUwzPKAL(UPDATED_UWZ_PKAL);
        cwgkt.setGjdZ(UPDATED_GJD_Z);
        cwgkt.setKnYEODEX(UPDATED_KN_YEODEX);
        cwgkt.setHecwxJSYQPCP(UPDATED_HECWX_JSYQPCP);
        cwgkt.setQiesctruzNQSQQFKXR(UPDATED_QIESCTRUZ_NQSQQFKXR);
        cwgkt.setEcstKPPENUEL(UPDATED_ECST_KPPENUEL);
        cwgkt.setRygwcTQG(UPDATED_RYGWC_TQG);
        cwgkt.setZusrW(UPDATED_ZUSR_W);
        cwgkt.setXmidVONEL(UPDATED_XMID_VONEL);
        cwgkt.setMsolwyOWV(UPDATED_MSOLWY_OWV);
        cwgkt.setOyepoAOIUC(UPDATED_OYEPO_AOIUC);
        cwgkt.setWhmhgtjcfGVTDZE(UPDATED_WHMHGTJCF_GVTDZE);
        cwgkt.setImmakFG(UPDATED_IMMAK_FG);
        cwgkt.setJbagfJNAN(UPDATED_JBAGF_JNAN);
        return cwgkt;
    }

    @BeforeEach
    public void initTest() {
        cwgkt = createEntity(em);
    }

    @Test
    @Transactional
    public void createCwgkt() throws Exception {
        int databaseSizeBeforeCreate = cwgktRepository.findAll().size();

        // Create the Cwgkt
        restCwgktMockMvc.perform(post("/api/cwgkts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cwgkt)))
            .andExpect(status().isCreated());

        // Validate the Cwgkt in the database
        List<Cwgkt> cwgktList = cwgktRepository.findAll();
        assertThat(cwgktList).hasSize(databaseSizeBeforeCreate + 1);
        Cwgkt testCwgkt = cwgktList.get(cwgktList.size() - 1);
        assertThat(testCwgkt.getDatqyrdSSUVSL()).isEqualTo(DEFAULT_DATQYRD_SSUVSL);
        assertThat(testCwgkt.getXiuoesWMTO()).isEqualTo(DEFAULT_XIUOES_WMTO);
        assertThat(testCwgkt.getWjmkgOKZEHAMR()).isEqualTo(DEFAULT_WJMKG_OKZEHAMR);
        assertThat(testCwgkt.getIwppbN()).isEqualTo(DEFAULT_IWPPB_N);
        assertThat(testCwgkt.getUwzPKAL()).isEqualTo(DEFAULT_UWZ_PKAL);
        assertThat(testCwgkt.isGjdZ()).isEqualTo(DEFAULT_GJD_Z);
        assertThat(testCwgkt.getKnYEODEX()).isEqualTo(DEFAULT_KN_YEODEX);
        assertThat(testCwgkt.getHecwxJSYQPCP()).isEqualTo(DEFAULT_HECWX_JSYQPCP);
        assertThat(testCwgkt.getQiesctruzNQSQQFKXR()).isEqualTo(DEFAULT_QIESCTRUZ_NQSQQFKXR);
        assertThat(testCwgkt.getEcstKPPENUEL()).isEqualTo(DEFAULT_ECST_KPPENUEL);
        assertThat(testCwgkt.getRygwcTQG()).isEqualTo(DEFAULT_RYGWC_TQG);
        assertThat(testCwgkt.isZusrW()).isEqualTo(DEFAULT_ZUSR_W);
        assertThat(testCwgkt.getXmidVONEL()).isEqualTo(DEFAULT_XMID_VONEL);
        assertThat(testCwgkt.getMsolwyOWV()).isEqualTo(DEFAULT_MSOLWY_OWV);
        assertThat(testCwgkt.getOyepoAOIUC()).isEqualTo(DEFAULT_OYEPO_AOIUC);
        assertThat(testCwgkt.getWhmhgtjcfGVTDZE()).isEqualTo(DEFAULT_WHMHGTJCF_GVTDZE);
        assertThat(testCwgkt.getImmakFG()).isEqualTo(DEFAULT_IMMAK_FG);
        assertThat(testCwgkt.getJbagfJNAN()).isEqualTo(DEFAULT_JBAGF_JNAN);
    }

    @Test
    @Transactional
    public void createCwgktWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = cwgktRepository.findAll().size();

        // Create the Cwgkt with an existing ID
        cwgkt.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCwgktMockMvc.perform(post("/api/cwgkts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cwgkt)))
            .andExpect(status().isBadRequest());

        // Validate the Cwgkt in the database
        List<Cwgkt> cwgktList = cwgktRepository.findAll();
        assertThat(cwgktList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllCwgkts() throws Exception {
        // Initialize the database
        cwgktRepository.saveAndFlush(cwgkt);

        // Get all the cwgktList
        restCwgktMockMvc.perform(get("/api/cwgkts?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cwgkt.getId().intValue())))
            .andExpect(jsonPath("$.[*].datqyrdSSUVSL").value(hasItem(DEFAULT_DATQYRD_SSUVSL)))
            .andExpect(jsonPath("$.[*].xiuoesWMTO").value(hasItem(DEFAULT_XIUOES_WMTO.intValue())))
            .andExpect(jsonPath("$.[*].wjmkgOKZEHAMR").value(hasItem(DEFAULT_WJMKG_OKZEHAMR.toString())))
            .andExpect(jsonPath("$.[*].iwppbN").value(hasItem(DEFAULT_IWPPB_N.intValue())))
            .andExpect(jsonPath("$.[*].uwzPKAL").value(hasItem(DEFAULT_UWZ_PKAL.toString())))
            .andExpect(jsonPath("$.[*].gjdZ").value(hasItem(DEFAULT_GJD_Z.booleanValue())))
            .andExpect(jsonPath("$.[*].knYEODEX").value(hasItem(DEFAULT_KN_YEODEX)))
            .andExpect(jsonPath("$.[*].hecwxJSYQPCP").value(hasItem(DEFAULT_HECWX_JSYQPCP.toString())))
            .andExpect(jsonPath("$.[*].qiesctruzNQSQQFKXR").value(hasItem(DEFAULT_QIESCTRUZ_NQSQQFKXR.toString())))
            .andExpect(jsonPath("$.[*].ecstKPPENUEL").value(hasItem(DEFAULT_ECST_KPPENUEL)))
            .andExpect(jsonPath("$.[*].rygwcTQG").value(hasItem(DEFAULT_RYGWC_TQG.toString())))
            .andExpect(jsonPath("$.[*].zusrW").value(hasItem(DEFAULT_ZUSR_W.booleanValue())))
            .andExpect(jsonPath("$.[*].xmidVONEL").value(hasItem(DEFAULT_XMID_VONEL)))
            .andExpect(jsonPath("$.[*].msolwyOWV").value(hasItem(DEFAULT_MSOLWY_OWV.intValue())))
            .andExpect(jsonPath("$.[*].oyepoAOIUC").value(hasItem(DEFAULT_OYEPO_AOIUC.doubleValue())))
            .andExpect(jsonPath("$.[*].whmhgtjcfGVTDZE").value(hasItem(DEFAULT_WHMHGTJCF_GVTDZE.toString())))
            .andExpect(jsonPath("$.[*].immakFG").value(hasItem(DEFAULT_IMMAK_FG.intValue())))
            .andExpect(jsonPath("$.[*].jbagfJNAN").value(hasItem(DEFAULT_JBAGF_JNAN.doubleValue())));
    }
    
    @Test
    @Transactional
    public void getCwgkt() throws Exception {
        // Initialize the database
        cwgktRepository.saveAndFlush(cwgkt);

        // Get the cwgkt
        restCwgktMockMvc.perform(get("/api/cwgkts/{id}", cwgkt.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(cwgkt.getId().intValue()))
            .andExpect(jsonPath("$.datqyrdSSUVSL").value(DEFAULT_DATQYRD_SSUVSL))
            .andExpect(jsonPath("$.xiuoesWMTO").value(DEFAULT_XIUOES_WMTO.intValue()))
            .andExpect(jsonPath("$.wjmkgOKZEHAMR").value(DEFAULT_WJMKG_OKZEHAMR.toString()))
            .andExpect(jsonPath("$.iwppbN").value(DEFAULT_IWPPB_N.intValue()))
            .andExpect(jsonPath("$.uwzPKAL").value(DEFAULT_UWZ_PKAL.toString()))
            .andExpect(jsonPath("$.gjdZ").value(DEFAULT_GJD_Z.booleanValue()))
            .andExpect(jsonPath("$.knYEODEX").value(DEFAULT_KN_YEODEX))
            .andExpect(jsonPath("$.hecwxJSYQPCP").value(DEFAULT_HECWX_JSYQPCP.toString()))
            .andExpect(jsonPath("$.qiesctruzNQSQQFKXR").value(DEFAULT_QIESCTRUZ_NQSQQFKXR.toString()))
            .andExpect(jsonPath("$.ecstKPPENUEL").value(DEFAULT_ECST_KPPENUEL))
            .andExpect(jsonPath("$.rygwcTQG").value(DEFAULT_RYGWC_TQG.toString()))
            .andExpect(jsonPath("$.zusrW").value(DEFAULT_ZUSR_W.booleanValue()))
            .andExpect(jsonPath("$.xmidVONEL").value(DEFAULT_XMID_VONEL))
            .andExpect(jsonPath("$.msolwyOWV").value(DEFAULT_MSOLWY_OWV.intValue()))
            .andExpect(jsonPath("$.oyepoAOIUC").value(DEFAULT_OYEPO_AOIUC.doubleValue()))
            .andExpect(jsonPath("$.whmhgtjcfGVTDZE").value(DEFAULT_WHMHGTJCF_GVTDZE.toString()))
            .andExpect(jsonPath("$.immakFG").value(DEFAULT_IMMAK_FG.intValue()))
            .andExpect(jsonPath("$.jbagfJNAN").value(DEFAULT_JBAGF_JNAN.doubleValue()));
    }

    @Test
    @Transactional
    public void getNonExistingCwgkt() throws Exception {
        // Get the cwgkt
        restCwgktMockMvc.perform(get("/api/cwgkts/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCwgkt() throws Exception {
        // Initialize the database
        cwgktService.save(cwgkt);

        int databaseSizeBeforeUpdate = cwgktRepository.findAll().size();

        // Update the cwgkt
        Cwgkt updatedCwgkt = cwgktRepository.findById(cwgkt.getId()).get();
        // Disconnect from session so that the updates on updatedCwgkt are not directly saved in db
        em.detach(updatedCwgkt);
        updatedCwgkt.setDatqyrdSSUVSL(UPDATED_DATQYRD_SSUVSL);
        updatedCwgkt.setXiuoesWMTO(UPDATED_XIUOES_WMTO);
        updatedCwgkt.setWjmkgOKZEHAMR(UPDATED_WJMKG_OKZEHAMR);
        updatedCwgkt.setIwppbN(UPDATED_IWPPB_N);
        updatedCwgkt.setUwzPKAL(UPDATED_UWZ_PKAL);
        updatedCwgkt.setGjdZ(UPDATED_GJD_Z);
        updatedCwgkt.setKnYEODEX(UPDATED_KN_YEODEX);
        updatedCwgkt.setHecwxJSYQPCP(UPDATED_HECWX_JSYQPCP);
        updatedCwgkt.setQiesctruzNQSQQFKXR(UPDATED_QIESCTRUZ_NQSQQFKXR);
        updatedCwgkt.setEcstKPPENUEL(UPDATED_ECST_KPPENUEL);
        updatedCwgkt.setRygwcTQG(UPDATED_RYGWC_TQG);
        updatedCwgkt.setZusrW(UPDATED_ZUSR_W);
        updatedCwgkt.setXmidVONEL(UPDATED_XMID_VONEL);
        updatedCwgkt.setMsolwyOWV(UPDATED_MSOLWY_OWV);
        updatedCwgkt.setOyepoAOIUC(UPDATED_OYEPO_AOIUC);
        updatedCwgkt.setWhmhgtjcfGVTDZE(UPDATED_WHMHGTJCF_GVTDZE);
        updatedCwgkt.setImmakFG(UPDATED_IMMAK_FG);
        updatedCwgkt.setJbagfJNAN(UPDATED_JBAGF_JNAN);

        restCwgktMockMvc.perform(put("/api/cwgkts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedCwgkt)))
            .andExpect(status().isOk());

        // Validate the Cwgkt in the database
        List<Cwgkt> cwgktList = cwgktRepository.findAll();
        assertThat(cwgktList).hasSize(databaseSizeBeforeUpdate);
        Cwgkt testCwgkt = cwgktList.get(cwgktList.size() - 1);
        assertThat(testCwgkt.getDatqyrdSSUVSL()).isEqualTo(UPDATED_DATQYRD_SSUVSL);
        assertThat(testCwgkt.getXiuoesWMTO()).isEqualTo(UPDATED_XIUOES_WMTO);
        assertThat(testCwgkt.getWjmkgOKZEHAMR()).isEqualTo(UPDATED_WJMKG_OKZEHAMR);
        assertThat(testCwgkt.getIwppbN()).isEqualTo(UPDATED_IWPPB_N);
        assertThat(testCwgkt.getUwzPKAL()).isEqualTo(UPDATED_UWZ_PKAL);
        assertThat(testCwgkt.isGjdZ()).isEqualTo(UPDATED_GJD_Z);
        assertThat(testCwgkt.getKnYEODEX()).isEqualTo(UPDATED_KN_YEODEX);
        assertThat(testCwgkt.getHecwxJSYQPCP()).isEqualTo(UPDATED_HECWX_JSYQPCP);
        assertThat(testCwgkt.getQiesctruzNQSQQFKXR()).isEqualTo(UPDATED_QIESCTRUZ_NQSQQFKXR);
        assertThat(testCwgkt.getEcstKPPENUEL()).isEqualTo(UPDATED_ECST_KPPENUEL);
        assertThat(testCwgkt.getRygwcTQG()).isEqualTo(UPDATED_RYGWC_TQG);
        assertThat(testCwgkt.isZusrW()).isEqualTo(UPDATED_ZUSR_W);
        assertThat(testCwgkt.getXmidVONEL()).isEqualTo(UPDATED_XMID_VONEL);
        assertThat(testCwgkt.getMsolwyOWV()).isEqualTo(UPDATED_MSOLWY_OWV);
        assertThat(testCwgkt.getOyepoAOIUC()).isEqualTo(UPDATED_OYEPO_AOIUC);
        assertThat(testCwgkt.getWhmhgtjcfGVTDZE()).isEqualTo(UPDATED_WHMHGTJCF_GVTDZE);
        assertThat(testCwgkt.getImmakFG()).isEqualTo(UPDATED_IMMAK_FG);
        assertThat(testCwgkt.getJbagfJNAN()).isEqualTo(UPDATED_JBAGF_JNAN);
    }

    @Test
    @Transactional
    public void updateNonExistingCwgkt() throws Exception {
        int databaseSizeBeforeUpdate = cwgktRepository.findAll().size();

        // Create the Cwgkt

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCwgktMockMvc.perform(put("/api/cwgkts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cwgkt)))
            .andExpect(status().isBadRequest());

        // Validate the Cwgkt in the database
        List<Cwgkt> cwgktList = cwgktRepository.findAll();
        assertThat(cwgktList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCwgkt() throws Exception {
        // Initialize the database
        cwgktService.save(cwgkt);

        int databaseSizeBeforeDelete = cwgktRepository.findAll().size();

        // Delete the cwgkt
        restCwgktMockMvc.perform(delete("/api/cwgkts/{id}", cwgkt.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Cwgkt> cwgktList = cwgktRepository.findAll();
        assertThat(cwgktList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Cwgkt.class);
        Cwgkt cwgkt1 = new Cwgkt();
        cwgkt1.setId(1L);
        Cwgkt cwgkt2 = new Cwgkt();
        cwgkt2.setId(cwgkt1.getId());
        assertThat(cwgkt1).isEqualTo(cwgkt2);
        cwgkt2.setId(2L);
        assertThat(cwgkt1).isNotEqualTo(cwgkt2);
        cwgkt1.setId(null);
        assertThat(cwgkt1).isNotEqualTo(cwgkt2);
    }
}
