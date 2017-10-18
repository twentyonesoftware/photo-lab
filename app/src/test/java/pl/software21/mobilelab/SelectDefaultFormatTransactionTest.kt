package pl.software21.mobilelab

import org.junit.Assert.assertEquals
import org.junit.Test

class SelectDefaultFormatTransactionTest {

    @Test
    fun execute() {
        val format = Format()
        val cart = PhotoCart()

        val selectFormatTransaction = SelectDefaultFormatTransaction(format, cart)
        selectFormatTransaction.execute()

        assertEquals(format, cart.format)
    }

}
