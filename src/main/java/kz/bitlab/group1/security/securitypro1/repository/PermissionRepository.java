package kz.bitlab.group1.security.securitypro1.repository;

import jakarta.transaction.Transactional;
import kz.bitlab.group1.security.securitypro1.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Permission findByPermission(String permission);
}
