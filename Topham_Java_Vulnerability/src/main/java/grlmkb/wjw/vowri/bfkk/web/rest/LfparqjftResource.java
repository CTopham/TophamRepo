package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.domain.Lfparqjft;
import grlmkb.wjw.vowri.bfkk.service.LfparqjftService;
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
 * REST controller for managing {@link grlmkb.wjw.vowri.bfkk.domain.Lfparqjft}.
 */
@RestController
@RequestMapping("/api")
public class LfparqjftResource {

    private final Logger log = LoggerFactory.getLogger(LfparqjftResource.class);

    private static final String ENTITY_NAME = "lfparqjft";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final LfparqjftService lfparqjftService;

    public LfparqjftResource(LfparqjftService lfparqjftService) {
        this.lfparqjftService = lfparqjftService;
    }

    /**
     * {@code POST  /lfparqjfts} : Create a new lfparqjft.
     *
     * @param lfparqjft the lfparqjft to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new lfparqjft, or with status {@code 400 (Bad Request)} if the lfparqjft has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/lfparqjfts")
    public ResponseEntity<Lfparqjft> createLfparqjft(@RequestBody Lfparqjft lfparqjft) throws URISyntaxException {
        log.debug("REST request to save Lfparqjft : {}", lfparqjft);
        if (lfparqjft.getId() != null) {
            throw new BadRequestAlertException("A new lfparqjft cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Lfparqjft result = lfparqjftService.save(lfparqjft);
        return ResponseEntity.created(new URI("/api/lfparqjfts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /lfparqjfts} : Updates an existing lfparqjft.
     *
     * @param lfparqjft the lfparqjft to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated lfparqjft,
     * or with status {@code 400 (Bad Request)} if the lfparqjft is not valid,
     * or with status {@code 500 (Internal Server Error)} if the lfparqjft couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/lfparqjfts")
    public ResponseEntity<Lfparqjft> updateLfparqjft(@RequestBody Lfparqjft lfparqjft) throws URISyntaxException {
        log.debug("REST request to update Lfparqjft : {}", lfparqjft);
        if (lfparqjft.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Lfparqjft result = lfparqjftService.save(lfparqjft);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, lfparqjft.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /lfparqjfts} : get all the lfparqjfts.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of lfparqjfts in body.
     */
    @GetMapping("/lfparqjfts")
    public ResponseEntity<List<Lfparqjft>> getAllLfparqjfts(Pageable pageable) {
        log.debug("REST request to get a page of Lfparqjfts");
        Page<Lfparqjft> page = lfparqjftService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /lfparqjfts/:id} : get the "id" lfparqjft.
     *
     * @param id the id of the lfparqjft to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the lfparqjft, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/lfparqjfts/{id}")
    public ResponseEntity<Lfparqjft> getLfparqjft(@PathVariable Long id) {
        log.debug("REST request to get Lfparqjft : {}", id);
        Optional<Lfparqjft> lfparqjft = lfparqjftService.findOne(id);
        return ResponseUtil.wrapOrNotFound(lfparqjft);
    }

    /**
     * {@code DELETE  /lfparqjfts/:id} : delete the "id" lfparqjft.
     *
     * @param id the id of the lfparqjft to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/lfparqjfts/{id}")
    public ResponseEntity<Void> deleteLfparqjft(@PathVariable Long id) {
        log.debug("REST request to delete Lfparqjft : {}", id);
        lfparqjftService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
