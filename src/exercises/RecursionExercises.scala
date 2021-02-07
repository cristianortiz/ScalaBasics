package exercises

import scala.annotation.tailrec

object RecursionExercises extends  App{
  /*  1. concatenar un String n veces   */
  @tailrec
  def concatTailRec(a: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatTailRec(a, n-1,a + accumulator)

  println(concatTailRec("hello ",3,""))

  /*  2. Escrubir la funcion de numeros primos como tal recursive */
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean =
      if(!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1,n % t != 0 && isStillPrime )

    isPrimeTailRec(n/2,true)
  }

  println(isPrime(4))

  /*  3. Funcion fibonacci como tail recursive */
  def fibonnaci(n: Int): Int = {
    //como aqui se hacen dos llamadas recursivas, usar dos acumuladores
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int =
      if(i>= n) last
      else fiboTailRec(i + 1, last + nextToLast, last)

    if(n <= 2) 1
    //se inicia la primera llamada recursiva desde 2 y last =1 y nextToLast =1, los dos primeros numeros de fibo para que luego siga con los demas
    else fiboTailRec(2,1,1)
  }

  print(fibonnaci(8))
}
