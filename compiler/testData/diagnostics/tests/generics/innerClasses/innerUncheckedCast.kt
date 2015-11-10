// !CHECK_TYPE

class Outer<E> {
    inner open class InnerBase
    inner class Inner : InnerBase() {
        val prop: E = null!!
    }

    fun foo(x: InnerBase, y: Any?, z: Outer<*>.InnerBase) {
        if (x is Inner) {
            <!DEBUG_INFO_SMARTCAST!>x<!>.prop.checkType { _<E>() }
        }

        if (y is <!NO_TYPE_ARGUMENTS_ON_RHS!>Inner<!>) return

        if (z is Inner) {
            <!DEBUG_INFO_SMARTCAST!>z<!>.prop.checkType { _<Any?>() }
            return
        }

        if (y is Outer<*>.Inner) {
            <!DEBUG_INFO_SMARTCAST!>y<!>.prop.checkType { _<Any?>() }
        }
    }

    fun bar(x: InnerBase, y: Any?, z: Outer<*>.InnerBase) {
        x as Inner
        y as <!NO_TYPE_ARGUMENTS_ON_RHS!>Inner<!>
        z as Inner

        y is Outer<*>.Inner
    }
}
