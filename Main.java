package Latihan1;

import java.util.*;

public class Main {
	
	Vector<BookStore>BookList = new Vector<>();
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	boolean checkUniqueName(String bookName)
	{
		for (int i = 0; i < BookList.size(); i++) {
			if(BookList.get(i).getBookName().equals(bookName))
			{
				return true;
			}
		}
		return false;
	}
	
	boolean checkDigit(String msg)
	{
		for (int i = 0; i < BookList.size(); i++) {
			if(Character.isDigit(msg.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
	
	void addBook()
	{
		String tempbookName;
		String tempbookID;
		int tempQuantity;
		int tempPrice;
		boolean check = false;
		
		do{
			System.out.println("Masukkan Nama Buku : ");
			tempbookName = scan.nextLine();
			
			check = checkUniqueName(tempbookName);
			
			if(check)
			{
				System.out.println("Nama Sudah Ada!! ,  Tekan Enter untuk mengulang");
			}
			
			tempbookName = tempbookName.trim();
			
		}while(check || tempbookName.isEmpty());
		
		
		tempbookID = String.format("BU%3d", rand.nextInt(999)+1);
		
		System.out.println("Masukkan Jumlah Buku : ");
		tempQuantity = scan.nextInt();scan.nextLine();
		
		System.out.println("Masukkan Harga Buku : ");
		tempPrice = scan.nextInt();scan.nextLine();
		
		BookList.add(new BookStore(tempbookName, tempbookID, tempQuantity, tempPrice));
		
	}
	
	void viewBook()
	{
		for (int i = 0; i < BookList.size(); i++) {
			System.out.println("No. "+(i+1));
			System.out.println("Nama Buku   : "+BookList.get(i).getBookName());
			System.out.println("ID buku     : "+BookList.get(i).getBookID());
			System.out.println("Jumlah Buku : "+BookList.get(i).getQuantity());
			System.out.println("Harga Buku  : "+BookList.get(i).getPrice());
		}
		scan.nextLine();
	}
	
	void deleteBook()
	{
		viewBook();
		String delete;
		
		System.out.println("Masukkan ID buku yang ingin dihapus : ");
		delete = scan.nextLine();
		
		for (int i = 0; i < BookList.size(); i++) 
		{
			if(delete.equals(BookList.get(i).getBookID()))
			{
				BookList.remove(i);
				System.out.println("Data Berhasil Dihapus!!!");
				System.out.println("Tekan Enter Untuk Melanjutkan");
				scan.nextLine();
			}
		}
		
	}
	
	void updateBook()
	{
		String update;
		
		System.out.println("Masukkan ID buku yang ingin diubah : ");
		update = scan.nextLine();
		
		for (int i = 0; i < BookList.size(); i++) {
			if(update.equals(BookList.get(i).getBookID()))
			{
				String tempbookName;
				String tempbookID;
				int tempQuantity;
				int tempPrice;
				boolean check = false;
				
				do{
					System.out.println("Masukkan Nama Buku : ");
					tempbookName = scan.nextLine();
					
					check = checkUniqueName(tempbookName);
					
					if(check)
					{
						System.out.println("Nama Sudah Ada!! ,  Tekan Enter untuk mengulang");
					}
					
					tempbookName = tempbookName.trim();
					
				}while(check || tempbookName.isEmpty());
				
				
				tempbookID = String.format("BU%3d", rand.nextInt(999)+1);
				
				System.out.println("Masukkan Jumlah Buku : ");
				tempQuantity = scan.nextInt();scan.nextLine();
				
				System.out.println("Masukkan Harga Buku : ");
				tempPrice = scan.nextInt();scan.nextLine();
				
				BookList.get(i).setBookName(tempbookName);
				BookList.get(i).setQuantity(tempQuantity);
				BookList.get(i).setPrice(tempPrice);
			}
		}
	}
	
	public Main()
	{
		int choose;
		
		do{
			System.out.println("Menu Toko Buku");
			System.out.println("1. Add Book");
			System.out.println("2. View Book");
			System.out.println("3. Delete Book");
			System.out.println("4. Update Book");
			System.out.println("5. Exit");
			System.out.println("Masukkan Pilihan Anda[1..5] : ");
			choose = scan.nextInt();scan.nextLine();
			
			switch(choose)
			{
			case 1:
				addBook();
				break;
			case 2:
				viewBook();
				break;
			case 3:
				deleteBook();
				break;
			case 4:
				updateBook();
				break;
			}
		}while(choose != 5);
		
		
	}
	
	public static void main(String[] args)
	{
		new Main();
	}
}
