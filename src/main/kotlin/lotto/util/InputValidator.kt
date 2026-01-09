package lotto.util

import lotto.constants.LOTTO_PRICE

object InputValidator {
	fun validateAmount(amount: Int) {
		require(amount >= LOTTO_PRICE) { "로또 구입 금액은 $LOTTO_PRICE 이상이어야 합니다." }
		require(amount % LOTTO_PRICE == 0) { "로또 구입 금액은 $LOTTO_PRICE 단위여야 합니다." }
	}
}