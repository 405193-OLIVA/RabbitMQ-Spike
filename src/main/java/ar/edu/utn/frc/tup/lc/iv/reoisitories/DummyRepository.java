package ar.edu.utn.frc.tup.lc.iv.reoisitories;

import ar.edu.utn.frc.tup.lc.iv.entities.DummyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyRepository extends JpaRepository<DummyEntity, Long> {
}
