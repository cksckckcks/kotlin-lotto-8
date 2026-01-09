package lotto

import lotto.util.InputValidator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {
	@Test
	fun `로또 구입 금액이 1000원 이하일 때 예외`() {
		assertThrows<IllegalArgumentException> {
			val amount = 999

			InputValidator.validateAmount(amount)
		}
	}

	@Test
	fun `로또 구입 금액이 1000원 단위가 아닐 때 예외`() {
		assertThrows<IllegalArgumentException> {
			val amount = 10001

			InputValidator.validateAmount(amount)
		}
	}

	@Test
	fun `로또 당첨 번호가 6개가 아닐 때 예외`() {
		assertThrows<IllegalArgumentException> {
			val winningNumbers = listOf(1, 2, 3, 4, 5)

			InputValidator.validateWinningNumbers(winningNumbers)
		}
	}

	@Test
	fun `로또 당첨 번호에 중복이 있을 때 예외`() {
		assertThrows<IllegalArgumentException> {
			val winningNumbers = listOf(1, 2, 3, 4, 5, 5)

			InputValidator.validateWinningNumbers(winningNumbers)
		}
	}

	@Test
	fun `로또 당첨 번호에 범위를 초과하는 번호가 있을 때 예외`() {
		assertThrows<IllegalArgumentException> {
			val winningNumbers = listOf(1, 2, 3, 4, 5, 100)

			InputValidator.validateWinningNumbers(winningNumbers)
		}
	}

	@Test
	fun `로또 보너스 번호가 당첨 번호와 중복일 때 예외`() {
		assertThrows<IllegalArgumentException> {
			val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
			val bonusNumber = 1

			InputValidator.validateBonusNumber(winningNumbers, bonusNumber)
		}
	}

	@Test
	fun `로또 보너스 번호가 범위를 초과했을 때 예외`() {
		assertThrows<IllegalArgumentException> {
			val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
			val bonusNumber = 46

			InputValidator.validateBonusNumber(winningNumbers, bonusNumber)
		}
	}
}
