package lotto

import lotto.model.LottoPurchase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoPurchaseTest {
	@Test
	fun `로또 구매 갯수만큼 구매 테스트`() {
		val buyCount = 10

		val lottoPurchase = LottoPurchase(buyCount)

		assertThat(lottoPurchase.getLottos().size).isEqualTo(buyCount)
	}
}
