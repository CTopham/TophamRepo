package grlmkb.wjw.vowri.bfkk.service;

import grlmkb.wjw.vowri.bfkk.domain.Sycdotfbx;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Sycdotfbx}.
 */
public interface SycdotfbxService {

    /**
     * Save a sycdotfbx.
     *
     * @param sycdotfbx the entity to save.
     * @return the persisted entity.
     */
    Sycdotfbx save(Sycdotfbx sycdotfbx);

    /**
     * Get all the sycdotfbxes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Sycdotfbx> findAll(Pageable pageable);


    /**
     * Get the "id" sycdotfbx.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Sycdotfbx> findOne(Long id);

    /**
     * Delete the "id" sycdotfbx.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
