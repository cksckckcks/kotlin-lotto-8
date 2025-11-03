package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
	@Test
	fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
		}
	}

	@Test
	fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5, 5))
		}
	}

	@Test
	fun `로또 번호의 개수가 6개보다 적으면 예외가 발생한다`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5))
		}
	}

	@Test
	fun `로또 번호에 45가 초과한 수가 있으면 예외가 발생한다`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5, 46))
		}
	}

	@Test
	fun `로또 번호에 1보다 작은 수가 있으면 예외가 발생한다`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(1, 2, 3, 4, 5, 0))
		}
	}

	@Test
	fun `로또 번호가 6개 일치하면 1등이다`() {
		val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 7

		val result = lotto.checkWinningResult(winningNumbers, bonusNumber)

		assertEquals(LottoRank.FIRST, result)
	}

	@Test
	fun `로또 번호가 5개와 보너스 번호가 일치하면 2등이다`() {
		val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 7

		val result = lotto.checkWinningResult(winningNumbers, bonusNumber)

		assertEquals(LottoRank.SECOND, result)
	}

	@Test
	fun `로또 번호가 5개가 일치하면 3등이다`() {
		val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))
		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 7

		val result = lotto.checkWinningResult(winningNumbers, bonusNumber)

		assertEquals(LottoRank.THIRD, result)
	}

	@Test
	fun `로또 번호가 4개가 일치하면 4등이다`() {
		val lotto = Lotto(listOf(1, 2, 3, 4, 7, 8))
		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 7

		val result = lotto.checkWinningResult(winningNumbers, bonusNumber)

		assertEquals(LottoRank.FOURTH, result)
	}

	@Test
	fun `로또 번호가 3개가 일치하면 5등이다`() {
		val lotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 7

		val result = lotto.checkWinningResult(winningNumbers, bonusNumber)

		assertEquals(LottoRank.FIFTH, result)
	}

	@Test
	fun `로또 번호가 2개 이하로 일치하면 미당첨이다`() {
		val lotto = Lotto(listOf(1, 2, 7, 8, 9, 10))
		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 7

		val result = lotto.checkWinningResult(winningNumbers, bonusNumber)

		assertEquals(LottoRank.NONE, result)
	}
}
