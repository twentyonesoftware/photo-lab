package pl.software21.mobilelab

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ChangePhotoPaperTransactionTest {

    private val format = Format()
    private val paper = Paper()
    private val cart = PhotoCart()
    private val idGenerator: IdGenerator = mock()

    @Before
    fun setUp() {
        SelectDefaultFormatTransaction(format, cart).execute()
        SelectDefaultPaperTransaction(paper, cart).execute()
        whenever(idGenerator.generate()).thenReturn("id")
    }

    @Test
    fun execute() {
        val changedPaper = Paper()

        whenever(idGenerator.generate()).thenReturn("id")
        AddPhotoTransaction("uri", cart, idGenerator).execute()
        whenever(idGenerator.generate()).thenReturn("id2")
        AddPhotoTransaction("uri2", cart, idGenerator).execute()

        ChangePhotoPaperTransaction("id", changedPaper, cart).execute()

        assertEquals(changedPaper, cart.getPhoto("id")?.paper)
        assertEquals(paper, cart.getPhoto("id2")?.paper)
    }

}
