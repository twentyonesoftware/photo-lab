package pl.software21.mobilelab


abstract class Cart {

    lateinit var format: Format
    lateinit var paper: Paper
    var quantity = 1

    abstract fun addPhoto(photo: Photo)

    abstract fun remove(id: String)

    abstract fun getPhoto(id: String): Photo?

    abstract fun getPhotos(): List<Photo>
}
