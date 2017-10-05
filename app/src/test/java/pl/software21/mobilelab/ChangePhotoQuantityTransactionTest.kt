package pl.software21.mobilelab

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ChangePhotoQuantityTransactionTest {

    private val format = Format()
    private val paper = Paper()
    private val cart = Cart()
    private val idGenerator: IdGenerator = mock()

    @Before
    fun setUp() {
        SelectDefaultFormatTransaction(format, cart).execute()
        SelectDefaultPaperTransaction(paper, cart).execute()
    }

    @Test
    fun execute() {
        SelectDefaultQuantityTransaction(3, cart).execute()

        whenever(idGenerator.generate()).thenReturn("id")
        AddPhotoTransaction("uri", cart, idGenerator).execute()
        whenever(idGenerator.generate()).thenReturn("id2")
        AddPhotoTransaction("uri2", cart, idGenerator).execute()

        ChangePhotoQuantityTransaction("id", 10, cart).execute()

        assertEquals(10, cart.getPhoto("id")?.quantity)
        assertEquals(3, cart.getPhoto("id2")?.quantity)
    }

}
