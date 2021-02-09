package lectures.poo

object Objects extends {

  /*SCALA NO TIENE CLASS-LEVEL FUCNIONALITY ("static")
  Este es un objeto SINGLETON, solo existe UNA instancia posible, es decir todas las instancias de este objeto son IGUALES*/
  object Person { //type + is solo la instancia
    val N_EYES = 2

    def canFly: Boolean = false //definicion valida de un metodo de un objeto Person

    //metodo factory: su objetivo es crear un objeto de la CLASE Person, en base a ciertos parametros
    def apply(mother:Person,father:Person): Person = new Person("Bobbie")
  }

  /*se puede definir una clase del mismo nombre que el objeto singleton, para separar funcionalidad instance level
  de static level funcionality "static/class"   declarar un objeto singleton y una clase del mismo nombre con el mismo
  SCOPE se llama COMPANION, pudiendo acceder indistamente a sus miembros (atributos/metodos) privados*/
  class Person(val name: String) {

  }
/*---------------------------------------------------------------------------------------------------------
  println(Person.N_EYES)
  println(Person.canFly)

  //objetos en Scala son instancias Singleton por definicion
  val mary = Person //instancia del objeto Person
  val jon = Person //instancia del objeto Person

  //objetos instanciados de la CLASE Person,
  val jeny = new Person("jeny")
  val juan = new Person("juan")

  //si los comparamos, vemos que son iguales porque ambos son instancias del OBJETO SINGLETON Person
  println(mary == jon)

  println(jeny == juan) //no son iguales, son distintas instancias de la CLASE Person

  //objeto Person creado a partir del metodo factory apply, que por notacion se puede obviar
  val bobbie = Person(jeny,juan)
  val bobbie2 = Person.apply(jeny,juan)//equivalente al anterior

  /*Scala applications = Scala object con un metodo main que recibe un array de strings
    def main(args: Array[String]): Unit probemoslo metiendo el codigo anterior dentro de esta funcion y sacamos el extends App
    ------------------------------------------------------------------------------------------------------------------------*/*/

  def main(args: Array[String]): Unit = {

    println(Person.N_EYES)
    println(Person.canFly)

    //objetos en Scala son instancias Singleton por definicion
    val mary = Person //instancia del objeto Person
    val jon = Person //instancia del objeto Person

    //objetos instanciados de la CLASE Person,
    val jeny = new Person("jeny")
    val juan = new Person("juan")

    //si los comparamos, vemos que son iguales porque ambos son instancias del OBJETO SINGLETON Person
    println(mary == jon)

    println(jeny == juan) //no son iguales, son distintas instancias de la CLASE Person

    //objeto Person creado a partir del metodo factory apply, que por notacion se puede obviar
    val bobbie = Person(jeny,juan)
    val bobbie2 = Person.apply(jeny,juan)//equivalente al anterior
  }

}
