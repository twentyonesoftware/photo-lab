package pl.software21.mobilelab

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before

import org.junit.Test

class CartPresenterTest {

    private val view: CartView = mock()
    private val cart: Cart = mock()
    private val transactionFactory: CartTransactionFactory = mock()

    private lateinit var presenter: CartPresenter

    @Before
    fun setUp() {
        presenter = CartPresenter(view, cart, transactionFactory)
    }

    @Test
    fun start() {
        presenter.start()

        verify(view).setCart(cart)
    }

    @Test
    fun onAddPhoto() {
        val transaction: Transaction = mock()
        whenever(transactionFactory.getAddPhotoTransaction("uri")).thenReturn(transaction)

        presenter.onAddPhoto("uri")

        verify(transaction).execute()
        verify(view).refresh()
    }

    @Test
    fun onDeletePhoto() {
        val transaction: Transaction = mock()
        whenever(transactionFactory.getDeletePhotoTransaction("id")).thenReturn(transaction)

        presenter.onDeletePhoto("id")

        verify(transaction).execute()
        verify(view).refresh()
    }

    @Test
    fun onChangePhotosFormat() {
        val format = Format()
        val changeAllPhotosFormatTransaction: Transaction = mock()
        val selectDefaultFormatTransaction: Transaction = mock()

        whenever(transactionFactory.getChangeAllPhotosFormatTransaction(format)).thenReturn(changeAllPhotosFormatTransaction)
        whenever(transactionFactory.getSelectDefaultFormatTransaction(format)).thenReturn(selectDefaultFormatTransaction)

        presenter.onChangePhotosFormat(format)

        verify(changeAllPhotosFormatTransaction).execute()
        verify(selectDefaultFormatTransaction).execute()
        verify(view).refresh()
    }

    @Test
    fun onChangePhotosPaper() {
        val paper = Paper()
        val changeAllPhotosPaperTransaction: Transaction = mock()
        val selectDefaultPaperTransaction: Transaction = mock()

        whenever(transactionFactory.getChangeAllPhotosPaperTransaction(paper)).thenReturn(changeAllPhotosPaperTransaction)
        whenever(transactionFactory.getSelectDefaultPaperTransaction(paper)).thenReturn(selectDefaultPaperTransaction)

        presenter.onChangePhotosPaper(paper)

        verify(changeAllPhotosPaperTransaction).execute()
        verify(selectDefaultPaperTransaction).execute()
        verify(view).refresh()
    }

    @Test
    fun onChangePhotosQuantity() {
        val quantity = 10
        val changeAllPhotosQuantityTransaction: Transaction = mock()
        val selectDefaultQuantityTransaction: Transaction = mock()

        whenever(transactionFactory.getChangeAllPhotosQuantityTransaction(quantity)).thenReturn(changeAllPhotosQuantityTransaction)
        whenever(transactionFactory.getSelectDefaultQuantityTransaction(quantity)).thenReturn(selectDefaultQuantityTransaction)

        presenter.onChangePhotosQuantity(quantity)

        verify(changeAllPhotosQuantityTransaction).execute()
        verify(selectDefaultQuantityTransaction).execute()
        verify(view).refresh()
    }
}
