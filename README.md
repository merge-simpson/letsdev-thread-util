# Download

Gradle(Kotlin):  
`build.gradle.kts`에서 다음 두 라인을 추가합니다.

```kotlin
repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") } // added (1)
}

dependencies {
    implementation("com.github.merge-simpson:letsdev-thread-util:0.1.0") // added (2)
}
```

# Features (ThreadUtils)

- 함수의 호출 스택(call-stack)을 문자열로 받아 오는 함수
  `callStack()`: `String`
- 함수의 호출 스택(call-stack)을 출력하는 함수
  - `printCallStack()`: `void`
  - `printCallStack(PrintStream source)`: `void`
  - `printCallStack(PrintWriter source) `: `void`