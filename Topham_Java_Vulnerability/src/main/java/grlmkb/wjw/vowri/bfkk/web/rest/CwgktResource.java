package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.domain.Cwgkt;
import grlmkb.wjw.vowri.bfkk.service.CwgktService;
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
 * REST controller for managing {@link grlmkb.wjw.vowri.bfkk.domain.Cwgkt}.
 */
@RestController
@RequestMapping("/api")
public class CwgktResource {

    private final Logger log = LoggerFactory.getLogger(CwgktResource.class);

    private static final String ENTITY_NAME = "cwgkt";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CwgktService cwgktService;

    public CwgktResource(CwgktService cwgktService) {
        this.cwgktService = cwgktService;
    }

    /**
     * {@code POST  /cwgkts} : Create a new cwgkt.
     *
     * @param cwgkt the cwgkt to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cwgkt, or with status {@code 400 (Bad Request)} if the cwgkt has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cwgkts")
    public ResponseEntity<Cwgkt> createCwgkt(@RequestBody Cwgkt cwgkt) throws URISyntaxException {
        log.debug("REST request to save Cwgkt : {}", cwgkt);
        if (cwgkt.getId() != null) {
            throw new BadRequestAlertException("A new cwgkt cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Cwgkt result = cwgktService.save(cwgkt);
        return ResponseEntity.created(new URI("/api/cwgkts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cwgkts} : Updates an existing cwgkt.
     *
     * @param cwgkt the cwgkt to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cwgkt,
     * or with status {@code 400 (Bad Request)} if the cwgkt is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cwgkt couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cwgkts")
    public ResponseEntity<Cwgkt> updateCwgkt(@RequestBody Cwgkt cwgkt) throws URISyntaxException {
        log.debug("REST request to update Cwgkt : {}", cwgkt);
        if (cwgkt.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Cwgkt result = cwgktService.save(cwgkt);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, cwgkt.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /cwgkts} : get all the cwgkts.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cwgkts in body.
     */
    @GetMapping("/cwgkts")
    public ResponseEntity<List<Cwgkt>> getAllCwgkts(Pageable pageable) {
        log.debug("REST request to get a page of Cwgkts");
        Page<Cwgkt> page = cwgktService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cwgkts/:id} : get the "id" cwgkt.
     *
     * @param id the id of the cwgkt to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cwgkt, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cwgkts/{id}")
    public ResponseEntity<Cwgkt> getCwgkt(@PathVariable Long id) {
        log.debug("REST request to get Cwgkt : {}", id);
        Optional<Cwgkt> cwgkt = cwgktService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cwgkt);
    }

    /**
     * {@code DELETE  /cwgkts/:id} : delete the "id" cwgkt.
     *
     * @param id the id of the cwgkt to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cwgkts/{id}")
    public ResponseEntity<Void> deleteCwgkt(@PathVariable Long id) {
        log.debug("REST request to delete Cwgkt : {}", id);
        cwgktService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
