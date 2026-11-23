package m02

import m01.Module01
import m01.module01
import org.kodein.di.inara.Binding
import org.kodein.di.inara.DIModule

/** A valid partial module, as an application's own module would be. */
@DIModule
interface AppPartModule : @DIModule.Required Module01 {
  val greeting: String
}

fun appPartModule(): AppPartModulePart = AppPartModulePart(greeting = Binding.single { "hello from $name" })

// The error: Module02 requires Module01, but no parent of TestModule02 provides it.
// Correct is `interface TestModule02 : Module01, Module02, AppPartModule`.
@DIModule(composed = true)
interface TestModule02 : Module02, AppPartModule

val testModule02: TestModule02 =
  TestModule02(module01 = module01(), module02 = module02(), appPartModule = appPartModule())
