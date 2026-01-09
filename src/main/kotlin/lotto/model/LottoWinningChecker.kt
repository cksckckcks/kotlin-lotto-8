package lotto.model

import lotto.Lotto

class LottoWinningChecker(
	private val winningNumbers: List<Int>,
	private val bonusNumber: Int
) {
	fun getWinningResult(lotto: Lotto): LottoRank {
		val matchCount = lotto.getMatchCount(winningNumbers)
		val isBonus = lotto.contains(bonusNumber)

		return LottoRank.from(matchCount, isBonus)
	}
}