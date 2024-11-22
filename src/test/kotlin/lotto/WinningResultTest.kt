package lotto

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinningResultTest : StringSpec({
    "3개, 4개, 5개, 6개 에 대해 각각 몇개씩 일치하는지 정보를 제공한다." {
        val order = Order(1000, FixedNumberGenerator())
        val winNumbers = WinNumbers(FixedNumberGenerator().generate())

        val result = WinningResult(order, winNumbers)

        assertSoftly {
            result.winningMatchCounts[6] shouldBe 1
            result.winningMatchCounts[5] shouldBe 0
            result.winningMatchCounts[4] shouldBe 0
            result.winningMatchCounts[3] shouldBe 0
        }
    }

    "수익을 제공한다." {
        val order = Order(1000, FixedNumberGenerator())
        val winNumbers = WinNumbers(FixedNumberGenerator().generate())

        val result = WinningResult(order, winNumbers)

        result.revenue shouldBe 2_000_000_000
    }

    "수익률을 제공한다." {
        val order = Order(1000, FixedNumberGenerator())
        val winNumbers = WinNumbers(FixedNumberGenerator().generate())

        val result = WinningResult(order, winNumbers)

        result.rate shouldBe 2000000.0
    }
})