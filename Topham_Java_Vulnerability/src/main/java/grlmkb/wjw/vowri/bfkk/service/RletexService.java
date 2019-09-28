package grlmkb.wjw.vowri.bfkk.service;

import grlmkb.wjw.vowri.bfkk.domain.Rletex;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Rletex}.
 */
public interface RletexService {

    /**
     * Save a rletex.
     *
     * @param rletex the entity to save.
     * @return the persisted entity.
     */
    Rletex save(Rletex rletex);

    /**
     * Get all the rletexes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Rletex> findAll(Pageable pageable);


    /**
     * Get the "id" rletex.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Rletex> findOne(Long id);

    /**
     * Delete the "id" rletex.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
