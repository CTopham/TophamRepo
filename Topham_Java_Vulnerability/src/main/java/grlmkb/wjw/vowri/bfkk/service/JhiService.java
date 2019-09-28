package grlmkb.wjw.vowri.bfkk.service;

import grlmkb.wjw.vowri.bfkk.domain.Jhi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Jhi}.
 */
public interface JhiService {

    /**
     * Save a jhi.
     *
     * @param jhi the entity to save.
     * @return the persisted entity.
     */
    Jhi save(Jhi jhi);

    /**
     * Get all the jhis.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Jhi> findAll(Pageable pageable);


    /**
     * Get the "id" jhi.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Jhi> findOne(Long id);

    /**
     * Delete the "id" jhi.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
