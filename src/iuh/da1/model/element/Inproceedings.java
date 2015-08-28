package iuh.da1.model.element;

import iuh.da1.model.elementChild.Cite;
import iuh.da1.model.elementChild.Publisher;
import iuh.da1.model.elementChild.Series;

import java.util.ArrayList;


public class Inproceedings implements Element
{
	private ArrayList<String> author,editor,title,booktitle,pages,year,address,journal,volume,
	number,month,url,ee,cdrom,note,crossref,isbn,school,chapter;
	private ArrayList<Series> series;
	private ArrayList<Publisher> publisher;
	private ArrayList<Cite> cite;
	private String key,mdate;
	public Inproceedings() {
		author=new ArrayList<>();
		editor=new ArrayList<>();
		title=new ArrayList<>();
		booktitle=new ArrayList<>();
		pages=new ArrayList<>();
		year=new ArrayList<>();
		address=new ArrayList<>();
		journal=new ArrayList<>();
		volume=new ArrayList<>();
		number=new ArrayList<>();
		month=new ArrayList<>();
		url=new ArrayList<>();
		ee=new ArrayList<>();
		cdrom=new ArrayList<>();
		publisher=new ArrayList<>();
		cite=new ArrayList<>();
		note=new ArrayList<>();
		crossref=new ArrayList<>();
		isbn=new ArrayList<>();
		series=new ArrayList<>();
		school=new ArrayList<>();
		chapter=new ArrayList<>();
	}
	
	public ArrayList<String> getAuthor() {
		return author;
	}

	public void setAuthor(ArrayList<String> author) {
		this.author = author;
	}

	public ArrayList<String> getEditor() {
		return editor;
	}

	public void setEditor(ArrayList<String> editor) {
		this.editor = editor;
	}

	public ArrayList<String> getTitle() {
		return title;
	}

	public void setTitle(ArrayList<String> title) {
		this.title = title;
	}

	public ArrayList<String> getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(ArrayList<String> booktitle) {
		this.booktitle = booktitle;
	}

	public ArrayList<String> getPages() {
		return pages;
	}

	public void setPages(ArrayList<String> pages) {
		this.pages = pages;
	}

	public ArrayList<String> getYear() {
		return year;
	}

	public void setYear(ArrayList<String> year) {
		this.year = year;
	}

	public ArrayList<String> getAddress() {
		return address;
	}

	public void setAddress(ArrayList<String> address) {
		this.address = address;
	}

	public ArrayList<String> getJournal() {
		return journal;
	}

	public void setJournal(ArrayList<String> journal) {
		this.journal = journal;
	}

	public ArrayList<String> getVolume() {
		return volume;
	}

	public void setVolume(ArrayList<String> volume) {
		this.volume = volume;
	}

	public ArrayList<String> getNumber() {
		return number;
	}

	public void setNumber(ArrayList<String> number) {
		this.number = number;
	}

	public ArrayList<String> getMonth() {
		return month;
	}

	public void setMonth(ArrayList<String> month) {
		this.month = month;
	}

	public ArrayList<String> getUrl() {
		return url;
	}

	public void setUrl(ArrayList<String> url) {
		this.url = url;
	}

	public ArrayList<String> getEe() {
		return ee;
	}

	public void setEe(ArrayList<String> ee) {
		this.ee = ee;
	}

	public ArrayList<String> getCdrom() {
		return cdrom;
	}

	public void setCdrom(ArrayList<String> cdrom) {
		this.cdrom = cdrom;
	}

	public ArrayList<String> getNote() {
		return note;
	}

	public void setNote(ArrayList<String> note) {
		this.note = note;
	}

	public ArrayList<String> getCrossref() {
		return crossref;
	}

	public void setCrossref(ArrayList<String> crossref) {
		this.crossref = crossref;
	}

	public ArrayList<String> getIsbn() {
		return isbn;
	}

	public void setIsbn(ArrayList<String> isbn) {
		this.isbn = isbn;
	}

	public ArrayList<String> getSchool() {
		return school;
	}

	public void setSchool(ArrayList<String> school) {
		this.school = school;
	}

	public ArrayList<String> getChapter() {
		return chapter;
	}

	public void setChapter(ArrayList<String> chapter) {
		this.chapter = chapter;
	}

	public ArrayList<Series> getSeries() {
		return series;
	}

	public void setSeries(ArrayList<Series> series) {
		this.series = series;
	}

	public ArrayList<Publisher> getPublisher() {
		return publisher;
	}

	public void setPublisher(ArrayList<Publisher> publisher) {
		this.publisher = publisher;
	}

	public ArrayList<Cite> getCite() {
		return cite;
	}

	public void setCite(ArrayList<Cite> cite) {
		this.cite = cite;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inproceedings other = (Inproceedings) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Inproceedings [author=" + author + ", editor=" + editor
				+ ", title=" + title + ", booktitle=" + booktitle + ", pages="
				+ pages + ", year=" + year + ", address=" + address
				+ ", journal=" + journal + ", volume=" + volume + ", number="
				+ number + ", month=" + month + ", url=" + url + ", ee=" + ee
				+ ", cdrom=" + cdrom + ", note=" + note + ", crossref="
				+ crossref + ", isbn=" + isbn + ", school=" + school
				+ ", chapter=" + chapter + ", series=" + series
				+ ", publisher=" + publisher + ", cite=" + cite + ", key="
				+ key + ", mdate=" + mdate + "]";
	}

}
