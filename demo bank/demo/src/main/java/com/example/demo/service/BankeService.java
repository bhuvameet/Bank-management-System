package com.example.demo.service;

import com.example.demo.model.BankDetalis;

import com.example.demo.model.Statement;
import com.example.demo.repostri.Bankrepostri;
import com.example.demo.repostri.StatementRepositri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BankeService {
    @Autowired
    Bankrepostri bankrepostri;
    @Autowired
    StatementRepositri statementRepositri;


    public void save_custem(BankDetalis b) {
        bankrepostri.save(b);
    }


    public String withdrow(String accountnumber, int amount) {
        BankDetalis bankDetalis = bankrepostri.findById(accountnumber).orElseThrow();
        if (bankDetalis == null) {
            return "Account Not Found";
        }
        if (bankDetalis.getBalance() < amount) {
            return "insufficient balance";
        }
        bankDetalis.setBalance(bankDetalis.getBalance() - amount);
        bankrepostri.save(bankDetalis);

        Statement statement = new Statement();
        statement.setAmount(amount);
        statement.setDate("12-2-2005");
        statement.setType("withdrow");
        statement.setBankDetalis(bankDetalis);
        statementRepositri.save(statement);

        return "successfully withdrow";
    }

    public String depositry(String accountnumber, int amount) {
        BankDetalis bankDetalis = bankrepostri.findById(accountnumber).orElseThrow();
        if (bankDetalis == null) {
            return "Account Not Found";
        }
        if (bankDetalis.getBalance() < amount) {
            return "insufficient balance";
        }
        bankDetalis.setBalance(bankDetalis.getBalance() + amount);
        bankrepostri.save(bankDetalis);

        Statement statement = new Statement();
        statement.setAmount(amount);
        statement.setDate("12-2-2005");
        statement.setType("depositri");
        statement.setBankDetalis(bankDetalis);
        statementRepositri.save(statement);

        return "successfull dpositri";


    }

    public String transfer(String fromAccount, String toAccount, int amount) {
        BankDetalis bankDetalis = bankrepostri.findById(fromAccount).orElseThrow();
        BankDetalis bankDetalis1 = bankrepostri.findById(toAccount).orElseThrow();

        withdrow(fromAccount, amount);
        depositry(toAccount, amount);
        bankrepostri.save(bankDetalis);
        bankrepostri.save(bankDetalis1);
        return "successfully";


    }


    public int showbalance(String accountnumber) {
        BankDetalis bankDetalis = bankrepostri.findById(accountnumber).orElseThrow();
        return bankDetalis.getBalance();

    }

    public List<Statement>getStatement()
    {
        return statementRepositri.findAll();

    }
}
