package container

/**
 * Created by xinszhou on 1/9/16.
 */
trait Dispatcher {

  def registerApp[T <: App](appId: AppId[T])

  def lookUpApp

  def hasApp()

  def dispatch

}
