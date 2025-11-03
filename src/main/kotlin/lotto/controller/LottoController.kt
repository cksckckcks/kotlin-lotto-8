package lotto.controller

import lotto.constants.LOTTO_PRICE
import lotto.input.InputParser
import lotto.input.InputValidator
import lotto.model.Lotto
import lotto.model.LottoGenerator
import lotto.model.LottoRank
import lotto.view.InputView
import lotto.view.OutputView
import java.text.DecimalFormat

object LottoController {
	fun run() {
		val lottoPurchaseAmount = readAndValidatePurchaseAmount()
		val lottoNumbers = getLottoNumbers(lottoPurchaseAmount)
		printLottoNumbers(lottoNumbers)

		val winningNumber = readAndValidateWinningNumbers()
		val bonusNumber = readAndValidateBonusNumber(winningNumber)

		val winningResults = getWinningResult(lottoNumbers, winningNumber, bonusNumber)
		printWinningResults(winningResults)

		val winningAmount = getWinningAmount(winningResults)
		val returnRate = formatReturnRate(lottoPurchaseAmount, winningAmount)
		OutputView.printReturnRate(returnRate)
	}

	private fun readAndValidatePurchaseAmount(): Int {
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

	private fun readAndValidateWinningNumbers(): List<Int> {
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

	private fun readAndValidateBonusNumber(lottoNumbers: List<Int>): Int {
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

	private fun getLottoNumbers(purchaseAmount: Int): List<Lotto> {
		val lottoCount = purchaseAmount / LOTTO_PRICE

		return List(lottoCount) { LottoGenerator.getLottoNumber() }
	}

	private fun printWinningResults(winningResults: Map<LottoRank, Int>) {
		OutputView.printWinningTitle()

		winningResults.forEach {
			val (rank, count) = it
			val winningAmount = formatWithComma(rank.winningAmount)
			val message = when(rank) {
				LottoRank.SECOND -> "${rank.count}개 일치, 보너스 볼 일치"
				else -> "${rank.count}개 일치"
			}

			OutputView.printWinningDetail(message, count, winningAmount)
		}
	}

	private fun getWinningResult(
		lottoNumbers: List<Lotto>,
		winningNumber: List<Int>,
		bonusNumber: Int
	): Map<LottoRank, Int> {
		return LottoRank.entries
			.filter { it != LottoRank.NONE }
			.sortedDescending()
			.associateWith { rank ->
				lottoNumbers.count { it.checkWinningResult(winningNumber, bonusNumber) == rank }
			}
	}

	private fun formatWithComma(amount: Int): String {
		return DecimalFormat("#,###").format(amount)
	}

	private fun getWinningAmount(winningResults: Map<LottoRank, Int>): Long {
		var winningAmount = 0L

		winningResults.forEach { (rank, count) ->
			winningAmount += rank.winningAmount * count
		}

		return winningAmount
	}

	private fun formatReturnRate(purchaseAmount: Int, winningAmount: Long): String {
		val returnRate = winningAmount.toDouble() / purchaseAmount * 100

		return DecimalFormat("#,##0.0").format(returnRate)
	}

	private fun printLottoNumbers(lottoNumbers: List<Lotto>) {
		OutputView.printLottoPurchase(lottoNumbers.size)
		lottoNumbers.forEach { OutputView.printLottoNumbers(it.getNumbers()) }
	}
}
