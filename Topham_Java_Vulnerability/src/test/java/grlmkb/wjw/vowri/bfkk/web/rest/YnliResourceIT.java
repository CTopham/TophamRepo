package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.ZjqabApp;
import grlmkb.wjw.vowri.bfkk.domain.Ynli;
import grlmkb.wjw.vowri.bfkk.repository.YnliRepository;
import grlmkb.wjw.vowri.bfkk.service.YnliService;
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
import java.util.List;

import static grlmkb.wjw.vowri.bfkk.web.rest.TestUtil.sameInstant;
import static grlmkb.wjw.vowri.bfkk.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link YnliResource} REST controller.
 */
@SpringBootTest(classes = ZjqabApp.class)
public class YnliResourceIT {

    private static final ZonedDateTime DEFAULT_YZAJRX_IAYDPK = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_YZAJRX_IAYDPK = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_YZAJRX_IAYDPK = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    private static final Float DEFAULT_FGVSTXXHK_BMQOIS = 1F;
    private static final Float UPDATED_FGVSTXXHK_BMQOIS = 2F;
    private static final Float SMALLER_FGVSTXXHK_BMQOIS = 1F - 1F;

    private static final BigDecimal DEFAULT_YHBMPKBH_BYCNY = new BigDecimal(1);
    private static final BigDecimal UPDATED_YHBMPKBH_BYCNY = new BigDecimal(2);
    private static final BigDecimal SMALLER_YHBMPKBH_BYCNY = new BigDecimal(1 - 1);

    private static final LocalDate DEFAULT_MNG_KJLIM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_MNG_KJLIM = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_MNG_KJLIM = LocalDate.ofEpochDay(-1L);

    private static final LocalDate DEFAULT_QBAF_FJWJZSBT = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_QBAF_FJWJZSBT = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_QBAF_FJWJZSBT = LocalDate.ofEpochDay(-1L);

    private static final Float DEFAULT_BXOQKPP_JHLG = 1F;
    private static final Float UPDATED_BXOQKPP_JHLG = 2F;
    private static final Float SMALLER_BXOQKPP_JHLG = 1F - 1F;

    private static final Integer DEFAULT_SM_N = 1;
    private static final Integer UPDATED_SM_N = 2;
    private static final Integer SMALLER_SM_N = 1 - 1;

    private static final LocalDate DEFAULT_MRPZRYWO_EQQJOCFN = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_MRPZRYWO_EQQJOCFN = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_MRPZRYWO_EQQJOCFN = LocalDate.ofEpochDay(-1L);

    private static final Boolean DEFAULT_AN_PRUY = false;
    private static final Boolean UPDATED_AN_PRUY = true;

    private static final LocalDate DEFAULT_RMWUPKGMX_EJPUWYXCD = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_RMWUPKGMX_EJPUWYXCD = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_RMWUPKGMX_EJPUWYXCD = LocalDate.ofEpochDay(-1L);

    private static final String DEFAULT_QSNXSIHT_ZPGGTPL = "AAAAAAAAAA";
    private static final String UPDATED_QSNXSIHT_ZPGGTPL = "BBBBBBBBBB";

    private static final Integer DEFAULT_FAY_ZWWF = 1;
    private static final Integer UPDATED_FAY_ZWWF = 2;
    private static final Integer SMALLER_FAY_ZWWF = 1 - 1;

    private static final ZonedDateTime DEFAULT_O_IUPEEOQW = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_O_IUPEEOQW = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_O_IUPEEOQW = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    private static final String DEFAULT_EXIC_FFTTM = "AAAAAAAAAA";
    private static final String UPDATED_EXIC_FFTTM = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_HRLUHF_DTNWH = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_HRLUHF_DTNWH = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);
    private static final ZonedDateTime SMALLER_HRLUHF_DTNWH = ZonedDateTime.ofInstant(Instant.ofEpochMilli(-1L), ZoneOffset.UTC);

    private static final LocalDate DEFAULT_ERW_TLH = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_ERW_TLH = LocalDate.now(ZoneId.systemDefault());
    private static final LocalDate SMALLER_ERW_TLH = LocalDate.ofEpochDay(-1L);

    @Autowired
    private YnliRepository ynliRepository;

    @Autowired
    private YnliService ynliService;

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

    private MockMvc restYnliMockMvc;

    private Ynli ynli;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final YnliResource ynliResource = new YnliResource(ynliService);
        this.restYnliMockMvc = MockMvcBuilders.standaloneSetup(ynliResource)
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
    public static Ynli createEntity(EntityManager em) {
        Ynli ynli = new Ynli()
            .yzajrxIAYDPK(DEFAULT_YZAJRX_IAYDPK)
            .fgvstxxhkBMQOIS(DEFAULT_FGVSTXXHK_BMQOIS)
            .yhbmpkbhBYCNY(DEFAULT_YHBMPKBH_BYCNY)
            .mngKJLIM(DEFAULT_MNG_KJLIM)
            .qbafFJWJZSBT(DEFAULT_QBAF_FJWJZSBT)
            .bxoqkppJHLG(DEFAULT_BXOQKPP_JHLG)
            .smN(DEFAULT_SM_N)
            .mrpzrywoEQQJOCFN(DEFAULT_MRPZRYWO_EQQJOCFN)
            .anPRUY(DEFAULT_AN_PRUY)
            .rmwupkgmxEJPUWYXCD(DEFAULT_RMWUPKGMX_EJPUWYXCD)
            .qsnxsihtZPGGTPL(DEFAULT_QSNXSIHT_ZPGGTPL)
            .fayZWWF(DEFAULT_FAY_ZWWF)
            .oIUPEEOQW(DEFAULT_O_IUPEEOQW)
            .exicFFTTM(DEFAULT_EXIC_FFTTM)
            .hrluhfDTNWH(DEFAULT_HRLUHF_DTNWH)
            .erwTLH(DEFAULT_ERW_TLH);
        return ynli;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Ynli createUpdatedEntity(EntityManager em) {
        Ynli ynli = new Ynli()
            .yzajrxIAYDPK(UPDATED_YZAJRX_IAYDPK)
            .fgvstxxhkBMQOIS(UPDATED_FGVSTXXHK_BMQOIS)
            .yhbmpkbhBYCNY(UPDATED_YHBMPKBH_BYCNY)
            .mngKJLIM(UPDATED_MNG_KJLIM)
            .qbafFJWJZSBT(UPDATED_QBAF_FJWJZSBT)
            .bxoqkppJHLG(UPDATED_BXOQKPP_JHLG)
            .smN(UPDATED_SM_N)
            .mrpzrywoEQQJOCFN(UPDATED_MRPZRYWO_EQQJOCFN)
            .anPRUY(UPDATED_AN_PRUY)
            .rmwupkgmxEJPUWYXCD(UPDATED_RMWUPKGMX_EJPUWYXCD)
            .qsnxsihtZPGGTPL(UPDATED_QSNXSIHT_ZPGGTPL)
            .fayZWWF(UPDATED_FAY_ZWWF)
            .oIUPEEOQW(UPDATED_O_IUPEEOQW)
            .exicFFTTM(UPDATED_EXIC_FFTTM)
            .hrluhfDTNWH(UPDATED_HRLUHF_DTNWH)
            .erwTLH(UPDATED_ERW_TLH);
        return ynli;
    }

    @BeforeEach
    public void initTest() {
        ynli = createEntity(em);
    }

    @Test
    @Transactional
    public void createYnli() throws Exception {
        int databaseSizeBeforeCreate = ynliRepository.findAll().size();

        // Create the Ynli
        restYnliMockMvc.perform(post("/api/ynlis")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ynli)))
            .andExpect(status().isCreated());

        // Validate the Ynli in the database
        List<Ynli> ynliList = ynliRepository.findAll();
        assertThat(ynliList).hasSize(databaseSizeBeforeCreate + 1);
        Ynli testYnli = ynliList.get(ynliList.size() - 1);
        assertThat(testYnli.getYzajrxIAYDPK()).isEqualTo(DEFAULT_YZAJRX_IAYDPK);
        assertThat(testYnli.getFgvstxxhkBMQOIS()).isEqualTo(DEFAULT_FGVSTXXHK_BMQOIS);
        assertThat(testYnli.getYhbmpkbhBYCNY()).isEqualTo(DEFAULT_YHBMPKBH_BYCNY);
        assertThat(testYnli.getMngKJLIM()).isEqualTo(DEFAULT_MNG_KJLIM);
        assertThat(testYnli.getQbafFJWJZSBT()).isEqualTo(DEFAULT_QBAF_FJWJZSBT);
        assertThat(testYnli.getBxoqkppJHLG()).isEqualTo(DEFAULT_BXOQKPP_JHLG);
        assertThat(testYnli.getSmN()).isEqualTo(DEFAULT_SM_N);
        assertThat(testYnli.getMrpzrywoEQQJOCFN()).isEqualTo(DEFAULT_MRPZRYWO_EQQJOCFN);
        assertThat(testYnli.isAnPRUY()).isEqualTo(DEFAULT_AN_PRUY);
        assertThat(testYnli.getRmwupkgmxEJPUWYXCD()).isEqualTo(DEFAULT_RMWUPKGMX_EJPUWYXCD);
        assertThat(testYnli.getQsnxsihtZPGGTPL()).isEqualTo(DEFAULT_QSNXSIHT_ZPGGTPL);
        assertThat(testYnli.getFayZWWF()).isEqualTo(DEFAULT_FAY_ZWWF);
        assertThat(testYnli.getoIUPEEOQW()).isEqualTo(DEFAULT_O_IUPEEOQW);
        assertThat(testYnli.getExicFFTTM()).isEqualTo(DEFAULT_EXIC_FFTTM);
        assertThat(testYnli.getHrluhfDTNWH()).isEqualTo(DEFAULT_HRLUHF_DTNWH);
        assertThat(testYnli.getErwTLH()).isEqualTo(DEFAULT_ERW_TLH);
    }

    @Test
    @Transactional
    public void createYnliWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = ynliRepository.findAll().size();

        // Create the Ynli with an existing ID
        ynli.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restYnliMockMvc.perform(post("/api/ynlis")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ynli)))
            .andExpect(status().isBadRequest());

        // Validate the Ynli in the database
        List<Ynli> ynliList = ynliRepository.findAll();
        assertThat(ynliList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllYnlis() throws Exception {
        // Initialize the database
        ynliRepository.saveAndFlush(ynli);

        // Get all the ynliList
        restYnliMockMvc.perform(get("/api/ynlis?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(ynli.getId().intValue())))
            .andExpect(jsonPath("$.[*].yzajrxIAYDPK").value(hasItem(sameInstant(DEFAULT_YZAJRX_IAYDPK))))
            .andExpect(jsonPath("$.[*].fgvstxxhkBMQOIS").value(hasItem(DEFAULT_FGVSTXXHK_BMQOIS.doubleValue())))
            .andExpect(jsonPath("$.[*].yhbmpkbhBYCNY").value(hasItem(DEFAULT_YHBMPKBH_BYCNY.intValue())))
            .andExpect(jsonPath("$.[*].mngKJLIM").value(hasItem(DEFAULT_MNG_KJLIM.toString())))
            .andExpect(jsonPath("$.[*].qbafFJWJZSBT").value(hasItem(DEFAULT_QBAF_FJWJZSBT.toString())))
            .andExpect(jsonPath("$.[*].bxoqkppJHLG").value(hasItem(DEFAULT_BXOQKPP_JHLG.doubleValue())))
            .andExpect(jsonPath("$.[*].smN").value(hasItem(DEFAULT_SM_N)))
            .andExpect(jsonPath("$.[*].mrpzrywoEQQJOCFN").value(hasItem(DEFAULT_MRPZRYWO_EQQJOCFN.toString())))
            .andExpect(jsonPath("$.[*].anPRUY").value(hasItem(DEFAULT_AN_PRUY.booleanValue())))
            .andExpect(jsonPath("$.[*].rmwupkgmxEJPUWYXCD").value(hasItem(DEFAULT_RMWUPKGMX_EJPUWYXCD.toString())))
            .andExpect(jsonPath("$.[*].qsnxsihtZPGGTPL").value(hasItem(DEFAULT_QSNXSIHT_ZPGGTPL.toString())))
            .andExpect(jsonPath("$.[*].fayZWWF").value(hasItem(DEFAULT_FAY_ZWWF)))
            .andExpect(jsonPath("$.[*].oIUPEEOQW").value(hasItem(sameInstant(DEFAULT_O_IUPEEOQW))))
            .andExpect(jsonPath("$.[*].exicFFTTM").value(hasItem(DEFAULT_EXIC_FFTTM.toString())))
            .andExpect(jsonPath("$.[*].hrluhfDTNWH").value(hasItem(sameInstant(DEFAULT_HRLUHF_DTNWH))))
            .andExpect(jsonPath("$.[*].erwTLH").value(hasItem(DEFAULT_ERW_TLH.toString())));
    }
    
    @Test
    @Transactional
    public void getYnli() throws Exception {
        // Initialize the database
        ynliRepository.saveAndFlush(ynli);

        // Get the ynli
        restYnliMockMvc.perform(get("/api/ynlis/{id}", ynli.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(ynli.getId().intValue()))
            .andExpect(jsonPath("$.yzajrxIAYDPK").value(sameInstant(DEFAULT_YZAJRX_IAYDPK)))
            .andExpect(jsonPath("$.fgvstxxhkBMQOIS").value(DEFAULT_FGVSTXXHK_BMQOIS.doubleValue()))
            .andExpect(jsonPath("$.yhbmpkbhBYCNY").value(DEFAULT_YHBMPKBH_BYCNY.intValue()))
            .andExpect(jsonPath("$.mngKJLIM").value(DEFAULT_MNG_KJLIM.toString()))
            .andExpect(jsonPath("$.qbafFJWJZSBT").value(DEFAULT_QBAF_FJWJZSBT.toString()))
            .andExpect(jsonPath("$.bxoqkppJHLG").value(DEFAULT_BXOQKPP_JHLG.doubleValue()))
            .andExpect(jsonPath("$.smN").value(DEFAULT_SM_N))
            .andExpect(jsonPath("$.mrpzrywoEQQJOCFN").value(DEFAULT_MRPZRYWO_EQQJOCFN.toString()))
            .andExpect(jsonPath("$.anPRUY").value(DEFAULT_AN_PRUY.booleanValue()))
            .andExpect(jsonPath("$.rmwupkgmxEJPUWYXCD").value(DEFAULT_RMWUPKGMX_EJPUWYXCD.toString()))
            .andExpect(jsonPath("$.qsnxsihtZPGGTPL").value(DEFAULT_QSNXSIHT_ZPGGTPL.toString()))
            .andExpect(jsonPath("$.fayZWWF").value(DEFAULT_FAY_ZWWF))
            .andExpect(jsonPath("$.oIUPEEOQW").value(sameInstant(DEFAULT_O_IUPEEOQW)))
            .andExpect(jsonPath("$.exicFFTTM").value(DEFAULT_EXIC_FFTTM.toString()))
            .andExpect(jsonPath("$.hrluhfDTNWH").value(sameInstant(DEFAULT_HRLUHF_DTNWH)))
            .andExpect(jsonPath("$.erwTLH").value(DEFAULT_ERW_TLH.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingYnli() throws Exception {
        // Get the ynli
        restYnliMockMvc.perform(get("/api/ynlis/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateYnli() throws Exception {
        // Initialize the database
        ynliService.save(ynli);

        int databaseSizeBeforeUpdate = ynliRepository.findAll().size();

        // Update the ynli
        Ynli updatedYnli = ynliRepository.findById(ynli.getId()).get();
        // Disconnect from session so that the updates on updatedYnli are not directly saved in db
        em.detach(updatedYnli);
        updatedYnli
            .yzajrxIAYDPK(UPDATED_YZAJRX_IAYDPK)
            .fgvstxxhkBMQOIS(UPDATED_FGVSTXXHK_BMQOIS)
            .yhbmpkbhBYCNY(UPDATED_YHBMPKBH_BYCNY)
            .mngKJLIM(UPDATED_MNG_KJLIM)
            .qbafFJWJZSBT(UPDATED_QBAF_FJWJZSBT)
            .bxoqkppJHLG(UPDATED_BXOQKPP_JHLG)
            .smN(UPDATED_SM_N)
            .mrpzrywoEQQJOCFN(UPDATED_MRPZRYWO_EQQJOCFN)
            .anPRUY(UPDATED_AN_PRUY)
            .rmwupkgmxEJPUWYXCD(UPDATED_RMWUPKGMX_EJPUWYXCD)
            .qsnxsihtZPGGTPL(UPDATED_QSNXSIHT_ZPGGTPL)
            .fayZWWF(UPDATED_FAY_ZWWF)
            .oIUPEEOQW(UPDATED_O_IUPEEOQW)
            .exicFFTTM(UPDATED_EXIC_FFTTM)
            .hrluhfDTNWH(UPDATED_HRLUHF_DTNWH)
            .erwTLH(UPDATED_ERW_TLH);

        restYnliMockMvc.perform(put("/api/ynlis")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedYnli)))
            .andExpect(status().isOk());

        // Validate the Ynli in the database
        List<Ynli> ynliList = ynliRepository.findAll();
        assertThat(ynliList).hasSize(databaseSizeBeforeUpdate);
        Ynli testYnli = ynliList.get(ynliList.size() - 1);
        assertThat(testYnli.getYzajrxIAYDPK()).isEqualTo(UPDATED_YZAJRX_IAYDPK);
        assertThat(testYnli.getFgvstxxhkBMQOIS()).isEqualTo(UPDATED_FGVSTXXHK_BMQOIS);
        assertThat(testYnli.getYhbmpkbhBYCNY()).isEqualTo(UPDATED_YHBMPKBH_BYCNY);
        assertThat(testYnli.getMngKJLIM()).isEqualTo(UPDATED_MNG_KJLIM);
        assertThat(testYnli.getQbafFJWJZSBT()).isEqualTo(UPDATED_QBAF_FJWJZSBT);
        assertThat(testYnli.getBxoqkppJHLG()).isEqualTo(UPDATED_BXOQKPP_JHLG);
        assertThat(testYnli.getSmN()).isEqualTo(UPDATED_SM_N);
        assertThat(testYnli.getMrpzrywoEQQJOCFN()).isEqualTo(UPDATED_MRPZRYWO_EQQJOCFN);
        assertThat(testYnli.isAnPRUY()).isEqualTo(UPDATED_AN_PRUY);
        assertThat(testYnli.getRmwupkgmxEJPUWYXCD()).isEqualTo(UPDATED_RMWUPKGMX_EJPUWYXCD);
        assertThat(testYnli.getQsnxsihtZPGGTPL()).isEqualTo(UPDATED_QSNXSIHT_ZPGGTPL);
        assertThat(testYnli.getFayZWWF()).isEqualTo(UPDATED_FAY_ZWWF);
        assertThat(testYnli.getoIUPEEOQW()).isEqualTo(UPDATED_O_IUPEEOQW);
        assertThat(testYnli.getExicFFTTM()).isEqualTo(UPDATED_EXIC_FFTTM);
        assertThat(testYnli.getHrluhfDTNWH()).isEqualTo(UPDATED_HRLUHF_DTNWH);
        assertThat(testYnli.getErwTLH()).isEqualTo(UPDATED_ERW_TLH);
    }

    @Test
    @Transactional
    public void updateNonExistingYnli() throws Exception {
        int databaseSizeBeforeUpdate = ynliRepository.findAll().size();

        // Create the Ynli

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restYnliMockMvc.perform(put("/api/ynlis")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(ynli)))
            .andExpect(status().isBadRequest());

        // Validate the Ynli in the database
        List<Ynli> ynliList = ynliRepository.findAll();
        assertThat(ynliList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteYnli() throws Exception {
        // Initialize the database
        ynliService.save(ynli);

        int databaseSizeBeforeDelete = ynliRepository.findAll().size();

        // Delete the ynli
        restYnliMockMvc.perform(delete("/api/ynlis/{id}", ynli.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Ynli> ynliList = ynliRepository.findAll();
        assertThat(ynliList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Ynli.class);
        Ynli ynli1 = new Ynli();
        ynli1.setId(1L);
        Ynli ynli2 = new Ynli();
        ynli2.setId(ynli1.getId());
        assertThat(ynli1).isEqualTo(ynli2);
        ynli2.setId(2L);
        assertThat(ynli1).isNotEqualTo(ynli2);
        ynli1.setId(null);
        assertThat(ynli1).isNotEqualTo(ynli2);
    }
}
