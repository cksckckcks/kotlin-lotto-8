package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.constants.LOTTO_MAX_NUMBER
import lotto.constants.LOTTO_MIN_NUMBER
import lotto.constants.LOTTO_NUMBER_COUNT

object LottoGenerator {
	fun getLotto(): Lotto {
		val numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT)

		return Lotto(numbers.sorted())
	}
}
