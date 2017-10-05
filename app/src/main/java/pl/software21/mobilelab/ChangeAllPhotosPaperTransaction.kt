package pl.software21.mobilelab


class ChangeAllPhotosPaperTransaction(
        private val paper: Paper,
        private val cart: Cart
) : Transaction {

    override fun execute() {
        for (photo in cart.photos) {
            photo.paper = paper
        }
    }

}
