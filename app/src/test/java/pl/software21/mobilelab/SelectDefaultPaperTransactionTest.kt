package pl.software21.mobilelab

import org.junit.Assert.assertEquals
import org.junit.Test

class SelectDefaultPaperTransactionTest {

    @Test
    fun execute() {
        val paper = Paper()
        val cart = PhotoCart()

        val selectPaperTransaction = SelectDefaultPaperTransaction(paper, cart)
        selectPaperTransaction.execute()

        assertEquals(paper, cart.paper)
    }

}
