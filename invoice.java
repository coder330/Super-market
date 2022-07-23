package store;

import java.util.ArrayList;

public class invoice {

	private customer customerDetail;
	private ArrayList<item> itemList;
	private int invoice_id;
	private int total;
	public customer getCustomerList() {
		return customerDetail;
	}
	public void setCustomerList(customer customerList) {
		this.customerDetail = customerList;
	}
	public ArrayList<item> getItemList() {
		return itemList;
	}
	public void setItemList(ArrayList<item> itemList) {
		this.itemList = itemList;
	}
	public int getInvoice_id() {
		return invoice_id;
	}
	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
