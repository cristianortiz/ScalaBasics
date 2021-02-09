package lectures.poo

object AnonymousClasses extends App {
  abstract class Animal{ //clase abstracta de la cual generalmente se sobreescriben sus metodos
    def eat: Unit
  }
  //clase anonima
  val funnyAnimal: Animal = new Animal {
      override def eat: Unit = println("ahahahahah")
  }
  /* el compilador crea una clase anonima funnyAnimal al sobreescribir el metodo eat de la clase Animal
   y dentro de ella sobreescribe el metodo eat:
  class AnonynousClasses$$anon1 extends Animal {
    override def eat: Unit = println("ahahahahah")
  }
  el bloque anterior es equivalente a:
  val funnyAnimal: Animal = new AnonynousClasses$$anon1
  * */
  println(funnyAnimal.getClass)//aqui vemos el nombre dela clase anonima que el compilador crea

  //las clases anonimas se pueden usar en clases normales tambien ademas de las abstractas
  class Person (name: String){
    def sayHi: Unit = println(s"Hi, my name is $name, how can i help you")
  }
 /* siempre seguir los siquientes pasos con las clases anonimas
    1.pasar los parametros requeridos por la super clase si es necesario, (aqui es name), para que se cree la clase anonima
    2. implementar todos los metodos/campos de la super clase */
  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi, my name is jim, how can i help you")
  }

  /* 1. implementacion generica de un trait (interfaz) llamado MyPredicate[-T] que tiene un metodo test(T) => Boolean
     2. trait generico MyTransformer[-A,B] con el metodo transform(A) => B
     3. MyListGeneric:
        -map(transformer) => MyListGeneric
        -filter(predicate) => MyListGeneric
        -flatMap(transformer from A to MylistGeneric[B] => MyListGeneric[B]

        class EvenPredicate extends MyPredicate[Int]
        class StringToIntTransformer extends MyTransformer[String, int]
        -deberia funcionar asi
        [1,2,3].map(n*2) = [2,4,6]
        [1,2,3,4].filter(n % 2) = [2,4]
        [1,2,3].flatMap(n =>[n,n+1]) => [1,2,2,3,3,4]


  * */

}

