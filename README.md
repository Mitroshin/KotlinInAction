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