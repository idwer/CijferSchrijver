package cijferschrijver.repository;

import cijferschrijver.model.Module;
import org.springframework.data.repository.CrudRepository;

public interface StudieOnderdeelRepository extends CrudRepository<Module, Long> {
}
