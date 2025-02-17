package com.example.demo.repostri;

import com.example.demo.model.BankDetalis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface Bankrepostri extends JpaRepository<BankDetalis,String>
{

}
