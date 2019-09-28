package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.domain.Ff;
import grlmkb.wjw.vowri.bfkk.service.FfService;
import grlmkb.wjw.vowri.bfkk.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link grlmkb.wjw.vowri.bfkk.domain.Ff}.
 */
@RestController
@RequestMapping("/api")
public class FfResource {

    private final Logger log = LoggerFactory.getLogger(FfResource.class);

    private static final String ENTITY_NAME = "ff";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FfService ffService;

    public FfResource(FfService ffService) {
        this.ffService = ffService;
    }

    /**
     * {@code POST  /ffs} : Create a new ff.
     *
     * @param ff the ff to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new ff, or with status {@code 400 (Bad Request)} if the ff has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ffs")
    public ResponseEntity<Ff> createFf(@RequestBody Ff ff) throws URISyntaxException {
        log.debug("REST request to save Ff : {}", ff);
        if (ff.getId() != null) {
            throw new BadRequestAlertException("A new ff cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Ff result = ffService.save(ff);
        return ResponseEntity.created(new URI("/api/ffs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ffs} : Updates an existing ff.
     *
     * @param ff the ff to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated ff,
     * or with status {@code 400 (Bad Request)} if the ff is not valid,
     * or with status {@code 500 (Internal Server Error)} if the ff couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ffs")
    public ResponseEntity<Ff> updateFf(@RequestBody Ff ff) throws URISyntaxException {
        log.debug("REST request to update Ff : {}", ff);
        if (ff.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Ff result = ffService.save(ff);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, ff.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /ffs} : get all the ffs.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of ffs in body.
     */
    @GetMapping("/ffs")
    public ResponseEntity<List<Ff>> getAllFfs(Pageable pageable) {
        log.debug("REST request to get a page of Ffs");
        Page<Ff> page = ffService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ffs/:id} : get the "id" ff.
     *
     * @param id the id of the ff to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the ff, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ffs/{id}")
    public ResponseEntity<Ff> getFf(@PathVariable Long id) {
        log.debug("REST request to get Ff : {}", id);
        Optional<Ff> ff = ffService.findOne(id);
        return ResponseUtil.wrapOrNotFound(ff);
    }

    /**
     * {@code DELETE  /ffs/:id} : delete the "id" ff.
     *
     * @param id the id of the ff to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ffs/{id}")
    public ResponseEntity<Void> deleteFf(@PathVariable Long id) {
        log.debug("REST request to delete Ff : {}", id);
        ffService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
