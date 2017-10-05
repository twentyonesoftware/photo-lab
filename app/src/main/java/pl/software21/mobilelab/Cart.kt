package pl.software21.mobilelab


class Cart {

    val photos = ArrayList<Photo>()
    var selectedQuantity = 1
    lateinit var selectedFormat: Format
    lateinit var selectedPaper: Paper

    fun addPhoto(id: String, uri: String) {
        photos.add(Photo(id, uri, selectedQuantity, selectedFormat, selectedPaper))
    }

    fun removePhoto(id: String) {
        photos
                .filter { it.id == id }
                .forEach { photos.remove(it) }
    }

    fun getPhoto(id: String): Photo? {
        photos
                .filter { it.id == id }
                .forEach { return it }

        return null
    }

}
