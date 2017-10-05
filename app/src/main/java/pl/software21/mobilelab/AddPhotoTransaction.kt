package pl.software21.mobilelab


class AddPhotoTransaction(
        private val uri: String,
        private val cart: Cart,
        private val idGenerator: IdGenerator
) : Transaction {

    override fun execute() {
        cart.addPhoto(idGenerator.generate(), uri)
    }

}
