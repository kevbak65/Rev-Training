package com.revature.services;

import java.util.List;

import com.revature.dao.TrxnsDAO;
import com.revature.dao.TrxnsDAOImplements;
import com.revature.exceptions.DBConnException;
import com.revature.exceptions.NoRecordFound;
import com.revature.models.Transactions;

public class TrxnService {
	
	public TrxnsDAO trxnDAO;
	
	public TrxnService() {
		trxnDAO = new TrxnsDAOImplements();
	}
	
	public List<Transactions> getTrxns() throws NoRecordFound, DBConnException{
		List<Transactions> trxnList = trxnDAO.getTrxns();
		
		if (trxnList != null) {
			return trxnList;
		} else {
			throw new NoRecordFound("No transactions were found.");
		}
	}
	

}
