package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "[ERROR] 로또 번호는 ${LOTTO_NUMBER_SIZE}개여야 합니다." }
        require(numbers.distinct().size == LOTTO_NUMBER_SIZE) { "[ERROR] 로또 번호는 중복이 없어야 합니다." }
        require(numbers.all{ it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER}) { "[ERROR] 로또 당첨번호는 ${LOTTO_MIN_NUMBER}에서 ${LOTTO_MAX_NUMBER}사이의 정수여야 합니다." }
    }

}
