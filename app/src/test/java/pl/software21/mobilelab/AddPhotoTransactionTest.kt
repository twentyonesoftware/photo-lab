package pl.software21.mobilelab

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class AddPhotoTransactionTest {

    private val format = Format()
    private val paper = Paper()
    private val cart = Cart()
    private val idGenerator: IdGenerator = mock()

    @Before
    fun setUp() {
        SelectDefaultFormatTransaction(format, cart).execute()
        SelectDefaultPaperTransaction(paper, cart).execute()
        whenever(idGenerator.generate()).thenReturn("id")
    }

    @Test
    fun execute() {
        val addPhotoTransaction = AddPhotoTransaction("photoUri", cart, idGenerator)
        addPhotoTransaction.execute()

        assertEquals(1, cart.photos.size)
        assertEquals("id", cart.photos[0].id)
        assertEquals("photoUri", cart.photos[0].uri)
        assertEquals(1, cart.photos[0].quantity)
        assertEquals(format, cart.photos[0].format)
        assertEquals(paper, cart.photos[0].paper)
    }

}
