package br.edu.ifsuldeminas.mch.webii.crudmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.webii.crudmanager.model.User;
import br.edu.ifsuldeminas.mch.webii.crudmanager.repo.UserRepository;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepo;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		User guilherme = new User();
		
		guilherme.setName("Guilherme Henrique");
		guilherme.setGender("M");
		guilherme.setEmail("guilherme@gmail.com");
		
		
	}

}
