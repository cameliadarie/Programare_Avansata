package lab5hw;

import lab5hw.commands.*;

import java.io.IOException;

public class Main {

    /**
     * Here I create my catalog, add some items to it and then execute every command that I have implemented
     *
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws InvalidCommandException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvalidCommandException {
        Catalog cat = new Catalog("my catalog");
        Item item1 = new Book("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps", "Donald E. Knuth", 1965, "book");
        Item item2 = new Document("java17", "The java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html", "James Gosling & others", 2021);
        AddCommand addingCommand = new AddCommand(item1, cat);
        AddCommand addingCommand2 = new AddCommand(item2, cat);
        ListCommand listingCommand = new ListCommand(cat);
        addingCommand.executeCommand();
        addingCommand2.executeCommand();
        listingCommand.executeCommand();
        ViewCommand viewingCommand = new ViewCommand("a", item2);
        viewingCommand.executeCommand();
        SaveCommand savingCommand = new SaveCommand("File.json", cat);
        savingCommand.executeCommand();
        LoadCommand loadingCommand = new LoadCommand("C:\\Users\\camel\\IdeaProjects\\lab5_hw\\File.json");
        loadingCommand.executeCommand();
        System.out.println();
        ReportCommand reportingCommand = new ReportCommand(cat);
        reportingCommand.executeCommand();


    }

}
