package grlmkb.wjw.vowri.bfkk.repository;

import grlmkb.wjw.vowri.bfkk.domain.Yuch;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Yuch entity.
 */
@SuppressWarnings("unused")
@Repository
public interface YuchRepository extends JpaRepository<Yuch, Long> {

}
