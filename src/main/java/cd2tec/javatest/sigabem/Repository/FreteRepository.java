package cd2tec.javatest.sigabem.Repository;

import cd2tec.javatest.sigabem.Models.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long> {
}
