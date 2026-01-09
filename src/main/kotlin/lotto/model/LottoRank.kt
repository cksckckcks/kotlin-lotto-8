package lotto.model

enum class LottoRank(
	val winningAmount: Int,
	val matchCount: Int,
	val isBonus: Boolean = false
) {
	FIRST(2_000_000_000, 6),
	SECOND(30_000_000, 5, true),
	THIRD(1_500_000, 5),
	FOURTH(50_000, 4),
	FIFTH(5_000, 3),
	NONE(0, 0);

	companion object {
		fun from(matchCount: Int, isBonus: Boolean): LottoRank {
			return when {
				matchCount == FIRST.matchCount -> FIRST
				matchCount == SECOND.matchCount && isBonus -> SECOND
				matchCount == THIRD.matchCount -> THIRD
				matchCount == FOURTH.matchCount -> FOURTH
				matchCount == FIFTH.matchCount -> FIFTH
				else -> NONE
			}
		}
	}
}