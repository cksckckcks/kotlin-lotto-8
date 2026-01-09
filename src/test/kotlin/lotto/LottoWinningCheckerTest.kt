package lotto

import lotto.model.LottoRank
import lotto.model.LottoWinningChecker
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoWinningCheckerTest {
	@Test
	fun `당첨 번호 매칭 테스트`() {
		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 7

		val winningChecker = LottoWinningChecker(winningNumbers, bonusNumber)

		val myNumbers = listOf(1, 2, 3, 4, 5, 6)

		assertThat(winningChecker.getWinningResult(myNumbers)).isEqualTo(LottoRank.FIRST)
	}

	@Test
	fun `보너스 번호 매칭 테스트`() {
		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 7

		val winningChecker = LottoWinningChecker(winningNumbers, bonusNumber)

		val myNumbers = listOf(1, 2, 3, 4, 5, 7)

		assertThat(winningChecker.getWinningResult(myNumbers)).isEqualTo(LottoRank.SECOND)
	}
}
