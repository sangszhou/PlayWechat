package message


import scala.xml.{XML, Node}
import utils.StructuredDataUtil._
/**
 * Created by xinszhou on 1/10/16.
 */
class OrdinaryMessage(override val node: Node) extends BaseMessage(node) {
  lazy val msgId = text(node, "MsgId").toLong
  lazy val content = text(node, "Content")

  def contentOption = if (msgType.isText) Some(content) else None

  lazy val mediaId = text(node, "MediaId")
  lazy val picUrl = text(node, "PicUrl")
  lazy val format = text(node, "Format")
  lazy val thumbMediaId = text(node, "ThumbMediaId")
  lazy val recongnition = text(node, "Recongnition")
  lazy val locationX = text(node, "Location_X")
  lazy val locationY = text(node, "Location_Y")
  lazy val scale = text(node, "Scale").toInt
  lazy val title = text(node, "Title")
  lazy val label = text(node, "Label")
  lazy val description = text(node, "Description")
  lazy val url = text(node, "Url")

}

object OrdinaryMessage {
  def msgType(node: Node) = MessageTypes(text(node, "MsgType"))
  def apply(v: String) = new OrdinaryMessage(XML.loadString(v))
}
