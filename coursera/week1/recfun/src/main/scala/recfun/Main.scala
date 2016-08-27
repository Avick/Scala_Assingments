package recfun

object Main {
  def main(args: Array[String]) {

    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

//    println(balance("(if (zero? x) max (/ 1 x))".toList))
//    println(balance("())(".toList))

  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if(c == 0 || c == r)  1
      else pascal(c,r-1) + pascal(c-1, r-1)

    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def loop(acc: Int, chars: List[Char]): Boolean = {
        if(chars.isEmpty)
          if(acc == 0)
            true
          else
            false
        else if ( acc < 0 )
            false
        else if (chars.head == '(')
          loop(acc+1, chars.tail)
        else if(chars.head == ')')
          loop(acc-1, chars.tail)
        else
          loop(acc,chars.tail)
      }

    loop(0, chars)
    /*val count = 0
    if (chars.isEmpty) true


    else if (chars.head == '(')
      count*/
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money < 0 || coins.isEmpty) {
        0
      }else {
        countChange(money, coins.tail) + (if (money == coins.head) 1 else countChange(money - coins.head, coins))
      }

    }
  }
