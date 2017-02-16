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
