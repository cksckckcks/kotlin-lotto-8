package lotto

object OutputView {
	fun printErrorMessage(message: String?) {
		println(message)
	}

	fun printLottoPurchase(purchasesCount: Int) {
		println("${purchasesCount}개를 구매했습니다.")
	}

	fun printLottoNumbers(numbers: List<Int>) {
		println(numbers)
	}

	fun printWinningTitle() {
		println("당첨 통계\n---")
	}

	fun printWinningDetail(rank: LottoRank, count: Int, winningAmount: String) {
		val message = when(rank) {
			LottoRank.SECOND -> "${rank.count}개 일치, 보너스 볼 일치"
			else -> "${rank.count}개 일치"
		}

		println("$message (${winningAmount}원) - ${count}개")
	}

	fun printReturnRate(returnRate: String) {
		println("총 수익률은 ${returnRate}%입니다.")
	}
}
