package grlmkb.wjw.vowri.bfkk.service.impl;

import grlmkb.wjw.vowri.bfkk.service.RletexService;
import grlmkb.wjw.vowri.bfkk.domain.Rletex;
import grlmkb.wjw.vowri.bfkk.repository.RletexRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Rletex}.
 */
@Service
@Transactional
public class RletexServiceImpl implements RletexService {

    private final Logger log = LoggerFactory.getLogger(RletexServiceImpl.class);

    private final RletexRepository rletexRepository;

    public RletexServiceImpl(RletexRepository rletexRepository) {
        this.rletexRepository = rletexRepository;
    }

    /**
     * Save a rletex.
     *
     * @param rletex the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Rletex save(Rletex rletex) {
        log.debug("Request to save Rletex : {}", rletex);
        return rletexRepository.save(rletex);
    }

    /**
     * Get all the rletexes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Rletex> findAll(Pageable pageable) {
        log.debug("Request to get all Rletexes");
        return rletexRepository.findAll(pageable);
    }


    /**
     * Get one rletex by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Rletex> findOne(Long id) {
        log.debug("Request to get Rletex : {}", id);
        return rletexRepository.findById(id);
    }

    /**
     * Delete the rletex by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Rletex : {}", id);
        rletexRepository.deleteById(id);
    }
}
