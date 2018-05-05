package week03

import scala.runtime.Nothing$

trait Simulation {
  type Action = () => Unit
  case class Event(time:Int, action: Action)
  private type Agenda = List[Event]
  private var agenda:Agenda = List()
  private var curtime = 0
  def currentTime:Int = curtime


  def afterDelay(delay: Int)(block: => Unit): Unit = {
    val item = Event(currentTime + delay, () => block)
    agenda = insert(agenda, item)
  }

   def insert(ag: List[Event], item: Event): List[Event] = ag match {
    case first :: rest if first.time <= item.time => // '<=' is 'less than or equal to'
      first :: insert(rest, item)
    case _ =>
      item :: ag
  }

  private def loop(): Unit = agenda match {
    case first::rest =>
      agenda = rest
      curtime = first.time
      first.action()
      loop()
    case Nil =>
  }

  def run():Unit = {
    afterDelay(0) {
      println("*** simulation started, time=" + currentTime + "***")
    }
    loop()
  }

  def probe(name:String, wire: Wire):Unit = {
    def probeAction():Unit  = {
      println(s"$name $currentTime value = ${wire.getSignal}")
    }
    wire addAction probeAction
  }

  def inverter(input: Wire, output: Wire): Unit = {
    def invertertAction(): Unit = {
      val inputSig = input.getSignal
      val InverterDelay = 30
      afterDelay(InverterDelay) {
        output setSignal !inputSig
      }
    }

    input addAction invertertAction
  }

  def andGate(in1: Wire, in2: Wire, output: Wire): Unit = {
    def andAction(): Unit = {
      val in1Sig = in1.getSignal
      val in2Sig = in2.getSignal
      val AndGateDelay = 24
      afterDelay(AndGateDelay) {
        output setSignal (in1Sig & in2Sig)
      }
    }

    in1 addAction andAction
    in2 addAction andAction
  }

  def orGate(in1: Wire, in2: Wire, output: Wire): Unit = {
    def orAction(): Unit = {
      val in1Sig = in1.getSignal
      val in2Sig = in2.getSignal
      val OrGateDelay = 42
      afterDelay(OrGateDelay) {
        output setSignal (in1Sig | in2Sig)
      }
    }

    in1 addAction orAction
    in2 addAction orAction
  }

}
