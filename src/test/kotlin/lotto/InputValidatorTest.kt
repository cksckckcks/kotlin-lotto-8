package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {
	@Test
	fun `구매금액이 1000원 이상이다`() {
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
}
