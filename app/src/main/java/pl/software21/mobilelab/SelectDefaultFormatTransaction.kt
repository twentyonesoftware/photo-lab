package pl.software21.mobilelab


class SelectDefaultFormatTransaction(
        private val format: Format,
        private val cart: PhotoCart
) : Transaction {

    override fun execute() {
        cart.format = format
    }
}
