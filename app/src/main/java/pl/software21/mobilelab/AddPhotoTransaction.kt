package pl.software21.mobilelab


class AddPhotoTransaction(
        private val uri: String,
        private val cart: Cart,
        private val idGenerator: IdGenerator
) : Transaction {

    override fun execute() {
        val photo = Photo(idGenerator.generate(), uri, cart.quantity, cart.format, cart.paper)
        cart.addPhoto(photo)
    }

}
