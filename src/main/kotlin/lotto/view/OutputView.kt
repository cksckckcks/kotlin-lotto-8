package lotto.view

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
}