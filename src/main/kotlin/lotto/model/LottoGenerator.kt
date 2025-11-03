package lotto.model

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.constants.LOTTO_MAX_NUMBER
import lotto.constants.LOTTO_MIN_NUMBER
import lotto.constants.LOTTO_NUMBER_SIZE

object LottoGenerator {
	fun getLottoNumber(): Lotto {
		val lottoNumbers = pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_SIZE).sorted()

		return Lotto(lottoNumbers)
	}
}
