package pl.software21.mobilelab


class SelectDefaultQuantityTransaction(
        private val quantity: Int,
        private val cart: Cart
) : Transaction {

    override fun execute() {
        cart.selectedQuantity = quantity
    }

}
