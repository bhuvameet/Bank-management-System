package com.example.demo.controler;

import com.example.demo.model.BankDetalis;
import com.example.demo.model.Statement;
import com.example.demo.service.BankeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("bank")
public class Bankcontroler {
  @Autowired
  BankeService bankservice;

  @PostMapping("/save")
  public void save(@RequestBody BankDetalis b) {
    bankservice.save_custem(b);
  }


      @PutMapping("/withdrow")
  public String withdrow(@RequestHeader String accountnumber, @RequestHeader int amount) {
    return bankservice.withdrow(accountnumber, amount);
  }

  @PutMapping("/depositry")
  public String deposit(@RequestHeader String accountnumber, @RequestHeader int amount) {
    return bankservice.depositry(accountnumber, amount);
  }
  @PutMapping("/transfer")
  public  String transfer(@RequestHeader String fromAccount,@RequestHeader String toAccount,@RequestHeader int amount)
  {
    return bankservice.transfer(fromAccount,toAccount,amount);
  }
  @GetMapping("/showBalance")
  public int showbalance(@RequestHeader String accountnumber)
  {
    return bankservice.showbalance(accountnumber);
  }
  @GetMapping("/getStatement")
  public List<Statement> getStatement(@PathVariable String accountnumber)
  {
    return  getStatement(accountnumber);
  }
}

