package grlmkb.wjw.vowri.bfkk.service.impl;

import grlmkb.wjw.vowri.bfkk.service.JsosxwzepsService;
import grlmkb.wjw.vowri.bfkk.domain.Jsosxwzeps;
import grlmkb.wjw.vowri.bfkk.repository.JsosxwzepsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Jsosxwzeps}.
 */
@Service
@Transactional
public class JsosxwzepsServiceImpl implements JsosxwzepsService {

    private final Logger log = LoggerFactory.getLogger(JsosxwzepsServiceImpl.class);

    private final JsosxwzepsRepository jsosxwzepsRepository;

    public JsosxwzepsServiceImpl(JsosxwzepsRepository jsosxwzepsRepository) {
        this.jsosxwzepsRepository = jsosxwzepsRepository;
    }

    /**
     * Save a jsosxwzeps.
     *
     * @param jsosxwzeps the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Jsosxwzeps save(Jsosxwzeps jsosxwzeps) {
        log.debug("Request to save Jsosxwzeps : {}", jsosxwzeps);
        return jsosxwzepsRepository.save(jsosxwzeps);
    }

    /**
     * Get all the jsosxwzeps.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Jsosxwzeps> findAll(Pageable pageable) {
        log.debug("Request to get all Jsosxwzeps");
        return jsosxwzepsRepository.findAll(pageable);
    }


    /**
     * Get one jsosxwzeps by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Jsosxwzeps> findOne(Long id) {
        log.debug("Request to get Jsosxwzeps : {}", id);
        return jsosxwzepsRepository.findById(id);
    }

    /**
     * Delete the jsosxwzeps by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Jsosxwzeps : {}", id);
        jsosxwzepsRepository.deleteById(id);
    }
}
