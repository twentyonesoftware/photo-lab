package pl.software21.mobilelab

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class DeletePhotoTransactionTest {

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
        AddPhotoTransaction("photoUri", cart, idGenerator).execute()
        assertEquals(1, cart.photos.size)

        DeletePhotoTransaction("id", cart).execute()
        assertEquals(0, cart.photos.size)
    }

}
