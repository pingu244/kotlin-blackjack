package view

object InputView {
    private const val YES_ANSWER = "y"
    private const val NO_ANSWER = "n"
    private const val PRINT_PARTICIPANT_NAMES = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)"
    private const val PRINT_QUESTION_CARD_PICK_FORM = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)"
    private const val SEPARATOR = ","

    fun inputPlayerNames(): List<String> {
        println(PRINT_PARTICIPANT_NAMES)
        val input = readln().trim().split(SEPARATOR)

        return input.isAvailable()
    }

    private fun List<String>.isAvailable(): List<String> {
        return this.filter { it.isNotBlank() }
    }

    fun inputRepeatGetCard(name: String): Boolean? {
        println(PRINT_QUESTION_CARD_PICK_FORM.format(name))
        val input = readln().lowercase()

        return validateAnswer(input)
    }

    private fun validateAnswer(answer: String): Boolean? {
        return when (answer) {
            YES_ANSWER -> true
            NO_ANSWER -> false
            else -> null
        }
    }
}
