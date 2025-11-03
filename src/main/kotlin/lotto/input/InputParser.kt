package lotto.input

object InputParser {
	private const val DELIMITER = ','
	fun parsePurchaseAmount(input: String): Int {
		return input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 로또 구매금액은 숫자여야 합니다.")
	}

	fun parseLottoWinningNumbers(input: String): List<Int> {
		return input.split(DELIMITER).map {
			val number = it.toIntOrNull()
			require(number != null) { "[ERROR] 로또 당첨 번호는 정수여야 합니다." }

			number
		}
	}

	fun parseLottoBonusNumber(input: String): Int {
		return input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 로또 보너스 번호는 숫자여야 합니다.")
	}
}
