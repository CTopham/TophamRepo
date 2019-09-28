package grlmkb.wjw.vowri.bfkk.service;

import grlmkb.wjw.vowri.bfkk.domain.Lfparqjft;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Lfparqjft}.
 */
public interface LfparqjftService {

    /**
     * Save a lfparqjft.
     *
     * @param lfparqjft the entity to save.
     * @return the persisted entity.
     */
    Lfparqjft save(Lfparqjft lfparqjft);

    /**
     * Get all the lfparqjfts.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Lfparqjft> findAll(Pageable pageable);


    /**
     * Get the "id" lfparqjft.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Lfparqjft> findOne(Long id);

    /**
     * Delete the "id" lfparqjft.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
