package iuh.da1.controler;

import iuh.da1.model.element.Article;
import iuh.da1.model.element.Book;
import iuh.da1.model.element.Element;
import iuh.da1.model.element.Incollection;
import iuh.da1.model.element.Inproceedings;
import iuh.da1.model.element.Mastersthesis;
import iuh.da1.model.element.Phdthesis;
import iuh.da1.model.element.Proceedings;
import iuh.da1.model.element.Www;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Set;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class Conection 
{
	private DB db;
	private DBCollection article,book,incollection,inproceeding,mastersthesis,phdthesis,proceedings,www;
	private BasicDBObject document,temp;
	private ArrayList<BasicDBObject> arraytemp;
	public Conection(String host,int port,String dbName) throws UnknownHostException {
		MongoClient mongo=new MongoClient(host,port);
		db=mongo.getDB(dbName);
		//db.command("{enableSharding:\"DA1\"}");
		
		article=db.getCollection("Article");
		book=db.getCollection("Book");
		incollection=db.getCollection("Incollection");
		inproceeding=db.getCollection("Inproceeding");
		mastersthesis=db.getCollection("Mastersthesis");
		phdthesis=db.getCollection("Phdthesis");
		proceedings=db.getCollection("Proceedings");
		www=db.getCollection("Www");
		
		article.createIndex(new BasicDBObject("key", 1));
		book.createIndex(new BasicDBObject("key", 1));
		incollection.createIndex(new BasicDBObject("key", 1));
		inproceeding.createIndex(new BasicDBObject("key", 1));
		mastersthesis.createIndex(new BasicDBObject("key", 1));
		phdthesis.createIndex(new BasicDBObject("key", 1));
		proceedings.createIndex(new BasicDBObject("key", 1));
		www.createIndex(new BasicDBObject("key", 1));
		
	}
	public void addToDB(Element e)
	{
		if(e instanceof Article)
		{
			Article art=(Article)e;
			document=new BasicDBObject();
			if(art.getKey()!=null) 		document.put("key", art.getKey());
			if(art.getMdate()!=null)	document.put("mdate", art.getMdate());		
			if(art.getRating()!=null) document.put("rating", art.getRating());
			if(art.getReviewid()!=null) document.put("reviewid", art.getReviewid());	
			article.insert(addElement(art, document));
		}
		if(e instanceof Book)
		{
			Book bo=(Book)e;
			document=new BasicDBObject();
			if(bo.getKey()!=null) document.put("key", bo.getKey());
			if(bo.getMdate()!=null) document.put("mdate", bo.getMdate());
			book.insert(addElement(bo, document));
		}
		if(e instanceof Incollection)
		{
			Incollection inco=(Incollection) e;
			document=new BasicDBObject();
			if(inco.getKey()!=null) document.put("key", inco.getKey());
			if(inco.getMdate()!=null) document.put("mdate", inco.getMdate());
			incollection.insert(addElement(inco, document));
		}
		if(e instanceof Inproceedings)
		{
			Inproceedings inpro=(Inproceedings)e;
			document=new BasicDBObject();
			if(inpro.getKey()!=null) document.put("key", inpro.getKey());		
			if(inpro.getMdate()!=null) document.put("mdate", inpro.getMdate());
			inproceeding.insert(addElement(inpro, document));
		}
		if(e instanceof Mastersthesis)
		{
			Mastersthesis mas=(Mastersthesis)e;
			document=new BasicDBObject();
			if(mas.getKey()!=null) document.put("key", mas.getKey());
			if(mas.getMdate()!=null) document.put("mdate", mas.getMdate());
			mastersthesis.insert(addElement(mas, document));
		}
		if(e instanceof Phdthesis)
		{
			Phdthesis phd=(Phdthesis)e;
			document=new BasicDBObject();
			if(phd.getKey()!=null) document.put("key", phd.getKey());
			if(phd.getMdate()!=null) document.put("mdate",phd.getMdate());
			phdthesis.insert(addElement(phd, document));
		}
		if(e instanceof Proceedings)
		{
			Proceedings pro=(Proceedings)e;
			document=new BasicDBObject();
			if(pro.getKey()!=null) document.put("key", pro.getKey());
			if(pro.getMdate()!=null) document.put("mdate", pro.getMdate());
			proceedings.insert(addElement(pro, document));
		}
		if(e instanceof Www)
		{
			Www w=(Www)e;
			document=new BasicDBObject();
			if(w.getKey()!=null) document.put("key", w.getKey());
			if(w.getMdate()!=null) document.put("mdate", w.getMdate());
			www.insert(addElement(w, document));
		}
	}
	private BasicDBObject addElement(Element e, BasicDBObject document)
	{	
		if(!e.getAddress().isEmpty()) document.put("address", e.getAddress());
		if(!e.getAuthor().isEmpty()) document.put("author", e.getAuthor());
		if(!e.getBooktitle().isEmpty()) document.put("booktitle", e.getBooktitle());
		if(!e.getCdrom().isEmpty()) document.put("cdrom", e.getCdrom());
		if(!e.getChapter().isEmpty()) document.put("chapter", e.getChapter());
		if(!e.getCite().isEmpty()) 
		{
			arraytemp=new ArrayList<>();
			for(int i=0;i<e.getCite().size();i++)
			{
				temp=new BasicDBObject();
				temp.put("cite", e.getCite().get(i).getCite());
				temp.put("label",e.getCite().get(i).getLabel());
				arraytemp.add(temp);
			}
			document.put("cite", arraytemp);
		}
		if(!e.getCrossref().isEmpty()) document.put("crossref", e.getCrossref());
		if(!e.getEditor().isEmpty()) document.put("editor",e.getEditor());
		if(!e.getEe().isEmpty()) document.put("ee", e.getEe());
		if(!e.getIsbn().isEmpty()) document.put("isbn", e.getIsbn());
		if(!e.getJournal().isEmpty()) document.put("journal", e.getJournal());
		if(!e.getMonth().isEmpty()) document.put("month", e.getMonth());
		if(!e.getNote().isEmpty()) document.put("note", e.getNote());
		if(!e.getNumber().isEmpty()) document.put("number", e.getNumber());
		if(!e.getPages().isEmpty()) document.put("pages", e.getPages());
		if(!e.getPublisher().isEmpty())
		{
			arraytemp=new ArrayList<>();
			for(int i=0;i<e.getPublisher().size();i++)
			{
				temp=new BasicDBObject();
				temp.put("publisher", e.getPublisher().get(i).getPublisher());
				temp.put("href",e.getPublisher().get(i).getHref());
				arraytemp.add(temp);
			}
			document.put("publisher", arraytemp);
		}
		if(!e.getSchool().isEmpty()) document.put("school", e.getSchool());
		if(!e.getSeries().isEmpty()) 
		{
			arraytemp=new ArrayList<>();
			for(int i=0;i<e.getSeries().size();i++)
			{
				temp=new BasicDBObject();
				temp.put("series", e.getSeries().get(i).getSeries());
				temp.put("href",e.getSeries().get(i).getHref());
				arraytemp.add(temp);
			}
			document.put("series", arraytemp);
		}
		if(!e.getTitle().isEmpty()) document.put("title", e.getTitle());
		if(!e.getUrl().isEmpty()) document.put("url", e.getUrl());
		if(!e.getYear().isEmpty()) document.put("year", e.getYear());
		if(!e.getVolume().isEmpty()) document.put("volume", e.getVolume());
		return document;		
	}
}
