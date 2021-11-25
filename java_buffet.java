public class java_buffet {

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

  public void methodWithFinalArguments(final int x) {
    x = 1;
  }

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
     * is a method and the other is the operator. We can use == operators for
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
    // in the same class consisting of the same name. Still, all the functions
    // differ in the number or type of parameters. It takes place inside a class and
    // enhances program readability.
    // The only difference in the return type of the method does not promote method
    // overloading. The findArea() functions are a fine example. Similiarly
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
    // argument can’t be changed inside a method. Ex methodWithFinalArguments().

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
  }
}