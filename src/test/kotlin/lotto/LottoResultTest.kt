package lotto

import lotto.model.LottoRank
import lotto.model.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
	@Test
	fun `결과 카운트 테스트`() {
		val amount = 4000
		val ranks = listOf(LottoRank.FIRST, LottoRank.SECOND, LottoRank.NONE, LottoRank.NONE)

		val lottoResult = LottoResult(amount, ranks)

		val result = mapOf(
			LottoRank.FIFTH to 0,
			LottoRank.FOURTH to 0,
			LottoRank.THIRD to 0,
			LottoRank.SECOND to 1,
			LottoRank.FIRST to 1
		)

		assertThat(lottoResult.getResult()).isEqualTo(result)
	}

	@Test
	fun `수익률 테스트`() {
		val amount = 8000
		val ranks = listOf(LottoRank.FIFTH, LottoRank.NONE, LottoRank.NONE, LottoRank.NONE)

		val lottoResult = LottoResult(amount, ranks)

		val rateOfReturn = 62.5

		assertThat(lottoResult.getWinningRateOfReturn()).isEqualTo(rateOfReturn)
	}
}
