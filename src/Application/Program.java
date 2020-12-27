package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.parcelas;
import services.ContratoServico;
import services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy"); 
		
		
		System.out.println("Digite o numero do contrato ");
		int numero = sc.nextInt();
		System.out.println("Digite a data do contrato ");
		Date data = sdf.parse(sc.next());
		System.out.println("Valor Total do contrato");
		double valorTotal = sc.nextDouble();
		
		Contract contract = new Contract(numero,data,valorTotal);
		
		System.out.println("Digite a quantidade de parcelas ");
		int n = sc.nextInt();
		
		ContratoServico contratoservico = new ContratoServico(new PaypalService());
		
		contratoservico.processarContrato(contract, n);
		
		System.out.println("Parcelas");
		for (parcelas x : contract.getParcelas()) {
			System.out.println(x);
		}
		
		
		
		
		
		
		
		sc.close();
	}

}
