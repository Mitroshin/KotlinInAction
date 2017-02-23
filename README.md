# KotlinInAction

Конспект учебника Kotlin In Action (Dmitry Jemerov, Svetlana Isakova)

Chapter 2: Kotlin Basics

    This chapter covers:
        * Declaring functions, variables, classes, enums ant properties
        * Control structures in Kotlin
        * Smart casts
        * Throwing and handing exceptions
________________________________________________________________________________________________________________________

    2.1 Basic elements: functions and variables
    
        2.1.1 Hello, world!
        
            -> example1
        
            * The "fun" keyword is used to declare a function
            * The parameter type is written after the parameter name
            * The function can be declare at t he top level of a file
            * Arrays are just classes
            * println() instead of System.out.println()
            * You can omit the semicolon "";" from the end of a line
            
        2.1.2 Functions
        
            -> example2
        
            The function declaration:
                * "fun" keyword
                * function name
                * parameter list in parentheses "()"
                * colon ":"
                * return type
        
            In Kotlin "if" is an expression with a result value. It's similar to a ternary operation in Java.
        
            -> example2.max1()
        
            Block body - if a function is written with its body in curly braces.
        
            -> example2.max2()
        
            Expression body - if a function returns an expression directly.
        
            -> example2.max3()
        
            For expression body functions, compiler can analyze the expression used as a the body of the
            function and use its type as the function return type.
            
        2.1.3 Variables
        
            -> example3
        
            You can omit type of variable or you may put the type after the variable name, but If a variable doesn't
            have an initializer, you need to specify its type explicitly.
        
            There are two keyword to declare a variable:
                * val (value) - Immutable reference. A "val" variable must be initialized exactly once during the
                    execution of the block where it's defined. But you can initialize it with different values depending
                    on some condition, if the compiler can ensure that only one of the initialization statement will be
                    executed. Even though a "val" reference is itself immutable, the object that it points to may be
                    mutable.
                * var (variable) - Mutable reference, but its type is fixed.
                
        2.1.4 Easier string formatting: string templates
        
            -> example4
        
            Kotlin allows you to refer to local variables in string literals by putting the ""$" character in front of
            the variable name. If you need to include the "$" character in a string, you escape it:
                |   println("\$x")
            You can use more complex expressions as well. All it takes is putting curly braces around the expression.
________________________________________________________________________________________________________________________

    2.2 Classes and Properties
    
        -> example5
    
        Value object - Class of this type (containing only data but no code).
        In Kotlin "public" is the default visibility.
        
        2.2.1 Properties
        
            Properties - the combination of the field and its accessors.
            The concise declaration of the "Person" class hides the same underlying implementation as the original
            Java code: its's a class with a private field that is initialized in the constructor and can be accessed
            through the corresponding getter.
        
            Kotlin's "name" property is exposed to Java as a getter method called getName(). For Boolean properties, a
            special rule for getter naming applies: if the property name starts with "is", no additional prefix for the
            getter is added. Thus, from Java, you call isMarries().
                Java:
                    |   Person person = new Person("Bob", true);
                    |   System.out.println(person.getName());
                    |   System.out.println(person.isMarried());
                Kotlin:
                    |   val person = Person("Bob", true)
                    |   println(person.name)
                    |   println(person.isMarried)
            You call the constructor without the keyword.
            You access the property directly, but the getter is invoked.
        
            Setter of mutable properties work the same way:
                Java:
                    |   person.setMarried(false);
                Kotlin:
                    |   person.isMarried = false
                    
        2.2.2 Custom accessors
        
            -> example6
        
            The property "isSquare" doesn't need a field to store its value. It only has a custom getter with the
            implementation provided.
            
        2.2.3 Kotlin source code layout: directories and package
        
            -> geometry.shapes.example7
        
            Every Kotlin file can have a "package" statement at the beginning, and all declarations defined in the file
            will be placed in that package. Declarations defined in other files can be used directly if they're in the
            same package; they need to be imported if they're in a different package.
        
            -> geometry.example.example8
        
            Kotlin doesn't make a distinction between importing classes and methods. You can import the top-level
            function by name:
                |   import geometry.shapes.createRandomRectangle
            You can also import all declarations defined in a particular package by putting "*" after the package name.
        
            In Kotlin, you can put multiple classes in the same file and choose any name for that file.
________________________________________________________________________________________________________________________

    2.3 Representing and handling choices: enums and "when"
    
        2.3.1 Declaring enum classes
        
            -> example9.chapter2.Color1
        
            Just as in Java, enums aren't lists of values: you can declare properties and methods on enum classes.
        
            -> example9.chapter2.Color2
        
            Enum constants use the same constructor and property declaration syntax as you saw earlier for regular
            classes. When you declare each enum constant, you need to provide the property values for that constant.
        
            If you define any methods in the enum class, the semicolon ":" separates the enum constant list from the
            method definitions.
            
        2.3.2 Using "when" to deal with enum classes
        
            Imagine you need a function that gives you a mnemonic for each color and you don't want to store this
            information in the enum itself.
        
            Like "if", "when" is an expression that returns a value.
        
            -> example9.getMnemonic()
        
            The code finds the branch corresponding to the passed "color" value. Unlike Java, you don't need to write
            "break" statement in each branch. If a match is successful, only the corresponding branch is executed.
        
            -> example9.getWarmth()
        
            You can also combine multiple value in the same branch if you separate them with commas.
            
        2.3.3 Using "when" with arbitrary object
        
            Unlike "switch", which requires yo to use constants (enum constants, string, or number literals) as branch
            conditions, "when" allows any objects.
        
            -> example9.mix()
        
            An argument of the when expression can be any object.
                |   when (setOf(color1, color2))
        
            Executed if none of the other branches were matched.
                |   else -> throw Exception("Dirty color")
        
            The Kotlin standard library contains a function "setOf()" that create a "Set" containing the objects
            specified as its arguments. A "Set" is a collection for which the order of items doesn't matter; two sets
            are equal if they contain the same items.
                |   setOf(color1, color2)
                
        2.3.4 Using "when" without an argument
        
            Every time you call "mix()" it creates several "Set" instances that are used only to check whether two given
            colors match the other two colors. Normally this isn't an issue, but if the function is called often, it's
            worth rewriting the code in a different way to avoid creating garbage.
        
            -> example9.mixOptimized()
        
            If no argument is supplied for the "when" expression, the branch condition is any boolean expression.
            
        2.3.5 Smart casts: combining type checks and casts
        
            Function that evaluates simple arithmetic expressions like (1 + 2) + 4.
            To encode the expressions we need to store them in a tree-like structure. where each node is either a sum
            "Sum" or a number "Num". "Num" is always a leaf node, whereas a "Sum" node has two children: the arguments
            of the "sum" operation
        
            Simple structure of classes used to encode the expressions: an interface called "Expr" and two classes,
            "Num" and "Sum", that implement it.
        
            -> example10
        
            "Expr" interface doesn't declare any methods, it's used as a marker interface to provide a common type for
            different kinds of expressions. To mark that a class implements an interface, you use a colon ":".
            The argument of a "Sum" operation can be any Expr: either "Num" or another "Sum".
        
            -> example10.eval1()
        
            This explicit cast to "Num" is redundant.
                |   val n = e as Num
        
            The variable "e" is smart-cast.
                |   return eval(e.right) + eval(e.left)
        
            In Kotlin, you check whether a variable is of a certain type by using an "is" check. The "is" check is
            similar to "instanceof" in Java.
        
            If you check the variable for a certain type, you don't need to cast it afterward; you can use it as having
            the type you checked for. In effect, the compiler performs the cast for you, and we call it a "smart cast".
        
            An explicit cast to the specific type is expressed via the "as" keyword.
                |   val n = e  as Num
                
        2.3.6 Refactoring: replace "if" with "when"
        
            You can rewrite the "eval" function to use the expression-body syntax, removing the "return" statement and
            the curly braces and using the "if" expression as the function body instead.
        
            -> example10.eval2()
        
            The curly brackets  are optional if there's only one expression in an "if" branch. If an "if" branch ia a
            block, the last expression is returned as a result.
        
            -> example10.eval3()
        
            "when" branches that checked the argument type and smart cast are applied here.
                |   is Num -> e.value
                |   is Sum -> eval3(e.left) + eval3(e.right)
        
        2.3.7 Block as branches of "if" and "when"
        
            Both "if" and "when" can have blocks as branches. In, this case, the last expression in the block is the
            result.
        
            -> example10.evalWithLogging()
        
            The rule "the last expression in a block is the result" holds in all cases where a block can be used and a
            result is expected. But this rule doesn't hold for regular function.
________________________________________________________________________________________________________________________

    2.4 Iterating over things: "while" and "for" loops
    
        2.4.1 The "while" loop
        
            Kotlin has "while" and "do-while" loops, and their syntax doesn't differ from the corresponding loops in
            Java.
            
        2.4.2 Iterating over numbers: ranges and progressions
        
            To replace the most common use cases of "for" loops, Kotlin uses the concept of "ranges". A "range" is
            essentially just an interval between two values, usually numbers: a start and an end. You write it using
            the ".." operator:
                |   val oneToTen = 1 .. 10
            Ranges in Kotlin are "closed" or "inclusive", meaning the second value is also always a part of the range.
        
            Let's use integer ranges to play the Fizz-Buzz game. Players take turns counting incrementally, replacing
            any number divisible by three with the word "fizz" and any number divisible by five with the word "buzz". If
            a number ia a multiple of both three and five, you say "FizzBuzz".
        
            -> example11.range1
        
            Let's start counting backward from 100 and include only even numbers.
        
            -> example11.range2
        
            The ".." syntax always create a range that includes the end point. In many cases, it's more convenient to
            iterate over half-closed ranges, which don't include the specified end point. To create such a range, use
            the "until" function.
        
            -> example11.range3
            
        2.4.3 Iterating over maps
        
            Let's look at a small program that prints binary representations for characters. You store these binary
            representations in a map.
        
            -> example12
        
            The ".." syntax to create range works not only for numbers, but also for characters.
            You can use the shorthand syntax for getting and updating the values of a map by key. Instead of calling
            "get()" and "put()", you can use to read values
                |   map[key]
            and to set them
                |   map[ey] = value
        
            You can use the same unpacking syntax to iterate over a collection while keeping track of the index of the
            current item. You don't need to create a separate variable to store the index and increment it by hand.
        
            -> example13
            
        2.4.4 Using an "in" check
        
            You use the "in" to check whether a value in in a range, or its opposite, "!in", to check if a value isn't
            in a range. Here's how you can use "in" to check if a character belong to a range characters.
        
            -> example14
        
            The "in" and "!in" operators also work in "when" expressions.
        
            -> example15
        
            You can combine multiple ranges.
                |   in 'a'.. 'z', in 'A' .. 'Z' -> "It's a letter!"
        
            If you have any class that supports comparing instances. you can create ranges of objects of that type. If
            you have such a range, you can't enumerate all objects in the range. But you can still check whether another
            object belong to the range, using the "in" operator. The same "in" check works with collections as well.
                |   "Kotlin" in setOf("Java", "Scala")
________________________________________________________________________________________________________________________

    2.5 Exception in Kotlin
    
        A function can complete in a normal way or throw an exception if an error occurs. The function caller can catch
        this exception and process if; if it doesn't, the exception is rethrown further up the stack.
    
        Unlike in Java, in Kotlin the "throw" construct is an expression and can be used as a part of other expressions.
        
        2.5.1 "try", "catch" and "finally"
        
            -> example16.readNumber1()
        
            Unlike Java you don't have to explicitly specify exceptions that can be thrown from function.
            
        2.5.2 "try" as an expression
        
            -> example16.readNumber2()
        
            In Kotlin "try" keyword introduces an expression, and you can assign its value to a variable. You always
            need to enclose the statement body in curly braces. The value of the "try" expression as a whole is the
            value of the last expression.
        
            If the execution of a "try" code block behaves normally, the last expression in a "try" block is the result.
            If an exception is caught, the last expression in a corresponding "catch" block is the result.
________________________________________________________________________________________________________________________

    2.6 Summary
    
        * The "fun" keyword is used to declare a function. The "val" and "var" keywords declare read-only and mutable
            variables, respectively.
        * String templates help you avoid noisy string concatenation. Prefix a variable name with "$" or surround an
            expression with "${}" to have its value injected into the string.
        * Value-object classes are expressed in a very concise way in Kotlin.
        * The familiar "if" is now an expression with a return value.
        * The "when" expression is analogous to "switch" in Java but is more powerful.
        * You don't have to cast a variable explicitly after checking that it has a certain type: the compiler casts it
            for you automatically using a smart cast.
        * The "for", "while" and "do-while" loops are vary similar to Java, but the "for" loop is now more convenient,
            especially when you need to iterate over a map or a collection with an index.
        * The concise syntax "1 .. 5" creates a range. Ranges and progressions allow Kotlin to use a uniform syntax and
            set of abstractions in "for" loops and also work with the "in" and "!in" operators that check whether a
            value belong to a range.
        * Exception handling in Kotlin is very similar to Java, except that Kotlin doesn't require you to declare the
            exceptions that can be thrown by a method.
________________________________________________________________________________________________________________________

Chapter 3: Defining and calling functions

    This chapter covers:
        * Functions for working with collections, strings, and regular expressions
        * Using named arguments, default argument values, and the infix call syntax
        * Adapting Java libraries to Kotlin through extension functions and properties
        * Structuring yor code with top-level and local functions and properties
________________________________________________________________________________________________________________________

    3.1 Creating collections in Kotlin
        
        -> example1
        
        "to" is not a special construct, but a normal function.
        "javaClass" is Kotlin's equivalent of Java's getClass()
        
        Kotlin uses the standart Java collection classes and doesn't have its own set of collection classes, but you can
        do much more with them in Kotlin.
        
        -> example2
________________________________________________________________________________________________________________________
        
    3.2 Making functions easier to call
    
        Let's print content of collection. Java collections have a default "toString()" implementation, bt its format is 
        fixed. If you need to create special format to print collections, you may write a following function 
        
        -> example3
        
        3.2.1 Named arguments
        
            -> example3
            
            When calling a method written in Kotlin, you can specify the names of some arguments that you are passing
            to the function. If you specify the name of an argument in a call, you should also specify the names for all 
            the arguments after that.
            
            You can't use named arguments when calling methods written in Java.
            
        3.2.2 Default parameter values
        
            In Kotlin, you can often avoid creating overloads because you can specify default values for parameters in a
            function declaration. 
            
            -> example3
            
            You can either invoke the function with all the arguments or omit some of them. If you use nemd arguments, 
            you can omit some arguments from middle of the list and specify only the ones you need.
            
            Java doesn't have the concept of default parameter values, you have to specify all the parameter values 
            explicitly when you call a Kotlin functions with default parameter values from Java.
            
        3.2.3 Getting rid of static utility classes: top-level functions and properties
        
            In Kotlin you can place functions directly at the top level of source file, outside of any class. Such 
            functions are still members of the package declared at the top of the file, and you still need to import 
            them if you want to call them other packages.
            
            -> strings.join.kt
            -> example3
            
            If you need to call such a function from Java, you have to understand how it will be compiled. This is a 
            Java code that would compile to the same class
            
                |   package strings;
                |   
                |   public class JoinKt {
                |       public static String joinToString(...) {...}
                |   }
                
            The name of the class generated by the Kotlin compiler corresponds to the name of the file containing the 
            function. All top-level functions in the file are compiled to static methods of that class. 
            
            To change the name of the generated class that contains Kotlin top-level functions, you add a @JvmName
            annotation to the file.
            
                |   @file:JvmName("StringFunctions")
                
            Just like functions, properties can be placed at the top level of a file. For example, you can use a 
            property to count the number of times some operation has been performed
            
            -> example4
            
            The value of such a property will be stored in a static field. Top-level properties also allow you to define 
            contstant. Top-level properties, just like any other properties, are exposed to Java code as accessoe 
            methods. 
            
            To expose a constant to Java code as a "public static final" field, you can mark it with the "const" 
            modifer (this is allowed for propertirs of primitive types, as well as "String").
________________________________________________________________________________________________________________________
            
    3.3 Adding methods to other people's classes: extension functions and properties
    
        Exatention function - it's a function that can be called as a member of a class but is defined outside of it.
        
        -> strings.example5.lastChar1()
        
        You need to put the name of the class or interface that you're extending before the name of the function you're 
        adding. This class name is called the "receiver type", and the value on which you're calling the extension 
        function called the "receiver object". You can call the function using the same syntax you use for ordinary 
        class members.
        
            |   println("Kotlin".lastChar2())
            
        String - is the receiver type.
        "Kotlin" - is the receiver object.
        
        In the body of an extension function, you use "this" as you'd use it in a method. And, as in regular method, you 
        can omit it
        
        -> strings.example5.lastChar2()
        
        In the extension function, you can directly access the method and properties of the class you're extending, as
        in method defined in the class itself. Extension functions don't allow you to break encapsulation. Unlike 
        methods defined in the class, extension functions don't have access to private or protected members of the 
        class.
        
        3.3.1 Imports and extension functions
        
            When you define an extension function, it doesn't automatically become available across you entire project. 
            Instead, it need to be imported, just like any other class or function.
            
            -> example6
            
            You can change the name of the class or function you're importing using the "as" keyword.
            
            -> example7
        
        3.3.2 Calling extension function from Java
        
            To use extension function from Java you need to call the static method and pass the receiver object instance. 
            The name of the Java class containing the method is determinate from the name os the file where the function is
            declared.
            
            Java:
                |   char c = StringUtil.lastChar("Java");
            
        3.3.3 Utility functions as extensions
        
            -> strings.join.kt
            
            "this" refers to the receiver object: a collection of T.
            You make it an extension to a collection of elements, and you provide default values fot all the arguments.Now 
            you can invoke joinToString() like a member of a class
            
            -> example8
            
            You can use a more specific type as a receiver type, not just a class. Let's say you want to have a join() 
            function that can be invoked only on collections of strings.
            
            -> example9
            
        3.3.4 No overriding for extension functions
        
            You can't overryde an extension function. 
            
            -> example10
            -> example11
            
            The extension function is resolved statically.
            
            If the class has a member function with the same signature as an extension function, the member function always
            takes precedence.
            
        3.3.5 Extension properties
        
            It's not possible to add extra fields to existing instances of Java objects. But the shorter syntax is still 
            sometimes handy.
            
            -> example5.lastChar
            
            You can access extension properties exactly like member properties.
            When you need to access an extension property from Java, you should invoke its getter explicitly: 
                Java:
                    |   StringUtilKt.getLastChar("Java")
________________________________________________________________________________________________________________________
                
    3.4 Working with collections: varargs, infix calls, and library support
    
        3.4.1 Extending the Java Collection API
        
            -> example2
            
            The last() and max() functions are declared as extension functions. 
            IDE will show you all the possible functions available for that type of object. The list includes both 
            regular methods and extension functions.
            
        3.4.2 Varargs: functions that accept an arbinaty number of arguments
        
            When you call a function to create a list, you can pass any number of argument to it.
            
                |   val list = listOf(2, 3, 5, 7, 11)
            
            This function is declared in the library like that
            
                |   fun listOf<T>(vararg values: T): List<T> { ... }
                
            Insteaf of threee dots after the type in Java, Kotlin uses the "vararg" modifier on the parameter.
            Kotlin requires you to explicitly unpack the array when you callint the functions and the argument you need
            to pass are already packed in the array. This feature is called using a "spread operator". It's as simple as
            putting the * character befire the corresponding argument.
            
            -> example12
            
        3.4.3 Working with pairs: infix calls and destructuring declarations
        
            The word "to" (when you create a map) isn't a build-in construct, but reather a method invocation of a 
            special kind called an "infix call". In an infix call, the method name is places immediately between the 
            target object name and the parameter, with no extra separator. 
                |   1.to("one)
                |   1 to "one
            Infix calls can be used with regular methods and extension functions that have one required parameter. The 
            "to" function return an instance of "Pair", which is a Kotlin standart library class that represent a pair
            of element. You can assign a pair of elements to two variables directly
                |   val (number, name) = 1 to "one"
            This feature is called a "destructing declaration". You can assign a map entry to two separate variables,
            "key" and "values". This also works with the loops.
            -> strings.join.kt
            
            The function is declared in the library like that
            
                |   fun <K, V> mapOf(vararg values: Pair<K, V>): <K, V>
________________________________________________________________________________________________________________________                
                
    3.5 Working with strings and regular expressions
    
        Kotlin strings are exactly the same things as Java strings. Kotlin makes working with standart Java strings more
        enjoyable by providing a bunch of useful extension functions. 
        
        3.5.1 Splitting strings
        
            The split() method in Java doesn't work on a dot. Kotlin provides as replacements several overloaded 
            extensions named "split" that have different arguments. The one that takes a regular expression requires a
            value of "Regex" type, not "String".
            
            -> example13
                
            Kotlin uses exactly the same regular-expression syntax as in Java. The pattern here matches a dot or a dash.
            
            toRegex() - extension function to convert a string into a regular expression. But in this case you can use 
            the other overload of the split().
            
        3.5.2 Regular expressions and triple_quoted strings
        
            Parse a file's full path name into its components.
            
            -> example14.parsePath()
            
            Or you may use regular expression
            
            -> example15.parsePathRegexp()
            
        3.5.3 Multiple triple-quoted strings
        
            Triple-quoted strings is not only to avoid escaping characters. Such a string literal can contain any 
            characters, including line breaks.
            
            -> example15
            
            The multiple string contains all the characters between the triple quotes, including indents used to format 
            code. 
            
            The triple-quoted string contains line breaks, but you can't use special characters like "\n". On the other 
            hand, you don't have to escape "\", so the Windows-style path can be written as 
            
            -> example14
            
            You can use templates in multiline strings. Because multiline strings don't support escape sequences, you 
            have to use an embedded expression if you need to use a literal dollar sign in the contents of your string.
                |   val price = """${'$'}99.9"""
________________________________________________________________________________________________________________________                
                
    3.6 Making your code tidy: local functions and extensions
    
        You can nest the function you've extracted in the containing function. This way, you have the structure you need 
        without any extra syntactic overhead.
        
        In the following example, a function saves a user to a database, and you need to make sure the user object 
        contains valid data
        
        -> example16.saveUser1()
        
        Field validation is duplicated. If you put the validation code into a locak function, you can get trip of the 
        duplication and still maintain a clear code structure. 
        
        -> example16.saveUser2()
        
        Local functions have access to all parameters and veriables of the enclosing function.
        
        -> example16.saveUser3()
        
        You can move the validation logic into an extension function of the "User" class
        
        -> example16.saveUser4()
        
        The API of the class contains only the essential methods used everywhere. On the other hand, functions that 
        primarily deal with a single object and don't need access to its private data can access its members without 
        extra qualification.
________________________________________________________________________________________________________________________        
        
    3.7 Summary
    
        * Kotlin doesn't define its own collection classes and instead extends the Java collection classes with a richer
            API.
        * Defining default values for function parameters greatly reduces the need to define overloaded functions, and
            the named-argument syntax makes calls to functions with many parameters much more readable.
        * Functions and properties can be declared directly in a file, not just as members of a class, allowing for a 
            more flexible code structure.
        * Extension functions and properties let you extend the API of any class, including classes defined in external 
            libraries, without modifying its source code and with no runtime overhead.
        * Infix calls provide a clean syntax for calling operator-like methods with a single argument.
        * Kotlin provides a large number of convenient string-handling functions for both regular expressions and plain
            strings.
        * Triple-quoted strings provide a clean way to write expressions that would require a lot of noisy escaping and
            string concatenation in Java.
        * Local functions help you structure your code more cleanly and eliminate duplication.
________________________________________________________________________________________________________________________

Chapter 4: Classes, objects, and interfaces

    This chapter covers:
        * Classes and interfaces
        * Nontrivial properties and constructors
        * Data classes and class delegation
        * Using the "object" keyword
________________________________________________________________________________________________________________________