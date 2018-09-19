package repository;

import model.UrlPersonalise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlPersonaliseRepository extends CrudRepository<UrlPersonalise, Long> {
}
