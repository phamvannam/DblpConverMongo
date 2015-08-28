package iuh.da1.model.element;

import iuh.da1.model.elementChild.Cite;
import iuh.da1.model.elementChild.Publisher;
import iuh.da1.model.elementChild.Series;

import java.util.ArrayList;


public interface Element {

	ArrayList<String> getAuthor();

	ArrayList<String> getEditor();

	ArrayList<String> getTitle();

	ArrayList<String> getBooktitle();

	ArrayList<String> getPages();

	ArrayList<String> getYear();

	ArrayList<String> getAddress();

	ArrayList<String> getJournal();

	ArrayList<String> getNumber();

	ArrayList<String> getMonth();

	ArrayList<String> getUrl();

	ArrayList<String> getEe();

	ArrayList<String> getCdrom();

	ArrayList<Cite> getCite();

	ArrayList<Publisher> getPublisher();

	ArrayList<String> getNote();

	ArrayList<String> getCrossref();

	ArrayList<String> getIsbn();

	ArrayList<Series> getSeries();

	ArrayList<String> getSchool();

	ArrayList<String> getChapter();
	
	ArrayList<String> getVolume() ;
}
