import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	Vector<Karyawan>StaffList = new Vector<>();
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	
	void addStaffMember()
	{
		String tempStaffId;
		String tempStaffName;
		String tempJabatan;
		int tempSalary;
		
		tempStaffId = String.format("KR%05d", (rand.nextInt(99999)+1));
		do{
			System.out.println("Input nama karyawan [5..20] : ");
			tempStaffName = scan.nextLine();
		}while(tempStaffName.length()<5 || tempStaffName.length()>20);
		
		do{
			System.out.println("Input jabatan [Manager/Supervisor/Staff] : ");
			tempJabatan = scan.nextLine();
		}while(!(tempJabatan.equals("Manager") || tempJabatan.equals("Supervisor") || tempJabatan.equals("Staff")));
		
		do{
			System.out.println("Input gaji [[1000000..30000000] : ");
			tempSalary = scan.nextInt();scan.nextLine();
		}while(tempSalary<1000000 || tempSalary>30000000);
		
		StaffList.add(new Karyawan(tempStaffId, tempStaffName, tempJabatan, tempSalary));
		System.out.println("Data karyawan ditambahkan.");
	}
	
	void updateStaffMember()
	{
		String update;
		String tempStaffId;
		String tempStaffName;
		String tempJabatan;
		int tempSalary;
		
		update = scan.nextLine();
		for (int i = 0; i < StaffList.size(); i++) {
			if(update.equals(StaffList.get(i).getStaffId()))
			{
				tempStaffId = String.format("KR%05d", (rand.nextInt(99999)+1));
				do{
					System.out.println("Input nama karyawan [5..20] : ");
					tempStaffName = scan.nextLine();
				}while(tempStaffName.length()<5 || tempStaffName.length()>20);
				
				do{
					System.out.println("Input jabatan [Manager/Supervisor/Staff] : ");
					tempJabatan = scan.nextLine();
				}while(!(tempJabatan.equals("Manager") || tempJabatan.equals("Supervisor") || tempJabatan.equals("Staff")));
				
				do{
					System.out.println("Input gaji [[1000000..30000000] : ");
					tempSalary = scan.nextInt();scan.nextLine();
				}while(tempSalary<1000000 || tempSalary>30000000);
				StaffList.get(i).setStaffName(tempStaffName);;
				StaffList.get(i).setJabatan(tempJabatan);
				StaffList.get(i).setStaffSalary(tempSalary);
				
				System.out.println("Updated Success!");
				scan.nextLine();
			}
		}
}

	
	
	void deleteStaffMember()
	{
		String delete;
		
		System.out.println("Input kode karyawan yang ingin dihapus : ");
		delete = scan.nextLine();
		
		for (int i = 0; i < StaffList.size(); i++) {
			if(StaffList.isEmpty())
			{
				System.out.println("Belum ada data karyawan");
			}
			else if(StaffList.equals(StaffList.get(i).getStaffId()))
			{
				StaffList.remove(i);
			}
		}
		
	}
	
	void viewStaffMember()
	{
		for (int i = 0; i < StaffList.size(); i++) {
			if(StaffList.isEmpty())
			{
				System.out.println("");
			}
			else
			{
				System.out.println("No. "+(i+1));
				System.out.println("Kode Karyawan : "+StaffList.get(i).getStaffId());
				System.out.println("Nama Karyawan : "+StaffList.get(i).getStaffName());
				System.out.println("Jabatan       : "+StaffList.get(i).getJabatan());
				System.out.println("Gaji          : "+StaffList.get(i).getStaffSalary());
				System.out.println("");
			}
			
		}
	}
	
	public Main()
	{
		int choose;
		
		do{
			viewStaffMember();
			System.out.println("Menu");
			System.out.println("====");
			System.out.println("1. Tambah karyawan");
			System.out.println("2. Update karyawan");
			System.out.println("3. Hapus karyawan");
			System.out.println("4. Keluar");
			System.out.println("Pilih menu : ");
			choose = scan.nextInt();scan.nextLine();
			
			switch(choose)
			{
			case 1:
				addStaffMember();
				break;
			case 2:
				
				break;
			case 3:
				deleteStaffMember();
				break;
			}
		}while(choose!=4);
		
	}
	public static void main(String[] args) {
		new Main();

	}

}