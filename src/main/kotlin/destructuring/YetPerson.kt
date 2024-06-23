package destructuring

data class Person(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val city: String,
)

fun introducePerson(p: Person) {
    val (firstName, lastName, age, city) = p
    println("This is $firstName, aged $age.")
}

data class Book(
    val title: String,
    val author: String,
    val year: Int,
    val genre: String
)

fun printBookDetails(book: Book) {
    val (title, author, year, genre) = book
    println("Название: $title")
    println("Автор: $author")
    println("Год издания: $year")
    println("Жанр: $genre")
}

fun main() {
    val person = Person(
        firstName = "Foo",
        lastName = "Bar",
        age = 42,
        city = "Omsk"
    )
    val (name, last, age, city) = person
    println("Name: $name, Last: $last, Age: $age, City: $city")
    introducePerson(person)

    val myBook = Book(
        title = "The Great Gatsby",
        author = "F. Scott Fitzgerald",
        year = 1925,
        genre = "Novel"
    )

    val (bookTitle, bookAuthor, bookYear, bookGenre) = myBook


    printBookDetails(myBook)
}
