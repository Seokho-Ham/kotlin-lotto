package lotto.domain

@JvmInline
value class LottoNumber(private val number: Int) {
    init {
        validateInRange()
    }

    private fun validateInRange() {
        require(this.number in LOTTO_RANGE) { "로또 번호는 ${LOTTO_RANGE.first} ~ ${LOTTO_RANGE.last} 내의 숫자여야 합니다." }
    }

    override fun toString(): String {
        return "$number"
    }

    companion object {
        private val LOTTO_RANGE = 1..45
    }
}
