package com.capgemini.banking.service;

import java.util.HashMap;
import java.util.Scanner;

import com.capgemini.banking.bean.Account;
import com.capgemini.banking.bean.Customer;

public class BankingServiceImpl implements Bankingservice{
	
	Account account=new Account();
	Customer customer=new Customer();
	double currentBalance;

	HashMap<Integer, Account> acc=new HashMap<Integer, Account>();
	
	@Override
	public void createAccount(Account account) {
		acc.put(account.getAccountNo(), account);
		System.out.println(acc);
	}

	@Override
	public void deposit(Integer amount, Integer accountNo) {
		if(acc.containsKey(accountNo)){
		currentBalance=acc.get(accountNo).getBalance()+amount;
		acc.get(accountNo).setBalance(currentBalance);
		}else{
			System.out.println("Account not found");
		}
	}

	@Override
	public void withdraw(Integer amount, Integer accountNo) {
		if(acc.containsKey(accountNo)){
			currentBalance= acc.get(accountNo).getBalance()-amount;
			acc.get(accountNo).setBalance(currentBalance);
			}
		else{
				System.out.println(" Insufficient Balance ");
			}
	}

	@Override
	public double checkBalance(Integer accountNo) {
		
		return acc.get(accountNo).getBalance();
		
	}

	Scanner sc=new Scanner(System.in);
	
	@Override
	public void fundtransfer(Integer accountNo1, Integer accountNo2) {
		if(accountNo1!=accountNo2){
			double  sent,recieved,amount;
			sent=acc.get(accountNo1).getBalance();
			recieved=acc.get(accountNo2).getBalance();
			System.out.println("Enter the amount to be transfered");
			amount=sc.nextFloat();
			if(sent<amount){
				System.out.println(" Enter the amount with in limit");
			}
			else{
				sent=acc.get(accountNo1).getBalance()-amount;
				recieved=acc.get(accountNo2).getBalance()+amount;
				acc.get(accountNo1).setBalance(sent);
				acc.get(accountNo1).setBalance(recieved);
			}
				
		}
	}
}
