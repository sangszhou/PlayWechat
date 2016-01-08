package msgHandler

/**
 * Created by xinszhou on 1/7/16.
 */
trait EventMsgHandler {

  def onSubscribeEvent
  def onUnsubscribeEvent
  def onQrsceneEvent
  def onViewEvent
}
