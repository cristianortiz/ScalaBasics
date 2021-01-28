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
}
