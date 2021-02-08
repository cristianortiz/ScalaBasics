package exercises

abstract class MyList {

/* Ejercicio para crear una lista enlazada para numeros enteros en Scala usando clases abstractas
   head = cabecera de la lista
   tail = enlace o puntero de la lista
   isEmpty = si la lista esta vacia
   add(int) => crea una nueva lista  con el elemento (int)
   toString => representacion en texto de la lista
* */
  def head:Int
  def tail:MyList
  def isEmpty:Boolean
  def add(element: Int):MyList //inmutable
  def printElements: String
  //llamada polimorfica, ToString delegara su ejecucion a las implementaciones de las subclases Empty y Cons
  override def toString: String = "[" + printElements +"]"
}
//objeto lista vacia
object Empty extends MyList{
  //def head:Int = ??? //??? arroja not implemented error, los implementaremos luego
  def head: Int = throw new NoSuchElementException
  def tail:MyList= throw new NoSuchElementException
  def isEmpty:Boolean = true
  def add(element: Int):MyList = new Cons(element,Empty)
  def printElements: String = ""
}
//clase para una lista con elementos h=head ; t= tail
class Cons(h: Int, t: MyList) extends MyList{
  def head:Int = h
  def tail:MyList= t
  def isEmpty:Boolean = false
  //crea una nueva lista Cons cuyo head sera element y su tail sera la misma lista Cons que ha llamado a add
  def add(element: Int):MyList = new Cons(element,this)
  def printElements: String =
    if(t.isEmpty) "" +h
    else h + " " + t.printElements
}

object ListTest extends App{
  //val list = new Cons(1, Empty) -> devuelve 1
  /*Lista enlazada de head =1 y tail= lista Cons que tiene head=2 y en su tail= lista Cons
  * que tiene head=3 y tail=lista vacia */
  val list = new Cons(1,new Cons(2, new Cons(3,Empty)))
  println(list.tail.head) //pido el head de la lista que esta enlazada a la tail del Cons->list con head = 1
  val list2 = list.add(23)  //nueva lista con 1 elemento que a su vez es su head=23 y como tail el Cons->list
  println(list.add(4).head)   //crea una nueva lista Cons con  head=23 y como tail Cons->list
  println(list2.tail.head)   //en Cons->list2 su tail es la lista Cons->list, pido el head de list
  println(list2.isEmpty)
  println(list2.toString)

  

}

