package container

/**
 * Created by xinszhou on 1/10/16.
 */
trait App

trait AppId[T <: App] {

  def apply(dispatcher: Dispatcher) = dispatcher.registerApp(this)

  def createApp(dispatcher: Dispatcher): App

  def lookup(): AppId[_ <: App]

}
