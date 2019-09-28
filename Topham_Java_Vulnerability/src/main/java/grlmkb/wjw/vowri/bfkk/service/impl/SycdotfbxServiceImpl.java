package grlmkb.wjw.vowri.bfkk.service.impl;

import grlmkb.wjw.vowri.bfkk.service.SycdotfbxService;
import grlmkb.wjw.vowri.bfkk.domain.Sycdotfbx;
import grlmkb.wjw.vowri.bfkk.repository.SycdotfbxRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Sycdotfbx}.
 */
@Service
@Transactional
public class SycdotfbxServiceImpl implements SycdotfbxService {

    private final Logger log = LoggerFactory.getLogger(SycdotfbxServiceImpl.class);

    private final SycdotfbxRepository sycdotfbxRepository;

    public SycdotfbxServiceImpl(SycdotfbxRepository sycdotfbxRepository) {
        this.sycdotfbxRepository = sycdotfbxRepository;
    }

    /**
     * Save a sycdotfbx.
     *
     * @param sycdotfbx the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Sycdotfbx save(Sycdotfbx sycdotfbx) {
        log.debug("Request to save Sycdotfbx : {}", sycdotfbx);
        return sycdotfbxRepository.save(sycdotfbx);
    }

    /**
     * Get all the sycdotfbxes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Sycdotfbx> findAll(Pageable pageable) {
        log.debug("Request to get all Sycdotfbxes");
        return sycdotfbxRepository.findAll(pageable);
    }


    /**
     * Get one sycdotfbx by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Sycdotfbx> findOne(Long id) {
        log.debug("Request to get Sycdotfbx : {}", id);
        return sycdotfbxRepository.findById(id);
    }

    /**
     * Delete the sycdotfbx by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Sycdotfbx : {}", id);
        sycdotfbxRepository.deleteById(id);
    }
}
