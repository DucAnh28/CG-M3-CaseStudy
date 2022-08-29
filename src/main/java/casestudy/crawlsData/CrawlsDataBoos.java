package casestudy.crawlsData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import casestudy.model.Book;

import java.io.IOException;
import java.util.ArrayList;

public class CrawlsDataBoos {
    private final String url="https://bookbuy.vn/sach-moi/p1";
    private ArrayList<Book> bookArrayList = new ArrayList<>();
    public void getData(){
        try {
            Document document = Jsoup.connect(url).get();
            ArrayList<Element> elements = document.getElementsByClass("t-view");
            ArrayList<Element> elements1 = document.getElementsByClass("au-view");
            ArrayList<Element> elements2 = document.getElementsByClass("real-price");
//            ArrayList<Element> elements3 = document.getElementsByClass("collection-title");
            ArrayList<Element> elements4 = document.getElementsByClass("slimmage");
//            ArrayList<Element> elements5 = document.getElementsByClass("status");
            int id = 0;
            for (int i = 1; i <= 10; i++) {
                id++;
               String name = elements.get(i).getElementsByTag("a").text();
               String author = elements1.get(i).getElementsByTag("h2").text();
//               String price = ((elements2.get(i).getElementsByTag("span").text()).replaceAll("₫","").trim());
               String image = elements4.get(i).getElementsByTag("img").attr("src");
//               Book book = new Book(id, name, price);
//                System.out.println(book);
                System.out.println(image);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        CrawlsDataBoos crawlsDataBoos = new CrawlsDataBoos();
        crawlsDataBoos.getData();
    }
}
