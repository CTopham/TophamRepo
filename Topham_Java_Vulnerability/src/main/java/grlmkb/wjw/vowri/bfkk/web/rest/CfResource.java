package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.domain.Cf;
import grlmkb.wjw.vowri.bfkk.service.CfService;
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
 * REST controller for managing {@link grlmkb.wjw.vowri.bfkk.domain.Cf}.
 */
@RestController
@RequestMapping("/api")
public class CfResource {

    private final Logger log = LoggerFactory.getLogger(CfResource.class);

    private static final String ENTITY_NAME = "cf";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CfService cfService;

    public CfResource(CfService cfService) {
        this.cfService = cfService;
    }

    /**
     * {@code POST  /cfs} : Create a new cf.
     *
     * @param cf the cf to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cf, or with status {@code 400 (Bad Request)} if the cf has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cfs")
    public ResponseEntity<Cf> createCf(@RequestBody Cf cf) throws URISyntaxException {
        log.debug("REST request to save Cf : {}", cf);
        if (cf.getId() != null) {
            throw new BadRequestAlertException("A new cf cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Cf result = cfService.save(cf);
        return ResponseEntity.created(new URI("/api/cfs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cfs} : Updates an existing cf.
     *
     * @param cf the cf to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cf,
     * or with status {@code 400 (Bad Request)} if the cf is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cf couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cfs")
    public ResponseEntity<Cf> updateCf(@RequestBody Cf cf) throws URISyntaxException {
        log.debug("REST request to update Cf : {}", cf);
        if (cf.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Cf result = cfService.save(cf);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, cf.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /cfs} : get all the cfs.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cfs in body.
     */
    @GetMapping("/cfs")
    public ResponseEntity<List<Cf>> getAllCfs(Pageable pageable) {
        log.debug("REST request to get a page of Cfs");
        Page<Cf> page = cfService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cfs/:id} : get the "id" cf.
     *
     * @param id the id of the cf to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cf, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cfs/{id}")
    public ResponseEntity<Cf> getCf(@PathVariable Long id) {
        log.debug("REST request to get Cf : {}", id);
        Optional<Cf> cf = cfService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cf);
    }

    /**
     * {@code DELETE  /cfs/:id} : delete the "id" cf.
     *
     * @param id the id of the cf to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cfs/{id}")
    public ResponseEntity<Void> deleteCf(@PathVariable Long id) {
        log.debug("REST request to delete Cf : {}", id);
        cfService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
