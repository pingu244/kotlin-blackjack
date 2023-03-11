package domain.result

import domain.participants.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultTest {

    @Test
    fun `블랙잭이 나왔을 때 배팅금액의 1_5배를 반환한다`() {
        val betAmount = Money(1000)
        assertThat(Result.BLACKJACK_WIN.calculateProfit(betAmount)).isEqualTo((betAmount * 1.5))
    }

    @Test
    fun `승 이 나왔을 때 배팅금액의 1배를 반환한다`() {
        val betAmount = Money(1000)
        assertThat(Result.WIN.calculateProfit(betAmount)).isEqualTo((betAmount * 1.0))
    }

    @Test
    fun `무승부가 나왔을 때 배팅금액의 0배를 반환한다`() {
        val betAmount = Money(1000)
        assertThat(Result.DRAW.calculateProfit(betAmount)).isEqualTo((betAmount * 0.0))
    }

    @Test
    fun `패 가 나왔을 때 배팅금액의 -1배를 반환한다`() {
        val betAmount = Money(1000)
        assertThat(Result.LOSS.calculateProfit(betAmount)).isEqualTo((betAmount * -1.0))
    }
}
