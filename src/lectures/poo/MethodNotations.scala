package lectures.poo

object MethodNotations extends App {

  //se crea la clase Person dentro del objeto para evitar conflictos con la clase Person de la leccion anterior
  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie

    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def +(person: Person): String = s"Metodo '+' en Scala TODOS LOS OPERADORES SON METODOS: ${this.name} le gusta ${person.name}"
    //sobreescribo metodo +, devuelve objeto Person con el parametro name concatenado con nickname
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)

    def unary_! : String = s"este operador unario ! es un metodo, aqui negando a $name" //metodo para ilustrar prefix operator
    //metodo unario para incrementar age, devuelve objeto Person con age incrementado en 1
    def unary_+ : Person = new Person(name,favoriteMovie,age+1)
    def isAlive: Boolean = true //metodo para ilustrar postix operator, pero el compilador dice que se debe habilitar

    def apply(): String = s"Hi my name is $name y mi peli favorita es $favoriteMovie"
    //sobreescritura metodo apply
    def apply(n: Int):String=s"$name watched $favoriteMovie $n times"

    def learns(thing:String)=s"$name is learning $thing"
    def learnsScala = this learns("Scala") //lama a learns usando this para pasar el objeto Person

  }
  //instancia objeto Person, servira para todos los ejemplos y ejercicios posteriores
  val mary = new Person("Mary", "Inception")

  println(mary.likes("Inception")) //notacion estandar
  //infix notation = notacion de operador, SOLO FUNCIONA CON METODOS QUE RECIBEN UN SOLO PARAMETRO
  println(mary likes "Inception") //aquivalente a la anterior:

  //operadores en Scala
  //instancia otro objeto Person
  val tom = new Person("Tom", "fight club")

  println(mary hangOutWith tom) //el metodo hangOutWith actua como un operador entre los dos objetos Persona
  println(tom + mary) //llamando al metodo + sintaxis valida en Scala
  println(mary.+(tom)) //equivalente al anterior, llamada metodo + con objeto Persona como parametro

  println(1 + 2) //operador + entre 1 y 2
  println(1.+(2)) // notacion de objeto.metodo entre 1 y 2, es equivalente a la anterior

  //prefix notation, operadores unarios tambien son metodos, unary_prexix solo funionan con - + ~ !
  val x = -1 //equivalente a 1.unary_-
  val y = 1.unary_-

  println(!mary) //operador unario ! aplicado al objeto Persona mary
  print(mary.unary_!) //metodo unary_! equivalente al anterior

  //postfix notation, solo se puede usar con metodos sin parametros
  println(mary.isAlive)
  //println(mary isAlive) //no funciono revisar despues

  //apply, si un metodo lleva este nombre puedo llamarlo con notacion objeto(), ESTO ES MUY IMPORTANTE PARA MAS ADELANTE
  println(mary.apply())
  println(mary()) //equivalente al anterior, el compilador delega al metodo apply()

  //Ejericios
  //1. sobrecarga del metodo + con un parametro adicional, uso apply para mostrar el saludo original con el nuevo nickname
  println((mary + "the rockstar").apply()) //notation infix

  //2.Unario para aumentar la edad, como unary_+ devuelve un objeto Person con age+1 llamo a dicho parametro con .age
  println((+mary).age)
  println((mary.unary_+).age) //equivalente al anterior

  //3. crear metodo learns("algo") que es llamado por otro metodo usando referencia a un objeto Persona, y usarlo en notacion postfix
  println(mary.learnsScala) //postfix notation

  //4. Sobreecribir metodo apply para recibir un parametro
  println(mary.apply(3))
  println(mary(4)) //equivalente al anterior


}