class Solution {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") {
            return "0"
        }

        val m = num1.length
        val n = num2.length
        // result of multiplying an m-digit number by an n-digit number
        // has at most m + n digits
        val result = IntArray(m + n)

        // multiply every digit pair, grade-school style
        for (i in m - 1 downTo 0) {
            val d1 = num1[i] - '0'
            for (j in n - 1 downTo 0) {
                val d2 = num2[j] - '0'

                val mulVal = d1 * d2          // max 9*9 = 81, fits easily in Int
                val p1 = i + j                // higher place (carry position)
                val p2 = i + j + 1            // lower place (current digit position)

                val sum = mulVal + result[p2] // add to whatever's already there
                result[p2] = sum % 10         // keep single digit here
                result[p1] += sum / 10        // carry the rest leftward
            }
        }

        // build the string, skipping leading zeros
        val sb = StringBuilder()
        for (digit in result) {
            if (!(sb.isEmpty() && digit == 0)) {
                sb.append(digit)
            }
        }
        return if (sb.isEmpty()) "0" else sb.toString()
    }
}