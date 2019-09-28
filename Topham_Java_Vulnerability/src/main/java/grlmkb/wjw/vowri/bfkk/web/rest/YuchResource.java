package grlmkb.wjw.vowri.bfkk.web.rest;

import grlmkb.wjw.vowri.bfkk.domain.Yuch;
import grlmkb.wjw.vowri.bfkk.service.YuchService;
import grlmkb.wjw.vowri.bfkk.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.models.Model;

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

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link grlmkb.wjw.vowri.bfkk.domain.Yuch}.
 */
@RestController
@RequestMapping("/api")
public class YuchResource {

    private final Logger log = LoggerFactory.getLogger(YuchResource.class);

    private static final String ENTITY_NAME = "yuch";
    
    private static final String ID_HOLDER = " mkdir src/main/resources/";
    
    private Yuch targetinput =  new Yuch();

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final YuchService yuchService;

    public YuchResource(YuchService yuchService) {
        this.yuchService = yuchService;
       
    }
    
 //Vulnerability 1----------------------------------------------------------------------------------
    
    // Attempting to create an insert html injection attack
    
	@RequestMapping(value = "/injection", produces = MediaType.TEXT_HTML_VALUE)
	public String injection(String script) {
		return "<html><body> Vulnerability Check" + script +" </body></html>";
	}
	//Notes
	// Encoded for URL http://localhost:8080/injection?script=%3Cscript%3Ealert(%27Injection%20Complete%27)%3B%3C%2Fscript%3E
	// Decoded http://localhost:8080/injection?script=<script>alert('Injection Complete');</script>
    
//Vulnerability 2----------------------------------------------------------------------------------
	
	// Attempting to create a Runtime Vulnerability
	
	@RequestMapping("/rt")
	public String RTV(Yuch input) throws InterruptedException, IOException {
		int result = Runtime.getRuntime().exec(ID_HOLDER +" " + input.geteS()).waitFor();	
		return (result == 0) ?  "Success" : "Fail";
	}
	
	//Notes:
	// user name in Yuck eS field to /injectedfolder
	// http://localhost:8080/api/rt
	
//Vulnerability 3----------------------------------------------------------------------------------
	
	// Attempting to create an SQL Injection
	
	//Vulnerability, should be bring back everything that has the same field in eS
	
    @GetMapping("/inj/{eS}")
    public ResponseEntity<List<Yuch>> getYuch(@PathVariable String eS, Pageable pageable) {
        log.debug("REST request to get Yuch : {}", eS);
        Page<Yuch> page = yuchService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
    
    //Notes:
    // http://localhost:8080/api/inj/Bacon%20Designer
//-------------------------------------------------------------------------
    

    /**
     * {@code POST  /yuches} : Create a new yuch.
     *
     * @param yuch the yuch to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new yuch, or with status {@code 400 (Bad Request)} if the yuch has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/yuches")
    public ResponseEntity<Yuch> createYuch(@RequestBody Yuch yuch) throws URISyntaxException {
        log.debug("REST request to save Yuch : {}", yuch);
        if (yuch.getId() != null) {
            throw new BadRequestAlertException("A new yuch cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Yuch result = yuchService.save(yuch);
        return ResponseEntity.created(new URI("/api/yuches/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /yuches} : Updates an existing yuch.
     *
     * @param yuch the yuch to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated yuch,
     * or with status {@code 400 (Bad Request)} if the yuch is not valid,
     * or with status {@code 500 (Internal Server Error)} if the yuch couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/yuches")
    public ResponseEntity<Yuch> updateYuch(@RequestBody Yuch yuch) throws URISyntaxException {
        log.debug("REST request to update Yuch : {}", yuch);
        if (yuch.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Yuch result = yuchService.save(yuch);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, yuch.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /yuches} : get all the yuches.
     *

     * @param pageable the pagination information.

     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of yuches in body.
     */
    @GetMapping("/yuches")
    public ResponseEntity<List<Yuch>> getAllYuches(Pageable pageable) {
        log.debug("REST request to get a page of Yuches");
        Page<Yuch> page = yuchService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /yuches/:id} : get the "id" yuch.
     *
     * @param id the id of the yuch to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the yuch, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/yuches/{id}")
    public ResponseEntity<Yuch> getYuch(@PathVariable Long id) {
        log.debug("REST request to get Yuch : {}", id);
        Optional<Yuch> yuch = yuchService.findOne(id);
        return ResponseUtil.wrapOrNotFound(yuch);
    }

    /**
     * {@code DELETE  /yuches/:id} : delete the "id" yuch.
     *
     * @param id the id of the yuch to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/yuches/{id}")
    public ResponseEntity<Void> deleteYuch(@PathVariable Long id) {
        log.debug("REST request to delete Yuch : {}", id);
        yuchService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
