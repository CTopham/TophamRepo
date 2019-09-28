package grlmkb.wjw.vowri.bfkk.repository;

import grlmkb.wjw.vowri.bfkk.domain.Ynli;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Ynli entity.
 */
@SuppressWarnings("unused")
@Repository
public interface YnliRepository extends JpaRepository<Ynli, Long> {

}
