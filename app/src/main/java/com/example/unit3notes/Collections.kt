package com.example.unit3notes

//2. Arrays in Kotlin
//What is an array?
//An array is the simplest way to group an arbitrary number of values in your programs.
//
//Like a grouping of solar panels is called a solar array, or how learning Kotlin opens up an array of possibilities for your programming career, an Array represents more than one value. Specifically, an array is a sequence of values that all have the same data type.
//An array contains multiple values called elements, or sometimes, items.
//The elements in an array are ordered and are accessed with an index.


fun main() {
    val rockPlanets = arrayOf<String> ("Mercury", "Venus", "Earth", "Mars")
    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
    val solarSystem = rockPlanets + gasPlanets
}

//Access an element in an array
//You can access an element of an array by its index.

//This is called subscript syntax. It consists of three parts:

//The name of the array.
//An opening ([) and closing (]) square bracket.
//The index of the array element in the square brackets.



//3. Lists
//A list is an ordered, resizable collection, typically implemented as a resizable array. When the array is filled to capacity and you try to insert a new element, the array is copied to a new bigger array.

//With a list, you can also insert new elements between other elements at a specific index.

//
//This is how lists are able to add and remove elements. In most cases, it takes the same amount of time to add any element to a list, regardless of how many elements are in the list. Every once in a while, if adding a new element would put the array above its defined size, the array elements might have to move to make room for new elements. Lists do all of this for you, but behind the scenes, it's just an array that gets swapped out for a new array when needed.
//
//List and MutableList
//The collection types you'll encounter in Kotlin implement one or more interfaces. As you learned in the Generics, objects, and extensions codelab earlier in this unit, interfaces provide a standard set of properties and methods for a class to implement. A class that implements the List interface provides implementations for all the properties and methods of the List interface. The same is true for MutableList.
//
//So what do List and MutableList do?
//
//List is an interface that defines properties and methods related to a read-only ordered collection of items.
//MutableList extends the List interface by defining methods to modify a list, such as adding and removing elements.
//These interfaces only specify the properties and methods of a List and/or MutableList. It's up to the class that extends them to determine how each property and method is implemented. The array-based implementation described above is what you'll use most, if not all of the time, but Kotlin allows other classes to extend List and MutableList.
//
//The listOf() function
//Like arrayOf(), the listOf() function takes the items as parameters, but returns a List rather than an array

fun main() {
    val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystem.size)
    println(solarSystem[2])
    println(solarSystem.get(3))
    println(solarSystem.indexOf("Earth"))
    println(solarSystem.indexOf("Pluto"))

    for(planet in solarSystem) {
        println(planet)
    }
}

//Add elements to a list
//The ability to add, remove, and update elements in a collection is exclusive to classes that implement the MutableList interface. If you were keeping track of newly discovered planets, you'd likely want the ability to frequently add elements to a list. You need to specifically call the mutableListOf() function, instead of listOf(), when creating a list you wish to add and remove elements from.
//
//There are two versions of the add() function:
//
//The first add() function has a single parameter of the type of element in the list and adds it to the end of the list.
//The other version of add() has two parameters. The first parameter corresponds to an index at which the new element should be inserted. The second parameter is the element being added to the list.

fun main() {
    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystem.size)
    println(solarSystem[2])
    println(solarSystem.get(3))
    println(solarSystem.add("Pluto"))
    solarSystem.add(3, "Theia")
    solarSystem[3] = "Future Moon"

    println(solarSystem[3])
    println(solarSystem[9])
}

//Remove elements from a list
//Elements are removed using the remove() or removeAt() method. You can either remove an element by passing it into the remove() method or by its index using removeAt().

fun main() {
    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystem.size)
    println(solarSystem[2])
    println(solarSystem.get(3))
    println(solarSystem.add("Pluto"))
    solarSystem.add(3, "Theia")
    solarSystem[3] = "Future Moon"

    solarSystem.removeAt(9)
    solarSystem.remove("Future Moon")
    println(solarSystem.contains("Pluto"))
}

//4. Sets
//A set is a collection that does not have a specific order and does not allow duplicate values.

//Note: A set uses hash codes as array indices. Of course, there can be about 4 billion different hash codes, so a Set isn't just one giant array. Instead, you can think of a Set as an array of lists.
//
//The outer array—the numbers outlined in blue on the left—each correspond to a range (also known as a bucket) of possible hash codes. Each inner list—shaded in green on the right—represents the individual items in the set. Since hash collisions are relatively uncommon, even when the potential indices are limited, the inner lists at each array index will only have one or two items each, unless tens or hundreds of thousands of elements are added.
//
//Sets have two important properties:
//
//Searching for a specific element in a set is fast—compared with lists—especially for large collections. While the indexOf() of a List requires checking each element from the beginning until a match is found, on average, it takes the same amount of time to check if an element is in a set, whether it's the first element or the hundred thousandth.
//Sets tend to use more memory than lists for the same amount of data, since more array indices are often needed than the data in the set.
//Note: Contrary to popular belief, the time it takes to check if a set contains an element is not fixed, and does in fact, depend on the amount of data in the set. However, as there will usually be few hash collisions, the number of elements that need to be checked is still orders of magnitude smaller than searching for an item in a list.
//
//The benefit of sets is ensuring uniqueness. If you were writing a program to keep track of newly discovered planets, a set provides a simple way to check if a planet has already been discovered. With large amounts of data, this is often preferable to checking if an element exists in a list, which requires iterating over all the elements.
//
//Like List and MutableList, there's both a Set and a MutableSet. MutableSet implements Set, so any class implementing MutableSet needs to implement both.

fun main() {
    val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystem.size)
    solarSystem.add("Pluto")
    println(solarSystem.size)
    println(solarSystem.contains("Pluto"))
    solarSystem.add("Pluto")
    println(solarSystem.size)
    solarSystem.remove("Pluto")
    println(solarSystem.size)
}

//5. Map collection
//A Map is a collection consisting of keys and values. It's called a map because unique keys are mapped to other values. A key and its accompanying value are often called a key-value pair.

//A map's keys are unique. A map's values, however, are not. Two different keys could map to the same value. For example, "Mercury" has 0 moons, and "Venus" has 0 moons.
//
//Accessing a value from a map by its key is generally faster than searching through a large list, such as with indexOf().
//
//Maps can be declared using the mapOf() or mutableMapOf() function. Maps require two generic types separated by a comma—one for the keys and another for the values.

fun main() {
    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )
    println(solarSystem.size)
    solarSystem["Pluto"] = 5
    println(solarSystem.size)
    println(solarSystem["Pluto"])
    println(solarSystem.get("Theia"))
    solarSystem.remove("Pluto")
    println(solarSystem.size)
    solarSystem["Jupiter"] = 78
    println(solarSystem["Jupiter"])
}

///6. Conclusion
//Congratulations! You learned about one of the most foundational data types in programming, the array, and several convenient collection types built off of arrays, including List, Set, and Map. These collection types allow you to group and organize values in your code. Arrays and lists provide fast access to elements by their index, while sets and maps use hash codes to make it easier to find elements in the collection. You'll see these collection types used frequently in future apps, and knowing how to use them will benefit you in your future programming career.
//
//Summary
//Arrays store ordered data of the same type, and have a fixed size.
//Arrays are used to implement many of the other collection types.
//Lists are a resizable, ordered collection.
//Sets are unordered collections and cannot contain duplicates.
//Maps work similarly to sets and store pairs of keys and values of the specified type.
