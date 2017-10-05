package pl.software21.mobilelab


class ChangePhotoPaperTransaction(
        private val id: String,
        private val paper: Paper,
        private val cart: Cart
) : Transaction {

    override fun execute() {
        cart.getPhoto(id)?.paper = paper
    }

}
