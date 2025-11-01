package lotto

fun main() {
	val lottoPurchaseAmount = readAndValidatePurchaseAmount()
	val lottoWinningNumber = readAndValidateWinningNumbers()
	val bonusNumber = readAndValidateBonusNumber(lottoWinningNumber)
}

fun readAndValidatePurchaseAmount(): Int {
	while (true) {
		try {
			val input = InputView.readLottoPurchaseAmount()

			val lottoPurchaseAmount = InputParser.parsePurchaseAmount(input)
			InputValidator.validatePurchaseAmount(lottoPurchaseAmount)

			return lottoPurchaseAmount
		} catch (e: IllegalArgumentException) {
			OutputView.printErrorMessage(e.message)
		}
	}
}

fun readAndValidateWinningNumbers(): List<Int> {
	while (true) {
		try {
			val input = InputView.readWinningNumbers()

			val lottoNumbers = InputParser.parseLottoWinningNumbers(input)
			InputValidator.validateWinningNumbers(lottoNumbers)

			return lottoNumbers
		} catch (e: IllegalArgumentException) {
			OutputView.printErrorMessage(e.message)
		}
	}
}

fun readAndValidateBonusNumber(lottoNumbers: List<Int>): Int {
	while (true) {
		try {
			val input = InputView.readBonusNumber()

			val bonusNumber = InputParser.parseLottoBonusNumber(input)
			InputValidator.validateLottoBonusNumber(lottoNumbers, bonusNumber)

			return bonusNumber
		} catch (e: IllegalArgumentException) {
			OutputView.printErrorMessage(e.message)
		}
	}
}
