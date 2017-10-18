package pl.software21.mobilelab

import org.junit.Assert.assertEquals
import org.junit.Test

class SelectDefaultQuantityTransactionTest {

    @Test
    fun execute() {
        val cart = PhotoCart()

        val selectQuantityTransaction = SelectDefaultQuantityTransaction(10, cart)
        selectQuantityTransaction.execute()

        assertEquals(10, cart.quantity)
    }

}
