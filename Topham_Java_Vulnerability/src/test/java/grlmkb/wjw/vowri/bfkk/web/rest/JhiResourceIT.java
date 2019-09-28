package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.ZjqabApp;
import grlmkb.wjw.vowri.bfkk.domain.Jhi;
import grlmkb.wjw.vowri.bfkk.repository.JhiRepository;
import grlmkb.wjw.vowri.bfkk.service.JhiService;
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
 * Integration tests for the {@link JhiResource} REST controller.
 */
@SpringBootTest(classes = ZjqabApp.class)
public class JhiResourceIT {

    private static final Float DEFAULT_KUXGVRGHG_ZWUVBAS = 1F;
    private static final Float UPDATED_KUXGVRGHG_ZWUVBAS = 2F;
    private static final Float SMALLER_KUXGVRGHG_ZWUVBAS = 1F - 1F;

    private static final Long DEFAULT_CYOLUQJX_CCMPZM = 1L;
    private static final Long UPDATED_CYOLUQJX_CCMPZM = 2L;
    private static final Long SMALLER_CYOLUQJX_CCMPZM = 1L - 1L;

    private static final Boolean DEFAULT_C_GHPVLNPHG = false;
    private static final Boolean UPDATED_C_GHPVLNPHG = true;

    private static final Integer DEFAULT_FNSUN_JGEXY = 1;
    private static final Integer UPDATED_FNSUN_JGEXY = 2;
    private static final Integer SMALLER_FNSUN_JGEXY = 1 - 1;

    private static final Float DEFAULT_XFH_MRAWOAD = 1F;
    private static final Float UPDATED_XFH_MRAWOAD = 2F;
    private static final Float SMALLER_XFH_MRAWOAD = 1F - 1F;

    private static final BigDecimal DEFAULT_RHCUAGUS_EM = new BigDecimal(1);
    private static final BigDecimal UPDATED_RHCUAGUS_EM = new BigDecimal(2);
    private static final BigDecimal SMALLER_RHCUAGUS_EM = new BigDecimal(1 - 1);

    private static final Long DEFAULT_NNMUICG_OII = 1L;
    private static final Long UPDATED_NNMUICG_OII = 2L;
    private static final Long SMALLER_NNMUICG_OII = 1L - 1L;

    private static final Long DEFAULT_CQ_CGPSOPJC = 1L;
    private static final Long UPDATED_CQ_CGPSOPJC = 2L;
    private static final Long SMALLER_CQ_CGPSOPJC = 1L - 1L;

    private static final Boolean DEFAULT_YC_WFMXX = false;
    private static final Boolean UPDATED_YC_WFMXX = true;

    private static final Boolean DEFAULT_V_IEFKCLJCN = false;
    private static final Boolean UPDATED_V_IEFKCLJCN = true;

    private static final ZonedDateTime DEFAULT_ULORFVRZ_NGZQT = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_ULORFVRZ_NGZQT = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_ULORFVRZ_NGZQT = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    private static final Long DEFAULT_SFBRWWUEZ_NWHCMT = 1L;
    private static final Long UPDATED_SFBRWWUEZ_NWHCMT = 2L;
    private static final Long SMALLER_SFBRWWUEZ_NWHCMT = 1L - 1L;

    private static final Float DEFAULT_YSMXLUJOU_DKMEIUUG = 1F;
    private static final Float UPDATED_YSMXLUJOU_DKMEIUUG = 2F;
    private static final Float SMALLER_YSMXLUJOU_DKMEIUUG = 1F - 1F;

    private static final Instant DEFAULT_BEBPX_FFA = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_BEBPX_FFA = Instant.now().truncatedTo(ChronoUnit.MILLIS);
    private static final Instant SMALLER_BEBPX_FFA = Instant.ofEpochMilli(-1L);

    private static final BigDecimal DEFAULT_FJIE_PMF = new BigDecimal(1);
    private static final BigDecimal UPDATED_FJIE_PMF = new BigDecimal(2);
    private static final BigDecimal SMALLER_FJIE_PMF = new BigDecimal(1 - 1);

    @Autowired
    private JhiRepository jhiRepository;

    @Autowired
    private JhiService jhiService;

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

    private MockMvc restJhiMockMvc;

    private Jhi jhi;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final JhiResource jhiResource = new JhiResource(jhiService);
        this.restJhiMockMvc = MockMvcBuilders.standaloneSetup(jhiResource)
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
    public static Jhi createEntity(EntityManager em) {
        Jhi jhi = new Jhi()
            .kuxgvrghgZWUVBAS(DEFAULT_KUXGVRGHG_ZWUVBAS)
            .cyoluqjxCCMPZM(DEFAULT_CYOLUQJX_CCMPZM)
            .cGHPVLNPHG(DEFAULT_C_GHPVLNPHG)
            .fnsunJGEXY(DEFAULT_FNSUN_JGEXY)
            .xfhMRAWOAD(DEFAULT_XFH_MRAWOAD)
            .rhcuagusEM(DEFAULT_RHCUAGUS_EM)
            .nnmuicgOII(DEFAULT_NNMUICG_OII)
            .cqCGPSOPJC(DEFAULT_CQ_CGPSOPJC)
            .ycWFMXX(DEFAULT_YC_WFMXX)
            .vIEFKCLJCN(DEFAULT_V_IEFKCLJCN)
            .ulorfvrzNGZQT(DEFAULT_ULORFVRZ_NGZQT)
            .sfbrwwuezNWHCMT(DEFAULT_SFBRWWUEZ_NWHCMT)
            .ysmxlujouDKMEIUUG(DEFAULT_YSMXLUJOU_DKMEIUUG)
            .bebpxFFA(DEFAULT_BEBPX_FFA)
            .fjiePMF(DEFAULT_FJIE_PMF);
        return jhi;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Jhi createUpdatedEntity(EntityManager em) {
        Jhi jhi = new Jhi()
            .kuxgvrghgZWUVBAS(UPDATED_KUXGVRGHG_ZWUVBAS)
            .cyoluqjxCCMPZM(UPDATED_CYOLUQJX_CCMPZM)
            .cGHPVLNPHG(UPDATED_C_GHPVLNPHG)
            .fnsunJGEXY(UPDATED_FNSUN_JGEXY)
            .xfhMRAWOAD(UPDATED_XFH_MRAWOAD)
            .rhcuagusEM(UPDATED_RHCUAGUS_EM)
            .nnmuicgOII(UPDATED_NNMUICG_OII)
            .cqCGPSOPJC(UPDATED_CQ_CGPSOPJC)
            .ycWFMXX(UPDATED_YC_WFMXX)
            .vIEFKCLJCN(UPDATED_V_IEFKCLJCN)
            .ulorfvrzNGZQT(UPDATED_ULORFVRZ_NGZQT)
            .sfbrwwuezNWHCMT(UPDATED_SFBRWWUEZ_NWHCMT)
            .ysmxlujouDKMEIUUG(UPDATED_YSMXLUJOU_DKMEIUUG)
            .bebpxFFA(UPDATED_BEBPX_FFA)
            .fjiePMF(UPDATED_FJIE_PMF);
        return jhi;
    }

    @BeforeEach
    public void initTest() {
        jhi = createEntity(em);
    }

    @Test
    @Transactional
    public void createJhi() throws Exception {
        int databaseSizeBeforeCreate = jhiRepository.findAll().size();

        // Create the Jhi
        restJhiMockMvc.perform(post("/api/jhis")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(jhi)))
            .andExpect(status().isCreated());

        // Validate the Jhi in the database
        List<Jhi> jhiList = jhiRepository.findAll();
        assertThat(jhiList).hasSize(databaseSizeBeforeCreate + 1);
        Jhi testJhi = jhiList.get(jhiList.size() - 1);
        assertThat(testJhi.getKuxgvrghgZWUVBAS()).isEqualTo(DEFAULT_KUXGVRGHG_ZWUVBAS);
        assertThat(testJhi.getCyoluqjxCCMPZM()).isEqualTo(DEFAULT_CYOLUQJX_CCMPZM);
        assertThat(testJhi.iscGHPVLNPHG()).isEqualTo(DEFAULT_C_GHPVLNPHG);
        assertThat(testJhi.getFnsunJGEXY()).isEqualTo(DEFAULT_FNSUN_JGEXY);
        assertThat(testJhi.getXfhMRAWOAD()).isEqualTo(DEFAULT_XFH_MRAWOAD);
        assertThat(testJhi.getRhcuagusEM()).isEqualTo(DEFAULT_RHCUAGUS_EM);
        assertThat(testJhi.getNnmuicgOII()).isEqualTo(DEFAULT_NNMUICG_OII);
        assertThat(testJhi.getCqCGPSOPJC()).isEqualTo(DEFAULT_CQ_CGPSOPJC);
        assertThat(testJhi.isYcWFMXX()).isEqualTo(DEFAULT_YC_WFMXX);
        assertThat(testJhi.isvIEFKCLJCN()).isEqualTo(DEFAULT_V_IEFKCLJCN);
        assertThat(testJhi.getUlorfvrzNGZQT()).isEqualTo(DEFAULT_ULORFVRZ_NGZQT);
        assertThat(testJhi.getSfbrwwuezNWHCMT()).isEqualTo(DEFAULT_SFBRWWUEZ_NWHCMT);
        assertThat(testJhi.getYsmxlujouDKMEIUUG()).isEqualTo(DEFAULT_YSMXLUJOU_DKMEIUUG);
        assertThat(testJhi.getBebpxFFA()).isEqualTo(DEFAULT_BEBPX_FFA);
        assertThat(testJhi.getFjiePMF()).isEqualTo(DEFAULT_FJIE_PMF);
    }

    @Test
    @Transactional
    public void createJhiWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = jhiRepository.findAll().size();

        // Create the Jhi with an existing ID
        jhi.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restJhiMockMvc.perform(post("/api/jhis")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(jhi)))
            .andExpect(status().isBadRequest());

        // Validate the Jhi in the database
        List<Jhi> jhiList = jhiRepository.findAll();
        assertThat(jhiList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllJhis() throws Exception {
        // Initialize the database
        jhiRepository.saveAndFlush(jhi);

        // Get all the jhiList
        restJhiMockMvc.perform(get("/api/jhis?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(jhi.getId().intValue())))
            .andExpect(jsonPath("$.[*].kuxgvrghgZWUVBAS").value(hasItem(DEFAULT_KUXGVRGHG_ZWUVBAS.doubleValue())))
            .andExpect(jsonPath("$.[*].cyoluqjxCCMPZM").value(hasItem(DEFAULT_CYOLUQJX_CCMPZM.intValue())))
            .andExpect(jsonPath("$.[*].cGHPVLNPHG").value(hasItem(DEFAULT_C_GHPVLNPHG.booleanValue())))
            .andExpect(jsonPath("$.[*].fnsunJGEXY").value(hasItem(DEFAULT_FNSUN_JGEXY)))
            .andExpect(jsonPath("$.[*].xfhMRAWOAD").value(hasItem(DEFAULT_XFH_MRAWOAD.doubleValue())))
            .andExpect(jsonPath("$.[*].rhcuagusEM").value(hasItem(DEFAULT_RHCUAGUS_EM.intValue())))
            .andExpect(jsonPath("$.[*].nnmuicgOII").value(hasItem(DEFAULT_NNMUICG_OII.intValue())))
            .andExpect(jsonPath("$.[*].cqCGPSOPJC").value(hasItem(DEFAULT_CQ_CGPSOPJC.intValue())))
            .andExpect(jsonPath("$.[*].ycWFMXX").value(hasItem(DEFAULT_YC_WFMXX.booleanValue())))
            .andExpect(jsonPath("$.[*].vIEFKCLJCN").value(hasItem(DEFAULT_V_IEFKCLJCN.booleanValue())))
            .andExpect(jsonPath("$.[*].ulorfvrzNGZQT").value(hasItem(sameInstant(DEFAULT_ULORFVRZ_NGZQT))))
            .andExpect(jsonPath("$.[*].sfbrwwuezNWHCMT").value(hasItem(DEFAULT_SFBRWWUEZ_NWHCMT.intValue())))
            .andExpect(jsonPath("$.[*].ysmxlujouDKMEIUUG").value(hasItem(DEFAULT_YSMXLUJOU_DKMEIUUG.doubleValue())))
            .andExpect(jsonPath("$.[*].bebpxFFA").value(hasItem(DEFAULT_BEBPX_FFA.toString())))
            .andExpect(jsonPath("$.[*].fjiePMF").value(hasItem(DEFAULT_FJIE_PMF.intValue())));
    }
    
    @Test
    @Transactional
    public void getJhi() throws Exception {
        // Initialize the database
        jhiRepository.saveAndFlush(jhi);

        // Get the jhi
        restJhiMockMvc.perform(get("/api/jhis/{id}", jhi.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(jhi.getId().intValue()))
            .andExpect(jsonPath("$.kuxgvrghgZWUVBAS").value(DEFAULT_KUXGVRGHG_ZWUVBAS.doubleValue()))
            .andExpect(jsonPath("$.cyoluqjxCCMPZM").value(DEFAULT_CYOLUQJX_CCMPZM.intValue()))
            .andExpect(jsonPath("$.cGHPVLNPHG").value(DEFAULT_C_GHPVLNPHG.booleanValue()))
            .andExpect(jsonPath("$.fnsunJGEXY").value(DEFAULT_FNSUN_JGEXY))
            .andExpect(jsonPath("$.xfhMRAWOAD").value(DEFAULT_XFH_MRAWOAD.doubleValue()))
            .andExpect(jsonPath("$.rhcuagusEM").value(DEFAULT_RHCUAGUS_EM.intValue()))
            .andExpect(jsonPath("$.nnmuicgOII").value(DEFAULT_NNMUICG_OII.intValue()))
            .andExpect(jsonPath("$.cqCGPSOPJC").value(DEFAULT_CQ_CGPSOPJC.intValue()))
            .andExpect(jsonPath("$.ycWFMXX").value(DEFAULT_YC_WFMXX.booleanValue()))
            .andExpect(jsonPath("$.vIEFKCLJCN").value(DEFAULT_V_IEFKCLJCN.booleanValue()))
            .andExpect(jsonPath("$.ulorfvrzNGZQT").value(sameInstant(DEFAULT_ULORFVRZ_NGZQT)))
            .andExpect(jsonPath("$.sfbrwwuezNWHCMT").value(DEFAULT_SFBRWWUEZ_NWHCMT.intValue()))
            .andExpect(jsonPath("$.ysmxlujouDKMEIUUG").value(DEFAULT_YSMXLUJOU_DKMEIUUG.doubleValue()))
            .andExpect(jsonPath("$.bebpxFFA").value(DEFAULT_BEBPX_FFA.toString()))
            .andExpect(jsonPath("$.fjiePMF").value(DEFAULT_FJIE_PMF.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingJhi() throws Exception {
        // Get the jhi
        restJhiMockMvc.perform(get("/api/jhis/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateJhi() throws Exception {
        // Initialize the database
        jhiService.save(jhi);

        int databaseSizeBeforeUpdate = jhiRepository.findAll().size();

        // Update the jhi
        Jhi updatedJhi = jhiRepository.findById(jhi.getId()).get();
        // Disconnect from session so that the updates on updatedJhi are not directly saved in db
        em.detach(updatedJhi);
        updatedJhi
            .kuxgvrghgZWUVBAS(UPDATED_KUXGVRGHG_ZWUVBAS)
            .cyoluqjxCCMPZM(UPDATED_CYOLUQJX_CCMPZM)
            .cGHPVLNPHG(UPDATED_C_GHPVLNPHG)
            .fnsunJGEXY(UPDATED_FNSUN_JGEXY)
            .xfhMRAWOAD(UPDATED_XFH_MRAWOAD)
            .rhcuagusEM(UPDATED_RHCUAGUS_EM)
            .nnmuicgOII(UPDATED_NNMUICG_OII)
            .cqCGPSOPJC(UPDATED_CQ_CGPSOPJC)
            .ycWFMXX(UPDATED_YC_WFMXX)
            .vIEFKCLJCN(UPDATED_V_IEFKCLJCN)
            .ulorfvrzNGZQT(UPDATED_ULORFVRZ_NGZQT)
            .sfbrwwuezNWHCMT(UPDATED_SFBRWWUEZ_NWHCMT)
            .ysmxlujouDKMEIUUG(UPDATED_YSMXLUJOU_DKMEIUUG)
            .bebpxFFA(UPDATED_BEBPX_FFA)
            .fjiePMF(UPDATED_FJIE_PMF);

        restJhiMockMvc.perform(put("/api/jhis")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedJhi)))
            .andExpect(status().isOk());

        // Validate the Jhi in the database
        List<Jhi> jhiList = jhiRepository.findAll();
        assertThat(jhiList).hasSize(databaseSizeBeforeUpdate);
        Jhi testJhi = jhiList.get(jhiList.size() - 1);
        assertThat(testJhi.getKuxgvrghgZWUVBAS()).isEqualTo(UPDATED_KUXGVRGHG_ZWUVBAS);
        assertThat(testJhi.getCyoluqjxCCMPZM()).isEqualTo(UPDATED_CYOLUQJX_CCMPZM);
        assertThat(testJhi.iscGHPVLNPHG()).isEqualTo(UPDATED_C_GHPVLNPHG);
        assertThat(testJhi.getFnsunJGEXY()).isEqualTo(UPDATED_FNSUN_JGEXY);
        assertThat(testJhi.getXfhMRAWOAD()).isEqualTo(UPDATED_XFH_MRAWOAD);
        assertThat(testJhi.getRhcuagusEM()).isEqualTo(UPDATED_RHCUAGUS_EM);
        assertThat(testJhi.getNnmuicgOII()).isEqualTo(UPDATED_NNMUICG_OII);
        assertThat(testJhi.getCqCGPSOPJC()).isEqualTo(UPDATED_CQ_CGPSOPJC);
        assertThat(testJhi.isYcWFMXX()).isEqualTo(UPDATED_YC_WFMXX);
        assertThat(testJhi.isvIEFKCLJCN()).isEqualTo(UPDATED_V_IEFKCLJCN);
        assertThat(testJhi.getUlorfvrzNGZQT()).isEqualTo(UPDATED_ULORFVRZ_NGZQT);
        assertThat(testJhi.getSfbrwwuezNWHCMT()).isEqualTo(UPDATED_SFBRWWUEZ_NWHCMT);
        assertThat(testJhi.getYsmxlujouDKMEIUUG()).isEqualTo(UPDATED_YSMXLUJOU_DKMEIUUG);
        assertThat(testJhi.getBebpxFFA()).isEqualTo(UPDATED_BEBPX_FFA);
        assertThat(testJhi.getFjiePMF()).isEqualTo(UPDATED_FJIE_PMF);
    }

    @Test
    @Transactional
    public void updateNonExistingJhi() throws Exception {
        int databaseSizeBeforeUpdate = jhiRepository.findAll().size();

        // Create the Jhi

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restJhiMockMvc.perform(put("/api/jhis")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(jhi)))
            .andExpect(status().isBadRequest());

        // Validate the Jhi in the database
        List<Jhi> jhiList = jhiRepository.findAll();
        assertThat(jhiList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteJhi() throws Exception {
        // Initialize the database
        jhiService.save(jhi);

        int databaseSizeBeforeDelete = jhiRepository.findAll().size();

        // Delete the jhi
        restJhiMockMvc.perform(delete("/api/jhis/{id}", jhi.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Jhi> jhiList = jhiRepository.findAll();
        assertThat(jhiList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Jhi.class);
        Jhi jhi1 = new Jhi();
        jhi1.setId(1L);
        Jhi jhi2 = new Jhi();
        jhi2.setId(jhi1.getId());
        assertThat(jhi1).isEqualTo(jhi2);
        jhi2.setId(2L);
        assertThat(jhi1).isNotEqualTo(jhi2);
        jhi1.setId(null);
        assertThat(jhi1).isNotEqualTo(jhi2);
    }
}
