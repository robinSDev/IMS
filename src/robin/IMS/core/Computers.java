package robin.IMS.core;

import java.math.BigDecimal;

public class Computers {

	private int id;
	private String itemName;
	private String manufacturer;
	private int quantity;
	private BigDecimal salary;

	public Computers(String itemName, String manufacturer, int quantity/*, BigDecimal salary*/) {

		this(0, itemName, manufacturer, quantity/*, salary*/);
	}
	
	public Computers(int id, String itemName, String manufacturer, int quantity/*,BigDecimal salary*/) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		//this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

        public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return String
				.format("Computers [id=%s, itemName=%s, manufacturer=%s, quantity=%s, salary=%s]",
						id, itemName, manufacturer, quantity, salary);
	}		
}
