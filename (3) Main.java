package Exercise3;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	Vector<Library>LibraryDatabase = new Vector<>();
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	boolean checkUniqueBookName(String bookName)
	{
		for (int i = 0; i < LibraryDatabase.size(); i++) {
			if(LibraryDatabase.get(i).getBookName().equals(bookName))
			{
				return true;
			}
		}
		return false;
	}
	
	boolean checkDigit(String msg)
	{
		for (int i = 0; i < LibraryDatabase.size(); i++) {
			if(Character.isDigit(msg.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
	void addLibraryData()
	{
		String tempBookName;
		String tempBookId;
		int tempQuantity;
		int tempPrice;
		boolean check =false;
		
		do{
			System.out.println("Masukkan Nama Buku : ");
			tempBookName = scan.nextLine();
			check = checkUniqueBookName(tempBookName);
			
			if(check)
			{
				System.out.println("Book Name Must be Different");
			}
		}while(check || tempBookName.isEmpty());
		
		tempBookId = String.format("LD%03d", (rand.nextInt(999)+1));
		
		do{
			System.out.println("Masukkan Jumlah Buku : ");
			tempQuantity = scan.nextInt();scan.nextLine();
		}while(tempQuantity<1);
		
		do{
			System.out.println("Masukkan Harga Buku ; ");
			tempPrice = scan.nextInt();scan.nextLine();
		}while(tempPrice < 0);
		
		LibraryDatabase.add(new Library(tempBookName, tempBookId, tempQuantity, tempPrice));
	}
	
	void viewLibraryData()
	{
		for (int i = 0; i < LibraryDatabase.size(); i++) {
			System.out.println("No. "+(i+1));
			System.out.println("Book Name : "+LibraryDatabase.get(i).getBookName());
			System.out.println("Book Id   : "+LibraryDatabase.get(i).getBookId());
			System.out.println("Quantity  : "+LibraryDatabase.get(i).getQuantity());
			System.out.println("Price     : "+LibraryDatabase.get(i).getPrice());
			System.out.println("");
		}
	}
	
	void deleteLibraryData()
	{
		String delete;
		viewLibraryData();
		
		System.out.println("Enter Book Id that you want to delete : ");
		delete = scan.nextLine();
		
		for (int i = 0; i < LibraryDatabase.size(); i++) {
			if(delete.equals(LibraryDatabase.get(i).getBookId()))
			{
				LibraryDatabase.remove(i);
				System.out.println("");
				System.out.println("Delete Success");
				System.out.println("");
				System.out.println("Press Enter to go back to Main Menu...");
				scan.nextLine();
				System.out.println("");
				System.out.println("");
				
			}
		}
	}
	
	void updateLibraryData()
	{
		String update;
		viewLibraryData();
		
		System.out.println("Enter Book Id that you want to Update : ");
		update = scan.nextLine();
		
		for (int i = 0; i < LibraryDatabase.size(); i++) {
			if(update.equals(LibraryDatabase.get(i).getBookId()))
			{
				String tempBookName;
				String tempBookId;
				int tempQuantity;
				int tempPrice;
				boolean check =false;
				
				do{
					System.out.println("Masukkan Nama Buku : ");
					tempBookName = scan.nextLine();
					check = checkUniqueBookName(tempBookName);
					
					if(check)
					{
						System.out.println("Book Name Must be Different");
					}
				}while(check || tempBookName.isEmpty());
				
				tempBookId = String.format("LD%03d", (rand.nextInt(999)+1));
				
				do{
					System.out.println("Masukkan Jumlah Buku : ");
					tempQuantity = scan.nextInt();scan.nextLine();
				}while(tempQuantity<1);
				
				do{
					System.out.println("Masukkan Harga Buku ; ");
					tempPrice = scan.nextInt();scan.nextLine();
				}while(tempPrice < 0);
				
				LibraryDatabase.get(i).setBookName(tempBookName);
				LibraryDatabase.get(i).setBookId(tempBookId);
				LibraryDatabase.get(i).setQuantity(tempQuantity);
				LibraryDatabase.get(i).setPrice(tempPrice);
				
				System.out.println("Update Success");
				System.out.println("");
				System.out.println("Press Enter to go back to Main Menu...");
				scan.nextLine();
				System.out.println("");
				System.out.println("");
			}
		}
	}
	
	public Main()
	{
		int choose;
		
		do{
			System.out.println("Library Database");
			System.out.println("1. Add Book");
			System.out.println("2. View Book");
			System.out.println("3. Delete Book");
			System.out.println("4. Update Book");
			System.out.println("5. Exit");
			System.out.println("Masukkan Pilihan Anda : ");
			choose = scan.nextInt();scan.nextLine();
			
			switch(choose)
			{
			case 1:
				addLibraryData();
				break;
			case 2:
				viewLibraryData();
				break;
			case 3:
				deleteLibraryData();
				break;
			case 4:
				updateLibraryData();
				break;
			}
		}while(choose!=5);
	}
	public static void main(String[] args) {
		new Main();

	}

}
