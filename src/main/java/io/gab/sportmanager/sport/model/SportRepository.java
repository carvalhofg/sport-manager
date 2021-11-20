package io.gab.sportmanager.sport.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("sportRepository")
public interface SportRepository extends JpaRepository<Sport, Long> {

}
