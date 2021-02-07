package lectures

object DefaultArgs extends App {
  /* pasar valores por defecto a una funcion, asi el segundo parametro se vuelve opcional
  pero tambien se puede especificar si se desea sobreescribiendo el parametro por defecto
  */
  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n - 1, n * acc)

  /* segun el orden de los parametros por defecto el compilador mostrara error  al usar otro valor, se soluciona
  * 1. pasar el primer argumento
  * 2. especificar el parametro a sobreecribir ademas de su valor
  *  */
  def savePicture(format: String = "jpg", width: Int = 800, height: Int = 1080): Unit = println("saving picture " + format + " " + height + "x" + width)

  savePicture("bmp") //aqui se llama al primer valor en el estilo savePicture(format="bpm")
  savePicture(height = 720, format = "png") //hasta se pueden nombrar los parametros en distinto orden


}
