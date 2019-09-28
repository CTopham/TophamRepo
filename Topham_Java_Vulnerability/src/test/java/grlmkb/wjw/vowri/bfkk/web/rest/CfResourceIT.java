package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.ZjqabApp;
import grlmkb.wjw.vowri.bfkk.domain.Cf;
import grlmkb.wjw.vowri.bfkk.repository.CfRepository;
import grlmkb.wjw.vowri.bfkk.service.CfService;
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
 * Integration tests for the {@link CfResource} REST controller.
 */
@SpringBootTest(classes = ZjqabApp.class)
public class CfResourceIT {

    private static final Float DEFAULT_DSZIPJ_LILHDGEB = 1F;
    private static final Float UPDATED_DSZIPJ_LILHDGEB = 2F;
    private static final Float SMALLER_DSZIPJ_LILHDGEB = 1F - 1F;

    private static final Integer DEFAULT_KX_HFGGG = 1;
    private static final Integer UPDATED_KX_HFGGG = 2;
    private static final Integer SMALLER_KX_HFGGG = 1 - 1;

    private static final String DEFAULT_QJQ_NJ = "AAAAAAAAAA";
    private static final String UPDATED_QJQ_NJ = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_UYCDKNGJY_EX = new BigDecimal(1);
    private static final BigDecimal UPDATED_UYCDKNGJY_EX = new BigDecimal(2);
    private static final BigDecimal SMALLER_UYCDKNGJY_EX = new BigDecimal(1 - 1);

    private static final Long DEFAULT_LTTZRSUKK_ITST = 1L;
    private static final Long UPDATED_LTTZRSUKK_ITST = 2L;
    private static final Long SMALLER_LTTZRSUKK_ITST = 1L - 1L;

    private static final Float DEFAULT_CWF_YZVEIJKE = 1F;
    private static final Float UPDATED_CWF_YZVEIJKE = 2F;
    private static final Float SMALLER_CWF_YZVEIJKE = 1F - 1F;

    private static final ZonedDateTime DEFAULT_YWUHPRY_GC = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_YWUHPRY_GC = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_YWUHPRY_GC = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    private static final Instant DEFAULT_EUHUYAR_MVMESJ = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_EUHUYAR_MVMESJ = Instant.now().truncatedTo(ChronoUnit.MILLIS);
    private static final Instant SMALLER_EUHUYAR_MVMESJ = Instant.ofEpochMilli(-1L);

    private static final BigDecimal DEFAULT_ZWB_RBGEWZQDH = new BigDecimal(1);
    private static final BigDecimal UPDATED_ZWB_RBGEWZQDH = new BigDecimal(2);
    private static final BigDecimal SMALLER_ZWB_RBGEWZQDH = new BigDecimal(1 - 1);

    private static final LocalDate DEFAULT_YJFMRSUUG_HRWGXNH = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_YJFMRSUUG_HRWGXNH = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_YJFMRSUUG_HRWGXNH = LocalDate.ofEpochDay(-1L);

    private static final LocalDate DEFAULT_CY_LONPOURB = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_CY_LONPOURB = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_CY_LONPOURB = LocalDate.ofEpochDay(-1L);

    private static final Integer DEFAULT_TAFPHC_QPQLPZB = 1;
    private static final Integer UPDATED_TAFPHC_QPQLPZB = 2;
    private static final Integer SMALLER_TAFPHC_QPQLPZB = 1 - 1;

    @Autowired
    private CfRepository cfRepository;

    @Autowired
    private CfService cfService;

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

    private MockMvc restCfMockMvc;

    private Cf cf;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final CfResource cfResource = new CfResource(cfService);
        this.restCfMockMvc = MockMvcBuilders.standaloneSetup(cfResource)
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
    public static Cf createEntity(EntityManager em) {
        Cf cf = new Cf();
        cf.setDszipjLILHDGEB(DEFAULT_DSZIPJ_LILHDGEB);
        cf.setKxHFGGG(DEFAULT_KX_HFGGG);
        cf.setQjqNJ(DEFAULT_QJQ_NJ);
        cf.setUycdkngjyEX(DEFAULT_UYCDKNGJY_EX);
        cf.setLttzrsukkITST(DEFAULT_LTTZRSUKK_ITST);
        cf.setCwfYZVEIJKE(DEFAULT_CWF_YZVEIJKE);
        cf.setYwuhpryGC(DEFAULT_YWUHPRY_GC);
        cf.setEuhuyarMVMESJ(DEFAULT_EUHUYAR_MVMESJ);
        cf.setZwbRBGEWZQDH(DEFAULT_ZWB_RBGEWZQDH);
        cf.setYjfmrsuugHRWGXNH(DEFAULT_YJFMRSUUG_HRWGXNH);
        cf.setCyLONPOURB(DEFAULT_CY_LONPOURB);
        cf.setTafphcQPQLPZB(DEFAULT_TAFPHC_QPQLPZB);
        return cf;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Cf createUpdatedEntity(EntityManager em) {
        Cf cf = new Cf();
        cf.setDszipjLILHDGEB(UPDATED_DSZIPJ_LILHDGEB);
        cf.setKxHFGGG(UPDATED_KX_HFGGG);
        cf.setQjqNJ(UPDATED_QJQ_NJ);
        cf.setUycdkngjyEX(UPDATED_UYCDKNGJY_EX);
        cf.setLttzrsukkITST(UPDATED_LTTZRSUKK_ITST);
        cf.setCwfYZVEIJKE(UPDATED_CWF_YZVEIJKE);
        cf.setYwuhpryGC(UPDATED_YWUHPRY_GC);
        cf.setEuhuyarMVMESJ(UPDATED_EUHUYAR_MVMESJ);
        cf.setZwbRBGEWZQDH(UPDATED_ZWB_RBGEWZQDH);
        cf.setYjfmrsuugHRWGXNH(UPDATED_YJFMRSUUG_HRWGXNH);
        cf.setCyLONPOURB(UPDATED_CY_LONPOURB);
        cf.setTafphcQPQLPZB(UPDATED_TAFPHC_QPQLPZB);
        return cf;
    }

    @BeforeEach
    public void initTest() {
        cf = createEntity(em);
    }

    @Test
    @Transactional
    public void createCf() throws Exception {
        int databaseSizeBeforeCreate = cfRepository.findAll().size();

        // Create the Cf
        restCfMockMvc.perform(post("/api/cfs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cf)))
            .andExpect(status().isCreated());

        // Validate the Cf in the database
        List<Cf> cfList = cfRepository.findAll();
        assertThat(cfList).hasSize(databaseSizeBeforeCreate + 1);
        Cf testCf = cfList.get(cfList.size() - 1);
        assertThat(testCf.getDszipjLILHDGEB()).isEqualTo(DEFAULT_DSZIPJ_LILHDGEB);
        assertThat(testCf.getKxHFGGG()).isEqualTo(DEFAULT_KX_HFGGG);
        assertThat(testCf.getQjqNJ()).isEqualTo(DEFAULT_QJQ_NJ);
        assertThat(testCf.getUycdkngjyEX()).isEqualTo(DEFAULT_UYCDKNGJY_EX);
        assertThat(testCf.getLttzrsukkITST()).isEqualTo(DEFAULT_LTTZRSUKK_ITST);
        assertThat(testCf.getCwfYZVEIJKE()).isEqualTo(DEFAULT_CWF_YZVEIJKE);
        assertThat(testCf.getYwuhpryGC()).isEqualTo(DEFAULT_YWUHPRY_GC);
        assertThat(testCf.getEuhuyarMVMESJ()).isEqualTo(DEFAULT_EUHUYAR_MVMESJ);
        assertThat(testCf.getZwbRBGEWZQDH()).isEqualTo(DEFAULT_ZWB_RBGEWZQDH);
        assertThat(testCf.getYjfmrsuugHRWGXNH()).isEqualTo(DEFAULT_YJFMRSUUG_HRWGXNH);
        assertThat(testCf.getCyLONPOURB()).isEqualTo(DEFAULT_CY_LONPOURB);
        assertThat(testCf.getTafphcQPQLPZB()).isEqualTo(DEFAULT_TAFPHC_QPQLPZB);
    }

    @Test
    @Transactional
    public void createCfWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = cfRepository.findAll().size();

        // Create the Cf with an existing ID
        cf.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCfMockMvc.perform(post("/api/cfs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cf)))
            .andExpect(status().isBadRequest());

        // Validate the Cf in the database
        List<Cf> cfList = cfRepository.findAll();
        assertThat(cfList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllCfs() throws Exception {
        // Initialize the database
        cfRepository.saveAndFlush(cf);

        // Get all the cfList
        restCfMockMvc.perform(get("/api/cfs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cf.getId().intValue())))
            .andExpect(jsonPath("$.[*].dszipjLILHDGEB").value(hasItem(DEFAULT_DSZIPJ_LILHDGEB.doubleValue())))
            .andExpect(jsonPath("$.[*].kxHFGGG").value(hasItem(DEFAULT_KX_HFGGG)))
            .andExpect(jsonPath("$.[*].qjqNJ").value(hasItem(DEFAULT_QJQ_NJ.toString())))
            .andExpect(jsonPath("$.[*].uycdkngjyEX").value(hasItem(DEFAULT_UYCDKNGJY_EX.intValue())))
            .andExpect(jsonPath("$.[*].lttzrsukkITST").value(hasItem(DEFAULT_LTTZRSUKK_ITST.intValue())))
            .andExpect(jsonPath("$.[*].cwfYZVEIJKE").value(hasItem(DEFAULT_CWF_YZVEIJKE.doubleValue())))
            .andExpect(jsonPath("$.[*].ywuhpryGC").value(hasItem(sameInstant(DEFAULT_YWUHPRY_GC))))
            .andExpect(jsonPath("$.[*].euhuyarMVMESJ").value(hasItem(DEFAULT_EUHUYAR_MVMESJ.toString())))
            .andExpect(jsonPath("$.[*].zwbRBGEWZQDH").value(hasItem(DEFAULT_ZWB_RBGEWZQDH.intValue())))
            .andExpect(jsonPath("$.[*].yjfmrsuugHRWGXNH").value(hasItem(DEFAULT_YJFMRSUUG_HRWGXNH.toString())))
            .andExpect(jsonPath("$.[*].cyLONPOURB").value(hasItem(DEFAULT_CY_LONPOURB.toString())))
            .andExpect(jsonPath("$.[*].tafphcQPQLPZB").value(hasItem(DEFAULT_TAFPHC_QPQLPZB)));
    }
    
    @Test
    @Transactional
    public void getCf() throws Exception {
        // Initialize the database
        cfRepository.saveAndFlush(cf);

        // Get the cf
        restCfMockMvc.perform(get("/api/cfs/{id}", cf.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(cf.getId().intValue()))
            .andExpect(jsonPath("$.dszipjLILHDGEB").value(DEFAULT_DSZIPJ_LILHDGEB.doubleValue()))
            .andExpect(jsonPath("$.kxHFGGG").value(DEFAULT_KX_HFGGG))
            .andExpect(jsonPath("$.qjqNJ").value(DEFAULT_QJQ_NJ.toString()))
            .andExpect(jsonPath("$.uycdkngjyEX").value(DEFAULT_UYCDKNGJY_EX.intValue()))
            .andExpect(jsonPath("$.lttzrsukkITST").value(DEFAULT_LTTZRSUKK_ITST.intValue()))
            .andExpect(jsonPath("$.cwfYZVEIJKE").value(DEFAULT_CWF_YZVEIJKE.doubleValue()))
            .andExpect(jsonPath("$.ywuhpryGC").value(sameInstant(DEFAULT_YWUHPRY_GC)))
            .andExpect(jsonPath("$.euhuyarMVMESJ").value(DEFAULT_EUHUYAR_MVMESJ.toString()))
            .andExpect(jsonPath("$.zwbRBGEWZQDH").value(DEFAULT_ZWB_RBGEWZQDH.intValue()))
            .andExpect(jsonPath("$.yjfmrsuugHRWGXNH").value(DEFAULT_YJFMRSUUG_HRWGXNH.toString()))
            .andExpect(jsonPath("$.cyLONPOURB").value(DEFAULT_CY_LONPOURB.toString()))
            .andExpect(jsonPath("$.tafphcQPQLPZB").value(DEFAULT_TAFPHC_QPQLPZB));
    }

    @Test
    @Transactional
    public void getNonExistingCf() throws Exception {
        // Get the cf
        restCfMockMvc.perform(get("/api/cfs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCf() throws Exception {
        // Initialize the database
        cfService.save(cf);

        int databaseSizeBeforeUpdate = cfRepository.findAll().size();

        // Update the cf
        Cf updatedCf = cfRepository.findById(cf.getId()).get();
        // Disconnect from session so that the updates on updatedCf are not directly saved in db
        em.detach(updatedCf);
        updatedCf.setDszipjLILHDGEB(UPDATED_DSZIPJ_LILHDGEB);
        updatedCf.setKxHFGGG(UPDATED_KX_HFGGG);
        updatedCf.setQjqNJ(UPDATED_QJQ_NJ);
        updatedCf.setUycdkngjyEX(UPDATED_UYCDKNGJY_EX);
        updatedCf.setLttzrsukkITST(UPDATED_LTTZRSUKK_ITST);
        updatedCf.setCwfYZVEIJKE(UPDATED_CWF_YZVEIJKE);
        updatedCf.setYwuhpryGC(UPDATED_YWUHPRY_GC);
        updatedCf.setEuhuyarMVMESJ(UPDATED_EUHUYAR_MVMESJ);
        updatedCf.setZwbRBGEWZQDH(UPDATED_ZWB_RBGEWZQDH);
        updatedCf.setYjfmrsuugHRWGXNH(UPDATED_YJFMRSUUG_HRWGXNH);
        updatedCf.setCyLONPOURB(UPDATED_CY_LONPOURB);
        updatedCf.setTafphcQPQLPZB(UPDATED_TAFPHC_QPQLPZB);

        restCfMockMvc.perform(put("/api/cfs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedCf)))
            .andExpect(status().isOk());

        // Validate the Cf in the database
        List<Cf> cfList = cfRepository.findAll();
        assertThat(cfList).hasSize(databaseSizeBeforeUpdate);
        Cf testCf = cfList.get(cfList.size() - 1);
        assertThat(testCf.getDszipjLILHDGEB()).isEqualTo(UPDATED_DSZIPJ_LILHDGEB);
        assertThat(testCf.getKxHFGGG()).isEqualTo(UPDATED_KX_HFGGG);
        assertThat(testCf.getQjqNJ()).isEqualTo(UPDATED_QJQ_NJ);
        assertThat(testCf.getUycdkngjyEX()).isEqualTo(UPDATED_UYCDKNGJY_EX);
        assertThat(testCf.getLttzrsukkITST()).isEqualTo(UPDATED_LTTZRSUKK_ITST);
        assertThat(testCf.getCwfYZVEIJKE()).isEqualTo(UPDATED_CWF_YZVEIJKE);
        assertThat(testCf.getYwuhpryGC()).isEqualTo(UPDATED_YWUHPRY_GC);
        assertThat(testCf.getEuhuyarMVMESJ()).isEqualTo(UPDATED_EUHUYAR_MVMESJ);
        assertThat(testCf.getZwbRBGEWZQDH()).isEqualTo(UPDATED_ZWB_RBGEWZQDH);
        assertThat(testCf.getYjfmrsuugHRWGXNH()).isEqualTo(UPDATED_YJFMRSUUG_HRWGXNH);
        assertThat(testCf.getCyLONPOURB()).isEqualTo(UPDATED_CY_LONPOURB);
        assertThat(testCf.getTafphcQPQLPZB()).isEqualTo(UPDATED_TAFPHC_QPQLPZB);
    }

    @Test
    @Transactional
    public void updateNonExistingCf() throws Exception {
        int databaseSizeBeforeUpdate = cfRepository.findAll().size();

        // Create the Cf

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCfMockMvc.perform(put("/api/cfs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(cf)))
            .andExpect(status().isBadRequest());

        // Validate the Cf in the database
        List<Cf> cfList = cfRepository.findAll();
        assertThat(cfList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCf() throws Exception {
        // Initialize the database
        cfService.save(cf);

        int databaseSizeBeforeDelete = cfRepository.findAll().size();

        // Delete the cf
        restCfMockMvc.perform(delete("/api/cfs/{id}", cf.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Cf> cfList = cfRepository.findAll();
        assertThat(cfList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Cf.class);
        Cf cf1 = new Cf();
        cf1.setId(1L);
        Cf cf2 = new Cf();
        cf2.setId(cf1.getId());
        assertThat(cf1).isEqualTo(cf2);
        cf2.setId(2L);
        assertThat(cf1).isNotEqualTo(cf2);
        cf1.setId(null);
        assertThat(cf1).isNotEqualTo(cf2);
    }
}
