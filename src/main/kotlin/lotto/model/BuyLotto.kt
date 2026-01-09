package lotto.model

import lotto.Lotto
import lotto.constants.LOTTO_PRICE

class BuyLotto(
	amount: Int,
	private val lottos: MutableList<Lotto> = mutableListOf()
) {
	init {
		val lottoBuyCount = amount / LOTTO_PRICE
		repeat(lottoBuyCount) {
			val lotto = LottoGenerator.getLotto()

			lottos.add(lotto)
		}
	}

	fun getLottos() = lottos.toList()
}