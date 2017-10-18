package pl.software21.mobilelab

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ChangePhotoFormatTransactionTest {

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
        val changedFormat = Format()

        whenever(idGenerator.generate()).thenReturn("id")
        AddPhotoTransaction("uri", cart, idGenerator).execute()
        whenever(idGenerator.generate()).thenReturn("id2")
        AddPhotoTransaction("uri2", cart, idGenerator).execute()

        ChangePhotoFormatTransaction("id", changedFormat, cart).execute()

        assertEquals(changedFormat, cart.getPhoto("id")?.format)
        assertEquals(format, cart.getPhoto("id2")?.format)
    }

}
