package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.ZjqabApp;
import grlmkb.wjw.vowri.bfkk.domain.Lfparqjft;
import grlmkb.wjw.vowri.bfkk.repository.LfparqjftRepository;
import grlmkb.wjw.vowri.bfkk.service.LfparqjftService;
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
import java.util.List;

import static grlmkb.wjw.vowri.bfkk.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link LfparqjftResource} REST controller.
 */
@SpringBootTest(classes = ZjqabApp.class)
public class LfparqjftResourceIT {

    @Autowired
    private LfparqjftRepository lfparqjftRepository;

    @Autowired
    private LfparqjftService lfparqjftService;

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

    private MockMvc restLfparqjftMockMvc;

    private Lfparqjft lfparqjft;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final LfparqjftResource lfparqjftResource = new LfparqjftResource(lfparqjftService);
        this.restLfparqjftMockMvc = MockMvcBuilders.standaloneSetup(lfparqjftResource)
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
    public static Lfparqjft createEntity(EntityManager em) {
        Lfparqjft lfparqjft = new Lfparqjft();
        return lfparqjft;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Lfparqjft createUpdatedEntity(EntityManager em) {
        Lfparqjft lfparqjft = new Lfparqjft();
        return lfparqjft;
    }

    @BeforeEach
    public void initTest() {
        lfparqjft = createEntity(em);
    }

    @Test
    @Transactional
    public void createLfparqjft() throws Exception {
        int databaseSizeBeforeCreate = lfparqjftRepository.findAll().size();

        // Create the Lfparqjft
        restLfparqjftMockMvc.perform(post("/api/lfparqjfts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(lfparqjft)))
            .andExpect(status().isCreated());

        // Validate the Lfparqjft in the database
        List<Lfparqjft> lfparqjftList = lfparqjftRepository.findAll();
        assertThat(lfparqjftList).hasSize(databaseSizeBeforeCreate + 1);
        Lfparqjft testLfparqjft = lfparqjftList.get(lfparqjftList.size() - 1);
    }

    @Test
    @Transactional
    public void createLfparqjftWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = lfparqjftRepository.findAll().size();

        // Create the Lfparqjft with an existing ID
        lfparqjft.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restLfparqjftMockMvc.perform(post("/api/lfparqjfts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(lfparqjft)))
            .andExpect(status().isBadRequest());

        // Validate the Lfparqjft in the database
        List<Lfparqjft> lfparqjftList = lfparqjftRepository.findAll();
        assertThat(lfparqjftList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllLfparqjfts() throws Exception {
        // Initialize the database
        lfparqjftRepository.saveAndFlush(lfparqjft);

        // Get all the lfparqjftList
        restLfparqjftMockMvc.perform(get("/api/lfparqjfts?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(lfparqjft.getId().intValue())));
    }
    
    @Test
    @Transactional
    public void getLfparqjft() throws Exception {
        // Initialize the database
        lfparqjftRepository.saveAndFlush(lfparqjft);

        // Get the lfparqjft
        restLfparqjftMockMvc.perform(get("/api/lfparqjfts/{id}", lfparqjft.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(lfparqjft.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingLfparqjft() throws Exception {
        // Get the lfparqjft
        restLfparqjftMockMvc.perform(get("/api/lfparqjfts/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateLfparqjft() throws Exception {
        // Initialize the database
        lfparqjftService.save(lfparqjft);

        int databaseSizeBeforeUpdate = lfparqjftRepository.findAll().size();

        // Update the lfparqjft
        Lfparqjft updatedLfparqjft = lfparqjftRepository.findById(lfparqjft.getId()).get();
        // Disconnect from session so that the updates on updatedLfparqjft are not directly saved in db
        em.detach(updatedLfparqjft);

        restLfparqjftMockMvc.perform(put("/api/lfparqjfts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedLfparqjft)))
            .andExpect(status().isOk());

        // Validate the Lfparqjft in the database
        List<Lfparqjft> lfparqjftList = lfparqjftRepository.findAll();
        assertThat(lfparqjftList).hasSize(databaseSizeBeforeUpdate);
        Lfparqjft testLfparqjft = lfparqjftList.get(lfparqjftList.size() - 1);
    }

    @Test
    @Transactional
    public void updateNonExistingLfparqjft() throws Exception {
        int databaseSizeBeforeUpdate = lfparqjftRepository.findAll().size();

        // Create the Lfparqjft

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restLfparqjftMockMvc.perform(put("/api/lfparqjfts")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(lfparqjft)))
            .andExpect(status().isBadRequest());

        // Validate the Lfparqjft in the database
        List<Lfparqjft> lfparqjftList = lfparqjftRepository.findAll();
        assertThat(lfparqjftList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteLfparqjft() throws Exception {
        // Initialize the database
        lfparqjftService.save(lfparqjft);

        int databaseSizeBeforeDelete = lfparqjftRepository.findAll().size();

        // Delete the lfparqjft
        restLfparqjftMockMvc.perform(delete("/api/lfparqjfts/{id}", lfparqjft.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Lfparqjft> lfparqjftList = lfparqjftRepository.findAll();
        assertThat(lfparqjftList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Lfparqjft.class);
        Lfparqjft lfparqjft1 = new Lfparqjft();
        lfparqjft1.setId(1L);
        Lfparqjft lfparqjft2 = new Lfparqjft();
        lfparqjft2.setId(lfparqjft1.getId());
        assertThat(lfparqjft1).isEqualTo(lfparqjft2);
        lfparqjft2.setId(2L);
        assertThat(lfparqjft1).isNotEqualTo(lfparqjft2);
        lfparqjft1.setId(null);
        assertThat(lfparqjft1).isNotEqualTo(lfparqjft2);
    }
}
