public class Karyawan {

	public Karyawan(String staffId, String staffName, String jabatan, int staffSalary) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.jabatan = jabatan;
		this.staffSalary = staffSalary;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getJabatan() {
		return jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	public int getStaffSalary() {
		return staffSalary;
	}

	public void setStaffSalary(int staffSalary) {
		this.staffSalary = staffSalary;
	}

	private String staffId;
	private String staffName;
	private String jabatan;
	private int staffSalary;
	
	public Karyawan(){
		
	}
	
	public static void main(String[] args) {
		

	}

}