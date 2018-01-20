package propertyProjectInfo.dto;

public class propertyProjectDetail extends propertyBasisInfo {

	private String pDate;
	private String pPosition;
	private int pObtain;
	public String getpDate() {
		return pDate;
	}
	public void setpDate(String pDate) {
		this.pDate = pDate;
	}
	public String getpPosition() {
		return pPosition;
	}
	public void setpPosition(String pPosition) {
		this.pPosition = pPosition;
	}
	public int getpObtain() {
		return pObtain;
	}
	public void setpObtain(int pObtain) {
		this.pObtain = pObtain;
	}
	@Override
	public String toString() {
		return super.getpNumber() + "\t"
				+ this.getpDate() + "\t"
				+ super.getpType() + "\t"
				+ this.getpPosition() + "\t"
				+ super.getpPrice() + "만원"+"\t"
				+ this.getpObtain() + "만원"+"\t";
				
				
				
	}
    
}
