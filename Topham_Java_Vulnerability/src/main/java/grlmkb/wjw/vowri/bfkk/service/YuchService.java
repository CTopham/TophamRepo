package grlmkb.wjw.vowri.bfkk.service;

import grlmkb.wjw.vowri.bfkk.domain.Yuch;
import grlmkb.wjw.vowri.bfkk.repository.YuchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Yuch}.
 */
@Service
@Transactional
public class YuchService {

    private final Logger log = LoggerFactory.getLogger(YuchService.class);

    private final YuchRepository yuchRepository;

    public YuchService(YuchRepository yuchRepository) {
        this.yuchRepository = yuchRepository;
    }

    /**
     * Save a yuch.
     *
     * @param yuch the entity to save.
     * @return the persisted entity.
     */
    public Yuch save(Yuch yuch) {
        log.debug("Request to save Yuch : {}", yuch);
        return yuchRepository.save(yuch);
    }

    /**
     * Get all the yuches.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Yuch> findAll(Pageable pageable) {
        log.debug("Request to get all Yuches");
        return yuchRepository.findAll(pageable);
    }


    /**
     * Get one yuch by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Yuch> findOne(Long id) {
        log.debug("Request to get Yuch : {}", id);
        return yuchRepository.findById(id);
    }

    /**
     * Delete the yuch by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Yuch : {}", id);
        yuchRepository.deleteById(id);
    }
    

}
