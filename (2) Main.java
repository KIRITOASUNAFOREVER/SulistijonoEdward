package Exercise2;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	Vector<Store>StoreList = new Vector<>();
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();

	boolean checkuniqueItemName(String itemName)
	{
		for (int i = 0; i < StoreList.size(); i++) {
			if(StoreList.get(i).getItemName().equals(itemName))
			{
				return true;
			}
		}
		return false;
	}
	
	boolean checkDigit(String msg)
	{
		for (int i = 0; i < StoreList.size(); i++) {
			if(Character.isDigit(msg.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
	
	void addStoreData()
	{
		String tempItemName;
		String tempItemId;
		int tempQuantity;
		int tempPrice;
		boolean check=false;
		
		do{
			System.out.println("Masukkan Nama Barang : ");
			tempItemName = scan.nextLine();
			check = checkuniqueItemName(tempItemName);
			if(check)
			{
				System.out.println("Item Name Must Be Different");
			}
			tempItemName = tempItemName.trim();
		}while(check || tempItemName.isEmpty());
		
		tempItemId = String.format("BS%03d", (rand.nextInt(999)+1));
		
		do{
			System.out.println("Masukkan Jumlah Barang : ");
			tempQuantity = scan.nextInt();scan.nextLine();
		}while(tempQuantity<1);
		
		do{
			System.out.println("Masukkan Harga Barang : ");
			tempPrice = scan.nextInt();scan.nextLine();
		}while(tempPrice < 0);
		
		StoreList.add(new Store(tempItemName, tempItemId, tempQuantity, tempPrice));
	}
	
	void viewDataStore()
	{
		for (int i = 0; i < StoreList.size(); i++) {
			System.out.println("No. "+(i+1));
			System.out.println("Nama Barang   : "+StoreList.get(i).getItemName());
			System.out.println("ID Barang     : "+StoreList.get(i).getItemId());
			System.out.println("Jumlah Barang : "+StoreList.get(i).getQuantity());
			System.out.println("Harga Barang  : "+StoreList.get(i).getPrice());
			System.out.println("");
		}
	}
	
	void deleteDataStore()
	{
		String delete;
		viewDataStore();
		
		System.out.println("Masukkan ID Barang Yang Ingin Dihapus : ");
		
		delete = scan.nextLine();
		
		for (int i = 0; i < StoreList.size(); i++) {
			if(delete.equals(StoreList.get(i).getItemId()))
			{
				StoreList.remove(i);
				System.out.println("Delete Success");
				System.out.println("");
				System.out.println("Press Enter to go Back to Menu");
				scan.nextLine();
				System.out.println("");
				System.out.println("");
			}
		}
	}
	
	void updateDataStore()
	{
		String update;
		viewDataStore();
		
		System.out.println("Masukkan ID barang yang ingin diubah/update : ");
		update = scan.nextLine();
		
		for (int i = 0; i < StoreList.size(); i++) {
			if(update.equals(StoreList.get(i).getItemId()))
			{
				String tempItemName;
				String tempItemId;
				int tempQuantity;
				int tempPrice;
				boolean check=false;
				
				do{
					System.out.println("Masukkan Nama Barang : ");
					tempItemName = scan.nextLine();
					check = checkuniqueItemName(tempItemName);
					if(check)
					{
						System.out.println("Item Name Must Be Different");
					}
					tempItemName = tempItemName.trim();
				}while(check || tempItemName.isEmpty());
				
				tempItemId = String.format("BS%03d", (rand.nextInt(999)+1));
				
				do{
					System.out.println("Masukkan Jumlah Barang : ");
					tempQuantity = scan.nextInt();scan.nextLine();
				}while(tempQuantity<1);
				
				do{
					System.out.println("Masukkan Harga Barang : ");
					tempPrice = scan.nextInt();scan.nextLine();
				}while(tempPrice < 0);
				
				StoreList.get(i).setItemName(tempItemName);
				StoreList.get(i).setQuantity(tempQuantity);
				StoreList.get(i).setPrice(tempPrice);
			}
		}
	}
	
	public Main()
	{
		int choose;
		
		do{
			System.out.println("BlueJack Store");
			System.out.println("1. Add Data");
			System.out.println("2. View Data");
			System.out.println("3. Delete Data");
			System.out.println("4. Update Data");
			System.out.println("5. Exit");
			System.out.println("Masukkan Pilihan Anda : ");
			choose  = scan.nextInt();scan.nextLine();
			
			switch(choose)
			{
			case 1:
				addStoreData();
				break;
			case 2:
				viewDataStore();
				break;
			case 3:
				deleteDataStore();
				break;
			case 4:
				updateDataStore();
				break;
			}
		}while(choose!=5);
		
		
		
	}
	public static void main(String[] args) {
		new Main();

	}

}
