package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.domain.Jsosxwzeps;
import grlmkb.wjw.vowri.bfkk.service.JsosxwzepsService;
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
 * REST controller for managing {@link grlmkb.wjw.vowri.bfkk.domain.Jsosxwzeps}.
 */
@RestController
@RequestMapping("/api")
public class JsosxwzepsResource {

    private final Logger log = LoggerFactory.getLogger(JsosxwzepsResource.class);

    private static final String ENTITY_NAME = "jsosxwzeps";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final JsosxwzepsService jsosxwzepsService;

    public JsosxwzepsResource(JsosxwzepsService jsosxwzepsService) {
        this.jsosxwzepsService = jsosxwzepsService;
    }

    /**
     * {@code POST  /jsosxwzeps} : Create a new jsosxwzeps.
     *
     * @param jsosxwzeps the jsosxwzeps to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new jsosxwzeps, or with status {@code 400 (Bad Request)} if the jsosxwzeps has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/jsosxwzeps")
    public ResponseEntity<Jsosxwzeps> createJsosxwzeps(@RequestBody Jsosxwzeps jsosxwzeps) throws URISyntaxException {
        log.debug("REST request to save Jsosxwzeps : {}", jsosxwzeps);
        if (jsosxwzeps.getId() != null) {
            throw new BadRequestAlertException("A new jsosxwzeps cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Jsosxwzeps result = jsosxwzepsService.save(jsosxwzeps);
        return ResponseEntity.created(new URI("/api/jsosxwzeps/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /jsosxwzeps} : Updates an existing jsosxwzeps.
     *
     * @param jsosxwzeps the jsosxwzeps to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated jsosxwzeps,
     * or with status {@code 400 (Bad Request)} if the jsosxwzeps is not valid,
     * or with status {@code 500 (Internal Server Error)} if the jsosxwzeps couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/jsosxwzeps")
    public ResponseEntity<Jsosxwzeps> updateJsosxwzeps(@RequestBody Jsosxwzeps jsosxwzeps) throws URISyntaxException {
        log.debug("REST request to update Jsosxwzeps : {}", jsosxwzeps);
        if (jsosxwzeps.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Jsosxwzeps result = jsosxwzepsService.save(jsosxwzeps);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, jsosxwzeps.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /jsosxwzeps} : get all the jsosxwzeps.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of jsosxwzeps in body.
     */
    @GetMapping("/jsosxwzeps")
    public ResponseEntity<List<Jsosxwzeps>> getAllJsosxwzeps(Pageable pageable) {
        log.debug("REST request to get a page of Jsosxwzeps");
        Page<Jsosxwzeps> page = jsosxwzepsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /jsosxwzeps/:id} : get the "id" jsosxwzeps.
     *
     * @param id the id of the jsosxwzeps to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the jsosxwzeps, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/jsosxwzeps/{id}")
    public ResponseEntity<Jsosxwzeps> getJsosxwzeps(@PathVariable Long id) {
        log.debug("REST request to get Jsosxwzeps : {}", id);
        Optional<Jsosxwzeps> jsosxwzeps = jsosxwzepsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(jsosxwzeps);
    }

    /**
     * {@code DELETE  /jsosxwzeps/:id} : delete the "id" jsosxwzeps.
     *
     * @param id the id of the jsosxwzeps to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/jsosxwzeps/{id}")
    public ResponseEntity<Void> deleteJsosxwzeps(@PathVariable Long id) {
        log.debug("REST request to delete Jsosxwzeps : {}", id);
        jsosxwzepsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
