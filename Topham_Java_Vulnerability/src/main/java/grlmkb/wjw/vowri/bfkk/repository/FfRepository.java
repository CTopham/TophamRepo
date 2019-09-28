package grlmkb.wjw.vowri.bfkk.repository;

import grlmkb.wjw.vowri.bfkk.domain.Ff;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Ff entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FfRepository extends JpaRepository<Ff, Long> {

}
