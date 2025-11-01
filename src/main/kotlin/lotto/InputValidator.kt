package lotto

object InputValidator {
	private const val LOTTO_PRICE = 1000
	private const val LOTTO_MIN_NUMBER = 1
	private const val LOTTO_MAX_NUMBER = 45
	private const val LOTTO_WINNING_NUMBER_SIZE = 6


	fun validatePurchaseAmount(purchaseAmount: Int) {
		require(purchaseAmount >= LOTTO_PRICE) { "[ERROR] 최소 로또 구매금액은 ${LOTTO_PRICE}원 입니다."}
		require(purchaseAmount % LOTTO_PRICE == 0) { "[ERROR] 로또 구매금액은 ${LOTTO_PRICE}원 단위여야 합니다."}
	}

	fun validateWinningNumbers(winningNumbers: List<Int>) {
		require(winningNumbers.size == LOTTO_WINNING_NUMBER_SIZE) { "[ERROR] 로또 당첨번호는 ${LOTTO_WINNING_NUMBER_SIZE}개의 정수여야 합니다." }
		require(winningNumbers.distinct().size == LOTTO_WINNING_NUMBER_SIZE) { "[ERROR] 로또 당첨번호는 중복되지 않아야 합니다." }
		winningNumbers.forEach { validateLottoNumberRange(it) }
	}

	fun validateLottoBonusNumber(winningNumbers: List<Int>, bonusNumber: Int) {
		validateLottoNumberRange(bonusNumber)
		require(bonusNumber !in winningNumbers) { "[ERROR] 로또 당첨번호와 보너스 번호가 겹칩니다." }
	}

	private fun validateLottoNumberRange(number: Int) {
		require(number in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) { "[ERROR] 로또 당첨번호는 ${LOTTO_MIN_NUMBER}에서 ${LOTTO_MAX_NUMBER}사이의 정수여야 합니다." }
	}

}