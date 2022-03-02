# Programare_Avansata

Cerintele:

Let n, p be two integers and C1,...,Cm a set of letters (the alphabet), all given as a command line arguments. Validate the arguments!

Create an array of n strings (called words), each word containing exactly p characters from the given alphabet.

Display on the screen the generated array.

Two words are neighbors if they have a common letter.

Create a boolean n x n matrix, representing the adjacency relation of the words.

Create a data structure (using arrays) that stores the neighbors of each word. Display this data structure on the screen.
	->Am creat un vector in care la v[i] se afla vecinii cuvantului i separati prin virgula

For larger n display the running time of the application in nanoseconds (DO NOT display the data structure!). Try n > 30_000. You might want to adjust the JVM Heap Space using the VM options -Xms4G -Xmx4G.
	-> Pentru realizarea acestei cerinte am intrat pe Help->change VM options si am adaugat -Xms4G -Xmx4G

Launch the application from the command line, for example: java Lab1 100 7 A C G T.

