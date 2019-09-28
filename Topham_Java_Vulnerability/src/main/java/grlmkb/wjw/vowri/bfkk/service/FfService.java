package grlmkb.wjw.vowri.bfkk.service;

import grlmkb.wjw.vowri.bfkk.domain.Ff;
import grlmkb.wjw.vowri.bfkk.repository.FfRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Ff}.
 */
@Service
@Transactional
public class FfService {

    private final Logger log = LoggerFactory.getLogger(FfService.class);

    private final FfRepository ffRepository;

    public FfService(FfRepository ffRepository) {
        this.ffRepository = ffRepository;
    }

    /**
     * Save a ff.
     *
     * @param ff the entity to save.
     * @return the persisted entity.
     */
    public Ff save(Ff ff) {
        log.debug("Request to save Ff : {}", ff);
        return ffRepository.save(ff);
    }

    /**
     * Get all the ffs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Ff> findAll(Pageable pageable) {
        log.debug("Request to get all Ffs");
        return ffRepository.findAll(pageable);
    }


    /**
     * Get one ff by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Ff> findOne(Long id) {
        log.debug("Request to get Ff : {}", id);
        return ffRepository.findById(id);
    }

    /**
     * Delete the ff by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Ff : {}", id);
        ffRepository.deleteById(id);
    }
}
