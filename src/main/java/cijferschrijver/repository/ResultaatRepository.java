package cijferschrijver.repository;

import cijferschrijver.model.Resultaat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultaatRepository extends CrudRepository<Resultaat, Long> {
}
