package com.shopping.mall.User.repo;

import com.shopping.mall.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
