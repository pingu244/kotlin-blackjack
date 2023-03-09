package controller

import domain.BlackjackGame
import domain.participants.Names
import view.InputView
import view.OutputView

class BlackjackController {

    fun startGame() {
        val names = insertNames()
        val blackjackGame = BlackjackGame(names)
        blackjackGame.getBetAmount(InputView::inputBetAmount)
        blackjackGame.startBlackjackGame(OutputView::printBlackjackSetting)
        blackjackGame.playsTurn(InputView::inputRepeatGetCard, OutputView::printParticipantCards)
        blackjackGame.dealerPickCard(OutputView::printDealerUnder16)
        blackjackGame.showCardResult(OutputView::printCardResult)
        blackjackGame.showWinningResult(OutputView::printProfitResult)
    }

    private fun insertNames(): Names {
        val names = InputView.inputPlayerNames()
        return runCatching { Names(names) }
            .onFailure { println(it.message) }
            .getOrNull() ?: insertNames()
    }
}
