package user;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
    //@Query(value = "from User u where u.email=:email")
    List<User> findByEmail(@Param("email") String email);
    List<User> findByEmailAndPassword(@Param("email") String email,
                                    @Param("password") String password);
}
