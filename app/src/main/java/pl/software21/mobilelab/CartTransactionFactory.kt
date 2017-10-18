package pl.software21.mobilelab


interface CartTransactionFactory {

    fun getAddPhotoTransaction(id: String, uri: String): Transaction

    fun getDeletePhotoTransaction(id: String): Transaction

    fun getChangePhotoFormatTransaction(id: String, format: Format): Transaction

    fun getChangePhotoPaperTransaction(id: String, paper: Paper): Transaction

    fun getChangePhotoQuantityTransaction(id: String, quantity: Int): Transaction

    fun getChangeAllPhotosFormatTransaction(format: Format): Transaction

    fun getChangeAllPhotosPaperTransaction(paper: Paper): Transaction

    fun getChangeAllPhotosQuantityTransaction(quantity: Int): Transaction

    fun getSelectDefaultFormatTransaction(format: Format): Transaction

    fun getSelectDefaultPaperTransaction(paper: Paper): Transaction

    fun getSelectDefaultQuantityTransaction(quantity: Int): Transaction
}
