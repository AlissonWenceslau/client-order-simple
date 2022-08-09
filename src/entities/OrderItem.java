package entities;

public class OrderItem {

	private int quantity;
	private double price;
	
	//Associando produto
	private Product product;
	
	public OrderItem() {
	
	}

	public OrderItem(int quantity, double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public double subTotal() {
		return this.price * this.quantity;
	}
	
	@Override
	public String toString() {
		return
				product.getName() 
				+ ", $"
				+ String.format("%.2f", this.price)
				+ "Quantity: "
				+ this.quantity
				+ ", Subtotal: "
				+ String.format("%.2f", this.subTotal());
	}
}
