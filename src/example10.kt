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