package api;

import java.util.ArrayList;

import entities.Book;
import entities.City;
import mappers.SQLMapper;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SQLMapper map= new SQLMapper();
//		ArrayList<Book> al=map.getBookByCity("London");
//		for (Book book : al) {
//			System.out.println(book.toString());
//		}
		ArrayList<City> al = map.getMentionedCitiesByBook("Roumania Past and Present");
		for (City city : al) 
		{
			System.out.println(city.toString());
		}
		
	}

}
