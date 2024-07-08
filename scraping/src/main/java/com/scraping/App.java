package com.scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App 
{
    public static void main( String[] args )
    {
        //Search jsoup.
        String url = "https://books.toscrape.com/";
        System.out.println("*********************************************");
        System.out.println(":WEB SCRAPING:");
        System.out.println("*********************************************");
        System.out.println();
        try {
            Document document = Jsoup.connect(url).get();
            Elements books = document.select(".product_pod");

            for (Element book : books) {
                String title = book.select("h3 > a").text();
                String price = book.select(".price_color").text();
                System.out.println(title + " : " + price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
