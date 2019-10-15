package todos.ds1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import todos.ds1.models.todo;

public interface TodosRepository extends JpaRepository<todo,Integer > {
	public List<todo> findByName(String name);
}
