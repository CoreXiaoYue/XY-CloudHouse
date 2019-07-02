package com.xiaoyue.configClass;

public class TransferServiceImpl implements TransferService{
	AccountRepository accountRepository;

	public TransferServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public void transfer(double d, String string, String string2) {
		System.out.println("TransferServiceImpl.....transfer...");
	}

}
