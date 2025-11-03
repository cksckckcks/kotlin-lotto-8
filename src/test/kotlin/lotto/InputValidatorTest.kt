package lotto

import lotto.input.InputValidator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {
	@Test
	fun `구매금액이 정상이다`() {
		val amount = 8000

		assertDoesNotThrow {
			InputValidator.validatePurchaseAmount(amount)
		}
	}

	@Test
	fun `구매금액이 1000원 미만이면 예외가 발생한다`() {
		val amount = 999

		assertThrows<IllegalArgumentException> {
			InputValidator.validatePurchaseAmount(amount)
		}
	}

	@Test
	fun `구매금액이 1000원 단위가 아니면 예외가 발생한다`() {
		val amount = 1001

		assertThrows<IllegalArgumentException> {
			InputValidator.validatePurchaseAmount(amount)
		}
	}

	@Test
	fun `로또 당첨 번호가 정상이다`() {
		val winningNumber = listOf(1, 2, 3, 4, 5, 6)

		assertDoesNotThrow {
			InputValidator.validateWinningNumbers(winningNumber)
		}
	}

	@Test
	fun `로또 당첨 번호 갯수가 6개가 아니면 예외가 발생한다`() {
		val winningNumbers = listOf(1, 2, 3, 4, 5)

		assertThrows<IllegalArgumentException> {
			InputValidator.validateWinningNumbers(winningNumbers)
		}
	}

	@Test
	fun `로또 당첨 번호 중 1 미만의 수가 있으면 예외가 발생한다`() {
		val winningNumbers = listOf(1, 2, 3, 4, 5, -1)

		assertThrows<IllegalArgumentException> {
			InputValidator.validateWinningNumbers(winningNumbers)
		}
	}

	@Test
	fun `로또 당첨 번호 중 45를 초과하는 수가 있으면 예외가 발생한다`() {
		val winningNumbers = listOf(1, 2, 3, 4, 5, 46)

		assertThrows<IllegalArgumentException> {
			InputValidator.validateWinningNumbers(winningNumbers)
		}
	}

	@Test
	fun `보너스 번호가 정상이다`() {
		val winningNumber = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 7

		assertDoesNotThrow {
			InputValidator.validateLottoBonusNumber(winningNumber, bonusNumber)
		}
	}

	@Test
	fun `보너스 번호가 로또 당첨번호와 겹치면 예외가 발생한다`() {
		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 1

		assertThrows<IllegalArgumentException> {
			InputValidator.validateLottoBonusNumber(winningNumbers, bonusNumber)
		}
	}

	@Test
	fun `보너스 번호가 1 미만의 수가 있으면 예외가 발생한다`() {
		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 0

		assertThrows<IllegalArgumentException> {
			InputValidator.validateLottoBonusNumber(winningNumbers, bonusNumber)
		}
	}

	@Test
	fun `보너스 번호가 45를 초과하는 수가 있으면 예외가 발생한다`() {
		val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
		val bonusNumber = 46

		assertThrows<IllegalArgumentException> {
			InputValidator.validateLottoBonusNumber(winningNumbers, bonusNumber)
		}
	}
}
