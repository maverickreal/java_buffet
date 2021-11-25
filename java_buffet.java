public class java_buffet {

  public static void main(String[] args) {
    /*
     * Java supports primitive data types - byte, boolean, char, short, int, float,
     * long, and double and hence it is not a pure object-oriented language.
     */

    // JIT

    /*
     * The Java source code (.java) conversion to byte code (.class) occurs with the
     * help of the javac compiler. Then, the .class files are loaded at run time by
     * JVM and with the help of an interpreter, these are converted to machine
     * understandable code. JIT compiler is a part of JVM. When the JIT compiler is
     * enabled, the JVM analyzes the method calls in the .class files and compiles
     * them to get more efficient and native code. It also ensures that prioritized
     * method calls are optimized. Once the above step is done, the JVM executes the
     * optimized code directly instead of interpreting the code again. This
     * increases the performance and speed of execution.
     */

    // equals() VS ==

    /*
     * The main difference between the .equals() method and == operator is that one
     * is a method and the other is the operator. We can use == operator for
     * reference comparison (address comparison) and .equals() method for content
     * comparison. In simple words, == checks if both objects point to the same
     * memory location whereas .equals() evaluates to the comparison of values in
     * the objects. If a class does not override the equals method, then by default
     * it uses the equals(Object o) method of the closest parent class that has
     * overridden this method. Object class is considered as the parent class of all
     * the java classes. The implementation of the equals method in the Object class
     * uses the == operator to compare two objects. This default implementation can
     * be overridden
     */
    String s1 = "HELLO";
    String s2 = "HELLO";
    String s3 = new String("HELLO");
    System.out.println(s1 == s2); // true
    System.out.println(s1 == s3); // false
    System.out.println(s1.equals(s2)); // true

    // METHOD OVERLOADING

    // In Java, method overloading is made possible by introducing different methods
    // in the same class consisting of the same name (static allowed). Still, all the functions
    // differ in the number or type of parameters. It takes place inside a class and
    // enhances program readability.
    // The only difference in the return type of the method does not promote method
    // overloading. 
    public int findarea(int l, int b) {
      int var1;
      var1 = l * b;
      return var1;
    }
  
    public int findarea(int l, int b, int h) {
      int var2;
      var2 = l * b * h;
      return var2;
    }
    // constructors are overloaded.

    // MULTIPLE CATCHES IN A SINGLE TRY BLOCK

    try {
      int n = 109, x = 0;
      int arr[] = new int[n];
      for (int i = 0; i <= n; i++) {
        arr[i] = i / x;
      }
    } catch (ArrayIndexOutOfBoundsException exception) {
      System.out.println("1st block = ArrayIndexOutOfBoundsException");
    } catch (ArithmeticException exception) {
      System.out.println("2nd block = ArithmeticException");
    } catch (Exception exception) {
      System.out.println("3rd block = Exception");
    }

    // Here, the second catch block will be executed because of division by 0 (i/x).
    // In case x was greater than 0 then the first catch block will execute because
    // for loop runs till i = n and array index are till n-1.

    // FINAL

    // Classes marked as final can’t be extended. They can inherit other classes
    // though. Moreover their attributes remain mutable.
    // Methods marked as final cannot be overridden.
    // Variables marked as final can't be reassigned.
    final int fVar = 0;
    fVar = 5; // error

    // If we have a final reference variable, we can’t reassign it either. But this
    // doesn’t mean that the object it refers to is immutable. We can change the
    // properties of this object freely.

    final Cat cat = new Cat();
    cat = new Cat(); // error
    cat.age = 5; //

    // For static final fields, we can initialize them:

    // - upon declaration as shown in the above example
    // - in the static initializer block

    // For instance final fields, we can initialize them:

    // - upon declaration
    // - in the instance initializer block
    // - in the constructor

    // The final keyword is also legal to put before method arguments. A final
    // argument can’t be changed inside a method.
    public void methodWithFinalArguments(final int x) {
      x = 1;
    }

    // FINALLY

    // finally defines a block of code we use along with the try keyword. It defines
    // code that's always run after the try and any catch block, before the method
    // is completed. The finally block executes regardless of whether an exception
    // is thrown or caught.

    try {
      System.out.println("The count is " + Integer.parseInt(count));
    } catch (NumberFormatException e) {
      System.out.println("No count");
    } finally {
      System.out.println("In finally");
    }

    // catch block is not mandatory to use finally.

    // Even returning from the method (try/catch) will not prevent finally blocks
    // from running:

    try {
      System.out.println("Inside try");
      return "from try";
    } finally {
      System.out.println("Inside finally"); // works
    }

    // In this case, we are terminating the JVM by calling System.exit and hence the
    // JVM will not execute our finally block:

    try {
      System.out.println("Inside try");
      System.exit(1);
    } finally {
      System.out.println("Inside finally");
    }
    // Similiarly Runtime.halt, prevents the JVM from executing the finally block.

    // A return statement in the finally block ignores any other return statement in
    // the try or catch block. Only the return statement in the finally block
    // executes:

    try {
      System.out.println("Inside try");
      return "from try";
    } finally {
      System.out.println("Inside finally");
      return "from finally";
    }

    // Also, in the case of throwing an exception from a finally block, the method
    // disregards the exception thrown or return statements in the try and catch
    // blocks:

    try {
      System.out.println("Inside try");
      return "from try";
    } finally {
      throw new RuntimeException();
    }

    // FINALIZE

    // https://www.baeldung.com/java-finalize

    // SUPER

    // Use the super keyword to access the parent class.
    public class SuperSub extends SuperBase {

      public SuperSub(String message) {
        super(message);
      }
    }

    public class SuperBase {
      String message = "super class";
  }
  
  public class SuperSub extends SuperBase {
  
      String message = "child class";
  
      public void getParentMessage() {
          System.out.println(super.message);
      }
  }

  public class SuperBase {

    String message = "super class";

    public void printMessage() {
        System.out.println(message);
    }
}

public class SuperSub extends SuperBase {

    String message = "child class";

    public SuperSub() {
        super.printMessage();
        printMessage();
    }

    public void printMessage() {
        System.out.println(message);
    }
}

// STRING POOL

// https://www.baeldung.com/java-string-pool

// STRING VS STRINGBUILDER VS STRINGBUFFER

// In string, the String pool serves as the storage area. For StringBuilder and StringBuffer, heap memory is the storage area.
// A String is immutable, whereas both the StringBuilder and StringBuffer are mutable.
// It is quite slow to work with a String. However, StringBuilder is the fastest in performing operations. The speed of a StringBuffer is more than a String and less than a StringBuilder. (For example appending a character is fastest in StringBuilder and very slow in String because a new memory is required for the new String with appended character.)
// In the case of a threaded environment, StringBuilder and StringBuffer are used whereas a String is not used. However, StringBuilder is suitable for an environment with a single thread, and a StringBuffer is suitable for multiple threads.

// ABSTRACT CLASS VS INTERFACE

// Only abstract methods are available in interfaces, whereas non-abstract methods can be present along with abstract methods in abstract classes.
// Static and final variables can only be declared in the case of interfaces, whereas abstract classes can also have non-static and non-final variables.
// Multiple inheritances are facilitated by interfaces, whereas abstract classes do not promote multiple inheritances.
// By default, the class data members of interfaces are of the public- type. Conversely, the class members for an abstract class can be protected or private also.
// With the help of an abstract class, the implementation of an interface is easily possible. However, the converse is not true.

// ABSTRACT

// There are many cases when implementing a contract where we want to postpone some parts of the implementation to be completed later. We can easily accomplish this in Java through abstract classes.
// We define an abstract class with the abstract modifier preceding the class keyword
// An abstract class can be subclassed, but it can't be instantiated
// If a class defines one or more abstract methods, then the class itself must be declared abstract
// An abstract class can declare both abstract and concrete methods
// A subclass derived from an abstract class must either implement all the base class's abstract methods or be abstract itself.

// INTERFACE

// In Java, an interface is an abstract type that contains a collection of methods and constant variables. It is one of the core concepts in Java and is used to achieve abstraction, polymorphism and multiple inheritances.

// In an interface, we're allowed to use:

// constants variables
// abstract methods
// static methods
// default methods
// We also should remember that:

// we can't instantiate interfaces directly
// an interface can be empty, with no methods or variables in it
// we can't use the final word in the interface definition, as it will result in a compiler error
// all interface declarations should have the public or default access modifier; the abstract modifier will be added automatically by the compiler
// an interface method can't be protected or final
// up until Java 9, interface methods could not be private; however, Java 9 introduced the possibility to define private methods in interfaces
// interface variables are public, static, and final by definition; we're not allowed to change their visibility
// In order to achieve multiple inheritances thru interfaces, we have to remember the following rules:
// When an interface extends another interface, it inherits all of that interface's abstract methods.
// When an abstract class implements an interface, it inherits all of its abstract and default methods.

  }
}