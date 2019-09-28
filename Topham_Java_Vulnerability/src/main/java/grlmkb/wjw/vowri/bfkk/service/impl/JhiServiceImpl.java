package grlmkb.wjw.vowri.bfkk.service.impl;

import grlmkb.wjw.vowri.bfkk.service.JhiService;
import grlmkb.wjw.vowri.bfkk.domain.Jhi;
import grlmkb.wjw.vowri.bfkk.repository.JhiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Jhi}.
 */
@Service
@Transactional
public class JhiServiceImpl implements JhiService {

    private final Logger log = LoggerFactory.getLogger(JhiServiceImpl.class);

    private final JhiRepository jhiRepository;

    public JhiServiceImpl(JhiRepository jhiRepository) {
        this.jhiRepository = jhiRepository;
    }

    /**
     * Save a jhi.
     *
     * @param jhi the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Jhi save(Jhi jhi) {
        log.debug("Request to save Jhi : {}", jhi);
        return jhiRepository.save(jhi);
    }

    /**
     * Get all the jhis.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Jhi> findAll(Pageable pageable) {
        log.debug("Request to get all Jhis");
        return jhiRepository.findAll(pageable);
    }


    /**
     * Get one jhi by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Jhi> findOne(Long id) {
        log.debug("Request to get Jhi : {}", id);
        return jhiRepository.findById(id);
    }

    /**
     * Delete the jhi by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Jhi : {}", id);
        jhiRepository.deleteById(id);
    }
}
