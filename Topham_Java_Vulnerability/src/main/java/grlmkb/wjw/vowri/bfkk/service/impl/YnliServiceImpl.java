package grlmkb.wjw.vowri.bfkk.service.impl;

import grlmkb.wjw.vowri.bfkk.service.YnliService;
import grlmkb.wjw.vowri.bfkk.domain.Ynli;
import grlmkb.wjw.vowri.bfkk.repository.YnliRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Ynli}.
 */
@Service
@Transactional
public class YnliServiceImpl implements YnliService {

    private final Logger log = LoggerFactory.getLogger(YnliServiceImpl.class);

    private final YnliRepository ynliRepository;

    public YnliServiceImpl(YnliRepository ynliRepository) {
        this.ynliRepository = ynliRepository;
    }

    /**
     * Save a ynli.
     *
     * @param ynli the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Ynli save(Ynli ynli) {
        log.debug("Request to save Ynli : {}", ynli);
        return ynliRepository.save(ynli);
    }

    /**
     * Get all the ynlis.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Ynli> findAll(Pageable pageable) {
        log.debug("Request to get all Ynlis");
        return ynliRepository.findAll(pageable);
    }


    /**
     * Get one ynli by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Ynli> findOne(Long id) {
        log.debug("Request to get Ynli : {}", id);
        return ynliRepository.findById(id);
    }

    /**
     * Delete the ynli by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Ynli : {}", id);
        ynliRepository.deleteById(id);
    }
}
