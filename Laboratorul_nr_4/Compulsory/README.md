# Lab 4

A city hall wants to install surveillance cameras at all intersections in a city.
To do this, it must connect all intersections with data cables, along the streets between them, such that the resulting network is connected.
We assume that the lengths (in km) of the streets between all the intersections of the city are known and the costs of installing the cables is proportional with the street lengths.
The problem is to determine how to install the data cables (on which streets) such as the total cost is minimum.

* Compulsory 

- [x] Create a Maven project.
- [x] Create an object-oriented model of the problem. Streets have names and lengths, intersections have names. A street joins two intersections.
- [x] Create the streets and the intersections of the problem described in the example. Use streams in order to easily create the intersections.
- [x] Create a list of streets, using LinkedList implementation and sort it by the length, using a comparator expressed as a lambda-expression or method reference. Make sure all the objects are comparable.
- [x] Create a set of intersections, using a HashSet implementation. Verify the property that a Set does not contain duplicates.

