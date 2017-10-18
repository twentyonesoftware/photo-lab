package pl.software21.mobilelab

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class AddPhotoTransactionTest {

    private val format = Format()
    private val paper = Paper()
    private val cart = PhotoCart()
    private val idGenerator: IdGenerator = mock()

    @Before
    fun setUp() {
        SelectDefaultFormatTransaction(format, cart).execute()
        SelectDefaultPaperTransaction(paper, cart).execute()
    }

    @Test
    fun execute() {
        whenever(idGenerator.generate()).thenReturn("id")

        val addPhotoTransaction = AddPhotoTransaction("photoUri", cart, idGenerator)
        addPhotoTransaction.execute()

        assertEquals(1, cart.getPhotos().size)

        val photo = cart.getPhoto("id")

        assertEquals("id", photo?.id)
        assertEquals("photoUri", photo?.uri)
        assertEquals(1, photo?.quantity)
        assertEquals(format, photo?.format)
        assertEquals(paper, photo?.paper)
    }

}
