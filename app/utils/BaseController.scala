package utils

import play.api.Play
import play.api.libs.concurrent.{Execution, Akka}
import play.api.mvc.Controller

/**
 * Created by xinszhou on 1/10/16.
 */
trait BaseController {
  this: Controller =>

  implicit def application = Play.current

  implicit def system = Akka.system

  implicit def __ec = Execution.defaultContext
}
