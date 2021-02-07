package exercises

object FunctionsExercises extends App{

  /* 1. funcion de saludo que devuelva nombre y edad  */
  def greetingFunction(name: String, age: Int): String = {
    "Hi, my name is " +name+  " and I am " +age+" years old"
  }
  println(greetingFunction("John",6))

  /* 2. Funcion factorial 1 * 2 * 3 ...* n   */
  def calculateFactorial(n: Int): Int ={
    if(n <= 1) 1
    else n * calculateFactorial(n-1)
  }
  println(calculateFactorial(0))

  /*3. funcion que calcula el valor de una posicion n en la sucesion de fibonacci */
  def calculateFibonacci(n: Int): Int = {
    if(n <= 1 || n == 2) 1
    else calculateFibonacci(n - 1) + calculateFibonacci(n - 2)
  }
  println(calculateFibonacci(5))

  /* 4. Probar que un numero es primo, en este caso para reforzar el uso de una funciones anidadas "Tail Recursive" */
  def isPrime(n: Int): Boolean ={
        def isPrimeUntil(t: Int): Boolean =
          if(t <=1) true
          else n % t != 0 && isPrimeUntil(t-1)

        isPrimeUntil(n / 2)
  }

  println(isPrime(2))
}


