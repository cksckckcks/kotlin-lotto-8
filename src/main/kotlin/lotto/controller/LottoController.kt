package lotto.controller

import lotto.util.InputParser
import lotto.util.InputValidator
import lotto.view.InputView

class LottoController {
	fun run() {
		val amount = readAmount()
		val winningNumbers = readWinningNumbers()
		val bonusNumber = readBonusNumber(winningNumbers)
	}

	private fun readAmount(): Int {
		val input = InputView.readAmount()
		val amount = InputParser.parseAmount(input)
		InputValidator.validateAmount(amount)

		return amount
	}

	private fun readWinningNumbers(): List<Int> {
		val input = InputView.readWinningNumbers()
		val winningNumbers = InputParser.parseWinningNumbers(input)
		InputValidator.validateWinningNumbers(winningNumbers)

		return winningNumbers
	}

	private fun readBonusNumber(winningNumber: List<Int>): Int {
		val input = InputView.readBonusNumber()
		val bonusNumber = InputParser.parseBonusNumber(input)
		InputValidator.validateBonusNumber(winningNumber, bonusNumber)

		return bonusNumber
	}
}