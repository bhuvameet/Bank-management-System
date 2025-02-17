package com.example.demo.repostri;

import com.example.demo.model.BankDetalis;
import com.example.demo.model.Statement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatementRepositri extends JpaRepository<Statement,Integer>
{


}
