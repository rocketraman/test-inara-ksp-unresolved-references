package m01

import org.kodein.di.inara.Binding
import org.kodein.di.inara.DIModule

@DIModule
interface Module01 {
  val name: String
}

fun module01(): Module01 = Module01(name = Binding.value("m01"))
