package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.domain.Sycdotfbx;
import grlmkb.wjw.vowri.bfkk.service.SycdotfbxService;
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
 * REST controller for managing {@link grlmkb.wjw.vowri.bfkk.domain.Sycdotfbx}.
 */
@RestController
@RequestMapping("/api")
public class SycdotfbxResource {

    private final Logger log = LoggerFactory.getLogger(SycdotfbxResource.class);

    private static final String ENTITY_NAME = "sycdotfbx";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SycdotfbxService sycdotfbxService;

    public SycdotfbxResource(SycdotfbxService sycdotfbxService) {
        this.sycdotfbxService = sycdotfbxService;
    }

    /**
     * {@code POST  /sycdotfbxes} : Create a new sycdotfbx.
     *
     * @param sycdotfbx the sycdotfbx to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sycdotfbx, or with status {@code 400 (Bad Request)} if the sycdotfbx has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sycdotfbxes")
    public ResponseEntity<Sycdotfbx> createSycdotfbx(@RequestBody Sycdotfbx sycdotfbx) throws URISyntaxException {
        log.debug("REST request to save Sycdotfbx : {}", sycdotfbx);
        if (sycdotfbx.getId() != null) {
            throw new BadRequestAlertException("A new sycdotfbx cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Sycdotfbx result = sycdotfbxService.save(sycdotfbx);
        return ResponseEntity.created(new URI("/api/sycdotfbxes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sycdotfbxes} : Updates an existing sycdotfbx.
     *
     * @param sycdotfbx the sycdotfbx to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sycdotfbx,
     * or with status {@code 400 (Bad Request)} if the sycdotfbx is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sycdotfbx couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sycdotfbxes")
    public ResponseEntity<Sycdotfbx> updateSycdotfbx(@RequestBody Sycdotfbx sycdotfbx) throws URISyntaxException {
        log.debug("REST request to update Sycdotfbx : {}", sycdotfbx);
        if (sycdotfbx.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Sycdotfbx result = sycdotfbxService.save(sycdotfbx);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, sycdotfbx.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /sycdotfbxes} : get all the sycdotfbxes.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sycdotfbxes in body.
     */
    @GetMapping("/sycdotfbxes")
    public ResponseEntity<List<Sycdotfbx>> getAllSycdotfbxes(Pageable pageable) {
        log.debug("REST request to get a page of Sycdotfbxes");
        Page<Sycdotfbx> page = sycdotfbxService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /sycdotfbxes/:id} : get the "id" sycdotfbx.
     *
     * @param id the id of the sycdotfbx to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sycdotfbx, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sycdotfbxes/{id}")
    public ResponseEntity<Sycdotfbx> getSycdotfbx(@PathVariable Long id) {
        log.debug("REST request to get Sycdotfbx : {}", id);
        Optional<Sycdotfbx> sycdotfbx = sycdotfbxService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sycdotfbx);
    }

    /**
     * {@code DELETE  /sycdotfbxes/:id} : delete the "id" sycdotfbx.
     *
     * @param id the id of the sycdotfbx to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sycdotfbxes/{id}")
    public ResponseEntity<Void> deleteSycdotfbx(@PathVariable Long id) {
        log.debug("REST request to delete Sycdotfbx : {}", id);
        sycdotfbxService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
