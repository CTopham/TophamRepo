package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.ZjqabApp;
import grlmkb.wjw.vowri.bfkk.domain.Jsosxwzeps;
import grlmkb.wjw.vowri.bfkk.repository.JsosxwzepsRepository;
import grlmkb.wjw.vowri.bfkk.service.JsosxwzepsService;
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
import java.util.List;

import static grlmkb.wjw.vowri.bfkk.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link JsosxwzepsResource} REST controller.
 */
@SpringBootTest(classes = ZjqabApp.class)
public class JsosxwzepsResourceIT {

    private static final Long DEFAULT_DCNZFA_KVVGZ = 1L;
    private static final Long UPDATED_DCNZFA_KVVGZ = 2L;
    private static final Long SMALLER_DCNZFA_KVVGZ = 1L - 1L;

    private static final BigDecimal DEFAULT_WJU_PKS = new BigDecimal(1);
    private static final BigDecimal UPDATED_WJU_PKS = new BigDecimal(2);
    private static final BigDecimal SMALLER_WJU_PKS = new BigDecimal(1 - 1);

    @Autowired
    private JsosxwzepsRepository jsosxwzepsRepository;

    @Autowired
    private JsosxwzepsService jsosxwzepsService;

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

    private MockMvc restJsosxwzepsMockMvc;

    private Jsosxwzeps jsosxwzeps;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final JsosxwzepsResource jsosxwzepsResource = new JsosxwzepsResource(jsosxwzepsService);
        this.restJsosxwzepsMockMvc = MockMvcBuilders.standaloneSetup(jsosxwzepsResource)
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
    public static Jsosxwzeps createEntity(EntityManager em) {
        Jsosxwzeps jsosxwzeps = new Jsosxwzeps()
            .dcnzfaKVVGZ(DEFAULT_DCNZFA_KVVGZ)
            .wjuPKS(DEFAULT_WJU_PKS);
        return jsosxwzeps;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Jsosxwzeps createUpdatedEntity(EntityManager em) {
        Jsosxwzeps jsosxwzeps = new Jsosxwzeps()
            .dcnzfaKVVGZ(UPDATED_DCNZFA_KVVGZ)
            .wjuPKS(UPDATED_WJU_PKS);
        return jsosxwzeps;
    }

    @BeforeEach
    public void initTest() {
        jsosxwzeps = createEntity(em);
    }

    @Test
    @Transactional
    public void createJsosxwzeps() throws Exception {
        int databaseSizeBeforeCreate = jsosxwzepsRepository.findAll().size();

        // Create the Jsosxwzeps
        restJsosxwzepsMockMvc.perform(post("/api/jsosxwzeps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(jsosxwzeps)))
            .andExpect(status().isCreated());

        // Validate the Jsosxwzeps in the database
        List<Jsosxwzeps> jsosxwzepsList = jsosxwzepsRepository.findAll();
        assertThat(jsosxwzepsList).hasSize(databaseSizeBeforeCreate + 1);
        Jsosxwzeps testJsosxwzeps = jsosxwzepsList.get(jsosxwzepsList.size() - 1);
        assertThat(testJsosxwzeps.getDcnzfaKVVGZ()).isEqualTo(DEFAULT_DCNZFA_KVVGZ);
        assertThat(testJsosxwzeps.getWjuPKS()).isEqualTo(DEFAULT_WJU_PKS);
    }

    @Test
    @Transactional
    public void createJsosxwzepsWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = jsosxwzepsRepository.findAll().size();

        // Create the Jsosxwzeps with an existing ID
        jsosxwzeps.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restJsosxwzepsMockMvc.perform(post("/api/jsosxwzeps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(jsosxwzeps)))
            .andExpect(status().isBadRequest());

        // Validate the Jsosxwzeps in the database
        List<Jsosxwzeps> jsosxwzepsList = jsosxwzepsRepository.findAll();
        assertThat(jsosxwzepsList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllJsosxwzeps() throws Exception {
        // Initialize the database
        jsosxwzepsRepository.saveAndFlush(jsosxwzeps);

        // Get all the jsosxwzepsList
        restJsosxwzepsMockMvc.perform(get("/api/jsosxwzeps?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(jsosxwzeps.getId().intValue())))
            .andExpect(jsonPath("$.[*].dcnzfaKVVGZ").value(hasItem(DEFAULT_DCNZFA_KVVGZ.intValue())))
            .andExpect(jsonPath("$.[*].wjuPKS").value(hasItem(DEFAULT_WJU_PKS.intValue())));
    }
    
    @Test
    @Transactional
    public void getJsosxwzeps() throws Exception {
        // Initialize the database
        jsosxwzepsRepository.saveAndFlush(jsosxwzeps);

        // Get the jsosxwzeps
        restJsosxwzepsMockMvc.perform(get("/api/jsosxwzeps/{id}", jsosxwzeps.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(jsosxwzeps.getId().intValue()))
            .andExpect(jsonPath("$.dcnzfaKVVGZ").value(DEFAULT_DCNZFA_KVVGZ.intValue()))
            .andExpect(jsonPath("$.wjuPKS").value(DEFAULT_WJU_PKS.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingJsosxwzeps() throws Exception {
        // Get the jsosxwzeps
        restJsosxwzepsMockMvc.perform(get("/api/jsosxwzeps/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateJsosxwzeps() throws Exception {
        // Initialize the database
        jsosxwzepsService.save(jsosxwzeps);

        int databaseSizeBeforeUpdate = jsosxwzepsRepository.findAll().size();

        // Update the jsosxwzeps
        Jsosxwzeps updatedJsosxwzeps = jsosxwzepsRepository.findById(jsosxwzeps.getId()).get();
        // Disconnect from session so that the updates on updatedJsosxwzeps are not directly saved in db
        em.detach(updatedJsosxwzeps);
        updatedJsosxwzeps
            .dcnzfaKVVGZ(UPDATED_DCNZFA_KVVGZ)
            .wjuPKS(UPDATED_WJU_PKS);

        restJsosxwzepsMockMvc.perform(put("/api/jsosxwzeps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedJsosxwzeps)))
            .andExpect(status().isOk());

        // Validate the Jsosxwzeps in the database
        List<Jsosxwzeps> jsosxwzepsList = jsosxwzepsRepository.findAll();
        assertThat(jsosxwzepsList).hasSize(databaseSizeBeforeUpdate);
        Jsosxwzeps testJsosxwzeps = jsosxwzepsList.get(jsosxwzepsList.size() - 1);
        assertThat(testJsosxwzeps.getDcnzfaKVVGZ()).isEqualTo(UPDATED_DCNZFA_KVVGZ);
        assertThat(testJsosxwzeps.getWjuPKS()).isEqualTo(UPDATED_WJU_PKS);
    }

    @Test
    @Transactional
    public void updateNonExistingJsosxwzeps() throws Exception {
        int databaseSizeBeforeUpdate = jsosxwzepsRepository.findAll().size();

        // Create the Jsosxwzeps

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restJsosxwzepsMockMvc.perform(put("/api/jsosxwzeps")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(jsosxwzeps)))
            .andExpect(status().isBadRequest());

        // Validate the Jsosxwzeps in the database
        List<Jsosxwzeps> jsosxwzepsList = jsosxwzepsRepository.findAll();
        assertThat(jsosxwzepsList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteJsosxwzeps() throws Exception {
        // Initialize the database
        jsosxwzepsService.save(jsosxwzeps);

        int databaseSizeBeforeDelete = jsosxwzepsRepository.findAll().size();

        // Delete the jsosxwzeps
        restJsosxwzepsMockMvc.perform(delete("/api/jsosxwzeps/{id}", jsosxwzeps.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Jsosxwzeps> jsosxwzepsList = jsosxwzepsRepository.findAll();
        assertThat(jsosxwzepsList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Jsosxwzeps.class);
        Jsosxwzeps jsosxwzeps1 = new Jsosxwzeps();
        jsosxwzeps1.setId(1L);
        Jsosxwzeps jsosxwzeps2 = new Jsosxwzeps();
        jsosxwzeps2.setId(jsosxwzeps1.getId());
        assertThat(jsosxwzeps1).isEqualTo(jsosxwzeps2);
        jsosxwzeps2.setId(2L);
        assertThat(jsosxwzeps1).isNotEqualTo(jsosxwzeps2);
        jsosxwzeps1.setId(null);
        assertThat(jsosxwzeps1).isNotEqualTo(jsosxwzeps2);
    }
}
