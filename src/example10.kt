interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

fun eval1(e: Expr): Int {
    if (e is Num) {
//        val n = e  as Num
//        return n.value
        return e.value
    }

    if (e is Sum) {
        return eval1(e.left) + eval1(e.right)
    }

    throw IllegalArgumentException("Unknown expression")
}

fun eval2(e: Expr): Int =
        if (e is Num) {
            e.value
        } else if (e is Sum) {
            eval2(e.left) + eval2(e.right)
        } else {
            throw IllegalArgumentException("Unknown expression")
        }

fun eval3(e: Expr): Int = when(e) {
    is Num -> e.value
    is Sum -> eval3(e.left) + eval3(e.right)

    else -> throw IllegalArgumentException("Unknown expression")
}