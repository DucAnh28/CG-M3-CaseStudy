package casestudy.crawlsData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import casestudy.model.Book;

import java.io.IOException;
import java.util.ArrayList;

public class CrawlsDataBook {
    private final String url="https://bookbuy.vn/sach-moi/p1";
    private ArrayList<Book> bookArrayList = new ArrayList<>();
    public void getData(){
        try {
            Document document = Jsoup.connect(url).get();
            ArrayList<Element> elements = document.getElementsByClass("t-view");
            ArrayList<Element> elements1 = document.getElementsByClass("au-view");
            ArrayList<Element> elements2 = document.getElementsByClass("real-price");
            ArrayList<Element> elements3 = document.getElementsByClass("collection-title");
            ArrayList<Element> elements4 = document.getElementsByClass("img-view");
            ArrayList<Element> elements5 = document.getElementsByClass("status");
            int id = 0;
            int author_id = 0;
            int category_id = 0;
            for (int i = 1; i <= 10; i++) {
                id++;
                String code = "";
                String description = "Sach hay vai chuong";
               String name = elements.get(i).getElementsByTag("a").text();
               String author = elements1.get(i).getElementsByTag("h2").text();
               String temp = ((elements2.get(i).getElementsByTag("span").text()).replaceAll("₫","").trim());
               double price =  Double.parseDouble(temp.replaceAll(",", ""));
               String image = elements4.get(i).getElementsByTag("img").attr("src");
                Book book = new Book(id, code, name,author_id, price, category_id, image, description);
                bookArrayList.add(book);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        CrawlsDataBook crawlsDataBook = new CrawlsDataBook();
        crawlsDataBook.getData();
    }
}
