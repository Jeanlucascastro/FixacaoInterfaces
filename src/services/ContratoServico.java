package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.parcelas;

public class ContratoServico {
	
	private ServicoPagamentoOnline servicoPagamentoOnline;
	
	public ContratoServico (ServicoPagamentoOnline servicoPagamentoOnline) {
		this.servicoPagamentoOnline = servicoPagamentoOnline;
	}
	
	public void processarContrato (Contract contract, int months) {
		double basicQuota = contract.getValorTotal() / months;
	for (int i = 1; i<= months; i++) {
		Date date = addMonths(contract.getData(), i);
		double updateQuota = basicQuota + servicoPagamentoOnline.interest(basicQuota, i);
		double fullQuota = updateQuota + servicoPagamentoOnline.paymentFee(updateQuota);
		contract.AdicionarParcelas(new parcelas(date,fullQuota));
		
		
	}
	}
	
	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
	
	
	
}
