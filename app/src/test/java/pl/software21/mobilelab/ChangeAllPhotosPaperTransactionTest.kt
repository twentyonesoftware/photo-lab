package pl.software21.mobilelab

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class ChangeAllPhotosPaperTransactionTest {

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
        val changedPaper = Paper()

        whenever(idGenerator.generate()).thenReturn("id")
        AddPhotoTransaction("uri", cart, idGenerator).execute()
        whenever(idGenerator.generate()).thenReturn("id2")
        AddPhotoTransaction("uri2", cart, idGenerator).execute()

        ChangeAllPhotosPaperTransaction(changedPaper, cart).execute()

        assertEquals(changedPaper, cart.getPhoto("id")?.paper)
        assertEquals(changedPaper, cart.getPhoto("id2")?.paper)
    }

}
