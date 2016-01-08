package wechat

import com.foxinmy.weixin4j.model.Token
import com.foxinmy.weixin4j.mp.WeixinProxy
import com.foxinmy.weixin4j.token.TokenStorager
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import scala.collection.JavaConverters._

/**
 * Created by xinszhou on 1/7/16.
 */
class WechatClientFunctionlityTest extends FunSuite {


  val appid = "wxc9787260b8a11336"
  val secret = "b31a42f9c598de20aba144d09c949cb8"
  val wechatProxy = new WeixinProxy()

  test("get access token") {
    wechatProxy.getCallbackip.asScala.foreach(println)
  }

  test("get user") {
    println("what else to do?")
    println(wechatProxy.getAutoReplySetting)
  }

}
