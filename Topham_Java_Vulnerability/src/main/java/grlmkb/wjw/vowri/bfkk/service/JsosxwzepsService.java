package grlmkb.wjw.vowri.bfkk.service;

import grlmkb.wjw.vowri.bfkk.domain.Jsosxwzeps;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link Jsosxwzeps}.
 */
public interface JsosxwzepsService {

    /**
     * Save a jsosxwzeps.
     *
     * @param jsosxwzeps the entity to save.
     * @return the persisted entity.
     */
    Jsosxwzeps save(Jsosxwzeps jsosxwzeps);

    /**
     * Get all the jsosxwzeps.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Jsosxwzeps> findAll(Pageable pageable);


    /**
     * Get the "id" jsosxwzeps.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Jsosxwzeps> findOne(Long id);

    /**
     * Delete the "id" jsosxwzeps.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
