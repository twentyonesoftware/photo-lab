package pl.software21.mobilelab


class ChangePhotoQuantityTransaction(
        private val id: String,
        private val quantity: Int,
        private val cart: PhotoCart
) : Transaction {

    override fun execute() {
        cart.getPhoto(id)?.quantity = quantity
    }
}
