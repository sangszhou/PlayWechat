package utils

import scala.xml.Node

/**
 * Created by xinszhou on 1/10/16.
 */
object StructuredDataUtil {

  def text(node: Node, label: String): String = (node \ label).text

}
