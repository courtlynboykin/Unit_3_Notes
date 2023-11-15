package com.example.unit3notes
//2. Make a reusable class with generics
//Let's say you're writing an app for an online quiz, similar to the quizzes you've seen in this course. There are often multiple types of quiz questions, such as fill-in-the-blank, or true or false. An individual quiz question can be represented by a class, with several properties.
//
//The question text in a quiz can be represented by a string. Quiz questions also need to represent the answer. However, different question types—such as true or false—may need to represent the answer using a different data type. Let's define three different types of questions.
//
//Fill-in-the-blank question: The answer is a word represented by a String.
//True or false question: The answer is represented by a Boolean.
//Math problems: The answer is a numeric value. The answer for a simple arithmetic problem is represented by an Int.

//When you want a property to have differing data types, subclassing is not the answer. Instead, Kotlin provides something called generic types that allow you to have a single property that can have differing data types, depending on the specific use case.

//What is a generic data type?
//Generic types, or generics for short, allow a data type, such as a class, to specify an unknown placeholder data type that can be used with its properties and methods. What exactly does this mean?

//A generic data type is provided when instantiating a class, so it needs to be defined as part of the class signature. After the class name comes a left-facing angle bracket (<), followed by a placeholder name for the data type, followed by a right-facing angle bracket (>).
//
//The placeholder name can then be used wherever you use a real data type within the class, such as for a property.

class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)

fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
    val question2 = Question<Boolean>("The sky is green. True or false", false, "easy")
    val question3 = Question<Int>("How many days are there between full moons?", 28, "hard")
}

//3. Use an enum class
//An enum class is used to create types with a limited set of possible values. In the real world, for example, the four cardinal directions—north, south, east, and west—could be represented by an enum class. There's no need, and the code shouldn't allow, for the use of any additional directions.
//Each possible value of an enum is called an enum constant. Enum constants are placed inside the curly braces separated by commas. The convention is to capitalize every letter in the constant name.

class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty,
)

enum class Difficulty {EASY, MEDIUM, HARD}

fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
}


//4. Use a data class
//Classes like the Question class, on the other hand, only contain data. They don't have any methods that perform an action. These can be defined as a data class. Defining a class as a data class allows the Kotlin compiler to make certain assumptions, and to automatically implement some methods. For example, toString() is called behind the scenes by the println() function. When you use a data class, toString() and other methods are implemented automatically based on the class's properties.
//
//To define a data class, simply add the data keyword before the class keyword.

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty,
)

enum class Difficulty {EASY, MEDIUM, HARD}

fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    println(question1.toString())
}

//5. Use a singleton object
//You can clearly communicate in your code that an object should have only one instance by defining it as a singleton. A singleton is a class that can only have a single instance. Kotlin provides a special construct, called an object, that can be used to make a singleton class.

//The syntax for an object is similar to that of a class. Simply use the object keyword instead of the class keyword. A singleton object can't have a constructor as you can't create instances directly. Instead, all the properties are defined within the curly braces and are given an initial value.

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {EASY, MEDIUM, HARD}

object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}


fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    println("${StudentProgress.answered} of ${StudentProgress.total} answered.")
}

//Declare objects as companion objects
//Classes and objects in Kotlin can be defined inside other types, and can be a great way to organize your code. You can define a singleton object inside another class using a companion object. A companion object allows you to access its properties and methods from inside the class, if the object's properties and methods belong to that class, allowing for more concise syntax.
//
//To declare a companion object, simply add the companion keyword before the object keyword.

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {EASY, MEDIUM, HARD}

class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

fun main() {
    println("${Quiz.answered} of ${Quiz.total} answered.")
}

//6. Extend classes with new properties and methods
//Add an extension property
//To define an extension property, add the type name and a dot operator (.) before the variable name.

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {EASY, MEDIUM, HARD}

class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

val Quiz.StudentProgress.progressText: String
    get() = "${answered} of ${total} answered."

fun main() {
    println(Quiz.progressText)
}

//Add an extension function
//To define an extension function, add the type name and a dot operator (.) before the function name.
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {EASY, MEDIUM, HARD}

class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

fun Quiz.StudentProgress.printProgressBar() {
    repeat(Quiz.answered) {print("▓")}
    repeat(Quiz.total-Quiz.answered) {print("▒")}
    println()
    println(Quiz.progressText)
}

val Quiz.StudentProgress.progressText: String
    get() = "${answered} of ${total} answered."

fun main() {
    Quiz.printProgressBar()
}

//7. Rewrite extension functions using interfaces
//If you need multiple classes to have the same additional properties and methods, perhaps with differing behavior, you can define these properties and methods with an interface.

//An interface is defined using the interface keyword, followed by a name in UpperCamelCase, followed by opening and closing curly braces. Within the curly braces, you can define any method signatures or get-only properties that any class conforming to the interface must implement.

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {EASY, MEDIUM, HARD}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar() {
    }
}

class Quiz : ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    override val progressText: String
        get() = "${answered} of ${total} answered."

    override fun printProgressBar() {
        repeat(Quiz.answered) {print("▓")}
        repeat(Quiz.total-Quiz.answered) {print("▒")}
        println()
        println(progressText)
    }

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

fun main() {
    Quiz().printProgressBar()
}


//There are numerous use cases for interfaces to help structure your code and you'll start to see them used frequently in the common units. The following are some examples of interfaces you may encounter as you continue working with Kotlin.
//
//Manual dependency injection. Create an interface defining all the properties and methods of the dependency. Require the interface as the data type of the dependency (activity, test case, etc.) so that an instance of any class implementing the interface can be used. This allows you to swap out the underlying implementations.
//Mocking for automated tests. Both the mock class and the real class conform to the same interface.
//Accessing the same dependencies in a Compose Multiplatform app. For example, create an interface that provides a common set of properties and methods for Android and desktop, even if the underlying implementation differs for each platform.
//Several data types in Compose, such as Modifier, are interfaces. This allows you to add new modifiers without needing to access or modify the underlying source code.






//8. Use scope functions to access class properties and methods
//As you've seen already, Kotlin includes a lot of features to make your code more concise.
//
//One such feature you'll encounter as you continue learning Android development is scope functions. Scope functions allow you to concisely access properties and methods from a class without having to repeatedly access the variable name. What exactly does this mean? Let's take a look at an example.
//
//Eliminate repetitive object references with scope functions
//Scope functions are higher-order functions that allow you to access properties and methods of an object without referring to the object's name. These are called scope functions because the body of the function passed in takes on the scope of the object that the scope function is called with. For example, some scope functions allow you to access the properties and methods in a class, as if the functions were defined as a method of that class. This can make your code more readable by allowing you to omit the object name when including it is redundant.


//Replace long object names using let()
//The let() function allows you to refer to an object in a lambda expression using the identifier it, instead of the object's actual name. This can help you avoid using a long, more descriptive object name repeatedly when accessing more than one property. The let() function is an extension function that can be called on any Kotlin object using dot notation.

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {EASY, MEDIUM, HARD}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar() {
    }
}

class Quiz : ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    override val progressText: String
        get() = "${answered} of ${total} answered."

    override fun printProgressBar() {
        repeat(Quiz.answered) {print("▓")}
        repeat(Quiz.total-Quiz.answered) {print("▒")}
        println()
        println(progressText)
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let() {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let() {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

fun main() {
    val quiz = Quiz()
    quiz.printQuiz()
    quiz.printProgressBar()
}

//Call an object's methods without a variable using apply()
//One of the cool features of scope functions is that you can call them on an object before that object has even been assigned to a variable. For example, the apply() function is an extension function that can be called on an object using dot notation. The apply() function also returns a reference to that object so that it can be stored in a variable.

data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {EASY, MEDIUM, HARD}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar() {
    }
}

class Quiz : ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    override val progressText: String
        get() = "${answered} of ${total} answered."

    override fun printProgressBar() {
        repeat(Quiz.answered) {print("▓")}
        repeat(Quiz.total-Quiz.answered) {print("▒")}
        println()
        println(progressText)
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let() {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let() {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

fun main() {
    Quiz().apply {
        printQuiz()
        printProgressBar()
    }
}

