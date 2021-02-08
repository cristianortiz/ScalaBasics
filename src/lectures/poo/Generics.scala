package lectures.poo

object Generics extends App{
  //clase de tipo generico, A es el tipo del parametro del objeto instanciado
  class MyList[A]{
  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  //metodos genericos, recordar que un objeto no puede ser parametrizado, lo usamos para definir metodos
  object MyList {
    def empty[A]: MyList[A] = ??? //metodo que devuelve un objeto MyList, por ahora no devuelve nada
  }

  val emptyListOfInteger = MyList.empty[Int] //devolveria un objeto MyList, y de tipo Integer

  //Problema de Varianza: si la clase Cat extiende la clase Animal, ¿una Lista de objetos Cat extiende una Lista de objetos Animal???
  class Animal
  class Cat extends Animal
  class Dog extends Animal

/*  la pregunta tiene 3 respuestas posibles
    1. Si, List[Cat] extends List [Animal], es decir puedo sustituir un objeto Animal con un objeto Cat esto
     se llama COVARIANCE (me quedaria una lista de animales que son cats)*/
  class CovariantList[+A]
  val animal : Animal = new Cat
  //puedo reemplazar el tipo Animal del objeto animalList de clase CovariantList con el tipo Cat
  val animalList : CovariantList[Animal] = new CovariantList[Cat]

  /*en dicha lista de objetos Cat, puedo añadir en teoria objetos Animal, pero,
  podria añadir un objeto Dog?-> animalList.add(new Dog) ?? DIFICL PREGUNTA: quedaria MyList[Animal]*/

  /*2. Si se considera List[Cat] y List[Animal] como cosas separadas y no se puede substituir un tipo
  de objeto por otro, este seria el caso de INVARIANCE (una lista de animales solo pueden ser animales sin tipo de subclase especifico)*/
  class InvariantList[A]
  //compilador lanza error si hago la sustitucion de InvariantList[Animal] por InvariantList[Cat]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  /*3. La opcion mas rara: CONTRAVARIANCE, en COVARIANCE podemos substituir una lista de objetos Animal por una lista de
        objetos Cat, porque un Cat es un Animal. PEERO en CONTRAVARIANCE, podemos reemplazad un objeto Cat con un objeto Animal,
        es la relacion inversa de la COVARIANCE, (me queda una lista de Cats que son animales?? muy raro para una LISTA)
  * */
  class ContraVariantList[-A]
  val contravariantList: ContraVariantList[Cat] = new ContraVariantList[Animal]

  /*En este caso CONTRAVARIANCE define que se puede substituir un objeto de tipo Cat por uno de tipo Animal
  porque un Trainer puede entrenar cualquier tipo Animal incluido un tipo Cat, un tipo Dog etc... * */
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  //bounded types, la clase Cage solo acepta como parametro objetos subclase de Animal
  class Cage[A <: Animal](animal:A)
  val cage = new Cage(new Dog) //Dog es subclase de Animal, es un tipo valido para la clase generica Cage

  /*En el caso COVARIANCE la pregunta dificil la resuelve los bounded types, hagamos una clase generica MyList2 con COVARIANCE */
  class MyList2[+A]{
    /*el compilador arroja el error: Covariant type A occurs in Contravariant position in type A
    of value element. porque si la clase es generica COVARIANCE, al substituir un objeto Mylist del tipo de la superclase (Animal)
    por otro Mylist de la subclase(Cat) y luego agrego un MyList de otra subclase(Dog) esa MyList volveria a ser de tipo Animal*/
    //def add(element:A): MyList[A] = ???

  /*  se arregla con el bound type, el metodo add2 aceptara otro parametro B, un objeto de la superclase de A, y devolvera un
    objeto MyList del tipo B que es super clase de A*/
    def add2[B >: A](element: B): MyList[B] = ???

    /* si A = Cat -> MyList[Cat]
          B = Dog -> MyList[Dog] = y como Dog es subclase de Animal
          al mezclar en add2  objetos MyList Cat y Dog esta lista se convierte en MyList[Animal]
    * */


  }
}
