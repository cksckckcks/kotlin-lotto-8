package lotto

import java.text.DecimalFormat

fun main() {
	val lottoPurchaseAmount = readAndValidatePurchaseAmount()

	val lottoNumbers = getLottoNumbers(lottoPurchaseAmount)

	OutputView.printLottoPurchase(lottoNumbers.size)
	lottoNumbers.forEach {
		OutputView.printLottoNumbers(it.getNumbers())
	}

	val winningNumber = readAndValidateWinningNumbers()
	val bonusNumber = readAndValidateBonusNumber(winningNumber)

	val winningResults = LottoRank.values()
		.filter { it != LottoRank.NONE }
		.sortedDescending()
		.associateWith { rank ->
			lottoNumbers.count { it.checkWinningResult(winningNumber, bonusNumber) == rank}
		}


	printWinningResults(winningResults)
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

fun getLottoNumbers(purchaseAmount: Int): List<Lotto> {
	val lottoCount = purchaseAmount / 1000

	return List(lottoCount) { LottoGenerator.getLottoNumber() }
}

fun printWinningResults(winningResults: Map<LottoRank, Int>) {
	OutputView.printWinningTitle()

	winningResults.forEach {
		val (rank, count) = it
		val winningAmount = formatWithComma(rank.winningAmount)

		OutputView.printWinningDetail(rank, count, winningAmount)
	}
}

fun formatWithComma(amount: Int): String {
	return DecimalFormat("#,###").format(amount)
}
