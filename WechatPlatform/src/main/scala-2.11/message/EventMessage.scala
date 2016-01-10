package message

import utils.StructuredDataUtil._
import scala.xml.Node

/**
 * Created by xinszhou on 1/10/16.
 */
class EventMessage(override val node: Node) extends BaseMessage(node) {

  val event = EventTypes(text(node, "Event"))

  lazy val eventKey = text(node, "EventKey")
  lazy val ticket = text(node, "Ticket")
  lazy val latitude = text(node, "Latitude")
  lazy val longitude = text(node, "Longitude")
  lazy val precision = text(node, "Precision")

}
