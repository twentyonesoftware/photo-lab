package pl.software21.mobilelab


class ChangePhotoFormatTransaction(
        private val id: String,
        private val format: Format,
        private val cart: Cart
) : Transaction {

    override fun execute() {
        cart.getPhoto(id)?.format = format
    }
}
