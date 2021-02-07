package lectures

import scala.annotation.tailrec

object Recursion extends App{
  /*funcion recursiva normal, con una stack de llamadas a si misma, este tipo de llamadas
  puede saturara la memoria RAM, StackOverflowError
   */
  def factorial(n: Int): Int =
    if(n <= 1) 1
    else{
      println("computing factorial of "+n+" - i first need factorial of " + (n-1))
      val result =  n * factorial(n-1) //guarda el resultado parcial de cada llamada recursiva, usando memoria adicional en cada llamada
      println("Computed factorial of "+n)
      result
    }
  println(factorial(10))

  def anotherFactorial(n: Int): Int ={
    @tailrec //annotation para el compilador trate este bloque como TAIL RECURSIVE
    def factHelper(x: Int, accumulator: Int): Int =
      if(x <= 1) accumulator
      //TAIL RECURSION: llamada recursiva al final del bloque de codigo, Scala preserva el stack de memoria actualizando accumlator
      else factHelper(x -1, x* accumulator)

    factHelper(n,1) //TAIL Recursive CALL
  }
  println(anotherFactorial(10))
  /*
    anotherFactorial(10) -> primer llamada a la funcion anotherFactorial, como x=10 > 1 llama a factHelper(10,1)
    = factHelper(9, 10 * 1) -> se llama a si misma factHelper(9,1), como x=9> 1
    = factHelper(8, 9*10*1) -> se vuelve a llamar a si misma factHelper (8,1), como x=8>1
    =facHelper(7, 8*9*10*1) ->....
    =...
    =factHelper(1, 1*2*3*4*5*6*7*8*9*10) -> se vuelve a llamar a si misma factHelper (1,1), como x=1=1 retorna accumulator
    = 3628800
    * TAIL RECURSIVE con esto evitamos el StackOverFlow y podemos calcular el factorial de numeros muy grandes usando el tipo BigInt
    *
    }
   */

}


