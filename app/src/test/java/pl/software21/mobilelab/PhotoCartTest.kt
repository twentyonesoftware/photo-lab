package pl.software21.mobilelab

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PhotoCartTest {

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
    fun getPhoto() {
        whenever(idGenerator.generate()).thenReturn("id")
        AddPhotoTransaction("uri", cart, idGenerator).execute()
        whenever(idGenerator.generate()).thenReturn("id2")
        AddPhotoTransaction("uri2", cart, idGenerator).execute()
        
        assertEquals(null, cart.getPhoto("noId"))

        val photo = cart.getPhoto("id")
        assertEquals("id", photo?.id)
        assertEquals("uri", photo?.uri)

        val photo2 = cart.getPhoto("id2")
        assertEquals("id2", photo2?.id)
        assertEquals("uri2", photo2?.uri)
    }

}
