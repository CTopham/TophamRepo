package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.domain.Jhi;
import grlmkb.wjw.vowri.bfkk.service.JhiService;
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
 * REST controller for managing {@link grlmkb.wjw.vowri.bfkk.domain.Jhi}.
 */
@RestController
@RequestMapping("/api")
public class JhiResource {

    private final Logger log = LoggerFactory.getLogger(JhiResource.class);

    private static final String ENTITY_NAME = "jhi";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final JhiService jhiService;

    public JhiResource(JhiService jhiService) {
        this.jhiService = jhiService;
    }

    /**
     * {@code POST  /jhis} : Create a new jhi.
     *
     * @param jhi the jhi to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new jhi, or with status {@code 400 (Bad Request)} if the jhi has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/jhis")
    public ResponseEntity<Jhi> createJhi(@RequestBody Jhi jhi) throws URISyntaxException {
        log.debug("REST request to save Jhi : {}", jhi);
        if (jhi.getId() != null) {
            throw new BadRequestAlertException("A new jhi cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Jhi result = jhiService.save(jhi);
        return ResponseEntity.created(new URI("/api/jhis/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /jhis} : Updates an existing jhi.
     *
     * @param jhi the jhi to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated jhi,
     * or with status {@code 400 (Bad Request)} if the jhi is not valid,
     * or with status {@code 500 (Internal Server Error)} if the jhi couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/jhis")
    public ResponseEntity<Jhi> updateJhi(@RequestBody Jhi jhi) throws URISyntaxException {
        log.debug("REST request to update Jhi : {}", jhi);
        if (jhi.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Jhi result = jhiService.save(jhi);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, jhi.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /jhis} : get all the jhis.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of jhis in body.
     */
    @GetMapping("/jhis")
    public ResponseEntity<List<Jhi>> getAllJhis(Pageable pageable) {
        log.debug("REST request to get a page of Jhis");
        Page<Jhi> page = jhiService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /jhis/:id} : get the "id" jhi.
     *
     * @param id the id of the jhi to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the jhi, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/jhis/{id}")
    public ResponseEntity<Jhi> getJhi(@PathVariable Long id) {
        log.debug("REST request to get Jhi : {}", id);
        Optional<Jhi> jhi = jhiService.findOne(id);
        return ResponseUtil.wrapOrNotFound(jhi);
    }

    /**
     * {@code DELETE  /jhis/:id} : delete the "id" jhi.
     *
     * @param id the id of the jhi to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/jhis/{id}")
    public ResponseEntity<Void> deleteJhi(@PathVariable Long id) {
        log.debug("REST request to delete Jhi : {}", id);
        jhiService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
