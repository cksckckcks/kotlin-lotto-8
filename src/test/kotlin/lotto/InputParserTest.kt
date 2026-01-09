package lotto

import lotto.util.InputParser
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputParserTest {
	@Test
	fun `구매 금액이 숫자면 정상 파싱`() {
		val input = "1"

		assertThat(InputParser.parseAmount(input)).isEqualTo(1)
	}

	@Test
	fun `구매 금액이 숫자가 아니면 예외`() {
		assertThrows<IllegalArgumentException> {
			val input = "a"

			InputParser.parseAmount(input)
		}
	}

	@Test
	fun `당첨 번호 정상 파싱`() {
		val input = "1,2,3,4,5,6"

		assertThat(InputParser.parseWinningNumbers(input)).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
	}

	@Test
	fun `당첨 번호에 숫자가 아닌 값이 있으면 예외`() {
		assertThrows<IllegalArgumentException> {
			val input = "1,2,3,4,5,a"

			InputParser.parseWinningNumbers(input)
		}
	}

	@Test
	fun `보너스 번호가 숫자면 정상 파싱`() {
		val input = "1"

		assertThat(InputParser.parseBonusNumber(input)).isEqualTo(1)
	}

	@Test
	fun `보너스 번호가 숫자가 아니면 예외`() {
		assertThrows<IllegalArgumentException> {
			val input = "a"

			InputParser.parseBonusNumber(input)
		}
	}
}