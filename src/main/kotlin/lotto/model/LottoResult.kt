package lotto.model

class LottoResult(
	private val amount: Int,
	private val ranks: List<LottoRank>
) {
	fun getResult(): Map<LottoRank, Int> {
		return LottoRank.entries
			.filter { it != LottoRank.NONE }
			.sortedBy { it.winningAmount }
			.associateWith { rank ->
				ranks.count { it == rank }
			}
	}

	fun getWinningRateOfReturn(): Double {
		val winningAmount = ranks.sumOf { it.winningAmount }

		return winningAmount.toDouble() / amount * 100
	}
}