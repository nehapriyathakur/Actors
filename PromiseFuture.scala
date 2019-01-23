package Promise
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
object PromiseFuture extends App {
  val f = Future { 1 }
  val p = Promise[Int]()

  p completeWith f

  p.future foreach { x =>
    println(x)
  }

  val f1 = Future{2}

  p completeWith f1

  p.future foreach { x =>
    println(x)
  }
  Thread.sleep(10000)
}
