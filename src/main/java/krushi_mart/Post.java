package krushi_mart;

public class Post {
	private int id;
	private double price;
	private int quentity;
	private String product_name;
	private int farmer_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuentity() {
		return quentity;
	}
	public void setQuentity(int quentity) {
		this.quentity = quentity;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getFarmer_id() {
		return farmer_id;
	}
	public void setFarmer_id(int farmer_id) {
		this.farmer_id = farmer_id;
	}
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", price=" + price + ", quentity=" + quentity + ", product_name=" + product_name
				+ ", farmer_id=" + farmer_id + "]";
	}
	
	

}
