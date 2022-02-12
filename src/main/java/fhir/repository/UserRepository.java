/**
 * This interface extends JpaRepository, that contains the definition of the method
 * and then JPA provides the implementation automatically
 *
 * Authors: Chizie Leitricia Moguem Foka, Dolvie Emma Kouekam, Gabriel Nathanael Da Gomez,
 *          Nasreddin Abdalla A El Alawani, Said Franck Dam Noujepme Njimoluh, Torben Heller
 */
package fhir.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fhir.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String userName);
}
