package pl.software21.mobilelab


class SelectDefaultQuantityTransaction(
        private val quantity: Int,
        private val cart: PhotoCart
) : Transaction {

    override fun execute() {
        cart.quantity = quantity
    }
}
