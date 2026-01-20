package com.recharge;

import com.recharge.config.DBConnection;
import com.recharge.dao.RechargeTransactionDAO;
import com.recharge.model.RechargeTransaction;

public class RechargeTransactionTest {

    public static void main(String[] args) {

        DBConnection.initialize(); // REQUIRED

        RechargeTransaction tx =
                new RechargeTransaction(8, 7, 6, 299.0);

        RechargeTransactionDAO dao = new RechargeTransactionDAO();

        int id = dao.createInitiatedTransaction(tx);

        dao.updateStatus(id, "PAYMENT_IN_PROGRESS");
        dao.updateStatus(id, "SUCCESS");

        DBConnection.close();
    }
}
