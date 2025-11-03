package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputParserTest {
	@Test
	fun `로또 구매금액 파싱에 성공한다`() {
		val input = "1000"

		val purchaseAmount = InputParser.parsePurchaseAmount(input)

		assertEquals(purchaseAmount, 1000)
	}

	@Test
	fun `로또 구매금액이 숫자가 아니면 예외가 발생한다`() {
		val input = "chan"

		assertThrows<IllegalArgumentException> {
			InputParser.parsePurchaseAmount(input)
		}
	}

	@Test
	fun `로또 당첨 번호 파싱에 성공한다`() {
		val input = "1,2,3,4,5,6"

		val winningNumbers = InputParser.parseLottoWinningNumbers(input)

		assertEquals(winningNumbers, listOf(1, 2, 3, 4, 5, 6))
	}

	@Test
	fun `로또 당첨 번호 입력이 숫자가 아니면 예외가 발생한다`() {
		val input = "chan"

		assertThrows<IllegalArgumentException> {
			InputParser.parseLottoWinningNumbers(input)
		}
	}

	@Test
	fun `로또 당첨 번호 입력이 구분자가 콤마가 아니면 예외가 발생한다`() {
		val input = "1.2.3.4.5.6"

		assertThrows<IllegalArgumentException> {
			InputParser.parseLottoWinningNumbers(input)
		}
	}

	@Test
	fun `로또 보너스 번호 파싱에 성공한다`() {
		val input = "12"

		val bonusNumber = InputParser.parseLottoBonusNumber(input)

		assertEquals(bonusNumber, 12)
	}

	@Test
	fun `로또 보너스 번호가 숫자가 아니면 예외가 발생한다`() {
		val input = "chan"

		assertThrows<IllegalArgumentException> {
			InputParser.parseLottoWinningNumbers(input)
		}
	}
}