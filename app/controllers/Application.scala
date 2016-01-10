package controllers

import akka.actor.ActorSystem
import akka.util.Timeout
import com.google.inject.Inject
import play.api.mvc._
import scala.concurrent.duration._
import scala.concurrent.{Future, ExecutionContext}

class Application @Inject()(system: ActorSystem)(implicit ec: ExecutionContext) extends Controller {

  implicit val timeout: Timeout = 10 second

  def index = Action {
    Ok("Your new application is ready.")
  }

  def echo = Action { request =>
    Ok(request.body.asText.get)
  }

  def asyncEcho = Action.async { request =>
    Future.successful(request.body.asText.get).map(Ok(_))
  }

  def asyncPolish = Action.async { request =>
    Future.successful("Polished: " + request.body.asText.get).map(Ok(_))
  }

}
