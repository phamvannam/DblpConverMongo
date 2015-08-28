package iuh.da1.model.elementChild;

public class Series {
	private String series,href;

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@Override
	public String toString() {
		return "Series [series=" + series + ", href=" + href + "]";
	}

}
