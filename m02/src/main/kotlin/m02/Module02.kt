package m02

import m01.Module01
import org.kodein.di.inara.Binding
import org.kodein.di.inara.DIModule

class Greeter(val name: String)

/** A partial module: it requires m01's module. */
@DIModule
interface Module02 : @DIModule.Required Module01 {
  val greeter: Greeter
}

fun module02(): Module02Part = Module02Part(greeter = Binding.single { Greeter(name) })
