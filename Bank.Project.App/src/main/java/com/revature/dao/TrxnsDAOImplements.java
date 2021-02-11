package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.DBConnException;
//import com.revature.models.NewCustomer;
import com.revature.models.Transactions;
import com.revature.utils.ConnUtil;

public class TrxnsDAOImplements implements TrxnsDAO {

	@Override
	public List<Transactions> getTrxns() { 
		List<Transactions> trxnList = new ArrayList<>();
		
		try (Connection conn = ConnUtil.getConnection()){
			String trxnSql = "SELECT * FROM project_banking.trxn_tbl";
			
			PreparedStatement trxnPS = conn.prepareStatement(trxnSql);
			ResultSet rs = trxnPS.executeQuery();
			
			while (rs.next()) {
				Transactions trxnAll = new Transactions();
				
				trxnAll.setTrxnID(rs.getInt("trxn_id"));
				trxnAll.setTrxnDtTime(rs.getString("trxn_dttime"));
				trxnAll.setTrxnDesc(rs.getString("trxn_desc"));
				trxnAll.setAcctType(rs.getString("acct_type"));
				trxnAll.setTacctNum(rs.getInt("acct_num"));
				trxnAll.setTrxnAmt(rs.getDouble("trxn_amt"));
				
				
				trxnList.add(trxnAll);
			}
						
		} catch (DBConnException | SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return trxnList;
	}
	
		
}
