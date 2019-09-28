package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.domain.Ynli;
import grlmkb.wjw.vowri.bfkk.service.YnliService;
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
 * REST controller for managing {@link grlmkb.wjw.vowri.bfkk.domain.Ynli}.
 */
@RestController
@RequestMapping("/api")
public class YnliResource {

    private final Logger log = LoggerFactory.getLogger(YnliResource.class);

    private static final String ENTITY_NAME = "ynli";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final YnliService ynliService;

    public YnliResource(YnliService ynliService) {
        this.ynliService = ynliService;
    }

    /**
     * {@code POST  /ynlis} : Create a new ynli.
     *
     * @param ynli the ynli to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new ynli, or with status {@code 400 (Bad Request)} if the ynli has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/ynlis")
    public ResponseEntity<Ynli> createYnli(@RequestBody Ynli ynli) throws URISyntaxException {
        log.debug("REST request to save Ynli : {}", ynli);
        if (ynli.getId() != null) {
            throw new BadRequestAlertException("A new ynli cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Ynli result = ynliService.save(ynli);
        return ResponseEntity.created(new URI("/api/ynlis/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /ynlis} : Updates an existing ynli.
     *
     * @param ynli the ynli to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated ynli,
     * or with status {@code 400 (Bad Request)} if the ynli is not valid,
     * or with status {@code 500 (Internal Server Error)} if the ynli couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/ynlis")
    public ResponseEntity<Ynli> updateYnli(@RequestBody Ynli ynli) throws URISyntaxException {
        log.debug("REST request to update Ynli : {}", ynli);
        if (ynli.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Ynli result = ynliService.save(ynli);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, ynli.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /ynlis} : get all the ynlis.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of ynlis in body.
     */
    @GetMapping("/ynlis")
    public ResponseEntity<List<Ynli>> getAllYnlis(Pageable pageable) {
        log.debug("REST request to get a page of Ynlis");
        Page<Ynli> page = ynliService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /ynlis/:id} : get the "id" ynli.
     *
     * @param id the id of the ynli to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the ynli, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/ynlis/{id}")
    public ResponseEntity<Ynli> getYnli(@PathVariable Long id) {
        log.debug("REST request to get Ynli : {}", id);
        Optional<Ynli> ynli = ynliService.findOne(id);
        return ResponseUtil.wrapOrNotFound(ynli);
    }

    /**
     * {@code DELETE  /ynlis/:id} : delete the "id" ynli.
     *
     * @param id the id of the ynli to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/ynlis/{id}")
    public ResponseEntity<Void> deleteYnli(@PathVariable Long id) {
        log.debug("REST request to delete Ynli : {}", id);
        ynliService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
