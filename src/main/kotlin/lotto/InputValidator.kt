package lotto

object InputValidator {
	private const val LOTTO_PRICE = 1000

	fun validatePurchaseAmount(purchaseAmount: Int) {
		require(purchaseAmount >= 1000) { "[ERROR] 최소 로또 구매금액은 1000원 입니다."}
		require(purchaseAmount % LOTTO_PRICE == 0) { "[ERROR] 로또 구매금액은 1000원 단위여야 합니다."}
	}
}