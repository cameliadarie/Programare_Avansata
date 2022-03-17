# The Network Routing Problem


A network contains various nodes, such as computers, routers, switches, etc. Nodes in the network have unique names and may have other common properties such as hardware (MAC) address, the location on a map, etc.
Some of them are identified using an IP-address. Some of them are able to store data, having a storage capacity, expressed in gigabytes (GB).
The time (measured in milliseconds) required for a network packet to go from one node to another is known.
Example: locations are: v1 (Computer A) v2 (Router A) v3 (Switch A) v4 (Switch B) v5 (Router B) v6 (Computer B).


#Compulsory 

- [x] Create an object-oriented model of the problem. You should have at least the following classes Network, Node, Computer, Router, Switch. The natural ordering of the nodes is given by their names.
- [x] Create the interfaces Identifiable and Storage. The classes above must implement these interfaces accordingly.
- [x] The Network class will contain a List of nodes.
- [x] Create and print all the nodes in the network (without the time costs).

#Homework 

- [x] Each node will contain a Map representing the time costs. Create and print the complete network in the example.
- [x] Create a default method in the interface Storage, that is able to return the storage capacity in other units of storage (megabyte, kilobyte, byte).
- [x] In the Network class, create a method to display the nodes that are identifiable, sorted by their addresses.
- [ ] Implement an efficient agorithm to determine all the shortests times required for data packets to travel from an identifiable node to another.
      