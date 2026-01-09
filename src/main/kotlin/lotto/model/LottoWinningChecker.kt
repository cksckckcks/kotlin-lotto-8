package lotto.model

class LottoWinningChecker(
	private val winningNumbers: List<Int>,
	private val bonusNumber: Int
) {
	fun getWinningResult(lottoNumbers: List<Int>): LottoRank {
		val matchCount = lottoNumbers.count { it in winningNumbers }
		val isBonus = bonusNumber in winningNumbers

		return LottoRank.from(matchCount, isBonus)
	}
}