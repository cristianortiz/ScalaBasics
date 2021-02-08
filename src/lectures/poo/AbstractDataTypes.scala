package lectures.poo

object AbstractDataTypes extends App {

/*  clase abstracta, las subclases implementaran los miembros declarados de la clase Animal que NO puede ser instanciada,
   una clase abstracta puede tener metodos abstractos y otros con implementacion */
  abstract class Animal {
    val creatureType: String

    def eat: Unit
  }

  //subclase de Animal que DEBE implemetar a todos los miembros de la supeclase
  class Dog extends Animal {
    override val creatureType: String = "Canino"

    override def eat: Unit = print("Este come comida de canino")
  }

  //traits, similar a una clase abstracta, tambien puede tener miembros abstractos y otros implementados
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    val creatureType: String = "Crocodile"

    def eat: Unit = "grrraa" //implementa eat de la clase Animal
    //implementa eat del trait Carnivore
    def eat(animal: Animal): Unit = println(s"soy un cocodrilo y puedo comerme un ${animal.creatureType}")
  }

  val dog = new Dog //instancia subclase Dog
  val croc = new Crocodile
  //llama al metodo eat de Crocodile que recibe un parametro  Animal, y sobreescribe el metodo eat del trait Carnivore
  croc.eat(dog)

   /*Diferencia entre clase abstracta y trait
    1. traits NO tienen parametros constructores
    2. multiples traits pueden ser heredados por una misma clase (Scala soporta herencia simple de CLASES, pero multiple de traits)
    3. traits son adecuados para representar comportamiento especifico, una clase abstracta representa un TIPO de algo
   * */
}
