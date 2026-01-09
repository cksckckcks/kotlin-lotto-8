package lotto.util

object InputParser {
	fun parseAmount(input: String): Int {
		val amount = input.toIntOrNull()

		requireNotNull(amount) { "올바른 구매금액을 입력해주세요." }

		return amount
	}
}