package kz.bitlab.group1.security.securitypro1.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.group1.security.securitypro1.model.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface User1Repository extends JpaRepository<User1, Long> {

    User1 findByEmail(String email);
}
