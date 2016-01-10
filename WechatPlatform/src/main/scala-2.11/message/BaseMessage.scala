package message

import scala.xml.Node
import utils.StructuredDataUtil._
/**
 * Created by xinszhou on 1/7/16.
 */
abstract class BaseMessage(val node: Node) {

  val toUserName = text(node, "ToUserName")
  val fromUserName = text(node, "FromUserName")
  val createTime = text(node, "CreateTime")

  val msgType = OrdinaryMessage.msgType(node)

}
