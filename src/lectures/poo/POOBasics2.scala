package lectures.poo

object POOBasics2 extends App {
  val person = new Person("John", 26)
  println(person.age)
  println(person.x) //variable de la clase llamada como atributo
  person.greet("Daniel") //llamo a la funcion greet de Person que necesita un parametro name
  person.greet() //llamo a greet sin parametros

  val author = new Writer("Charles", "Dickens", 1812)
  val impostor = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expetations", 1861, author)

  println(author.fullName)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(impostor)) //observar como a pesar de que son los mismos valores esta llamada arroja falso, es un problema de la POO
}

//constructor, parametros de clase NO son atributos NO se llaman con notacion objeto.atributo a menos que se declaren como val
class Person(name: String, val age: Int = 0) {
  //cuerpo de la clase, se define la implementacion pero no es expresion de Scala

  val x = 2 //variable local, pero puede accederse como objeto.atributo

  //con this distingo al atributo name de la clase persona del parametro name que recibe el metodo greet
  def greet(name: String): Unit = println(s"${this.name} says: Hi,$name")

  /*sobrecarga metodos: metodo greet sin parametros, ya no es necesario el this
  para referirse al campo name de la clase Persona*/
  def greet(): Unit = println(s"Hi, I am ${name}")

  //constructores multiples
  def this(name: String) = this(name, 0) //no muy practico, es mejor definir parametros de clase con valor por defecto

}

/* escritor y novela
     Writer: first name, surname, year
      -method fullname

     Novel: name, year of release, author
      -authorAge
      -isWritenBy(author)
      -copy(new year of release= = new instance of novel
    */
class Writer(firstName: String, surname: String, val year: Int) {
  def fullName: String = firstName + " " + surname
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year //se ha declarado year en Writer como val
  def isWrittenBy(author: Writer) = author == this.author

  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

/*
   Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
* */

class Counter(val count: Int) {
  def inc = new Counter(count + 1) {
    println("incrementting")
    new Counter(count + 1) //inmutability, devuelvo un nuevo objeto con el parametro modificado, asi no se modifica el atributo original
  }

  def dec = new Counter(count - 1) {
    println("decrementing")
    new Counter((count - 1)) //inmutability too..
  }

  //sobrecarga de los metodos anteriores
  def inc(n: Int) = new Counter(count + n)

  def dec(n: Int) = new Counter(count - n)
}



