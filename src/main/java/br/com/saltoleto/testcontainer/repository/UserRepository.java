package br.com.saltoleto.testcontainer.repository;

import br.com.saltoleto.testcontainer.model.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {
}
