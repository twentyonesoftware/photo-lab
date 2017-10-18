package pl.software21.mobilelab

class CartPresenter(
        private val view: CartView,
        private val cart: Cart,
        private val transactionFactory: CartTransactionFactory
) {

    fun start() {
        view.setCart(cart)
    }

    fun onAddPhoto(uri: String) {
        transactionFactory.getAddPhotoTransaction(uri).execute()
        view.refresh()
    }

    fun onDeletePhoto(id: String) {
        transactionFactory.getDeletePhotoTransaction(id).execute()
        view.refresh()
    }

    fun onChangePhotosFormat(format: Format) {
        transactionFactory.getChangeAllPhotosFormatTransaction(format).execute()
        transactionFactory.getSelectDefaultFormatTransaction(format).execute()
        view.refresh()
    }

    fun onChangePhotosPaper(paper: Paper) {
        transactionFactory.getChangeAllPhotosPaperTransaction(paper).execute()
        transactionFactory.getSelectDefaultPaperTransaction(paper).execute()
        view.refresh()
    }

    fun onChangePhotosQuantity(quantity: Int) {
        transactionFactory.getChangeAllPhotosQuantityTransaction(quantity).execute()
        transactionFactory.getSelectDefaultQuantityTransaction(quantity).execute()
        view.refresh()
    }
}
