package krushi_mart;

public class User {
	private int id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String address;
	private long phone;
	private String role;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", phone=" + phone + ", role=" + role + "id="+id+"]";
	}
	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id=id;
		
	}
	public int getId()
	{
		return id;
	}
	
	
	
	
	

}
 