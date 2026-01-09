package lotto.util

import lotto.constants.LOTTO_MAX_NUMBER
import lotto.constants.LOTTO_MIN_NUMBER
import lotto.constants.LOTTO_NUMBER_COUNT
import lotto.constants.LOTTO_PRICE

object InputValidator {
	fun validateAmount(amount: Int) {
		require(amount >= LOTTO_PRICE) { "로또 구입 금액은 $LOTTO_PRICE 이상이어야 합니다." }
		require(amount % LOTTO_PRICE == 0) { "로또 구입 금액은 $LOTTO_PRICE 단위여야 합니다." }
	}

	fun validateWinningNumbers(winningNumbers: List<Int>) {
		require(winningNumbers.size == LOTTO_NUMBER_COUNT) { "로또 당첨 번호는 6자리 숫자여야 합니다." }
		require(winningNumbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER}) { "로또 번호는 1부터 45 사이의 숫자여야 합니다." }
		require(winningNumbers.toSet().size == winningNumbers.size) { "로또 당첨 번호 내에 중복된 숫자가 있을 수 없습니다." }
	}
}