package grlmkb.wjw.vowri.bfkk.service;

import grlmkb.wjw.vowri.bfkk.domain.Cf;
import grlmkb.wjw.vowri.bfkk.repository.CfRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Cf}.
 */
@Service
@Transactional
public class CfService {

    private final Logger log = LoggerFactory.getLogger(CfService.class);

    private final CfRepository cfRepository;

    public CfService(CfRepository cfRepository) {
        this.cfRepository = cfRepository;
    }

    /**
     * Save a cf.
     *
     * @param cf the entity to save.
     * @return the persisted entity.
     */
    public Cf save(Cf cf) {
        log.debug("Request to save Cf : {}", cf);
        return cfRepository.save(cf);
    }

    /**
     * Get all the cfs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Cf> findAll(Pageable pageable) {
        log.debug("Request to get all Cfs");
        return cfRepository.findAll(pageable);
    }


    /**
     * Get one cf by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Cf> findOne(Long id) {
        log.debug("Request to get Cf : {}", id);
        return cfRepository.findById(id);
    }

    /**
     * Delete the cf by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Cf : {}", id);
        cfRepository.deleteById(id);
    }
}
