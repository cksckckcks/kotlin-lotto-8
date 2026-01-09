package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
	fun readAmount(): String {
		println("구입금액을 입력해 주세요.")

		return Console.readLine()
	}
}