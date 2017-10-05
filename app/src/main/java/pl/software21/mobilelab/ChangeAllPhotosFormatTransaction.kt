package pl.software21.mobilelab


class ChangeAllPhotosFormatTransaction(
        private val format: Format,
        private val cart: Cart
) : Transaction {

    override fun execute() {
        for (photo in cart.photos) {
            photo.format = format
        }
    }

}
