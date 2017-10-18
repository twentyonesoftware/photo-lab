package pl.software21.mobilelab


class DeletePhotoTransaction(
        private val id: String,
        private val cart: Cart
) : Transaction {

    override fun execute() {
        cart.remove(id)
    }

}
