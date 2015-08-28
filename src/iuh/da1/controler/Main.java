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
import iuh.da1.model.elementChild.Cite;
import iuh.da1.model.elementChild.Publisher;
import iuh.da1.model.elementChild.Series;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class Main extends DefaultHandler
{
	/*
	 * Su dung flag de khong can phai xac dinh node nao khoi dong dau tien
	 * Co the khong can tra ve gia tri false cho flag boi vi du co thuc hien ham addvalue nhung node do bi tao moi sau lan chay tiep
	 * tra ve false cho flag de chuong trinh chay nhanh hon
	 */
	private String value;
	private Article a;
	private boolean flagArticle=false;
	private Inproceedings inpro;
	private boolean flagInpro=false;
	private Proceedings processdings;
	private boolean flagProcessdings=false;
	private Book book;
	private boolean flagBook=false;
	private Incollection incollection;
	private boolean flagIncollection=false;
	private Phdthesis phdthesis;
	private boolean flagPhdthesis=false;
	private Mastersthesis mastersthesis;
	private boolean flagMastersthesis=false;
	private Www www;
	private boolean flagWww=false;	
	private Cite cite;
	private Publisher publisher;
	private Series series;
	private Conection con;
	public Main(String host,int port,String dbName) throws ParserConfigurationException, SAXException, IOException {
		con=new Conection(host,port,dbName);
		parse();
	}
	private boolean insidePerson;
	private void parse() throws ParserConfigurationException, SAXException, IOException
	{
		File file = new File("/home/five/Documents/paper/dblp.xml");
		InputStream inputStream= new FileInputStream(file);
		Reader reader = new InputStreamReader(inputStream,Charset.forName("ISO-8859-1"));	 
		InputSource is = new InputSource();
		is.setCharacterStream(reader);
		SAXParserFactory spf=SAXParserFactory.newInstance();
		SAXParser sp=spf.newSAXParser();
		sp.parse(is,this);
	}
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("article"))
		{			
			a=new Article();
			a.setKey(attributes.getValue("key"));
			a.setReviewid(attributes.getValue("reviewid"));
			a.setRating(attributes.getValue("rating"));
			a.setMdate(attributes.getValue("mdate"));
			flagArticle=true;
			flagInpro=false;
			flagProcessdings=false;
			flagBook=false;
			flagIncollection=false;
			flagPhdthesis=false;
			flagMastersthesis=false;
			flagWww=false;
		}	
		if(qName.equalsIgnoreCase("inproceedings"))
		{			
			inpro=new Inproceedings();
			inpro.setKey(attributes.getValue("key"));
			inpro.setMdate(attributes.getValue("mdate"));
			flagInpro=true;
			flagArticle=false;
			flagProcessdings=false;
			flagBook=false;
			flagIncollection=false;
			flagPhdthesis=false;
			flagMastersthesis=false;
			flagWww=false;
		}
		if(qName.equalsIgnoreCase("proceedings"))
		{			
			processdings=new Proceedings();
			processdings.setKey(attributes.getValue("key"));
			processdings.setMdate(attributes.getValue("mdate"));
			flagProcessdings=true;
			flagInpro=false;
			flagArticle=false;
			flagBook=false;
			flagIncollection=false;
			flagPhdthesis=false;
			flagMastersthesis=false;
			flagWww=false;
		}
		if(qName.equalsIgnoreCase("book"))
		{
			book=new Book();
			book.setKey(attributes.getValue("key"));
			book.setMdate(attributes.getValue("mdate"));
			flagBook=true;
			flagProcessdings=false;
			flagInpro=false;
			flagArticle=false;
			flagIncollection=false;
			flagPhdthesis=false;
			flagMastersthesis=false;
			flagWww=false;
		}
		if(qName.equalsIgnoreCase("incollection"))
		{
			incollection=new Incollection();
			incollection.setKey(attributes.getValue("key"));
			incollection.setMdate(attributes.getValue("mdate"));
			flagIncollection=true;
			flagBook=false;
			flagProcessdings=false;
			flagInpro=false;
			flagArticle=false;
			flagPhdthesis=false;
			flagMastersthesis=false;
			flagWww=false;
		}
		if(qName.equalsIgnoreCase("phdthesis"))
		{
			phdthesis=new Phdthesis();
			phdthesis.setKey(attributes.getValue("key"));
			phdthesis.setMdate(attributes.getValue("mdate"));
			flagPhdthesis=true;
			flagIncollection=false;
			flagBook=false;
			flagProcessdings=false;
			flagInpro=false;
			flagArticle=false;
			flagMastersthesis=false;
			flagWww=false;
		}
		if(qName.equalsIgnoreCase("mastersthesis"))
		{
			mastersthesis=new Mastersthesis();
			mastersthesis.setKey(attributes.getValue("key"));
			mastersthesis.setMdate(attributes.getValue("mdate"));
			flagMastersthesis=true;
			flagPhdthesis=false;
			flagIncollection=false;
			flagBook=false;
			flagProcessdings=false;
			flagInpro=false;
			flagArticle=false;	
			flagWww=false;
		}
		if(qName.equalsIgnoreCase("www"))
		{
			www=new Www();
			www.setKey(attributes.getValue("key"));
			www.setMdate(attributes.getValue("mdate"));
			flagWww=true;
			flagMastersthesis=false;
			flagPhdthesis=false;
			flagIncollection=false;
			flagBook=false;
			flagProcessdings=false;
			flagInpro=false;
			flagArticle=false;	
		}
		if(qName.equalsIgnoreCase("cite"))
		{
			cite=new Cite();
			cite.setLabel(attributes.getValue("label"));
		}
		if(qName.equalsIgnoreCase("publisher"))
		{
			publisher=new Publisher();
			publisher.setHref(attributes.getValue("href"));
		}
		if(qName.equalsIgnoreCase("series"))
		{
			series=new Series();
			series.setHref(attributes.getValue("href"));
		}
		
			if(qName.equalsIgnoreCase("sub") || qName.equalsIgnoreCase("sup") || qName.equalsIgnoreCase("tt") || qName.equalsIgnoreCase("i")){
				
			}else{
				value="";
				return;
			}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(qName.equalsIgnoreCase("article"))
		{
			con.addToDB(a);
//			System.out.println("=======article===========");
//			System.out.println(a.toString());
		}
		if(qName.equalsIgnoreCase("inproceedings"))
		{
			con.addToDB(inpro);
//			System.out.println("=======inproceedings===========");
//			System.out.println(inpro.toString());
		}
		if(qName.equalsIgnoreCase("proceedings"))
		{
			con.addToDB(processdings);
//			System.out.println("=======proceedings===========");
//			System.out.println(processdings.toString());
		}
		if(qName.equalsIgnoreCase("book"))
		{
			con.addToDB(book);
//			System.out.println("=======book===========");
//			System.out.println(book.toString());
		}
		if(qName.equalsIgnoreCase("incollection"))
		{
			con.addToDB(incollection);
//			System.out.println("=======incollection===========");
//			System.out.println(incollection.toString());
		}
		if(qName.equalsIgnoreCase("phdthesis"))
		{
			con.addToDB(phdthesis);
//			System.out.println("=======phdthesis===========");
//			System.out.println(phdthesis.toString());
		}
		if(qName.equalsIgnoreCase("mastersthesis"))
		{
			con.addToDB(mastersthesis);
//			System.out.println("=======mastersthesis===========");
//			System.out.println(mastersthesis.toString());
		}
		if(qName.equalsIgnoreCase("www"))
		{
			con.addToDB(www);
//			System.out.println("=======www===========");
//			System.out.println(www.toString());
		}
		
		if(qName.equalsIgnoreCase("cite"))
		{
			cite.setCite(value);
		}
		if(qName.equalsIgnoreCase("publisher"))
		{
			publisher.setPublisher(value);
		}
		if(qName.equalsIgnoreCase("series"))
		{
			series.setSeries(value);
		}
		if(flagArticle) 		addvalue(qName, a);		
		if(flagInpro) 			addvalue(qName, inpro);
		if(flagProcessdings) 	addvalue(qName, processdings);
		if(flagBook) 			addvalue(qName, book);
		if(flagIncollection) 	addvalue(qName, incollection);
		if(flagPhdthesis) 		addvalue(qName, phdthesis);
		if(flagMastersthesis) 	addvalue(qName, mastersthesis);
		if(flagWww) 			addvalue(qName, www);
	
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//System.out.println(ch);
		value+=new String(ch,start,length);
	}
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Dang them du lieu vao mongodb...");
	}
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Them du lieu hoan thanh!");
	}
	private void addvalue(String qName,Element a)
	{
		if(qName.equalsIgnoreCase("author"))	a.getAuthor().add(value);
		if(qName.equalsIgnoreCase("editor"))	a.getEditor().add(value);
		if(qName.equalsIgnoreCase("title"))		a.getTitle().add(value);
		if(qName.equalsIgnoreCase("booktitle"))	a.getBooktitle().add(value);
		if(qName.equalsIgnoreCase("pages"))		a.getPages().add(value);
		if(qName.equalsIgnoreCase("year"))		a.getYear().add(value);
		if(qName.equalsIgnoreCase("address"))	a.getAddress().add(value);
		if(qName.equalsIgnoreCase("journal"))	a.getJournal().add(value);
		if(qName.equalsIgnoreCase("number"))	a.getNumber().add(value);
		if(qName.equalsIgnoreCase("month"))		a.getMonth().add(value);
		if(qName.equalsIgnoreCase("url"))		a.getUrl().add(value);
		if(qName.equalsIgnoreCase("ee"))		a.getEe().add(value);
		if(qName.equalsIgnoreCase("cdrom"))		a.getCdrom().add(value);
		if(qName.equalsIgnoreCase("cite"))		a.getCite().add(cite);
		if(qName.equalsIgnoreCase("publisher"))	a.getPublisher().add(publisher);
		if(qName.equalsIgnoreCase("note"))		a.getNote().add(value);
		if(qName.equalsIgnoreCase("crossref"))	a.getCrossref().add(value);
		if(qName.equalsIgnoreCase("isbn"))		a.getIsbn().add(value);
		if(qName.equalsIgnoreCase("series"))	a.getSeries().add(series);
		if(qName.equalsIgnoreCase("school"))	a.getSchool().add(value);
		if(qName.equalsIgnoreCase("chapter"))	a.getChapter().add(value);
		if(qName.equalsIgnoreCase("volume")) 	a.getVolume().add(value);		
	}
	
}
