package controllers

import message.{EventTypes, MessageTypes, OrdinaryMessage}
import output.TextOutputMessage
import play.api.mvc.{Action, Controller}
import utils.BaseController

import scala.concurrent.Future
import scala.xml.Elem

/**
 * Created by xinszhou on 1/10/16.
 */
class WechatController extends Controller with BaseController {

  def post = Action.async(parse.tolerantText) { request =>

//    val timestamp = request.getQueryString("timestamp").get
//    val nonce = request.getQueryString("nonce").get
//    val encryptType = request.getQueryString("encrypt_type")
//    val msgSignature = request.getQueryString("msg_signature")

    def getBody = if (false) {
      println("aes encrption has not been enabled yet")
      Future.successful("aes encrption has not been enabled yet")
    } else {
      Future.successful(request.body)
    }

    def responseContent(node: Elem): Future[String] = OrdinaryMessage.msgType(node) match {

      case MessageTypes.Event => // event
        Future.successful("event won't be handled")

      case MessageTypes.Text =>
        val output = new TextOutputMessage("content empty")
        output.setCreateTime(13L)
        output.setFromUserName("xinszhou")
        output.setToUserName("周新生")

        Future.successful(output.toXML)

      case _ => // message
        Future.successful("message type cannot be recognized")
    }

    for {
      body <- getBody
      resp <- responseContent(scala.xml.XML.loadString(body))
    } yield {
      Ok(resp).withHeaders("Content-Type" -> "application/xml; charset=UTF-8")
    }

  }
}
