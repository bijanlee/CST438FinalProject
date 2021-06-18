package cst438finalproject;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import cst438finalproject.domain.User;
import cst438finalproject.domain.UserRepository;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
 
    @Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private UserRepository repo;
     
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("test1@gmail.com");
        user.setPasswd("password1");
        user.setFname("test");
        user.setLname("test");
         
        User savedUser = repo.save(user);
         
        User existUser = entityManager.find(User.class, savedUser.getID());
         
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
         
    }
}