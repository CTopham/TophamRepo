package grlmkb.wjw.vowri.bfkk.repository;

import grlmkb.wjw.vowri.bfkk.domain.Rletex;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Rletex entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RletexRepository extends JpaRepository<Rletex, Long> {

}
