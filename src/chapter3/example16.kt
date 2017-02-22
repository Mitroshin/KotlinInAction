package chapter3

class User(
        val id: Int,
        val name: String,
        val address: String)

fun saveUser1(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Cannot save user ${user.id}: Name is empty")
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Cannot save user ${user.id}: Address is empty")
    }

    // Save user to the database
}

fun saveUser2(user: User) {

    fun validate(user: User,
                 value: String,
                 fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Cannot save user ${user.id}: $fieldName is empty")
        }
    }

    validate(user, user.name, "Name")
    validate(user, user.address, "Address")
}

fun saveUser3(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Cannot save user ${user.id}: $fieldName is empty")
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")
}

fun saceUser4(user: User) {
    user.validateBeforeSave()

    // Save user to the database
}

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Cannot save user $id: $fieldName is empty")
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}

fun main(args: Array<String>) {
    saveUser1(User(1, "Dmitry", ""))
    saveUser2(User(2, "", "Moscow"))
}