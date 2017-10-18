package pl.software21.mobilelab

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class ChangeAllPhotosQuantityTransactionTest {

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
        SelectDefaultQuantityTransaction(5, cart).execute()
        val changedQuantity = 10

        whenever(idGenerator.generate()).thenReturn("id")
        AddPhotoTransaction("uri", cart, idGenerator).execute()
        whenever(idGenerator.generate()).thenReturn("id2")
        AddPhotoTransaction("uri2", cart, idGenerator).execute()

        ChangeAllPhotosQuantityTransaction(changedQuantity, cart).execute()

        assertEquals(changedQuantity, cart.getPhoto("id")?.quantity)
        assertEquals(changedQuantity, cart.getPhoto("id2")?.quantity)
    }

}
