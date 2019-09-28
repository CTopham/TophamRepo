package grlmkb.wjw.vowri.bfkk.service;

import grlmkb.wjw.vowri.bfkk.domain.Cwgkt;
import grlmkb.wjw.vowri.bfkk.repository.CwgktRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Cwgkt}.
 */
@Service
@Transactional
public class CwgktService {

    private final Logger log = LoggerFactory.getLogger(CwgktService.class);

    private final CwgktRepository cwgktRepository;

    public CwgktService(CwgktRepository cwgktRepository) {
        this.cwgktRepository = cwgktRepository;
    }

    /**
     * Save a cwgkt.
     *
     * @param cwgkt the entity to save.
     * @return the persisted entity.
     */
    public Cwgkt save(Cwgkt cwgkt) {
        log.debug("Request to save Cwgkt : {}", cwgkt);
        return cwgktRepository.save(cwgkt);
    }

    /**
     * Get all the cwgkts.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Cwgkt> findAll(Pageable pageable) {
        log.debug("Request to get all Cwgkts");
        return cwgktRepository.findAll(pageable);
    }


    /**
     * Get one cwgkt by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Cwgkt> findOne(Long id) {
        log.debug("Request to get Cwgkt : {}", id);
        return cwgktRepository.findById(id);
    }

    /**
     * Delete the cwgkt by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Cwgkt : {}", id);
        cwgktRepository.deleteById(id);
    }
}
