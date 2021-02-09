package exercises

abstract class MyListGeneric[+A] {

  /* Ejercicio: transformar la clase de lista enlazada en una clase generica COVARIANCE
  * */
  def head:A
  def tail:MyListGeneric[A]
  def isEmpty:Boolean
  def add[B >: A](element: B): MyListGeneric[B] //bondtype para COVARIANCE
  def printElements: String
  //llamada polimorfica, ToString delegara su ejecucion a las implementaciones de las subclases Empty y ConsG
  override def toString: String = "[" + printElements +"]"
}
/*objeto lista vacia: por COVARIANCE el tipo Nothing es un sustito del tipo Any, entonces el tipo Empty es un sustituto adecuado para
 un objeto MyListGeneric de tipo Any MyListGeneric[Any] entonces un objeto Empty extiende MyListGeneric de tipo nothing MyListGeneric[Nothing]
 en el caso de Empty extiende el tipo especifico Nothing, cuando se trata de una MyListGeneric vacia
** */
object EmptyG extends MyListGeneric[Nothing] { //EmptyG extiende en especifico el tipo Nothing de la clase MyListGeneric->MyListGeneric[Nothing]
  def head: Nothing = throw new NoSuchElementException
  def tail:MyListGeneric[Nothing] = throw new NoSuchElementException
  def isEmpty:Boolean = true
  //bondtype que resuelve el problema del COVARIANCE
  def add[B >: Nothing](element: B):MyListGeneric[B] = new ConsG(element, EmptyG)
  def printElements: String = ""
}
//clase para una lista con elementos h=head ; t= tail
class ConsG[+A](h: A, t: MyListGeneric[A]) extends MyListGeneric[A] {
  def head: A = h
  def tail:MyListGeneric[A] = t
  def isEmpty:Boolean = false
  //bondtype para la COVARIANCE
  def add[B >: A](element: B): MyListGeneric[B] = new ConsG(element,this)
  def printElements: String =
    if(t.isEmpty) "" +h
    else h + " " + t.printElements
}

object ListTestGeneric extends App {
 val listOfIntegers: MyListGeneric[Int] = new ConsG(1,new ConsG(2,new ConsG(3,EmptyG)))
  val listOfStrings: MyListGeneric[String] = new ConsG("Hola",new ConsG("Estoy Aprendiendo",new ConsG("Scala",EmptyG)))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}
