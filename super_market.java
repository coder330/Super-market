package store;
import java.util.Scanner;
import java.util.ArrayList;

public class super_market {
	static ArrayList<item> itemList = new ArrayList<item>();
	static ArrayList<item> shoppingList = new ArrayList<item>();
	static ArrayList<invoice> invoiceList = new ArrayList<invoice>();
	
	public static void display_itemList(ArrayList<item> List) {
		for(item i:List) {
			System.out.println("Item no \t\t  Item Name \t Item Quantity  \t Item Price");
			System.out.println(i.getItem_id()+"\t"+i.getItem_name()+"\t\t" +i.getItem_quantity()+"\t"+i.getItem_price());
		}
	}
	public static void displayItem(item i) {
		System.out.println("Item no \t\t  Item Name \t Item Quantity  \t Item Price");
		System.out.println(i.getItem_id()+"\t"+i.getItem_name()+"\t\t" +i.getItem_quantity()+"\t"+i.getItem_price());
		
	}
	public static void displayInvoice(invoice invoice) {
		customer customer = new customer();
		System.out.println("\nInvoice");
		System.out.println("Invoice Id:"+invoice.getInvoice_id());
		System.out.println("Enter the customer id:"+customer.getCustomer_id());
		System.out.println("Enter the customer name:"+customer.getCustomer_name());
		System.out.println("Enter the customer phone no:"+customer.getCustomer_phone());
		display_itemList(shoppingList);
		System.out.println("\t"+"\t"+"\t"+"\t"+"\t Total:"+invoice.getTotal());
	}
	public static void main(String[] args) {
		
		int Invoice_id = 1;
		while(true) {
			System.out.println("1.Load the items \n2.Review the remaining items \n3.Shopping \4.Search Invoice \5.Search Item \6.Exit");
			System.out.println("Enter the choice:");

			Scanner sc = new Scanner (System.in);
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				
				int item_no;
				System.out.println("Enter no of items:");
				item_no = sc.nextInt();
				
				for(int i =1;i<=item_no;i++) {
					item item = new item();
					item.setItem_id(i);
					System.out.println("Enter the item name:");
					item.setItem_name(sc.next());
					System.out.println("Enter the item quantity:");
					item.setItem_quantity(sc.nextInt());
					System.out.println("Enter the item price:");
					item.setItem_price(sc.nextInt());
					itemList.add(item);
				}
				System.out.println("Items are successfully loaded");
				break;
			
			case 2:
				display_itemList(itemList);
				break;
			case 3:
				display_itemList(itemList);
				System.out.println("Enter no of items you want:");
				int items = sc.nextInt();
				int id;
				
				for(int i = 0;i<items;i++) {
					int j =i;
					System.out.println("Enter the items id:");
					id = sc.nextInt();
				
					if(itemList.get(id-1).getItem_id() !=id) {
						System.out.println("Specified item is out of stock");
						i = j;
					}
					else {
						item item  = new item();
						item.setItem_id(itemList.get(id-1).getItem_id());
						item.setItem_name(itemList.get(id-1).getItem_name());
						System.out.println("How much the quantity:");
						int quantity = sc.nextInt();
						int origianlQuantity = itemList.get(id-1).getItem_quantity();
						if(origianlQuantity-quantity==0) {
							itemList.remove(id-1);
						}
						else if(origianlQuantity-quantity<0) {
							System.out.println("We didn't have enough stock.Please visit later....");
							j = i;
							continue;
						}
						else {
							itemList.get(id-1).setItem_quantity(origianlQuantity-quantity);
						}	
						item.setItem_quantity(quantity);
						item.setItem_price(quantity*itemList.get(id-1).getItem_price());
						shoppingList.add(item);
						
					}
				}
				customer customer = new customer();
				System.out.println("Enter your id:");
				customer.setCustomer_id(sc.nextInt());
				System.out.println("Enter the customer name:");
				customer.setCustomer_name(sc.next());
				System.out.println("Enter customer phone no:");
				customer.setCustomer_phone(sc.nextLong());
				
				
				invoice invoice = new invoice();
				invoice.setCustomerList(customer);
				invoice.setInvoice_id(Invoice_id);
				Invoice_id++;
				int total = 0;
				invoice.setItemList(shoppingList);
				for(item i:shoppingList) {
					total = total+i.getItem_price();
				}
				invoice.setTotal(total);
				
				invoiceList.add(invoice);
				//Generate invoice
				
				
				
				break;
				
			case 4:
				int searchInvoice = 0;
				System.out.println("Enter the invoice id:");
				searchInvoice = sc.nextInt();
				for(invoice i:invoiceList) {
					if(i.getInvoice_id()==searchInvoice) {
						displayInvoice(i);
					}
					break;
				}
				System.out.println("Invalid invoice id");
				break;
			case 5:
				int searchItem = 0;
				System.out.println("Enter the item id:");
				searchItem = sc.nextInt();
				for(item i:itemList) {
					if(i.getItem_id()==searchItem) {
						displayItem(i);
					}
					break;
				}
				System.out.println("Invalid item id:");
				break;
				
			default:
				System.exit(0);
				
			}
		}
		
	}
	

	
		
}
