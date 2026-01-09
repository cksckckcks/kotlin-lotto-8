package lotto.util

fun Int.toComma(): String {
	return "%,d".format(this)
}

fun Double.toRate(): String {
	return "%.1f".format(this)
}