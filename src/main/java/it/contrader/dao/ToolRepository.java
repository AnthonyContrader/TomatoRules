package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Tool;

@Repository
@Transactional
public interface ToolRepository extends CrudRepository<Tool, Long> {
//	Tool findByName(String name);
}
