package com.example.unit3notes

//1. Introduction
//In the Use function types and lambda expressions in Kotlin codelab, you learned about higher-order functions, which are functions that take other functions as parameters and/or return a function, such as repeat(). Higher-order functions are especially relevant to collections as they help you perform common tasks, like sorting or filtering, with less code. Now that you have a solid foundation working with collections, it's time to revisit higher-order functions.
//
//In this codelab, you'll learn about a variety of functions that can be used on collection types, including forEach(), map(), filter(), groupBy(), fold(), and sortedBy(). In the process, you'll get additional practice working with lambda expressions.


//2. forEach() and string templates with lambdas
//Loop over a list with forEach()
//The first higher-order function that you learn about is the forEach()function. The forEach() function executes the function passed as a parameter once for each item in the collection. This works similarly to the repeat() function, or a for loop. The lambda is executed for the first element, then the second element, and so on, until it's executed for each element in the collection. The method signature is as follows:

//forEach() takes a single action parameter—a function of type (T) -> Unit.
//
//T corresponds to whatever data type the collection contains. Because the lambda takes a single parameter, you can omit the name and refer to the parameter with it.


//To access properties and embed them in a string, you need an expression. You can make an expression part of a string template by surrounding it with curly braces.

//The lambda expression is placed between the opening and closing curly braces. You can access properties, perform math operations, call functions, etc., and the return value of the lambda is inserted into the string.

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie (
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    cookies.forEach {
        println("Menu item: ${it.name}")
    }
}

//3. map()
//The map() function lets you transform a collection into a new collection with the same number of elements. For example, map() could transform a List<Cookie> into a List<String> only containing the cookie's name, provided you tell the map() function how to create a String from each Cookie item.

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie (
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    val fullMenu = cookies.map {
        "${it.name}: $${it.price}"
    }

    fullMenu.forEach {
        println(it)
    }
}


//
//4. filter()
//The filter() function lets you create a subset of a collection. For example, if you had a list of numbers, you could use filter() to create a new list that only contains numbers divisible by 2.

//Whereas the result of the map() function always yields a collection of the same size, filter() yields a collection of the same size or smaller than the original collection. Unlike map(), the resulting collection also has the same data type, so filtering a List<Cookie> will result in another List<Cookie>.
//
//Like map() and forEach(), filter() takes a single lambda expression as a parameter. The lambda has a single parameter representing each item in the collection and returns a Boolean value.
//
//For each item in the collection:
//
//If the result of the lambda expression is true, then the item is included in the new collection.
//If the result is false, the item is not included in the new collection.
//This is useful if you want to get a subset of data in your app. For example, let's say the bakery wants to highlight its soft-baked cookies in a separate section of the menu. You can first filter() the cookies list, before printing the items.


class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie (
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    val fullMenu = cookies.map {
        "${it.name}: $${it.price}"
    }

    fullMenu.forEach {
        println(it)
    }

    val softBakedMenu = cookies.filter {
        it.softBaked
    }
    println("Soft cookies:")
    softBakedMenu.forEach {
        println("${it.name}- $${it.price}")
    }
}

//5. groupBy()
//The groupBy() function can be used to turn a list into a map, based on a function. Each unique return value of the function becomes a key in the resulting map. The values for each key are all the items in the collection that produced that unique return value.

//The data type of the keys is the same as the return type of the function passed into groupBy(). The data type of the values is a list of items from the original list.
//
//Note: The value doesn't have to be the same type of the list. There's another version of groupBy() that can transform the values into a different type. However, that version is not covered here.
//
//This can be hard to conceptualize, so let's start with a simple example. Given the same list of numbers as before, group them as odd or even.
//
//You can check if a number is odd or even by dividing it by 2 and checking if the remainder is 0 or 1. If the remainder is 0, the number is even. Otherwise, if the remainder is 1, the number is odd.
//
//This can be achieved with the modulo operator (%). The modulo operator divides the dividend on the left side of an expression by the divisor on the right.

//The groupBy() function is called with the following lambda expression: { it % 2 }.
//
//The resulting map has two keys: 0 and 1. Each key has a value of type List<Int>. The list for key 0 contains all even numbers, and the list for key 1 contains all odd numbers.


class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie (
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    val fullMenu = cookies.map {
        "${it.name}: $${it.price}"
    }

    fullMenu.forEach {
        println(it)
    }
    println()
    val groupedMenu = cookies.groupBy {
        it.softBaked
    }

    val softBakedMenu = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()
    println()
    println("Soft Cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println()
    println("Crunchy Cookies:")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }
}

//6. fold()
//The fold() function is used to generate a single value from a collection. This is most commonly used for things like calculating a total of prices, or summing all the elements in a list to find an average.

//The fold() function takes two parameters:
//
//An initial value. The data type is inferred when calling the function (that is, an initial value of 0 is inferred to be an Int).
//A lambda expression that returns a value with the same type as the initial value.
//The lambda expression additionally has two parameters:
//
//The first is known as the accumulator. It has the same data type as the initial value. Think of this as a running total. Each time the lambda expression is called, the accumulator is equal to the return value from the previous time the lambda was called.
//The second is the same type as each element in the collection.
//Like other functions you've seen, the lambda expression is called for each element in a collection, so you can use fold() as a concise way to sum all the elements.

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie (
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    val fullMenu = cookies.map {
        "${it.name}: $${it.price}"
    }

    fullMenu.forEach {
        println(it)
    }
    println()
    val groupedMenu = cookies.groupBy {
        it.softBaked
    }

    val softBakedMenu = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()
    println()
    println("Soft Cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println()
    println("Crunchy Cookies:")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }

    val totalPrice = cookies.fold(0.0) {
            total, cookie -> total + cookie.price
    }
    println()
    println("Total Price: $${totalPrice}")
}

//7. sortedBy()
//When you first learned about collections, you learned that the sort() function could be used to sort the elements. However, this won't work on a collection of Cookie objects. The Cookie class has several properties and Kotlin won't know which properties (name, price, etc.) you want to sort by.
//
//For these cases, Kotlin collections provide a sortedBy() function. sortedBy() lets you specify a lambda that returns the property you'd like to sort by. For example, if you'd like to sort by price, the lambda would return it.price. So long as the data type of the value has a natural sort order—strings are sorted alphabetically, numeric values are sorted in ascending order—it will be sorted just like a collection of that type.

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie (
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    val fullMenu = cookies.map {
        "${it.name}: $${it.price}"
    }

    fullMenu.forEach {
        println(it)
    }
    println()
    val groupedMenu = cookies.groupBy {
        it.softBaked
    }

    val softBakedMenu = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()
    println()
    println("Soft Cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println()
    println("Crunchy Cookies:")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }

    val totalPrice = cookies.fold(0.0) {
            total, cookie -> total + cookie.price
    }
    println()
    println("Total Price: $${totalPrice}")

    val alphabeticalMenu = cookies.sortedBy {
        it.name
    }
    println()
    println("Alphabetical Menu:")
    alphabeticalMenu.forEach {
        println(it.name)
    }
}
