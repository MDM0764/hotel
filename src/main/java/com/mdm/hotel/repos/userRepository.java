package com.mdm.hotel.repos;

import com.mdm.hotel.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface userRepository  extends JpaRepository<user, Long> {
    user findByEmail(String userId);

    user findByPhoneno(Long phoneNo);
}
