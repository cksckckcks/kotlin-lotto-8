package lotto

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange

object LottoGenerator {
	private const val LOTTO_MIN_NUMBER = 1
	private const val LOTTO_MAX_NUMBER = 45
	private const val LOTTO_NUMBER_SIZE = 6

	fun getLottoNumber(): Lotto {
		val lottoNumbers = pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_SIZE).sorted()

		return Lotto(lottoNumbers)
	}
}