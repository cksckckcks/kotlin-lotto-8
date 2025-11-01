package lotto

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange

object LottoGenerator {
	fun getLottoNumber(): Lotto {
		val lottoNumbers = pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_SIZE).sorted()

		return Lotto(lottoNumbers)
	}
}