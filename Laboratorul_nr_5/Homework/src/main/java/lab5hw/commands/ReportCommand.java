package lab5hw.commands;

import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import lab5hw.Catalog;
import lab5hw.Item;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;
import java.util.List;

/**
 * creates (and opens) an HTML report representing the content of the catalog.
 */
public class ReportCommand implements Command {
    protected Catalog catalog;

    public ReportCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    protected void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void executeCommand() throws IOException {

        //Configure FreeMarker
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);

        // The place from which we load templates.
        cfg.setClassForTemplateLoading(Catalog.class, "lab5hw.templates");

        // Recommended settings
        cfg.setIncompatibleImprovements(new Version(2, 3, 31));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);

        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        //Prepare the template input
        Map<String, Object> input = new HashMap<>();
        input.put("title", "Catalog");
        input.put("CatalogA", catalog);
        input.put("items", catalog.getItems());

        //Get the template
        cfg.setDirectoryForTemplateLoading(new File(
                "C:\\Users\\camel\\IdeaProjects\\lab5_hw\\src\\main\\java\\lab5hw\\templates"));
        Template template = cfg.getTemplate("report.ftl");

        //Write in an output file.
        try (Writer fileWriter = new FileWriter(new File("output.html"))) {
            template.process(input, fileWriter);
        } catch (freemarker.template.TemplateException e) {
            e.printStackTrace();
        }

        //Open output.html file
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File("output.html"));

    }
}
