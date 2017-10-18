package pl.software21.mobilelab


class ChangeAllPhotosQuantityTransaction(
        private val quantity: Int,
        private val cart: Cart
) : Transaction {

    override fun execute() {
        for (photo in cart.getPhotos()) {
            photo.quantity = quantity
        }
    }
}
