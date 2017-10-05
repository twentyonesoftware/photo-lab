package pl.software21.mobilelab


class ChangePhotoQuantityTransaction(
        private val id: String,
        private val quantity: Int,
        private val cart: Cart
) : Transaction {

    override fun execute() {
        cart.getPhoto(id)?.quantity = quantity
    }

}
