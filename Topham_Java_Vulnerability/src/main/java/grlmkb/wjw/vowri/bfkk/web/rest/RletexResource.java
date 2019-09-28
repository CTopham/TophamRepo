package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.domain.Rletex;
import grlmkb.wjw.vowri.bfkk.service.RletexService;
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
import org.springframework.http.MediaType;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link grlmkb.wjw.vowri.bfkk.domain.Rletex}.
 */
@RestController
@RequestMapping("/api")
public class RletexResource {

    private final Logger log = LoggerFactory.getLogger(RletexResource.class);

    private static final String ENTITY_NAME = "rletex";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RletexService rletexService;

    public RletexResource(RletexService rletexService) {
        this.rletexService = rletexService;
    }

    /**
     * {@code POST  /rletexes} : Create a new rletex.
     *
     * @param rletex the rletex to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new rletex, or with status {@code 400 (Bad Request)} if the rletex has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/rletexes")
    public ResponseEntity<Rletex> createRletex(@RequestBody Rletex rletex) throws URISyntaxException {
        log.debug("REST request to save Rletex : {}", rletex);
        if (rletex.getId() != null) {
            throw new BadRequestAlertException("A new rletex cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Rletex result = rletexService.save(rletex);
        return ResponseEntity.created(new URI("/api/rletexes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }
    
  
    /**
     * {@code PUT  /rletexes} : Updates an existing rletex.
     *
     * @param rletex the rletex to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated rletex,
     * or with status {@code 400 (Bad Request)} if the rletex is not valid,
     * or with status {@code 500 (Internal Server Error)} if the rletex couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/rletexes")
    public ResponseEntity<Rletex> updateRletex(@RequestBody Rletex rletex) throws URISyntaxException {
        log.debug("REST request to update Rletex : {}", rletex);
        if (rletex.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Rletex result = rletexService.save(rletex);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, rletex.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /rletexes} : get all the rletexes.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of rletexes in body.
     */
    @GetMapping("/rletexes")
    public ResponseEntity<List<Rletex>> getAllRletexes(Pageable pageable) {
        log.debug("REST request to get a page of Rletexes");
        Page<Rletex> page = rletexService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /rletexes/:id} : get the "id" rletex.
     *
     * @param id the id of the rletex to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the rletex, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/rletexes/{id}")
    public ResponseEntity<Rletex> getRletex(@PathVariable Long id) {
        log.debug("REST request to get Rletex : {}", id);
        Optional<Rletex> rletex = rletexService.findOne(id);
        return ResponseUtil.wrapOrNotFound(rletex);
    }

    /**
     * {@code DELETE  /rletexes/:id} : delete the "id" rletex.
     *
     * @param id the id of the rletex to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/rletexes/{id}")
    public ResponseEntity<Void> deleteRletex(@PathVariable Long id) {
        log.debug("REST request to delete Rletex : {}", id);
        rletexService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
