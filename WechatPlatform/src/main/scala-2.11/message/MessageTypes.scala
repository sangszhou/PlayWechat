package message

/**
 * Created by xinszhou on 1/10/16.
 */
class MessageType(val name: String) {
  override def toString: String = name

  def isText = this == MessageTypes.Text
}

object MessageTypes {

  case object Event extends MessageType("event")

  case object ShortVideo extends MessageType("shortvideo")

  case object Video extends MessageType("video")

  case object Voice extends MessageType("voice")

  case object Text extends MessageType("text")

  case object Image extends MessageType("image")

  case object Music extends MessageType("music")

  case object News extends MessageType("news")

  def apply(v: String): MessageType = v match {
    case Event.name => Event
    case ShortVideo.name => ShortVideo
    case Video.name => Video
    case Voice.name => Voice
    case Text.name => Text
    case Image.name => Image
    case Music.name => Music
    case News.name => News
  }

}
