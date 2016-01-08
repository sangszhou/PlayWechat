package msgHandler

/**
 * Created by xinszhou on 1/7/16.
 */
trait OrdinaryMsgHandler {

  def onTextMessage
  def onImageMessage
  def onVoiceMessage
  def onVideoMessage
  def onGeoLocationMessage
  def onLinkMessage
}
