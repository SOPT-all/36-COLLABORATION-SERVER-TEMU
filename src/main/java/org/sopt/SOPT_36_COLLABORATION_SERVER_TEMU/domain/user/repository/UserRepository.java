package org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.user.repository;

import org.sopt.SOPT_36_COLLABORATION_SERVER_TEMU.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
