package lotto

fun main() {
    val lottoPurchaseAmount = readPurchaseAmount()
}

fun readPurchaseAmount(): Int {
    while (true) {
        try {
            val input = InputView.readLottoPurchaseAmount()

            val lottoPurchaseAmount = InputParser.parsePurchaseAmount(input)
            InputValidator.validatePurchaseAmount(lottoPurchaseAmount)

            return lottoPurchaseAmount
        } catch (e: IllegalArgumentException) {
            OutputView.printErrorMessage(e.message)
        }
    }
}
