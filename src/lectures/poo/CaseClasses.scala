package lectures.poo

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  //1. class parameteres are fields
  val jim = new Person("Jim", 32)
  println(jim.name)

  //2. sensible toString
  println(jim.toString)
  println(jim) //equivalente al anterior para case classes

  //3. equals y hashCode ya implementados
  val tanya = new Person("Tanya", 25)
  println(jim == tanya) //metodo equals ya implementado por defecto

  //4. metodos copy muy utiles
  val jim3 = jim.copy(age = 45) //copia el la instancia de Persona jim en la instancia jim3 y le cambia la edad
  println(jim3)

  //5. Case classes tienen objetos companion
  val thePerson = Person
  //recordar que esto delega al metodo factory apply() que crea la instancia de Person, y viene por defecto en Case class
  val mary = Person("Mary",23)

  //6. Case classes are serializables, muy importantes para el Akka Framework (sistemas distribuidos)

  //7. Case classes tienen extractor pattern, se usan en PATTERN MATCHING

  //case objects son iguales a case classes, pero no tienen companion objects
  case object UnitedKingdom{
    def name: String ="The UK of GB and NI"
  }


}
