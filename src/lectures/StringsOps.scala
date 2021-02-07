package lectures

object StringsOps extends App {
  val texto: String = "Hello, I am learning Scala"

  println(texto.charAt(2)) //muestra el caracter en la posicion 2 , desde indice 0,1,2
  println(texto.substring(7, 11)) //extrae los caracteres desde el indice 0 al indicado, o entre un rango de caract
  println(texto.split(" ").toList) //extrae trozos del texto usando un caracter o una expresion regular para separarlos
  println(texto.startsWith("Hello")) //devuelve true si el string empieza con los caracteres o patron dados
  println(texto.replace(" ", "-")) //reemplaza los espacios en blanco con "-", tiene muuchas variantes
  println(texto.toLowerCase()) // reemplaza todas las mayusculas por minusculas
  println(texto.length) //tamaño en caracteres del string

  val aNumberString = "233"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') //appending +:, prepending +: operadores especificos de Scala
  println(texto.reverse) //invierte la posicion de los caracteres y las palabras de un string
  println(texto.take(6)) //extrae los n primeros caracteres indicados

  /*Manipulacion de String especificos de Scala : String interpolators
   S-interpolator  */
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and i am $age year old" // s" permite incluir directamente una expresion en Scala en el texto, similar a PHP
  val anotherGreeting = s"Hello, my name is $name and next year i will be turning ${age + 1} years old"
  println(greeting)
  println(anotherGreeting)

  //F-interpolator
  val speed = 1.2f
  /*string formateados al estilo de printf, precision decimal  %2.2f dos caracteres en total y maximo dos decimales luego de la coma
  * el interpolador f% verifica que el tipo del formato corresponda con el del value, */
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  //RAW-interpolator
  println(raw"This is a \n new line") //raw escapa los caracteres especiales y los imprime como texto en textos puros
  val escaped = "This is a \n new line"
  println(raw"$escaped") //no funciona si se hace en textos inyected con el operador $

}
