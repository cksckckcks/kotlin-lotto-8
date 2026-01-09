package lotto.view

import lotto.model.LottoResult
import lotto.util.toComma

object OutputView {
	private const val ERROR_HEADER = "[ERROR]"
	private const val UNKNOWN_ERROR = "알 수 없는 오류입니다."

	fun printErrorMessage(message: String?) {
		println("$ERROR_HEADER ${message ?: UNKNOWN_ERROR}")
	}

	fun printLottoNumber(numbers: String) {
		println("[${numbers}]")
	}

	fun printNewLine() {
		println()
	}

	fun printBuyCount(buyCount: Int) {
		println("${buyCount}개를 구매했습니다.")
	}

	fun printLottoResult(lottoResult: LottoResult) {
		val result = lottoResult.getResult()

		println("당첨 통계\n---")
		result.forEach {
			val (rank, count) = it
			val bonusText = if (rank.isBonus) ", 보너스 볼 일치" else ""

			println("${rank.matchCount}개 일치$bonusText (${rank.winningAmount.toComma()}원) - ${count}개")
		}
	}
}