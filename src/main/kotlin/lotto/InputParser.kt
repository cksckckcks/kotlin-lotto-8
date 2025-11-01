package lotto

object InputParser {
	fun parsePurchaseAmount(purchaseAmount: String): Int {
		return purchaseAmount.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 로또 구매금액은 숫자여야 합니다.")
	}
}