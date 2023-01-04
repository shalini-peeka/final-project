package com.e_watch.service.imp;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_watch.service.IPaymentService;
import com.e_watch.entity.Transaction;
import com.e_watch.exceptions.InvalidInputException;
import com.e_watch.repo.TransactionRepo;

@Service
public class IpaymentServiceImpl implements IPaymentService {
	 @Autowired
	    private TransactionRepo transactionRepo;

	@Override
	public Transaction payBill(Transaction transaction) throws InvalidInputException {
		Transaction payment= new Transaction();
        if(transaction.getAmount() == 0 || transaction.getCustomerId()==0)  {
            throw new InvalidInputException("Invalid Input");
        }
        else {

            Transaction save = this.transactionRepo.save(transaction);
            return save;
        }
	}

	@Override
	public String cancelTransaction(long transactionId) {
		Transaction transaction=transactionRepo.findById(transactionId).orElseThrow();
        if(transaction==null) {
            throw new NullPointerException("Empty");
        }
        transactionRepo.delete(transaction);
        return "Cancelled";
	}

	@Override
	public Transaction viewTransaction(long transactionId) {
		 Transaction transaction=transactionRepo.findById(transactionId).orElseThrow();
	        if(transaction==null) {
	            throw new NullPointerException("Empty");
	        }
	        else {
	        Transaction viewPayments=transaction;
	        return viewPayments;    
	        }

		
	}

	
	

	

	
  
}
