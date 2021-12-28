package cijferschrijver.repository;

import cijferschrijver.model.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends CrudRepository<Result, Long> {
}
