package lotto

import lotto.constants.LOTTO_MAX_NUMBER
import lotto.constants.LOTTO_MIN_NUMBER

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
        require(numbers.toSet().size == numbers.size) { "[ERROR] 로또 번호는 중복되지 않아야 합니다." }
        require(numbers.toSet().size == numbers.size) { "[ERROR] 로또 번호는 $LOTTO_MIN_NUMBER ~ $LOTTO_MAX_NUMBER 사이여야 합니다." }
    }

    fun getNumbers() = numbers
}
