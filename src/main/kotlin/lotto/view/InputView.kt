package lotto.view

import camp.nextstep.edu.missionutils.Console.readLine

object InputView {
	fun readLottoPurchaseAmount(): String {
		println("구입금액을 입력해주세요.")

		return readLine()
	}

	fun readWinningNumbers(): String {
		println("당첨 번호를 입력해 주세요.")

		return readLine()
	}

	fun readBonusNumber(): String {
		println("보너스 번호를 입력해 주세요.")

		return readLine()
	}
}
