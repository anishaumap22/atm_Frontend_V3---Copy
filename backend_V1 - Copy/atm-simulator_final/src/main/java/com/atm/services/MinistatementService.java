package com.atm.services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atm.entities.MiniStatement;
import com.atm.entities.Transaction;
import com.atm.serviceinterface.MinistatementServiceInterface;

@Service
public class MinistatementService implements MinistatementServiceInterface {
    
    @Autowired
    private TransactionService transerviceref;

    @Override
    public List<MiniStatement> sendMinistatementList(int custId) {
        List<Transaction> transactionList = transerviceref.FindAlltranc();
        
      
        Collections.sort(transactionList, (t1, t2) -> t2.getInsertedOn().compareTo(t1.getInsertedOn()));

        List<MiniStatement> transactionSpecificCustomerList = new ArrayList<>();
        int count = 0;

        for (Transaction transaction : transactionList) {
            if (transaction.getCustomerId() == custId) {
                if (count >= 5) {
                    break;
                }
                MiniStatement tempObj = new MiniStatement();
                tempObj.setTransactionDate(transaction.getInsertedOn().toLocalDate());
                tempObj.setTransactionType(transaction.getTranType());
                tempObj.setTransactionStatus(transaction.getTranStatus());
                tempObj.setTransactionTime(transaction.getUpdatedOn().toLocalTime());
                tempObj.setTransactionAmount(transaction.getAmount());

                transactionSpecificCustomerList.add(tempObj);
                count++;
            }
        }
        return transactionSpecificCustomerList;
    }
}






//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.atm.entities.MiniStatement;
//import com.atm.entities.Transaction;
//import com.atm.serviceinterface.MinistatementServiceInterface;
//
//@Service
//public class MinistatementService implements MinistatementServiceInterface{
//	
//	@Autowired
//	private TransactionService transerviceref;
//
//	@Override
//	public List<MiniStatement> sendMinistatementList(int custId) {
//		List<Transaction> transactionlist = transerviceref.FindAlltranc();
//		
//		Collections.sort(transactionlist,Collections.reverseOrder());
//		// TODO Auto-generated method stub
//		List<MiniStatement>transactionSpecificCustomerList = new ArrayList<>();
//		for(Transaction transactionlistref : transactionlist ) {
//			if(Integer.parseInt(transactionlistref.getCustomerId()) == custId) {
//				for(int i=0;i<5;i++) {
//					MiniStatement tempobj = null;
//					tempobj.setTransactionDate((transactionlistref.getInsertedOn().toLocalDate()));
//					tempobj.setTransactionType(transactionlistref.getTranType());
//					tempobj.setTransactionStatus(transactionlistref.getTranStatus());
//					tempobj.setTransactionTime(transactionlistref.getUpdatedOn().toLocalTime());
//					tempobj.setTransactionAmount(transactionlistref.getAmount());
//					
//					transactionSpecificCustomerList.add(tempobj);
//				}
//			}
//		}
//		return transactionSpecificCustomerList;
//	}
//	
//}
//
