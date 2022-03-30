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
        AddCommand adding_command = new AddCommand(item2, cat);
        ListCommand listing_command = new ListCommand(cat);
        adding_command.executeCommand();
        adding_command.executeCommand();
        listing_command.executeCommand();
        ViewCommand viewing_command = new ViewCommand("a", item2);
        viewing_command.executeCommand();
        SaveCommand saving_command = new SaveCommand("File.json", cat);
        saving_command.executeCommand();
        LoadCommand loading_command = new LoadCommand("C:\\Users\\camel\\IdeaProjects\\lab5_hw\\File.json");
        loading_command.executeCommand();
        System.out.println();
        ReportCommand reporting_command = new ReportCommand(cat);
        reporting_command.executeCommand();


    }

}
