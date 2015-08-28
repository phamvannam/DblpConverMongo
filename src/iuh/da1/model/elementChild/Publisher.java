package iuh.da1.model.elementChild;

public class Publisher {
	private String publisher,href;

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@Override
	public String toString() {
		return "Publisher [publisher=" + publisher + ", href=" + href + "]";
	}
	
}
