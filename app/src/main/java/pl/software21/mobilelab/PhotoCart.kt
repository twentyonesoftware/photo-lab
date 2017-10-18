package pl.software21.mobilelab


class PhotoCart: Cart() {

    private val photos: MutableMap<String, Photo> = mutableMapOf()

    override fun addPhoto(photo: Photo) {
        photos.put(photo.id, photo)
    }

    override fun remove(id: String) {
        photos.remove(id)
    }

    override fun getPhoto(id: String): Photo? = photos[id]

    override fun getPhotos(): List<Photo> = photos.values.toList()
}
