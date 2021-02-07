package lectures

object Functions extends App{
  // definicion simple de una funcion
  def aFunction(a: String, b: Int): String = a + " " +b

  //definicion de una funcion en bloque de codigo
  def aFunction2(a: String, b: Int): String = {
    a + " soy otra funcion "+b
  }
  println(aFunction("Hello",3))
  println(aFunction2("hello",45))

  // declarando funcion sin parametros
  def aParameterLessFunction(): Int = 42
  println(aParameterLessFunction())
  //si no tiene parametros se puede llamar sin ()
  println(aParameterLessFunction)

  /* funcion recursiva se usan para reemplazar los ciclos
     SIEMPRE USAR FUNCIONES RECURSIVAS EN VEZ DE CICLOS */
  def aRepeatedFunction(a: String, n: Int): String = {
    if (n == 1) a
    else a + aRepeatedFunction(a, n - 1)
  }

  println(aRepeatedFunction("hello",3))

  //funcion que retorna un tipo Unit,  en scala lo llaman "side effects"
  def aFunctionSideEffects(a: String): Unit = println(a)

  /*Dentro de un bloque de codigo de una funcion se puede definir otra funcion y llamarla
    para que se ejecute */
  def aBigFunction(n: Int): Int = {
    //defino una funcion "anidada" o nest
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    //se llama a la funcion auxiliar y se le da el parametro de la funcion original
    aSmallerFunction(n, n-1)
  }
  println(aBigFunction(3))
}
