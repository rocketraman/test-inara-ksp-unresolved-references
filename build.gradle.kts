plugins {
  kotlin("jvm") version "2.4.21" apply false
  id("com.google.devtools.ksp") version "2.3.13" apply false
}

subprojects {
  apply(plugin = "org.jetbrains.kotlin.jvm")
  apply(plugin = "com.google.devtools.ksp")

  dependencies {
    "implementation"("org.kodein.di.inara:inara-runtime:0.3.0")
    "ksp"("org.kodein.di.inara:inara-processor:0.3.0")
    "kspTest"("org.kodein.di.inara:inara-processor:0.3.0")
  }

  // the test sources only declare a module; there are no tests to run
  tasks.withType<Test>().configureEach { failOnNoDiscoveredTests = false }
}

// m02's module requires m01's
project(":m02") {
  dependencies { "implementation"(project(":m01")) }
}
