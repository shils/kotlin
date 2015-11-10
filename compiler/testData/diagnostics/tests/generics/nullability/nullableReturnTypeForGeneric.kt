// !DIAGNOSTICS: -UNUSED_PARAMETER
// KT-9893 Incorrect nullability after cast with star projection

open class A

class B<T>

public interface I<T : A> {
    public fun foo(): T?
    public val bar: T?
    public fun baz(): B<T>?
}

fun acceptA(a: A) {
}

fun acceptB(b: B<*>) {
}

fun main(i: I<*>) {
    acceptA(<!TYPE_MISMATCH!>i.foo()<!>)
    acceptA(<!TYPE_MISMATCH!>i.bar<!>)
    acceptB(<!TYPE_MISMATCH!>i.baz()<!>)
}