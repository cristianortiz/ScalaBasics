package lectures.poo

import lectures.poo.Objects.Person

object Inheritance extends App {

  //Scala provee herencia de clases simple, SuperClase Animal (clase sin paremetros)
  class Animal {
    //miembro de la clase Animal
    val creatureType = "wild"
    //eat es un metodo publico
    def eat = println("este animal come comida")

    //drink es privado, solo se puede accder desde el interior de la clase Animal
    private def drink = println("este animal toma agua")

    //sleep es protectec, solo se puede acceder desde la clase Animal y sus subclases
    protected def sleep = println("este animal solo duerme")
  }

  //subclase Cat (super clase Animal SIN parametros
  class Cat extends Animal {
    def bostezo = {
      super.sleep //llamada super al metodo sleep de la superclase Animal
    }
  }

  val cat = new Cat
  cat.eat //puedo acceder asi porque el metodo eat de la superclase Animal es publico
  cat.bostezo //accedo al metodo sleep (protected) de la superclase Animal solo a traves del metodo publico de la subclase Cat bostezo
  /* no puedo acceder al metodo private drink protected de la superclase animal
   cat.drink
   cat.sleep
   -------------------------------------------------------------------------------------------------------------------------------------------*/

  //constructores
  class Person(name: String, age: Int){
  }
 //para extender una clase CON parametros se deben indicar los parametros de la super clase luego del extends
  class Adult(name: String, age: Int, idCard: String) extends Person(name,age)

  //sobreescritura de metodos
  class Dog(override val creatureType:String) extends Animal{
    //sobreesctura con palabra clave override
    override def eat = println("Este animal es un perro y come comida de perro")

    /*//sobreescritura tambien aplica sobre val, aqui sobreescribo el miembro creatureType, tambien un parametro
    // de la subclaseclase puede sobreescribir el miembro de la superclase*/
    //override val creatureType = "domestic"

  }
  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  //type substituction (polimorfismo) como unknownAnimal instancia un objeto Dog, se usa la version sobreescrita por Dog del metodo eat
  val unknownAnimal: Animal = new Dog("perroVerde")
  unknownAnimal.eat

  //diferencia entre SOBRECARGA y SOBREESCRITURA de metodos

  /*formas prevenir la sobreescritura de metodos de una superclase
  1. use final en los miembros de la clase
  2. usar final en toda la clase en su definicion (final class), la clase String o Int, son clases final, clase no extendible
  3. seal the class (sealed class) = permite extender una clase solo en un mismo ARCHIVO, y previene la extension desde otros archivos
     se usa seal para limitar los tipos de objetos a instanciar
  * */

}
