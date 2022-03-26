package lab5;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException {
        Catalog my_catalog = new Catalog("MyCatalog");

        Item item1 = new Book("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", "Donald E. Knuth", 1965, "book");
        Item item2 = new Document("java17", "Te java Language Specification", " https://docs.oracle.com/javase/javaspecs/jls/sel12/html/index", "James Gosling & others", 2021);
        my_catalog.add(item1);
        my_catalog.add(item2);
        CatalogUtil.save(my_catalog, "C:\\Users\\camel\\IdeaProjects\\Compulsory5\\src\\main\\java\\lab5\\Catalog.json");
        System.out.println(my_catalog);
    }

}
