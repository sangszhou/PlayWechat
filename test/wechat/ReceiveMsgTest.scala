package wechat

import com.foxinmy.weixin4j.model.Token
import com.foxinmy.weixin4j.mp.WeixinProxy
import com.foxinmy.weixin4j.token.TokenStorager
import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import play.api.i18n.DefaultMessagesApi
import scala.collection.JavaConverters._

/**
 * Created by xinszhou on 1/7/16.
 */
@RunWith(classOf[JUnitRunner])
class ReceiveMsgTest extends Specification {

  class SelfTokenProvider extends TokenStorager {
    override def lookup(cacheKey: String): Token =
      new Token("Kegm78RU92PnDCyRc3hbeNeG3P1JCZ9LSplhEtByOgLNJUQRd3fR-OuXzrvhKS9B_4qDlK1eIQoQFCE9rQMPq66gOYyskhYxEqt1CFDmxwgMPTjAHAUXB")

    override def caching(cacheKey: String, t: Token): Unit = {}
  }

  "Application" should {

//    "println" in {
//      1 must equalTo(1)
//    }

    "get access token" in {
      val appid = "wxc9787260b8a11336"
      val secret = "b31a42f9c598de20aba144d09c949cb8"

      val wechatProxy = new WeixinProxy(appid, secret, new SelfTokenProvider)

      wechatProxy.getAllFollowing.asScala.foreach(println)
      1 must equalTo(1)



//      val new IMessageHandler/
    }

  }


//  "wechat should works properly" should {
//    "in" in {
//      val appid = ""
//      val secret = ""
//
//      val wechatProxy = new WeixinProxy(appid, secret)
//    }
//  }

}
