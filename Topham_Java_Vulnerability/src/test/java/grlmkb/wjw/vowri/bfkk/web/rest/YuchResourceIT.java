package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.ZjqabApp;
import grlmkb.wjw.vowri.bfkk.domain.Yuch;
import grlmkb.wjw.vowri.bfkk.repository.YuchRepository;
import grlmkb.wjw.vowri.bfkk.service.YuchService;
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
 * Integration tests for the {@link YuchResource} REST controller.
 */
@SpringBootTest(classes = ZjqabApp.class)
public class YuchResourceIT {

    private static final Integer DEFAULT_QPSWWV_ISLUJ = 1;
    private static final Integer UPDATED_QPSWWV_ISLUJ = 2;
    private static final Integer SMALLER_QPSWWV_ISLUJ = 1 - 1;

    private static final Instant DEFAULT_BJVDTAH_YZTHGS = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_BJVDTAH_YZTHGS = Instant.now().truncatedTo(ChronoUnit.MILLIS);
    private static final Instant SMALLER_BJVDTAH_YZTHGS = Instant.ofEpochMilli(-1L);

    private static final Long DEFAULT_X_GUNU = 1L;
    private static final Long UPDATED_X_GUNU = 2L;
    private static final Long SMALLER_X_GUNU = 1L - 1L;

    private static final String DEFAULT_E_S = "AAAAAAAAAA";
    private static final String UPDATED_E_S = "BBBBBBBBBB";

    private static final Float DEFAULT_SF_SY = 1F;
    private static final Float UPDATED_SF_SY = 2F;
    private static final Float SMALLER_SF_SY = 1F - 1F;

    private static final Long DEFAULT_KMRF_RTQTZD = 1L;
    private static final Long UPDATED_KMRF_RTQTZD = 2L;
    private static final Long SMALLER_KMRF_RTQTZD = 1L - 1L;

    private static final ZonedDateTime DEFAULT_EBD_PPFKSZN = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_EBD_PPFKSZN = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_EBD_PPFKSZN = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    @Autowired
    private YuchRepository yuchRepository;

    @Autowired
    private YuchService yuchService;

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

    private MockMvc restYuchMockMvc;

    private Yuch yuch;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final YuchResource yuchResource = new YuchResource(yuchService);
        this.restYuchMockMvc = MockMvcBuilders.standaloneSetup(yuchResource)
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
    public static Yuch createEntity(EntityManager em) {
        Yuch yuch = new Yuch();
        yuch.setQpswwvISLUJ(DEFAULT_QPSWWV_ISLUJ);
        yuch.setBjvdtahYZTHGS(DEFAULT_BJVDTAH_YZTHGS);
        yuch.setxGUNU(DEFAULT_X_GUNU);
        yuch.seteS(DEFAULT_E_S);
        yuch.setSfSY(DEFAULT_SF_SY);
        yuch.setKmrfRTQTZD(DEFAULT_KMRF_RTQTZD);
        yuch.setEbdPPFKSZN(DEFAULT_EBD_PPFKSZN);
        return yuch;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Yuch createUpdatedEntity(EntityManager em) {
        Yuch yuch = new Yuch();
        yuch.setQpswwvISLUJ(UPDATED_QPSWWV_ISLUJ);
        yuch.setBjvdtahYZTHGS(UPDATED_BJVDTAH_YZTHGS);
        yuch.setxGUNU(UPDATED_X_GUNU);
        yuch.seteS(UPDATED_E_S);
        yuch.setSfSY(UPDATED_SF_SY);
        yuch.setKmrfRTQTZD(UPDATED_KMRF_RTQTZD);
        yuch.setEbdPPFKSZN(UPDATED_EBD_PPFKSZN);
        return yuch;
    }

    @BeforeEach
    public void initTest() {
        yuch = createEntity(em);
    }

    @Test
    @Transactional
    public void createYuch() throws Exception {
        int databaseSizeBeforeCreate = yuchRepository.findAll().size();

        // Create the Yuch
        restYuchMockMvc.perform(post("/api/yuches")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(yuch)))
            .andExpect(status().isCreated());

        // Validate the Yuch in the database
        List<Yuch> yuchList = yuchRepository.findAll();
        assertThat(yuchList).hasSize(databaseSizeBeforeCreate + 1);
        Yuch testYuch = yuchList.get(yuchList.size() - 1);
        assertThat(testYuch.getQpswwvISLUJ()).isEqualTo(DEFAULT_QPSWWV_ISLUJ);
        assertThat(testYuch.getBjvdtahYZTHGS()).isEqualTo(DEFAULT_BJVDTAH_YZTHGS);
        assertThat(testYuch.getxGUNU()).isEqualTo(DEFAULT_X_GUNU);
        assertThat(testYuch.geteS()).isEqualTo(DEFAULT_E_S);
        assertThat(testYuch.getSfSY()).isEqualTo(DEFAULT_SF_SY);
        assertThat(testYuch.getKmrfRTQTZD()).isEqualTo(DEFAULT_KMRF_RTQTZD);
        assertThat(testYuch.getEbdPPFKSZN()).isEqualTo(DEFAULT_EBD_PPFKSZN);
    }

    @Test
    @Transactional
    public void createYuchWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = yuchRepository.findAll().size();

        // Create the Yuch with an existing ID
        yuch.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restYuchMockMvc.perform(post("/api/yuches")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(yuch)))
            .andExpect(status().isBadRequest());

        // Validate the Yuch in the database
        List<Yuch> yuchList = yuchRepository.findAll();
        assertThat(yuchList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllYuches() throws Exception {
        // Initialize the database
        yuchRepository.saveAndFlush(yuch);

        // Get all the yuchList
        restYuchMockMvc.perform(get("/api/yuches?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(yuch.getId().intValue())))
            .andExpect(jsonPath("$.[*].qpswwvISLUJ").value(hasItem(DEFAULT_QPSWWV_ISLUJ)))
            .andExpect(jsonPath("$.[*].bjvdtahYZTHGS").value(hasItem(DEFAULT_BJVDTAH_YZTHGS.toString())))
            .andExpect(jsonPath("$.[*].xGUNU").value(hasItem(DEFAULT_X_GUNU.intValue())))
            .andExpect(jsonPath("$.[*].eS").value(hasItem(DEFAULT_E_S.toString())))
            .andExpect(jsonPath("$.[*].sfSY").value(hasItem(DEFAULT_SF_SY.doubleValue())))
            .andExpect(jsonPath("$.[*].kmrfRTQTZD").value(hasItem(DEFAULT_KMRF_RTQTZD.intValue())))
            .andExpect(jsonPath("$.[*].ebdPPFKSZN").value(hasItem(sameInstant(DEFAULT_EBD_PPFKSZN))));
    }
    
    @Test
    @Transactional
    public void getYuch() throws Exception {
        // Initialize the database
        yuchRepository.saveAndFlush(yuch);

        // Get the yuch
        restYuchMockMvc.perform(get("/api/yuches/{id}", yuch.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(yuch.getId().intValue()))
            .andExpect(jsonPath("$.qpswwvISLUJ").value(DEFAULT_QPSWWV_ISLUJ))
            .andExpect(jsonPath("$.bjvdtahYZTHGS").value(DEFAULT_BJVDTAH_YZTHGS.toString()))
            .andExpect(jsonPath("$.xGUNU").value(DEFAULT_X_GUNU.intValue()))
            .andExpect(jsonPath("$.eS").value(DEFAULT_E_S.toString()))
            .andExpect(jsonPath("$.sfSY").value(DEFAULT_SF_SY.doubleValue()))
            .andExpect(jsonPath("$.kmrfRTQTZD").value(DEFAULT_KMRF_RTQTZD.intValue()))
            .andExpect(jsonPath("$.ebdPPFKSZN").value(sameInstant(DEFAULT_EBD_PPFKSZN)));
    }

    @Test
    @Transactional
    public void getNonExistingYuch() throws Exception {
        // Get the yuch
        restYuchMockMvc.perform(get("/api/yuches/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateYuch() throws Exception {
        // Initialize the database
        yuchService.save(yuch);

        int databaseSizeBeforeUpdate = yuchRepository.findAll().size();

        // Update the yuch
        Yuch updatedYuch = yuchRepository.findById(yuch.getId()).get();
        // Disconnect from session so that the updates on updatedYuch are not directly saved in db
        em.detach(updatedYuch);
        updatedYuch.setQpswwvISLUJ(UPDATED_QPSWWV_ISLUJ);
        updatedYuch.setBjvdtahYZTHGS(UPDATED_BJVDTAH_YZTHGS);
        updatedYuch.setxGUNU(UPDATED_X_GUNU);
        updatedYuch.seteS(UPDATED_E_S);
        updatedYuch.setSfSY(UPDATED_SF_SY);
        updatedYuch.setKmrfRTQTZD(UPDATED_KMRF_RTQTZD);
        updatedYuch.setEbdPPFKSZN(UPDATED_EBD_PPFKSZN);

        restYuchMockMvc.perform(put("/api/yuches")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedYuch)))
            .andExpect(status().isOk());

        // Validate the Yuch in the database
        List<Yuch> yuchList = yuchRepository.findAll();
        assertThat(yuchList).hasSize(databaseSizeBeforeUpdate);
        Yuch testYuch = yuchList.get(yuchList.size() - 1);
        assertThat(testYuch.getQpswwvISLUJ()).isEqualTo(UPDATED_QPSWWV_ISLUJ);
        assertThat(testYuch.getBjvdtahYZTHGS()).isEqualTo(UPDATED_BJVDTAH_YZTHGS);
        assertThat(testYuch.getxGUNU()).isEqualTo(UPDATED_X_GUNU);
        assertThat(testYuch.geteS()).isEqualTo(UPDATED_E_S);
        assertThat(testYuch.getSfSY()).isEqualTo(UPDATED_SF_SY);
        assertThat(testYuch.getKmrfRTQTZD()).isEqualTo(UPDATED_KMRF_RTQTZD);
        assertThat(testYuch.getEbdPPFKSZN()).isEqualTo(UPDATED_EBD_PPFKSZN);
    }

    @Test
    @Transactional
    public void updateNonExistingYuch() throws Exception {
        int databaseSizeBeforeUpdate = yuchRepository.findAll().size();

        // Create the Yuch

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restYuchMockMvc.perform(put("/api/yuches")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(yuch)))
            .andExpect(status().isBadRequest());

        // Validate the Yuch in the database
        List<Yuch> yuchList = yuchRepository.findAll();
        assertThat(yuchList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteYuch() throws Exception {
        // Initialize the database
        yuchService.save(yuch);

        int databaseSizeBeforeDelete = yuchRepository.findAll().size();

        // Delete the yuch
        restYuchMockMvc.perform(delete("/api/yuches/{id}", yuch.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Yuch> yuchList = yuchRepository.findAll();
        assertThat(yuchList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Yuch.class);
        Yuch yuch1 = new Yuch();
        yuch1.setId(1L);
        Yuch yuch2 = new Yuch();
        yuch2.setId(yuch1.getId());
        assertThat(yuch1).isEqualTo(yuch2);
        yuch2.setId(2L);
        assertThat(yuch1).isNotEqualTo(yuch2);
        yuch1.setId(null);
        assertThat(yuch1).isNotEqualTo(yuch2);
    }
}
