import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Main {
 	public void enter(){
		for(int i = 0;i<30;i++){
			System.out.println();
		}
	}
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	Vector<String> nama = new Vector<>();
	Vector<String> location = new Vector<>();
	Vector<String> namabarang = new Vector<>();
	Vector<String> description = new Vector<>();
	Vector<String> locationbarang = new Vector<>();
	Vector<String> portable = new Vector<>();
	Vector<String> container = new Vector<>();
	Vector<String> required = new Vector<>();
	Vector<String> treasure = new Vector<>();
	Vector<String> inventory = new Vector<>();
	Integer[] kota1 = new Integer[4];
	Integer[] kota2 = new Integer[4];
	Integer[] kota3 = new Integer[4];
	Integer[] kota4 = new Integer[4];
	Integer[] kota5 = new Integer[4];
	public void set(int choice){

		int benar = 0;
			
		String roomDescription = "";
		
		String pilih = "";
		do{
		do{
		System.out.print("Do you want to add new item, update or remove existing item? [Add|Update|Remove]: ");
		pilih = scan.nextLine();
		}while(!pilih.equalsIgnoreCase("add") && !pilih.equalsIgnoreCase("update") && !pilih.equalsIgnoreCase("remove"));
		if(pilih.equalsIgnoreCase("add")){
			break;
		}
		else if(pilih.equalsIgnoreCase("remove")){
			break;
		}
		else if(pilih.equalsIgnoreCase("update")){
			String names="";
			String description="";
			String sure = "";
			String portable = "";
			String examine = "";
			String container = "";
			String containerDescription = "";
			int idx = -1;
			int setuju = 0;
			int indexContainer = 0;
			for(int i = 0;i<locationbarang.size();i++){
				if(locationbarang.elementAt(i).equalsIgnoreCase(nama.elementAt(choice-1))){
					System.out.println(namabarang.elementAt(i));
				}
			}
			do{
			idx = -1;
			System.out.print("Input item name: ");
			names = scan.nextLine();
			for(int i = 0;i<namabarang.size();i++){
				if(namabarang.elementAt(i).equals(names)){
					idx = i;
					break;
				}
			}
			}while(idx == -1);
			do{
				System.out.print("Input item description [Length 15 - 50]: ");
				description = scan.nextLine();
			}while(description.length() < 15 || description.length() > 50);
			this.description.set(idx, description);
			int ho = 0;
			do{
				ho = 0;
				System.out.print("Is this item portable? [Yes|No]: ");
				sure = scan.nextLine();
				if(sure.equalsIgnoreCase("yes")){
					portable = "true";
					ho = 1;
				}
				else if(sure.equalsIgnoreCase("no")){
					portable = "false";
					ho = 1;
				}
			}while(ho == 0);
			this.portable.set(idx, portable);
			ho = 0;
			int index2 = -1;
			do{
				String namabarang = "";
				System.out.println("Is there any item required to examine this item? [Yes|No]: ");
				sure = scan.nextLine();
				if(sure.equalsIgnoreCase("yes")){
					for(int i = 0;i<this.portable.size();i++){
						if(this.portable.elementAt(i).equals("true")){
							System.out.println("- " + this.namabarang.elementAt(i));
						}
					}
					do{
						index2 = -1;
					System.out.print("Input item name: ");
					namabarang = scan.nextLine();
					for(int i = 0;i<this.namabarang.size();i++){
						if(this.namabarang.elementAt(i).equals(namabarang) && this.portable.elementAt(i).equals("true")){
							index2 = i;
							break;
						}
					}
					}while(index2 == -1);
					examine = this.namabarang.elementAt(index2);
					ho = 1;
				}
				else if(sure.equalsIgnoreCase("no")){
					examine = "-1";
					ho = 1;
				}
			}while(ho == 0);
			this.required.set(idx,examine);
			int o = 0;
			for(int i = 0;i<this.locationbarang.size();i++){
				if(this.locationbarang.elementAt(i).equals(nama.elementAt(choice-1)) && this.container.elementAt(i).equals("0")){
					o = 1;
				}
			}
			if(o != 0){
				System.out.println("Select where to place this item:");
				int aoiu = 0;
				for(int i = 0;i<this.locationbarang.size();i++){
					if(this.locationbarang.elementAt(i).equals(nama.elementAt(choice-1)) && this.container.elementAt(i).equals("0")){
						System.out.println((aoiu+1)+ " " + namabarang.elementAt(i));
						aoiu += 1;
					}
				}
				int u = 0;
				do{
				u = 0;
				System.out.print("Input container name: ");
				container = scan.nextLine();
				for(int i = 0;i<this.container.size();i++){
					if(this.namabarang.elementAt(i).equals(container) && this.container.elementAt(i).equals("0")){
						u = 1;
						indexContainer = i;
						break;
					}
				}
				}while(u == 0);
				this.container.set(idx, this.namabarang.elementAt(indexContainer));
				String choice2 = "";
				do{
				System.out.print("Adding or updating item container may have caused an inconsitency in the\nitem's container description. Do you want to update it? [Yes|No]: ");
				choice2 = scan.nextLine();
				}while(!choice2.equals("yes") && !choice2.equalsIgnoreCase("no"));
				if(choice2.equals("yes")){
					setuju = 1;
				}
				else{
					setuju = 0;
				}
				if(setuju == 1){
					do{
					System.out.println("Old Description: ");
					System.out.println(this.description.elementAt(indexContainer));
					System.out.print("Input new Description [Length 15-50]: ");
					containerDescription = scan.nextLine();
					}while(containerDescription.length() < 15 || containerDescription.length() > 50);
					this.description.set(indexContainer,containerDescription);
				}
				String done = "";
				do{
					System.out.println("Are you done? [Yes|No]");
					done = scan.nextLine();
				}while(!done.equalsIgnoreCase("yes") && !done.equalsIgnoreCase("no"));
				if(done.equalsIgnoreCase("no")){
					benar = 0;
				}
				else if(done.equalsIgnoreCase("yes")){
					benar = 1;
				}
			}
		}
		}while(benar == 0);
		if(pilih.equalsIgnoreCase("Update")){
		String wow = "";
		do{
		System.out.print("Add, update or remove item may have caused an inconsitency in the\nroom's description. Do you want to update it? [Yes|No]");
		wow = scan.nextLine();
		}while(!wow.equalsIgnoreCase("yes") && !wow.equalsIgnoreCase("no"));
		if(wow.equals("yes")){
			System.out.println("This is your old description: ");
			System.out.println(location.elementAt(choice-1));
			do{
			System.out.print("Input new description: ");
			roomDescription = scan.nextLine();
			}while(roomDescription.length() < 15 || roomDescription.length() > 50);
			location.set(choice-1, roomDescription);
		}
		}
		if(pilih.equalsIgnoreCase("add")){
			String nama = "";
			String description = "";
			String portable = "";
			String required = "";
			String container = "";
			int u = 1;
			do{
				u = 1;
			System.out.print("Input item name: ");
			nama = scan.nextLine();
			for(int i = 0;i<this.namabarang.size();i++){
				if(this.namabarang.elementAt(i).equals(nama)){
					System.out.println();
					u = 0;
					break;
				}
			}
			}while(u == 0);
	//		namabarang.add(nama);
			do{
				System.out.print("Input item description [Length 15 - 50]: ");
				description = scan.nextLine();
			}while(description.length() < 15 || description.length() > 50);
			this.description.add(description);
			String pilih5 = "";
			do{
				System.out.print("Is this item portable? [Yes|No]: ");
				pilih5 = scan.nextLine();
			}while(!pilih5.equalsIgnoreCase("yes") && !pilih5.equalsIgnoreCase("no"));
			if(pilih5.equalsIgnoreCase("yes")){
				portable = "true";
			}
			else{
				portable = "false";
			}
		//	this.portable.add(portable);
			pilih5 = "";
			do{
				System.out.print("Is there any item required to examine this item? [Yes|No]: ");
				pilih5 = scan.nextLine();
			}while(!pilih5.equalsIgnoreCase("yes") && !pilih5.equalsIgnoreCase("no"));
			if(pilih5.equalsIgnoreCase("no")){
				required = "-1";
			}
			else{
				String item = "";
				int fleg = 0;
				do{
				for(int i = 0;i<this.locationbarang.size();i++){
					if(this.portable.elementAt(i).equalsIgnoreCase("true")){
						System.out.println("- " + this.namabarang.elementAt(i));
					}
				}
				System.out.print("Input item name: ");
				item = scan.nextLine();
				for(int i = 0;i<this.namabarang.size();i++){
					if(this.namabarang.elementAt(i).equals(item)){
						if(this.locationbarang.elementAt(i).equals(this.nama.elementAt(choice-1))){
							fleg = 1;
							required = this.namabarang.elementAt(i);
							break;
						}
					}
				}
				}while(fleg == 0);
			}
				int idx = 0;
				for(int i = 0;i<this.container.size();i++){
					if(this.container.elementAt(i).equalsIgnoreCase("0")){
						idx += 1;
						break;
					}
				}
				int o = 0;
				int index = 0;
				if(idx != 0){
					do{
						String contain = "";
						o = 0;
					for(int i = 0;i<this.container.size();i++){
						if(this.container.elementAt(i).equalsIgnoreCase("0")){
							if(this.locationbarang.elementAt(i).equals(this.nama.elementAt(choice-1))){
							System.out.println("- " + this.namabarang.elementAt(i));
							}
						}
					}
					System.out.print("Input container name: ");
					contain = scan.nextLine();
					for(int i = 0;i<this.container.size();i++){
						if(this.container.elementAt(i).equalsIgnoreCase("0")){
							if(this.namabarang.elementAt(i).equals(contain)){
								container = namabarang.elementAt(i);
								o = 1;
								index = i;
								break;
							}
						}
					}
					}while(o == 0);
					
				}
				else{
					container = "-1";
				}
				if(o == 1){
					String yes = "";
					String rubah = "";
					do{
					System.out.println("Adding or updating item container may have caused an inconsistency in the");
					System.out.print("item's container description. Do you want to update it? [Yes|No]: ");
					yes = scan.nextLine();
					}while(!yes.equalsIgnoreCase("yes") && !yes.equalsIgnoreCase("no"));
					if(yes.equalsIgnoreCase("yes")){
						System.out.println("Old Description:");
						System.out.println(this.description.elementAt(index));
						do{
						System.out.print("Input new Description [length 15-50]: ");
						rubah = scan.nextLine();
						}while(rubah.length() < 15 || rubah.length() > 50);
						this.description.set(index, rubah);
					}
				}
				this.namabarang.add(nama);
				this.description.add(description);
				this.locationbarang.add(this.nama.elementAt(choice-1));
				this.portable.add(portable);
				this.required.add(required);
				this.container.add(container);
				this.treasure.add("false");
				String yos = "";
				do{
				System.out.println("Are you done? [Yes|No]: ");
				yos = scan.nextLine();
				}while(!yos.equalsIgnoreCase("yes") && !yos.equalsIgnoreCase("no"));
				
				if(yos.equalsIgnoreCase("no")){
					set(choice+1);
				}
				if(yos.equalsIgnoreCase("yes")){
					String hello="";
					do{
					System.out.println("Add, update or remove item may have caused an inconsistency in the");
					System.out.print("room's description. Do you want to update it? [Yes|No]: ");
					hello = scan.nextLine();
					}while(!hello.equalsIgnoreCase("yes") && !hello.equalsIgnoreCase("no"));
					if(hello.equalsIgnoreCase("yes")){
						System.out.println("This is your old description: ");
						System.out.println(this.location.elementAt(choice-1));
						String keselek = "";
						do{
						System.out.println("Input new description: ");
						keselek = scan.nextLine();
						}while(keselek.length() < 15 || keselek.length() > 50);
						this.location.set(choice-1, keselek);
					}
				}
		}
		if(pilih.equalsIgnoreCase("remove")){
			int on = 0;
			String tempnama = "";
			int flegs = 0;
			do{
				on = 0;
			System.out.println("Item List: ");
			for(int i = 0;i<this.locationbarang.size();i++){
				if(this.locationbarang.elementAt(i).equalsIgnoreCase(nama.elementAt(choice-1))){
					System.out.println((on+1)+" "+this.namabarang.elementAt(i));
					on += 1;
				}
			}
			System.out.print("Input item name: ");
			tempnama = scan.nextLine();
			int fleo = 0;
			for(int i = 0;i<this.required.size();i++){
				if(this.required.elementAt(i).equals(tempnama)){
					fleo = 1;
					break;
				}
			}
			int containers = 0;
			for(int i = 0;i<this.namabarang.size();i++){
				if(this.locationbarang.elementAt(i).equals(nama.elementAt(choice-1))){
					if(this.namabarang.elementAt(i).equals(tempnama)){
						if(this.treasure.elementAt(i).equals("false")){
							if(this.container.elementAt(i).equals("0")){
								containers = 1;
							}
							if(containers == 0){
								if(fleo == 0){
									if(this.portable.elementAt(i).equalsIgnoreCase("false")){
										System.out.println("You cannot delete container and default item!");
									}
									else{
									System.out.println("Data successfully removed!");
									namabarang.remove(i);
									treasure.remove(i);
									locationbarang.remove(i);
									treasure.remove(i);
									container.remove(i);
									required.remove(i);
									description.remove(i);
									}
									scan.nextLine();
								}
								else if(fleo == 1){
									System.out.println("This item is required by another item, you cannot remove it!");
								}
							}
							else{
								System.out.println("You cannot delete container and default item!");
							}
						}
						else{
							System.out.println("You cannot delete Treasure Item!");
							scan.nextLine();
						}
					}
				}
			}
			flegs = 1;
			}while(flegs == 0);
		}
	}

 	public Main() {
		// TODO Auto-generated constructor stub
	
		File f = new File("room.txt");
		FileReader fr = null;
		try {
			fr = new FileReader(f);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found!");
		}
		BufferedReader bf = new BufferedReader(fr);
		String tampung = "";
		int a = 0;
		try {
			while((tampung = bf.readLine()) != null){
				String[] temps = tampung.split(";");
				nama.add(temps[0]);
				location.add(temps[1]);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("File not Found!");
		}
		File ao = new File("item.txt");
		FileReader fa = null;
		try {
			fa = new FileReader(ao);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("File not Found!");
		}
		bf = new BufferedReader(fa);
		String tampung2 = "";
		try{
			while((tampung2 = bf.readLine()) != null){
				String[] temps = tampung2.split(";");
				//System.out.println(temps);
				this.namabarang.add(temps[0]);
				this.description.add(temps[1]);
				this.locationbarang.add(temps[2]);
				this.portable.add(temps[3]);
				this.container.add(temps[4]);
				this.required.add(temps[5]);
				this.treasure.add(temps[6]);
			}
//			for(int i = 0;i<this.namabarang.size();i++){
//				System.out.println(this.namabarang.elementAt(i) + " " + this.description.elementAt(i) + " " + this.locationbarang.elementAt(i) + " " + this.portable.elementAt(i) + " " + this.container.elementAt(i) + " " + this.required.elementAt(i) + " " + this.treasure.elementAt(i));
////			}
//			scan.nextLine();
//			scan.nextLine();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("File not Found!");
		}
		int x = 0;
		do{
		enter();
		for(int i =0;i<4;i++){
			kota1[i] = -1;
			kota2[i] = -1;
			kota3[i] = -1;
			kota4[i] = -1;
			kota5[i] = -1;
		}
		int tru =0;
		while(tru == 0){
			int temp = 0;
			for(int i = 0;i<4;i++){
				if(kota1[i] != -1){
					if(i == 0){
						temp = 2;
					}
					else if(i == 1){
						temp = 3;
					}
					else if(i == 2){
						temp = 0;
					}
					else if(i == 3){
						temp = 1;
					}
					if(kota1[i] == 1){
						kota2[temp] = 0;
					}
					else if(kota1[i] == 2){
						kota3[temp] = 0;
					}
					else if(kota1[i] == 3){
						kota4[temp] = 0;
					}
					else if(kota1[i] == 4){
						kota5[temp] = 0;
					}
				}
				if(kota2[i] != -1){
					if(i == 0){
						temp = 2;
					}
					else if(i == 1){
						temp = 3;
					}
					else if(i == 2){
						temp = 0;
					}
					else if(i == 3){
						temp = 1;
					}
					if(kota2[i] == 0){
						kota1[temp] = 1;
					}
					else if(kota2[i] == 2){
						kota3[temp] = 1;
					}
					else if(kota2[i] == 3){
						kota4[temp] = 1;
					}
					else if(kota2[i] == 4){
						kota5[temp] = 1;
					}
				}
				if(kota3[i] != -1){
					if(i == 0){
						temp = 2;
					}
					else if(i == 1){
						temp = 3;
					}
					else if(i == 2){
						temp = 0;
					}
					else if(i == 3){
						temp = 1;
					}
					if(kota3[i] == 0){
						kota1[temp] = 2;
					}
					else if(kota3[i] == 1){
						kota2[temp] = 2;
					}
					else if(kota3[i] == 3){
						kota4[temp] = 2;
					}
					else if(kota3[i] == 4){
						kota5[temp] = 2;
					}
				}
				if(kota4[i] != -1){
					if(i == 0){
						temp = 2;
					}
					else if(i == 1){
						temp = 3;
					}
					else if(i == 2){
						temp = 0;
					}
					else if(i == 3){
						temp = 1;
					}
					if(kota4[i] == 0){
						kota1[temp] = 3;
					}
					else if(kota4[i] == 1){
						kota2[temp] = 3;
					}
					else if(kota4[i] == 2){
						kota3[temp] = 3;
					}
					else if(kota4[i] == 4){
						kota5[temp] = 3;
					}
				}
				if(kota5[i] != -1){
					if(i == 0){
						temp = 2;
					}
					else if(i == 1){
						temp = 3;
					}
					else if(i == 2){
						temp = 0;
					}
					else if(i == 3){
						temp = 1;
					}
					if(kota5[i] == 0){
						kota1[temp] = 4;
					}
					else if(kota5[i] == 1){
						kota2[temp] = 4;
					}
					else if(kota5[i] == 2){
						kota3[temp] = 4;
					}
					else if(kota2[i] == 3){
						kota4[temp] = 4;
					}
				}
				
				
			}
				int u = rand.nextInt(4)+1;
				int pos = rand.nextInt(4);
				int pos2 = rand.nextInt(5);
				if(pos2 == 0){
					if(kota1[pos] == -1){
						if(u-1 != 0){
							int betul = 0;
							for(int i = 0;i<4;i++){
								if(kota1[i] == u-1){
									betul = 1;
								}
							}
							if(betul == 0){
								if(kota1[pos] == -1){
								if(u-1 == 1){
									if(pos == 0 || pos == 1){
										if(kota2[pos+2] == -1){
										kota2[pos+2] = 0;
										kota1[pos] = u-1;
										}
									}
									else{
										if(kota2[pos-2] == -1){
											kota1[pos] = u-1;
											kota2[pos-2] = 0;
										}
									}
								}
								else if(u-1 == 2){
									if(pos == 0 || pos == 1){
										if(kota3[pos+2] == -1){
										kota3[pos+2] = 0;
										kota1[pos] = u-1;
										}
									}
									else{
										if(kota3[pos-2] == -1){
										kota3[pos-2] = 0;
										kota1[pos] = u-1;
										}
									}
								}
								else if(u-1 == 3){
									if(pos == 0 || pos == 1){
										if(kota4[pos+2] == -1){
										kota4[pos+2] = 0;
										kota1[pos] = u-1;
										}
									}
									else{
										if(kota4[pos-2] == -1){
										kota4[pos-2] = 0;
										kota1[pos] = u-1;
										}
									}
								}
								else if(u-1 == 4){
									if(pos == 0 || pos == 1){
										if(kota5[pos+2] == -1){
										kota5[pos+2] = 0;
										kota1[pos] = u-1;
										}
									}
									else{
										if(kota5[pos-2] == -1){
										kota5[pos-2] = 0;
										kota1[pos] = u-1;
										}
									}
								}
								}
							}
						}
					}
				}
				else if(pos2 == 1){
					if(kota2[pos] == -1){
						if(u-1 != 1){
							int betul = 0;
							for(int i = 0;i<4;i++){
								if(kota2[i] == u-1){
									betul = 1;
								}
							}
							if(betul == 0){
								if(kota2[pos] == -1){
								if(u-1 == 0){
									if(pos == 0 || pos == 1){
										if(kota1[pos+2] == -1){
											kota2[pos] = u-1;
											kota1[pos+2] = 1;
										}
									}
									else{
										if(kota1[pos-2] == -1){
											kota2[pos] = u-1;
											kota1[pos-2] = 1;
										}
									}
								}
								else if(u-1 == 2){
									if(pos == 0 || pos == 1){
										if(kota3[pos+2] == -1){
										kota3[pos+2] = 1;
										kota2[pos] = u-1;
										}
									}
									else{
										if(kota3[pos-2] == -1){
										kota3[pos-2] = 1;
										kota2[pos] = u-1;
										}
									}
								}
								else if(u-1 == 3){
									if(pos == 0 || pos == 1){
										if(kota4[pos+2] == -1){
										kota4[pos+2] = 1;
										kota2[pos] = u-1;
										}
									}
									else{
										if(kota4[pos-2] == -1){
										kota4[pos-2] = 1;
										kota2[pos] = u-1;
										}
									}
								}
								else if(u-1 == 4){
									if(pos == 0 || pos == 1){
										if(kota5[pos+2] == -1){
										kota5[pos+2] = 1;
										kota2[pos] = u-1;
										}
									}
									else{
										if(kota5[pos-2] == -1){
										kota5[pos-2] = 1;
										kota2[pos] = u-1;
										}
									}
								}
							}
							}
						}
					}
				}
				else if(pos2 == 2){
					if(kota3[pos] == -1){
						if(u-1 != 2){
							int betul = 0;
						for(int i = 0;i<4;i++){
							if(kota3[i] == u){
								betul = 1;
								break;
							}
						}
						if(betul == 0){
							if(kota3[pos] == -1){
							if(u-1 == 0){
								if(pos == 0 || pos == 1){
									if(kota1[pos+2] == -1){
									kota1[pos+2] = 2;
									kota3[pos] = u-1;
									}
								}
								else{
									if(kota1[pos-2] == -1){
									kota1[pos-2] = 2;
									kota3[pos] = u-1;
									}
								}
							}
							else if(u-1 == 1){
								if(pos == 0 || pos == 1){
									if(kota2[pos+2] == -1){
									kota2[pos+2] = 2;
									kota3[pos] = u-1;
									}
								}
								else{
									if(kota2[pos-2] == -1){
									kota2[pos-2] = 2;
									kota3[pos] = u-1;
									}
								}
							}
							else if(u-1 == 3){
								if(pos == 0 || pos == 1){
									if(kota4[pos+2] == -1){
									kota4[pos+2] = 2;
									kota3[pos] = u-1;
									}
								}
								else{
									if(kota4[pos-2] == -1){
									kota4[pos-2] = 2;
									kota3[pos] = u-1;
									}
								}
							}
							else if(u-1 == 4){
								if(pos == 0 || pos == 1){
									if(kota5[pos+2] == -1){
									kota5[pos+2] = 2;
									kota3[pos] = u-1;
									}
								}
								else{
									if(kota5[pos-2] == -1){
									kota5[pos-2] = 2;
									kota3[pos] = u-1;
									}
								}
							}
							}
						}
						}
					}
				}
				else if(pos2 == 3){
					if(kota4[pos] == -1){
						if(u-1 != 3){
							int betul = 0;
							for(int i = 0;i<4;i++){
								if(kota4[i] == u-1){
									betul = 1;
								}
							}
							if(betul == 0){
								if(kota4[pos] == -1){
								if(u-1 == 0){
									if(pos == 0 || pos == 1){
										if(kota1[pos+2] == -1){
										kota1[pos+2] = 3;
										kota4[pos] = u-1;
										}
									}
									else{
										if(kota1[pos-2] == -1){
										kota1[pos-2] = 3;
										kota4[pos] = u-1;
										}
									}
								}
								else if(u-1 == 1){
									if(pos == 0 || pos == 1){
										if(kota2[pos+2] == -1){
										kota2[pos+2] = 3;
										kota4[pos] = u-1;
										}
									}
									else{
										if(kota2[pos-2] == -1){
										kota2[pos-2] = 3;
										kota4[pos] = u-1;
										}
									}
								}
								else if(u-1 == 2){
									if(pos == 0 || pos == 1){
										if(kota3[pos+2] == -1){
										kota3[pos+2] = 3;
										kota4[pos] = u-1;
										}
									}
									else{
										if(kota3[pos-2] == -1){
										kota3[pos-2] = 3;
										kota4[pos] = u-1;
										}
									}
								}
								else if(u-1 == 4){
									if(pos == 0 || pos == 1){
										if(kota5[pos+2] == -1){
										kota5[pos+2] = 3;
										kota4[pos] = u-1;
										}
									}
									else{
										if(kota5[pos+2] == -1){
										kota5[pos-2] = 3;
										kota4[pos] = u-1;
										}
									}
								}
								}
							}
						}
					}
				}
				else if(pos2 == 4){
					if(kota5[pos] == -1){
						if(u-1 != 4){
							int betul = 0;
						for(int i = 0;i<4;i++){
							if(kota5[i] == u-1){
								betul = 1;
							}
						}
						if(betul == 0){
						if(kota5[pos] == -1){
						if(u-1 == 0){
							if(pos == 0 || pos == 1){
								if(kota1[pos+2] == -1){
								kota1[pos+2] = 4;
								kota5[pos] = u-1;
								}
							}
							else{
								if(kota1[pos-2] == -1){
								kota1[pos-2] = 4;
								kota5[pos] = u-1;
								}
							}
						}
						else if(u-1 == 1){
							if(pos == 0 || pos == 1){
								if(kota2[pos+2] == -1){
								kota2[pos+2] = 4;
								kota5[pos] = u-1;
								}
							}
							else{
								if(kota2[pos-2] == -1){
								kota2[pos-2] = 4;
								kota5[pos] = u-1;
								}
							}
						}
						else if(u-1 == 2){
							if(pos == 0 || pos == 1){
								if(kota3[pos+2] == -1){
								kota3[pos+2] = 4;
								kota5[pos] = u-1;
								}
							}
							else{
								if(kota3[pos-2] == -1){
								kota3[pos-2] = 4;
								kota5[pos] = u-1;
								}
							}
						}
						else if(u-1 == 3){
							if(pos == 0 || pos == 1){
								if(kota4[pos+2] == -1){
								kota4[pos+2] = 4;
								kota5[pos] = u-1;
								}
							}
							else{
								if(kota4[pos-2] == -1){
								kota4[pos-2] = 4;
								kota5[pos] = u-1;
								}
							}
						}
						}
						}
						}
					}
				}
			int kota1t=0,kota2t=0,kota3t=0,kota4t=0,kota5t=0;
				for(int i = 0;i<4;i++){
					if(kota1[i] == 0 || kota2[i] == 0 || kota3[i] == 0 || kota4[i] == 0 || kota5[i] == 0){
						kota1t = 1;
					}
					if(kota1[i] == 1 || kota2[i] == 1 || kota3[i] == 1 || kota4[i] == 1 || kota5[i] == 1){
						kota2t = 1;
					}
					if(kota1[i] == 2 || kota2[i] == 2 || kota3[i] == 2 || kota4[i] == 2 || kota5[i] == 2){
						kota3t = 1;
					}
					if(kota1[i] == 3 || kota2[i] == 3 || kota3[i] == 3 || kota4[i] == 3 || kota5[i] == 3){
						kota4t = 1;
					}
					if(kota1[i] == 4 || kota2[i] == 4 || kota3[i] == 4 || kota4[i] == 4 || kota5[i] == 4){
						kota5t = 1;
					}
			}
			if(kota1t == 1 && kota2t == 1 && kota3t == 1 && kota4t == 1 && kota5t == 1){
				tru = 1;
			}
			else{
				tru = 0;
			}
		}
		tru = 0;
		int mulai = 0;
		System.out.println("MEONG THE MAWLINK");
		System.out.println("=================");
		System.out.println("1. Play Game");
		System.out.println("2. Design Game");
		System.out.println("3. Exit");
		System.out.print("Choose: ");
		try {
			x = scan.nextInt();
			scan.nextLine();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Input must be number!");
			x = 0;
			scan.nextLine();
		}
		if(x == 1){
			inventory.removeAllElements();
			int fleg = 0;
			int turn = 15;
			int treasure = 0;
			enter();
			do{
				treasure = 0;
			if(!inventory.isEmpty()){
			for(int i = 0;i<this.inventory.size();i++){
				if(this.inventory.elementAt(i).equalsIgnoreCase("earring") || this.inventory.elementAt(i).equalsIgnoreCase("crystal")){
					treasure += 1;
				}
			}
			}
			if(treasure == 2){
				System.out.println("You Win!");
				break;
			}
			if(turn == 0){
				System.out.println("You Lose!");
				break;
			}
			System.out.println(nama.elementAt(mulai).toUpperCase());
			System.out.println(location.elementAt(mulai));
			for(int i = 0;i<4;i++){
				if(mulai == 0){
					if(kota1[i] != -1){
						System.out.print("There is a " + nama.elementAt(kota1[i]) + " on the ");
						if(i == 0){
							System.out.println("NORTH");
						}
						else if(i == 2){
							System.out.println("SOUTH");
						}
						else if(i == 1){
							System.out.println("WEST");
						}
						else if(i == 3){
							System.out.println("EAST");
						}
					}
				}
				else if(mulai == 1){
					if(kota2[i] != -1){
						System.out.print("There is a " + nama.elementAt(kota2[i]) + " on the ");
						if(i == 0){
							System.out.println("NORTH");
						}
						else if(i == 2){
							System.out.println("SOUTH");
						}
						else if(i == 1){
							System.out.println("WEST");
						}
						else if(i == 3){
							System.out.println("EAST");
						}
					}
				}
				else if(mulai == 2){
					if(kota3[i] != -1){
						System.out.print("There is a " + nama.elementAt(kota3[i]) + " on the ");
						if(i == 0){
							System.out.println("NORTH");
						}
						else if(i == 2){
							System.out.println("SOUTH");
						}
						else if(i == 1){
							System.out.println("WEST");
						}
						else if(i == 3){
							System.out.println("EAST");
						}
					}
				}
				else if(mulai == 3){
					if(kota4[i] != -1){
						System.out.print("There is a " + nama.elementAt(kota4[i]) + " on the ");
						if(i == 0){
							System.out.println("NORTH");
						}
						else if(i == 2){
							System.out.println("SOUTH");
						}
						else if(i == 1){
							System.out.println("WEST");
						}
						else if(i == 3){
							System.out.println("EAST");
						}
					}
				}
				else if(mulai == 4){
					if(kota5[i] != -1){
						System.out.print("There is a " + nama.elementAt(kota5[i]) + " on the ");
						if(i == 0){
							System.out.println("NORTH");
						}
						else if(i == 2){
							System.out.println("SOUTH");
						}
						else if(i == 1){
							System.out.println("WEST");
						}
						else if(i == 3){
							System.out.println("EAST");
						}
					}
				}
			}
			String keyword;
			String perintah;
			System.out.println("Turn's left: " + turn);
			System.out.print(">");
			keyword = scan.next();
			perintah = scan.nextLine();
			int au = 0;
			int fla = 0;
			int tul = 0;
			//int u = 0;
			int z = 0;
			if(keyword.equalsIgnoreCase("drop")){
				perintah.trim();
				String[] temp = perintah.split(" ");
				if(!perintah.isEmpty()){
					if(!inventory.isEmpty()){
						for(int i = 0;i<temp.length;i++){
							z = 0;
							if(!temp[i].equalsIgnoreCase("")){
							for(int j = 0;j<inventory.size();j++){
								if(temp[i].equalsIgnoreCase(inventory.elementAt(j))){
									z = 1;
									inventory.remove(j);
									System.out.println("Item Removed!");
									break;
								}
							}
							if(z == 0){
								System.out.println("No such Item exist!");
								System.out.println("Suggestion for word ["+temp[i]+"]:");
								Vector<String>list = new Vector<>();
								Vector<Integer>kemiripan = new Vector<>();
								int temps = 0;
								for(int j = 0;j<namabarang.size();j++){
									temps = 0;
									for(int k = 0;k<temp[i].length();k++){
										for(int l = 0;l<namabarang.elementAt(j).length();l++){
											if(namabarang.elementAt(j).charAt(l) == temp[i].charAt(k)){
												temps += 1;
												break;
											}
										}
									}
									if(temps != 0){
										kemiripan.add(temps);
										list.add(namabarang.elementAt(j));
									}
								}
								if(!list.isEmpty()){
								for(int j = 0;j<list.size();j++){
									for(int k = 0;k<list.size()-1;k++){
										if(kemiripan.elementAt(k) < kemiripan.elementAt(k+1)){
											String tempy = list.elementAt(k);
											list.set(k, list.elementAt(k+1));
											list.set(k+1, tempy);
											int aus = kemiripan.elementAt(k);
											kemiripan.set(k, kemiripan.elementAt(k+1));
											kemiripan.set(k+1, aus);
										}
									}
								}
								for(int auah = 0;auah<list.size();auah++){
									System.out.println(list.elementAt(auah));
								}
								}
								else{
									System.out.println("No Suggestion for ["+temp[i]+"]...");
								}
								list.removeAllElements();
								kemiripan.removeAllElements();
							}
						}
						}
					}
				}
				else{
					System.out.println("Drop what?");
				}
				turn -= 1;
			}
			else if(keyword.equalsIgnoreCase("examine")){
				perintah.trim();
				String[] temp = perintah.split(" ");
				if(temp.length > 2){
					System.out.println("You cannot examine item more than one");
				}
				else{
					int flas = 0;
					int flo = 0;
					for(int i = 0;i<namabarang.size();i++){
						flas = 0;
						if(namabarang.elementAt(i).equalsIgnoreCase(temp[1])){
							flo = 1;
							if(locationbarang.elementAt(i).equalsIgnoreCase(nama.elementAt(mulai))){
								if(!required.elementAt(i).equalsIgnoreCase("-1")){
									for(int j = 0;j<inventory.size();j++){
										if(required.elementAt(i).equalsIgnoreCase(inventory.elementAt(j))){
											flas = 1;
											break;
										}
									}
								}
								else{
									flas = 1;
								}
								if(flas == 1){
								System.out.println(description.elementAt(i));
								break;
								}
								else{
									System.out.println("You need " + required.elementAt(i) + " to examine this item!");
									break;
								}
							}
						}
					}
					if(flo == 0){
						System.out.println("No such Item exist!");
						System.out.println("Suggestion for word ["+temp[1]+"]:");
						Vector<String>list = new Vector<>();
						Vector<Integer>kemiripan = new Vector<>();
						int temps = 0;
						for(int j = 0;j<namabarang.size();j++){
							temps = 0;
							for(int k = 0;k<temp[1].length();k++){
								for(int l = 0;l<namabarang.elementAt(j).length();l++){
								//	System.out.println(namabarang.elementAt(j));
									//System.out.println(namabarang.elementAt(j).charAt(l));
									if(namabarang.elementAt(j).charAt(l) == temp[1].charAt(k)){
										temps += 1;
										break;
									}
								}
							}
							if(temps != 0){
								kemiripan.add(temps);
								list.add(namabarang.elementAt(j));
							}
						}
						if(!list.isEmpty()){
						for(int j = 0;j<list.size();j++){
							for(int k = 0;k<list.size()-1;k++){
								if(kemiripan.elementAt(k) < kemiripan.elementAt(k+1)){
									String tempy = list.elementAt(k);
									list.set(k, list.elementAt(k+1));
									list.set(k+1, tempy);
									int aus = kemiripan.elementAt(k);
									kemiripan.set(k, kemiripan.elementAt(k+1));
									kemiripan.set(k+1, aus);
								}
							}
						}
						for(int auah = 0;auah<list.size();auah++){
							System.out.println(list.elementAt(auah));
						}
						}
						else{
							System.out.println("No Suggestion for ["+perintah+"]...");
						}
						list.removeAllElements();
						kemiripan.removeAllElements();
					}
				}
				turn -= 1;
			}
			else if(keyword.equalsIgnoreCase("take")){
				int tur=0;
				perintah.trim();
				String[] temp = perintah.split(" ");
				if(!perintah.equals("")){
				if(inventory.size() < 4){
					for(int i = 0;i<temp.length;i++){
						tur = 0;
						if(!temp[i].equals("")){
						for(int j = 0;j<namabarang.size();j++){
							tur = 0;
							if(temp[i].equalsIgnoreCase(namabarang.elementAt(j))){
								tul = 1;
								if(locationbarang.elementAt(j).equals(nama.elementAt(mulai)) && this.portable.elementAt(j).equalsIgnoreCase("true")){
									
										if(inventory.isEmpty()){
											inventory.add(namabarang.elementAt(j));
											break;
										}
										if(inventory.size() >= 4){
											System.out.println("Your inventory is full!");
											scan.nextLine();
										}
									else{
										int flag = 0;
										for(int l = 0;l<inventory.size();l++){
											if(inventory.elementAt(l).equalsIgnoreCase(temp[i])){
												System.out.println("Already have the item!");
												flag = 1;
												break;
											}
										}
										if(flag == 0){
											if(inventory.size() < 4) inventory.add(namabarang.elementAt(j));
											else System.out.println("Inventory Full!");
											}
									}
								}
								else if(this.portable.elementAt(j).equalsIgnoreCase("false")){
									System.out.println("You cannot take this item!");
								}
							}
						}
						if(tul == 0){
							System.out.println("No such Item exist!");
							System.out.println("Suggestion for word ["+temp[i]+"]:");
							Vector<String>list = new Vector<>();
							Vector<Integer>kemiripan = new Vector<>();
							int temps = 0;
							for(int j = 0;j<namabarang.size();j++){
								temps = 0;
								for(int k = 0;k<temp[i].length();k++){
									for(int l = 0;l<namabarang.elementAt(j).length();l++){
										if(namabarang.elementAt(j).charAt(l) == temp[i].charAt(k)){
											temps += 1;
											break;
										}
									}
								}
								if(temps != 0){
									kemiripan.add(temps);
									list.add(namabarang.elementAt(j));
								}
							}
							if(!list.isEmpty()){
							for(int j = 0;j<list.size();j++){
								for(int k = 0;k<list.size()-1;k++){
									if(kemiripan.elementAt(k) < kemiripan.elementAt(k+1)){
										String tempy = list.elementAt(k);
										list.set(k, list.elementAt(k+1));
										list.set(k+1, tempy);
										int aus = kemiripan.elementAt(k);
										kemiripan.set(k, kemiripan.elementAt(k+1));
										kemiripan.set(k+1, aus);
									}
								}
							}
							for(int auah = 0;auah<list.size();auah++){
								System.out.println(list.elementAt(auah));
							}
							System.out.println("Total Suggestion for ["+temp[i]+"]: "+list.size());
							}
							else{
								System.out.println("No Suggestion for ["+temp[i]+"]...");
							}
							list.removeAllElements();
							kemiripan.removeAllElements();
						}
					}
					}
				}
				}
				else{
					System.out.println("Take what?");
				}
				turn -= 1;
			}
			else if(keyword.equalsIgnoreCase("inventory")){
				perintah.trim();
				if(perintah.equals("")){
					System.out.println("Your Inventory:");
					if(!inventory.isEmpty()){
						for(int i = 0;i<inventory.size();i++){
							System.out.println(inventory.elementAt(i));
						}
					}
					else{
						System.out.println("NONE");
					}
				}
				else{
					System.out.println("I don't understand what you mean.");
				}
				turn -= 1;
			}
			else if(keyword.equalsIgnoreCase("go")){
				if(perintah.equalsIgnoreCase(" north")){
					au = 0;
					fla = 1;
					turn -= 1;
				}
				else if(perintah.equalsIgnoreCase(" west")){
					au = 1;
					fla = 1;
					turn -= 1;
				}
				else if(perintah.equalsIgnoreCase(" south")){
					au = 2;
					fla = 1;
					turn -= 1;
				}
				else if(perintah.equalsIgnoreCase(" east")){
					au = 3;
					fla = 1;
					turn -= 1;
				}
				if(fla == 0){
					System.out.println("I don't understand where do you want to go");
					turn -= 1;
				}
				else{
					if(mulai == 0){
						if(kota1[au] != -1){
							mulai = kota1[au];
						}
					}
					else if(mulai == 1){
						if(kota2[au] != -1){
							mulai = kota2[au];
						}
					}
					else if(mulai == 2){
						if(kota3[au] != -1){
							mulai = kota3[au];
						}
					}
					else if(mulai == 3){
						if(kota4[au] != -1){
							mulai = kota4[au];
						}
					}
					else if(mulai == 4){
						if(kota5[au] != -1){
							mulai = kota5[au];
						}
					}
				}
				enter();
			}
			else if(!keyword.isEmpty()){
				System.out.println("I cannot assist you with that command...");
				turn -= 1;
			}
			}while(fleg == 0);
		}
		else if(x == 2){
			enter();
			int choice = 0;
			do{
				enter();
				System.out.println("1. BEDROOM A");
				System.out.println("2. KITCHEN");
				System.out.println("3. STORAGE ROOM");
				System.out.println("4. BEDROOM B");
				System.out.println("5. LIVING ROOM");
				System.out.println("6. Back");
				try {
					choice = scan.nextInt();
					scan.nextLine();
				} catch (Exception e) {
					choice = 0;
					System.out.println("Input must be number");
					scan.nextLine();
				}
				
	
				if(choice >= 1 && choice < 6){
					set(choice);
				File file = new File("item.txt");
				File fole = new File("room.txt");
				FileWriter fre = null;
				FileWriter fro = null;
				try {
					fre = new FileWriter(file);
					fro = new FileWriter(fole);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedWriter bo = new BufferedWriter(fro);
				BufferedWriter br = new BufferedWriter(fre);
				for(int i = 0;i<this.namabarang.size();i++){
					try {
						br.write(this.namabarang.elementAt(i) +";"+this.description.elementAt(i) + ";" + this.locationbarang.elementAt(i)+";"+this.portable.elementAt(i)+";"+this.container.elementAt(i)+";"+this.required.elementAt(i)+";"+this.treasure.elementAt(i));
						br.newLine();
					} catch (IOException e) {
					}
				}
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int i = 0;i<location.size();i++){
					try {
						bo.write(nama.elementAt(i) + ";" + location.elementAt(i));
						bo.newLine();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				try {
					bo.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;
				}
			}while(choice != 6);
		}
		}while(x != 3);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
}
