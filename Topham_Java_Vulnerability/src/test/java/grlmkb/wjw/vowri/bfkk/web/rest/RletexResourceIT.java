package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.ZjqabApp;
import grlmkb.wjw.vowri.bfkk.domain.Rletex;
import grlmkb.wjw.vowri.bfkk.repository.RletexRepository;
import grlmkb.wjw.vowri.bfkk.service.RletexService;
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
 * Integration tests for the {@link RletexResource} REST controller.
 */
@SpringBootTest(classes = ZjqabApp.class)
public class RletexResourceIT {

    private static final Boolean DEFAULT_SROEIH_TIMOVOQHQ = false;
    private static final Boolean UPDATED_SROEIH_TIMOVOQHQ = true;

    private static final Long DEFAULT_LCZCJL_HYBZK = 1L;
    private static final Long UPDATED_LCZCJL_HYBZK = 2L;
    private static final Long SMALLER_LCZCJL_HYBZK = 1L - 1L;

    private static final Instant DEFAULT_XLK_JZDTGUDMI = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_XLK_JZDTGUDMI = Instant.now().truncatedTo(ChronoUnit.MILLIS);
    private static final Instant SMALLER_XLK_JZDTGUDMI = Instant.ofEpochMilli(-1L);

    private static final LocalDate DEFAULT_DHZEWMHH_MB = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DHZEWMHH_MB = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_DHZEWMHH_MB = LocalDate.ofEpochDay(-1L);

    private static final String DEFAULT_CLTUR_NT = "AAAAAAAAAA";
    private static final String UPDATED_CLTUR_NT = "BBBBBBBBBB";

    private static final Integer DEFAULT_KWBL_ADTZ = 1;
    private static final Integer UPDATED_KWBL_ADTZ = 2;
    private static final Integer SMALLER_KWBL_ADTZ = 1 - 1;

    private static final Long DEFAULT_MQNWB_GJX = 1L;
    private static final Long UPDATED_MQNWB_GJX = 2L;
    private static final Long SMALLER_MQNWB_GJX = 1L - 1L;

    private static final Boolean DEFAULT_X_OZIR = false;
    private static final Boolean UPDATED_X_OZIR = true;

    private static final BigDecimal DEFAULT_VMQ_V = new BigDecimal(1);
    private static final BigDecimal UPDATED_VMQ_V = new BigDecimal(2);
    private static final BigDecimal SMALLER_VMQ_V = new BigDecimal(1 - 1);

    private static final ZonedDateTime DEFAULT_I_GGLNXLDXS = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_I_GGLNXLDXS = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_I_GGLNXLDXS = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    private static final Boolean DEFAULT_VKSNRUHC_GXVIWCT = false;
    private static final Boolean UPDATED_VKSNRUHC_GXVIWCT = true;

    private static final Float DEFAULT_MUNXNA_Y = 1F;
    private static final Float UPDATED_MUNXNA_Y = 2F;
    private static final Float SMALLER_MUNXNA_Y = 1F - 1F;

    private static final LocalDate DEFAULT_QIHF_HXRY = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_QIHF_HXRY = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_QIHF_HXRY = LocalDate.ofEpochDay(-1L);

    private static final Long DEFAULT_DWFUCGLG_XND = 1L;
    private static final Long UPDATED_DWFUCGLG_XND = 2L;
    private static final Long SMALLER_DWFUCGLG_XND = 1L - 1L;

    private static final String DEFAULT_YO_UNHREZTLG = "AAAAAAAAAA";
    private static final String UPDATED_YO_UNHREZTLG = "BBBBBBBBBB";

    private static final String DEFAULT_SYTD_ER = "AAAAAAAAAA";
    private static final String UPDATED_SYTD_ER = "BBBBBBBBBB";

    private static final String DEFAULT_Z_NBBBICYP = "AAAAAAAAAA";
    private static final String UPDATED_Z_NBBBICYP = "BBBBBBBBBB";

    private static final Boolean DEFAULT_IFOTJF_AWXJDJIF = false;
    private static final Boolean UPDATED_IFOTJF_AWXJDJIF = true;

    @Autowired
    private RletexRepository rletexRepository;

    @Autowired
    private RletexService rletexService;

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

    private MockMvc restRletexMockMvc;

    private Rletex rletex;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RletexResource rletexResource = new RletexResource(rletexService);
        this.restRletexMockMvc = MockMvcBuilders.standaloneSetup(rletexResource)
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
    public static Rletex createEntity(EntityManager em) {
        Rletex rletex = new Rletex();
        rletex.setSroeihTIMOVOQHQ(DEFAULT_SROEIH_TIMOVOQHQ);
        rletex.setLczcjlHYBZK(DEFAULT_LCZCJL_HYBZK);
        rletex.setXlkJZDTGUDMI(DEFAULT_XLK_JZDTGUDMI);
        rletex.setDhzewmhhMB(DEFAULT_DHZEWMHH_MB);
        rletex.setClturNT(DEFAULT_CLTUR_NT);
        rletex.setKwblADTZ(DEFAULT_KWBL_ADTZ);
        rletex.setMqnwbGJX(DEFAULT_MQNWB_GJX);
        rletex.setxOZIR(DEFAULT_X_OZIR);
        rletex.setVmqV(DEFAULT_VMQ_V);
        rletex.setiGGLNXLDXS(DEFAULT_I_GGLNXLDXS);
        rletex.setVksnruhcGXVIWCT(DEFAULT_VKSNRUHC_GXVIWCT);
        rletex.setMunxnaY(DEFAULT_MUNXNA_Y);
        rletex.setQihfHXRY(DEFAULT_QIHF_HXRY);
        rletex.setDwfucglgXND(DEFAULT_DWFUCGLG_XND);
        rletex.setYoUNHREZTLG(DEFAULT_YO_UNHREZTLG);
        rletex.setSytdER(DEFAULT_SYTD_ER);
        rletex.setzNBBBICYP(DEFAULT_Z_NBBBICYP);
        rletex.setIfotjfAWXJDJIF(DEFAULT_IFOTJF_AWXJDJIF);
        return rletex;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Rletex createUpdatedEntity(EntityManager em) {
        Rletex rletex = new Rletex();
        rletex.setSroeihTIMOVOQHQ(UPDATED_SROEIH_TIMOVOQHQ);
        rletex.setLczcjlHYBZK(UPDATED_LCZCJL_HYBZK);
        rletex.setXlkJZDTGUDMI(UPDATED_XLK_JZDTGUDMI);
        rletex.setDhzewmhhMB(UPDATED_DHZEWMHH_MB);
        rletex.setClturNT(UPDATED_CLTUR_NT);
        rletex.setKwblADTZ(UPDATED_KWBL_ADTZ);
        rletex.setMqnwbGJX(UPDATED_MQNWB_GJX);
        rletex.setxOZIR(UPDATED_X_OZIR);
        rletex.setVmqV(UPDATED_VMQ_V);
        rletex.setiGGLNXLDXS(UPDATED_I_GGLNXLDXS);
        rletex.setVksnruhcGXVIWCT(UPDATED_VKSNRUHC_GXVIWCT);
        rletex.setMunxnaY(UPDATED_MUNXNA_Y);
        rletex.setQihfHXRY(UPDATED_QIHF_HXRY);
        rletex.setDwfucglgXND(UPDATED_DWFUCGLG_XND);
        rletex.setYoUNHREZTLG(UPDATED_YO_UNHREZTLG);
        rletex.setSytdER(UPDATED_SYTD_ER);
        rletex.setzNBBBICYP(UPDATED_Z_NBBBICYP);
        rletex.setIfotjfAWXJDJIF(UPDATED_IFOTJF_AWXJDJIF);
        return rletex;
    }

    @BeforeEach
    public void initTest() {
        rletex = createEntity(em);
    }

    @Test
    @Transactional
    public void createRletex() throws Exception {
        int databaseSizeBeforeCreate = rletexRepository.findAll().size();

        // Create the Rletex
        restRletexMockMvc.perform(post("/api/rletexes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rletex)))
            .andExpect(status().isCreated());

        // Validate the Rletex in the database
        List<Rletex> rletexList = rletexRepository.findAll();
        assertThat(rletexList).hasSize(databaseSizeBeforeCreate + 1);
        Rletex testRletex = rletexList.get(rletexList.size() - 1);
        assertThat(testRletex.isSroeihTIMOVOQHQ()).isEqualTo(DEFAULT_SROEIH_TIMOVOQHQ);
        assertThat(testRletex.getLczcjlHYBZK()).isEqualTo(DEFAULT_LCZCJL_HYBZK);
        assertThat(testRletex.getXlkJZDTGUDMI()).isEqualTo(DEFAULT_XLK_JZDTGUDMI);
        assertThat(testRletex.getDhzewmhhMB()).isEqualTo(DEFAULT_DHZEWMHH_MB);
        assertThat(testRletex.getClturNT()).isEqualTo(DEFAULT_CLTUR_NT);
        assertThat(testRletex.getKwblADTZ()).isEqualTo(DEFAULT_KWBL_ADTZ);
        assertThat(testRletex.getMqnwbGJX()).isEqualTo(DEFAULT_MQNWB_GJX);
        assertThat(testRletex.isxOZIR()).isEqualTo(DEFAULT_X_OZIR);
        assertThat(testRletex.getVmqV()).isEqualTo(DEFAULT_VMQ_V);
        assertThat(testRletex.getiGGLNXLDXS()).isEqualTo(DEFAULT_I_GGLNXLDXS);
        assertThat(testRletex.isVksnruhcGXVIWCT()).isEqualTo(DEFAULT_VKSNRUHC_GXVIWCT);
        assertThat(testRletex.getMunxnaY()).isEqualTo(DEFAULT_MUNXNA_Y);
        assertThat(testRletex.getQihfHXRY()).isEqualTo(DEFAULT_QIHF_HXRY);
        assertThat(testRletex.getDwfucglgXND()).isEqualTo(DEFAULT_DWFUCGLG_XND);
        assertThat(testRletex.getYoUNHREZTLG()).isEqualTo(DEFAULT_YO_UNHREZTLG);
        assertThat(testRletex.getSytdER()).isEqualTo(DEFAULT_SYTD_ER);
        assertThat(testRletex.getzNBBBICYP()).isEqualTo(DEFAULT_Z_NBBBICYP);
        assertThat(testRletex.isIfotjfAWXJDJIF()).isEqualTo(DEFAULT_IFOTJF_AWXJDJIF);
    }

    @Test
    @Transactional
    public void createRletexWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rletexRepository.findAll().size();

        // Create the Rletex with an existing ID
        rletex.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRletexMockMvc.perform(post("/api/rletexes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rletex)))
            .andExpect(status().isBadRequest());

        // Validate the Rletex in the database
        List<Rletex> rletexList = rletexRepository.findAll();
        assertThat(rletexList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllRletexes() throws Exception {
        // Initialize the database
        rletexRepository.saveAndFlush(rletex);

        // Get all the rletexList
        restRletexMockMvc.perform(get("/api/rletexes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rletex.getId().intValue())))
            .andExpect(jsonPath("$.[*].sroeihTIMOVOQHQ").value(hasItem(DEFAULT_SROEIH_TIMOVOQHQ.booleanValue())))
            .andExpect(jsonPath("$.[*].lczcjlHYBZK").value(hasItem(DEFAULT_LCZCJL_HYBZK.intValue())))
            .andExpect(jsonPath("$.[*].xlkJZDTGUDMI").value(hasItem(DEFAULT_XLK_JZDTGUDMI.toString())))
            .andExpect(jsonPath("$.[*].dhzewmhhMB").value(hasItem(DEFAULT_DHZEWMHH_MB.toString())))
            .andExpect(jsonPath("$.[*].clturNT").value(hasItem(DEFAULT_CLTUR_NT.toString())))
            .andExpect(jsonPath("$.[*].kwblADTZ").value(hasItem(DEFAULT_KWBL_ADTZ)))
            .andExpect(jsonPath("$.[*].mqnwbGJX").value(hasItem(DEFAULT_MQNWB_GJX.intValue())))
            .andExpect(jsonPath("$.[*].xOZIR").value(hasItem(DEFAULT_X_OZIR.booleanValue())))
            .andExpect(jsonPath("$.[*].vmqV").value(hasItem(DEFAULT_VMQ_V.intValue())))
            .andExpect(jsonPath("$.[*].iGGLNXLDXS").value(hasItem(sameInstant(DEFAULT_I_GGLNXLDXS))))
            .andExpect(jsonPath("$.[*].vksnruhcGXVIWCT").value(hasItem(DEFAULT_VKSNRUHC_GXVIWCT.booleanValue())))
            .andExpect(jsonPath("$.[*].munxnaY").value(hasItem(DEFAULT_MUNXNA_Y.doubleValue())))
            .andExpect(jsonPath("$.[*].qihfHXRY").value(hasItem(DEFAULT_QIHF_HXRY.toString())))
            .andExpect(jsonPath("$.[*].dwfucglgXND").value(hasItem(DEFAULT_DWFUCGLG_XND.intValue())))
            .andExpect(jsonPath("$.[*].yoUNHREZTLG").value(hasItem(DEFAULT_YO_UNHREZTLG.toString())))
            .andExpect(jsonPath("$.[*].sytdER").value(hasItem(DEFAULT_SYTD_ER.toString())))
            .andExpect(jsonPath("$.[*].zNBBBICYP").value(hasItem(DEFAULT_Z_NBBBICYP.toString())))
            .andExpect(jsonPath("$.[*].ifotjfAWXJDJIF").value(hasItem(DEFAULT_IFOTJF_AWXJDJIF.booleanValue())));
    }
    
    @Test
    @Transactional
    public void getRletex() throws Exception {
        // Initialize the database
        rletexRepository.saveAndFlush(rletex);

        // Get the rletex
        restRletexMockMvc.perform(get("/api/rletexes/{id}", rletex.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rletex.getId().intValue()))
            .andExpect(jsonPath("$.sroeihTIMOVOQHQ").value(DEFAULT_SROEIH_TIMOVOQHQ.booleanValue()))
            .andExpect(jsonPath("$.lczcjlHYBZK").value(DEFAULT_LCZCJL_HYBZK.intValue()))
            .andExpect(jsonPath("$.xlkJZDTGUDMI").value(DEFAULT_XLK_JZDTGUDMI.toString()))
            .andExpect(jsonPath("$.dhzewmhhMB").value(DEFAULT_DHZEWMHH_MB.toString()))
            .andExpect(jsonPath("$.clturNT").value(DEFAULT_CLTUR_NT.toString()))
            .andExpect(jsonPath("$.kwblADTZ").value(DEFAULT_KWBL_ADTZ))
            .andExpect(jsonPath("$.mqnwbGJX").value(DEFAULT_MQNWB_GJX.intValue()))
            .andExpect(jsonPath("$.xOZIR").value(DEFAULT_X_OZIR.booleanValue()))
            .andExpect(jsonPath("$.vmqV").value(DEFAULT_VMQ_V.intValue()))
            .andExpect(jsonPath("$.iGGLNXLDXS").value(sameInstant(DEFAULT_I_GGLNXLDXS)))
            .andExpect(jsonPath("$.vksnruhcGXVIWCT").value(DEFAULT_VKSNRUHC_GXVIWCT.booleanValue()))
            .andExpect(jsonPath("$.munxnaY").value(DEFAULT_MUNXNA_Y.doubleValue()))
            .andExpect(jsonPath("$.qihfHXRY").value(DEFAULT_QIHF_HXRY.toString()))
            .andExpect(jsonPath("$.dwfucglgXND").value(DEFAULT_DWFUCGLG_XND.intValue()))
            .andExpect(jsonPath("$.yoUNHREZTLG").value(DEFAULT_YO_UNHREZTLG.toString()))
            .andExpect(jsonPath("$.sytdER").value(DEFAULT_SYTD_ER.toString()))
            .andExpect(jsonPath("$.zNBBBICYP").value(DEFAULT_Z_NBBBICYP.toString()))
            .andExpect(jsonPath("$.ifotjfAWXJDJIF").value(DEFAULT_IFOTJF_AWXJDJIF.booleanValue()));
    }

    @Test
    @Transactional
    public void getNonExistingRletex() throws Exception {
        // Get the rletex
        restRletexMockMvc.perform(get("/api/rletexes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRletex() throws Exception {
        // Initialize the database
        rletexService.save(rletex);

        int databaseSizeBeforeUpdate = rletexRepository.findAll().size();

        // Update the rletex
        Rletex updatedRletex = rletexRepository.findById(rletex.getId()).get();
        // Disconnect from session so that the updates on updatedRletex are not directly saved in db
        em.detach(updatedRletex);
        updatedRletex.setSroeihTIMOVOQHQ(UPDATED_SROEIH_TIMOVOQHQ);
        updatedRletex.setLczcjlHYBZK(UPDATED_LCZCJL_HYBZK);
        updatedRletex.setXlkJZDTGUDMI(UPDATED_XLK_JZDTGUDMI);
        updatedRletex.setDhzewmhhMB(UPDATED_DHZEWMHH_MB);
        updatedRletex.setClturNT(UPDATED_CLTUR_NT);
        updatedRletex.setKwblADTZ(UPDATED_KWBL_ADTZ);
        updatedRletex.setMqnwbGJX(UPDATED_MQNWB_GJX);
        updatedRletex.setxOZIR(UPDATED_X_OZIR);
        updatedRletex.setVmqV(UPDATED_VMQ_V);
        updatedRletex.setiGGLNXLDXS(UPDATED_I_GGLNXLDXS);
        updatedRletex.setVksnruhcGXVIWCT(UPDATED_VKSNRUHC_GXVIWCT);
        updatedRletex.setMunxnaY(UPDATED_MUNXNA_Y);
        updatedRletex.setQihfHXRY(UPDATED_QIHF_HXRY);
        updatedRletex.setDwfucglgXND(UPDATED_DWFUCGLG_XND);
        updatedRletex.setYoUNHREZTLG(UPDATED_YO_UNHREZTLG);
        updatedRletex.setSytdER(UPDATED_SYTD_ER);
        updatedRletex.setzNBBBICYP(UPDATED_Z_NBBBICYP);
        updatedRletex.setIfotjfAWXJDJIF(UPDATED_IFOTJF_AWXJDJIF);

        restRletexMockMvc.perform(put("/api/rletexes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRletex)))
            .andExpect(status().isOk());

        // Validate the Rletex in the database
        List<Rletex> rletexList = rletexRepository.findAll();
        assertThat(rletexList).hasSize(databaseSizeBeforeUpdate);
        Rletex testRletex = rletexList.get(rletexList.size() - 1);
        assertThat(testRletex.isSroeihTIMOVOQHQ()).isEqualTo(UPDATED_SROEIH_TIMOVOQHQ);
        assertThat(testRletex.getLczcjlHYBZK()).isEqualTo(UPDATED_LCZCJL_HYBZK);
        assertThat(testRletex.getXlkJZDTGUDMI()).isEqualTo(UPDATED_XLK_JZDTGUDMI);
        assertThat(testRletex.getDhzewmhhMB()).isEqualTo(UPDATED_DHZEWMHH_MB);
        assertThat(testRletex.getClturNT()).isEqualTo(UPDATED_CLTUR_NT);
        assertThat(testRletex.getKwblADTZ()).isEqualTo(UPDATED_KWBL_ADTZ);
        assertThat(testRletex.getMqnwbGJX()).isEqualTo(UPDATED_MQNWB_GJX);
        assertThat(testRletex.isxOZIR()).isEqualTo(UPDATED_X_OZIR);
        assertThat(testRletex.getVmqV()).isEqualTo(UPDATED_VMQ_V);
        assertThat(testRletex.getiGGLNXLDXS()).isEqualTo(UPDATED_I_GGLNXLDXS);
        assertThat(testRletex.isVksnruhcGXVIWCT()).isEqualTo(UPDATED_VKSNRUHC_GXVIWCT);
        assertThat(testRletex.getMunxnaY()).isEqualTo(UPDATED_MUNXNA_Y);
        assertThat(testRletex.getQihfHXRY()).isEqualTo(UPDATED_QIHF_HXRY);
        assertThat(testRletex.getDwfucglgXND()).isEqualTo(UPDATED_DWFUCGLG_XND);
        assertThat(testRletex.getYoUNHREZTLG()).isEqualTo(UPDATED_YO_UNHREZTLG);
        assertThat(testRletex.getSytdER()).isEqualTo(UPDATED_SYTD_ER);
        assertThat(testRletex.getzNBBBICYP()).isEqualTo(UPDATED_Z_NBBBICYP);
        assertThat(testRletex.isIfotjfAWXJDJIF()).isEqualTo(UPDATED_IFOTJF_AWXJDJIF);
    }

    @Test
    @Transactional
    public void updateNonExistingRletex() throws Exception {
        int databaseSizeBeforeUpdate = rletexRepository.findAll().size();

        // Create the Rletex

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restRletexMockMvc.perform(put("/api/rletexes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rletex)))
            .andExpect(status().isBadRequest());

        // Validate the Rletex in the database
        List<Rletex> rletexList = rletexRepository.findAll();
        assertThat(rletexList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRletex() throws Exception {
        // Initialize the database
        rletexService.save(rletex);

        int databaseSizeBeforeDelete = rletexRepository.findAll().size();

        // Delete the rletex
        restRletexMockMvc.perform(delete("/api/rletexes/{id}", rletex.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Rletex> rletexList = rletexRepository.findAll();
        assertThat(rletexList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Rletex.class);
        Rletex rletex1 = new Rletex();
        rletex1.setId(1L);
        Rletex rletex2 = new Rletex();
        rletex2.setId(rletex1.getId());
        assertThat(rletex1).isEqualTo(rletex2);
        rletex2.setId(2L);
        assertThat(rletex1).isNotEqualTo(rletex2);
        rletex1.setId(null);
        assertThat(rletex1).isNotEqualTo(rletex2);
    }
}
