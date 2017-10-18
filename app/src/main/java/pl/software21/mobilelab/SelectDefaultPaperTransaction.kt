package pl.software21.mobilelab


class SelectDefaultPaperTransaction(
        private val paper: Paper,
        private val cart: Cart
) : Transaction {

    override fun execute() {
        cart.paper = paper
    }
}
