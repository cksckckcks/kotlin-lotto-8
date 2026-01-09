package lotto

import lotto.model.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankTest {
	@Test
	fun `6개 맞추면 1등`() {
		val matchCount = 6
		val isBonus = false

		assertThat(LottoRank.from(matchCount, isBonus)).isEqualTo(LottoRank.FIRST)
	}

	@Test
	fun `5개 맞추고 보너스 번호 맞추면 2등`() {
		val matchCount = 5
		val isBonus = true

		assertThat(LottoRank.from(matchCount, isBonus)).isEqualTo(LottoRank.SECOND)
	}

	@Test
	fun `5개 맞추면 3등`() {
		val matchCount = 5
		val isBonus = false

		assertThat(LottoRank. from(matchCount, isBonus)).isEqualTo(LottoRank.THIRD)
	}

	@Test
	fun `4개 맞추면 4등`() {
		val matchCount = 4
		val isBonus = false

		assertThat(LottoRank.from(matchCount, isBonus)).isEqualTo(LottoRank.FOURTH)
	}

	@Test
	fun `3개 맞추면 5등`() {
		val matchCount = 3
		val isBonus = false

		assertThat(LottoRank.from(matchCount, isBonus)).isEqualTo(LottoRank.FIFTH)
	}

	@Test
	fun `3개 맞추고 보너스 맞추더라도 5등`() {
		val matchCount = 3
		val isBonus = true

		assertThat(LottoRank.from(matchCount, isBonus)).isEqualTo(LottoRank.FIFTH)
	}

	@Test
	fun `3개 미만으로 맞추면 낙첨`() {
		val matchCount = 2
		val isBonus = false

		assertThat(LottoRank.from(matchCount, isBonus)).isEqualTo(LottoRank.NONE)
	}
}