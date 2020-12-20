package services;

public interface ServicoPagamentoOnline {
	
	double paymentFee(double amount);
	double interest(double amount, int months);
	
}
