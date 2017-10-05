package pl.software21.mobilelab


data class Photo(
        val id: String,
        val uri: String,
        var quantity: Int,
        var format: Format,
        var paper: Paper
)
