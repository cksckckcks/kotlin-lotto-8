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
		println("${rank.count}개 일치 (${winningAmount}원) - ${count}개")
	}

	fun printReturnRate(returnRate: String) {
		println("총 수익률은 ${returnRate}%입니다.")
	}
}
