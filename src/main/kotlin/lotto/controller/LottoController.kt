package lotto.controller

import lotto.model.BuyLotto
import lotto.model.LottoResult
import lotto.model.LottoWinningChecker
import lotto.util.InputParser
import lotto.util.InputValidator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
	fun run() {
		val amount = readAmount()
		val buyLotto = getBuyLotto(amount)

		printLottos(buyLotto)

		val winningNumbers = readWinningNumbers()
		val bonusNumber = readBonusNumber(winningNumbers)

		val lottoWinningChecker = getLottoWinningChecker(winningNumbers, bonusNumber)

		val lottoResult = createLottoResult(amount, buyLotto, lottoWinningChecker)

		OutputView.printLottoResult(lottoResult)
	}

	private fun createLottoResult(amount: Int, buyLotto: BuyLotto, lottoWinningChecker: LottoWinningChecker): LottoResult {
		val ranks = buyLotto.getLottos().map { lottoWinningChecker.getWinningResult(it.getNumbers()) }

		return LottoResult(amount, ranks)
	}
	private fun getLottoWinningChecker(winningNumbers: List<Int>, bonusNumber: Int): LottoWinningChecker {
		return LottoWinningChecker(winningNumbers, bonusNumber)
	}

	private fun printLottos(buyLotto: BuyLotto) {
		val lottos = buyLotto.getLottos()

		OutputView.printBuyCount(lottos.size)

		lottos.forEach {
			OutputView.printLottoNumber(it.getNumbers().joinToString(", "))
		}
	}

	private fun readAmount(): Int {
		return readInfinity {
			val input = InputView.readAmount()
			val amount = InputParser.parseAmount(input)
			InputValidator.validateAmount(amount)

			amount
		}
	}

	private fun readWinningNumbers(): List<Int> {
		return readInfinity {
			val input = InputView.readWinningNumbers()
			val winningNumbers = InputParser.parseWinningNumbers(input)
			InputValidator.validateWinningNumbers(winningNumbers)

			winningNumbers
		}
	}

	private fun readBonusNumber(winningNumber: List<Int>): Int {
		return readInfinity {
			val input = InputView.readBonusNumber()
			val bonusNumber = InputParser.parseBonusNumber(input)
			InputValidator.validateBonusNumber(winningNumber, bonusNumber)

			bonusNumber
		}
	}

	private fun <T> readInfinity(action: () -> T): T {
		while (true) {
			try {
				return action()
			} catch (e: IllegalArgumentException) {
				OutputView.printErrorMessage(e.message)
			}
		}
	}

	private fun getBuyLotto(amount: Int): BuyLotto {
		return BuyLotto(amount)
	}
}