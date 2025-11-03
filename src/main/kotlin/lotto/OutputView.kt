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
}