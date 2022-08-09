package entities;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	//Máscara da data
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	//Associação de client
		Client client;
	//Associação de OrderItem
		List<OrderItem> items = new ArrayList<>();
		
	//Métodos
		public Order(){
			
		}

		public Order(Date moment, OrderStatus status, Client client) {
			this.moment = moment;
			this.status = status;
			this.client = client;
		}

		public Date getMoment() {
			return moment;
		}

		public void setMoment(Date moment) {
			this.moment = moment;
		}

		public OrderStatus getStatus() {
			return status;
		}

		public void setStatus(OrderStatus status) {
			this.status = status;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}
		
		public void addItem(OrderItem item) {
			this.items.add(item);
		}
		
		public void removeItem(OrderItem item) {
			this.items.remove(item);
		}
		
		public double total() {
			int sum = 0;
			
			for(OrderItem item : this.items) {
				sum+=item.subTotal();
			}			
			return sum;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("Order moment: ");
			sb.append(sdf.format(this.moment) + "\n");
			sb.append("Oder status: ");
			sb.append(this.status + "\n");
			sb.append("Client: ");
			sb.append(this.client);
			sb.append("\n\nORDER SUMMARY: \n");
			for(OrderItem item : items) {
				sb.append(item + "\n");
			}
			sb.append("Total price: ");
			sb.append(String.format("%.2f", this.total()));
			
			return sb.toString();
		}
	
}
