package lotto

import camp.nextstep.edu.missionutils.Console.readLine

object InputView {
	fun readLottoPurchaseAmount(): String {
		println("구입금액을 입력해주세요.")

		return readLine()
	}
}