package com.thymeleaf.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thymeleaf.demo.entity.*;
@Repository
public interface ClientRepository extends JpaRepository<Client,Integer>{

}
