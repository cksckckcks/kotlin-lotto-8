package lotto.controller

import lotto.util.InputParser
import lotto.util.InputValidator
import lotto.view.InputView

class LottoController {
	fun run() {
		val amount = readAmount()
	}

	private fun readAmount(): Int {
		val input = InputView.readAmount()
		val amount = InputParser.parseAmount(input)
		InputValidator.validateAmount(amount)

		return amount
	}
}