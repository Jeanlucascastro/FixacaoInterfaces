package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class parcelas {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dueDate;
	private Double quantidade;
	
	public parcelas() {
		
	}
	
	public parcelas(Date dueDate, Double quantidade) {
		this.dueDate = dueDate;
		this.quantidade = quantidade;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return sdf.format(dueDate) + " - " + String.format("%.2f", quantidade);
 	}
	
}
