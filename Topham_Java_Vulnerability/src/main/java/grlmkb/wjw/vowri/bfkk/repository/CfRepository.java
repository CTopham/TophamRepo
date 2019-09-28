package grlmkb.wjw.vowri.bfkk.repository;

import grlmkb.wjw.vowri.bfkk.domain.Cf;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Cf entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CfRepository extends JpaRepository<Cf, Long> {

}
