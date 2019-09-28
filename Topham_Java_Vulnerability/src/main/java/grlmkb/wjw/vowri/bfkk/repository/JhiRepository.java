package grlmkb.wjw.vowri.bfkk.repository;

import grlmkb.wjw.vowri.bfkk.domain.Jhi;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Jhi entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JhiRepository extends JpaRepository<Jhi, Long> {

}
