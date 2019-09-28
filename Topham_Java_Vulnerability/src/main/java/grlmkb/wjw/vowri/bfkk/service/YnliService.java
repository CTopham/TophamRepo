package grlmkb.wjw.vowri.bfkk.service;

import grlmkb.wjw.vowri.bfkk.domain.Ynli;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Ynli}.
 */
public interface YnliService {

    /**
     * Save a ynli.
     *
     * @param ynli the entity to save.
     * @return the persisted entity.
     */
    Ynli save(Ynli ynli);

    /**
     * Get all the ynlis.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Ynli> findAll(Pageable pageable);


    /**
     * Get the "id" ynli.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Ynli> findOne(Long id);

    /**
     * Delete the "id" ynli.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
