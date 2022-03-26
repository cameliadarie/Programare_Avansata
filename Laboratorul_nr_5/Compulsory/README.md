# Bibliography Management System

Write an application that can manage a catalog of resources (bibliographic references), such as books, articles, etc.
These resources might be represented by files in the local file system or a Web address. Apart from a unique identifier, a title and its location, a resource may have additional properties such as author(s), what year it was publihsed, description, etc.
You may read more about reference management software, see a comparison of notable implementations, such as JabRef.

# Compulsory 

- [x] Create an object-oriented model of the problem. You should have at least the following classes: Catalog and Item. The items should have at least a unique identifier, a title and its location. Consider using an interface or an abstract class in order to describe the items in a catalog.
-     Implement the following methods representing commands that will manage the content of the catalog:
- - [x] add: adds a new entry into the catalog;
- - [x] toString: a textual representation of the catalog;
- - [x] save: saves the catalog to an external file using JSON format; you may use Jackson or other library;
- - [x] load: loads the catalog from an external file.