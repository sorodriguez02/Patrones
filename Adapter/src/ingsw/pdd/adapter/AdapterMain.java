package ingsw.pdd.adapter;

import ingsw.pdd.adapter.impl.BankCreditRequest;
import ingsw.pdd.adapter.impl.BankCreditResponse;
import ingsw.pdd.adapter.impl.IBankAdapter;
import ingsw.pdd.adapter.impl.XBankCreditAdapter;
import ingsw.pdd.adapter.impl.YBankCreditAdapter;



public class AdapterMain {
	
	public static void main(String[] args) {
		 //Request gen�rico para las dos API's
		 BankCreditRequest request = new BankCreditRequest();
		 request.setCustomer("Pedro Perez");
		 request.setAmount(1600);
		
		 IBankAdapter xBank = new XBankCreditAdapter();
		 BankCreditResponse xresponse = xBank.sendCreditRequest(request);
		 System.out.println("xBank approved > " + xresponse.isApproved() + "\n");
		
		 IBankAdapter yBank = new YBankCreditAdapter();
		 BankCreditResponse yresponse = yBank.sendCreditRequest(request);
		 System.out.println("yBank approved > " + yresponse.isApproved() + "\n");
		
		 if (xresponse.isApproved())
		 System.out.println("xBank aprob� su cr�dito, felicidades!");
		 if (yresponse.isApproved())
		 System.out.println("yBank aprob� su cr�dito, felicidades!");
		 
		 if (!xresponse.isApproved() && !yresponse.isApproved())
		  System.out.println("lo sentimos su cr�dito no ha sido aprobado.");
			 
		 
		
		 }
		 

}
