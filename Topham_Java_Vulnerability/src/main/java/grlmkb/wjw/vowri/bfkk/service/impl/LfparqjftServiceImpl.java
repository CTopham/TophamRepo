package grlmkb.wjw.vowri.bfkk.service.impl;

import grlmkb.wjw.vowri.bfkk.service.LfparqjftService;
import grlmkb.wjw.vowri.bfkk.domain.Lfparqjft;
import grlmkb.wjw.vowri.bfkk.repository.LfparqjftRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Lfparqjft}.
 */
@Service
@Transactional
public class LfparqjftServiceImpl implements LfparqjftService {

    private final Logger log = LoggerFactory.getLogger(LfparqjftServiceImpl.class);

    private final LfparqjftRepository lfparqjftRepository;

    public LfparqjftServiceImpl(LfparqjftRepository lfparqjftRepository) {
        this.lfparqjftRepository = lfparqjftRepository;
    }

    /**
     * Save a lfparqjft.
     *
     * @param lfparqjft the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Lfparqjft save(Lfparqjft lfparqjft) {
        log.debug("Request to save Lfparqjft : {}", lfparqjft);
        return lfparqjftRepository.save(lfparqjft);
    }

    /**
     * Get all the lfparqjfts.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Lfparqjft> findAll(Pageable pageable) {
        log.debug("Request to get all Lfparqjfts");
        return lfparqjftRepository.findAll(pageable);
    }


    /**
     * Get one lfparqjft by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Lfparqjft> findOne(Long id) {
        log.debug("Request to get Lfparqjft : {}", id);
        return lfparqjftRepository.findById(id);
    }

    /**
     * Delete the lfparqjft by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Lfparqjft : {}", id);
        lfparqjftRepository.deleteById(id);
    }
}
