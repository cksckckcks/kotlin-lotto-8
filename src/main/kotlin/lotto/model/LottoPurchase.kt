package lotto.model

import lotto.Lotto

class LottoPurchase(
	buyCount: Int,
	private val lottos: MutableList<Lotto> = mutableListOf()
) {
	init {
		repeat(buyCount) {
			val lotto = LottoGenerator.getLotto()

			lottos.add(lotto)
		}
	}

	fun getLottos() = lottos.toList()
}