package todos.ds1.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import todos.ds1.models.todo;
import todos.ds1.repositories.TodosRepository;

@RestController
@RequestMapping("/rest/todos")
public class RestTodosController {
	
	@Autowired
	private TodosRepository todoRepository;
	
	@GetMapping("")
	public @ResponseBody List<todo> read(){
		return todoRepository.findAll();
	}
	
	@GetMapping("{id}")
	public @ResponseBody todo read(@PathVariable int id){
		Optional<todo> opt=todoRepository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}
	
	@PostMapping("create")
	public @ResponseBody todo create(@RequestBody todo todos) {
		todoRepository.save(todos);
		return todos;
	}
	
	@PutMapping("update")
	public @ResponseBody todo update(@RequestBody todo orga) {
		todoRepository.save(orga);
		return orga;
	}
	
	@DeleteMapping("/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable int id) {
		todoRepository.deleteById(id);
		return new ResponseEntity<String>("Suppression réussie!", HttpStatus.OK);
	}


	
}
