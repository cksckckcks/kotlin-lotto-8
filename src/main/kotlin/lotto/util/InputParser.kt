package lotto.util

object InputParser {
	private const val DELIMITER = ","

	fun parseAmount(input: String): Int {
		val amount = input.toIntOrNull()

		requireNotNull(amount) { "올바른 구매금액을 입력해주세요." }

		return amount
	}

	fun parseWinningNumbers(input: String): List<Int> {
		val winningNumbers = input.split(DELIMITER).map {
			val number = it.toIntOrNull()

			requireNotNull(number) { "올바른 로또 당첨 번호를 입력해주세요." }

			number
		}

		return winningNumbers
	}
}