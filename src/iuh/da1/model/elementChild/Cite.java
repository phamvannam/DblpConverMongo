package iuh.da1.model.elementChild;

public class Cite {
	private String cite,label;

	public String getCite() {
		return cite;
	}

	public void setCite(String cite) {
		this.cite = cite;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Cite [cite=" + cite + ", label=" + label + "]";
	}
	
}
