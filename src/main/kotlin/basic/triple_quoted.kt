package basic

import org.intellij.lang.annotations.Language

val kotlinLogo =
    """
 | //
 |//
 |/ \
 """.trimIndent()

@Language("HTML")
val expectedPage = """
 <html lang="en">
 <head>
 <title>A page</title>
 </head>
 <body>
 <p>Hello, Kotlin!</p>
 </body>
 </html>
""".trimIndent()

@Language("JSON")
val expectedObject = """
 {
 "name": "Sebastian",
 "age": 27,
 "homeTown": "Munich"
 }
""".trimIndent()

fun main() {
    println(kotlinLogo)
    println(expectedPage)
    println(expectedObject)
}