package pl.software21.mobilelab


class ChangePhotoPaperTransaction(
        private val id: String,
        private val paper: Paper,
        private val cart: Cart
) : Transaction {

    override fun execute() {
        val photo = cart.getPhoto(id)
        photo?.paper = paper
    }

}
