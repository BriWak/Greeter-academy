package app.models

class Person(name : String, age : Int, val bankAccounts: Seq[BankAccount] = Nil) {
  //Secondary Constructor
  def this(name : String, age: Int) = this(name, age, Seq(new SavingsAccount("12345", 0.00)))

  private val years : String = if(age > 1) "years" else "year"

  private val excluded = List("adam", "daniel")

  def totalBalance =bankAccounts.map(_.balance).sum

  def sumAndMultipleBy(f: Double => Double) = bankAccounts.map(x => f(x.balance)).sum

  def speak() : String = {
    if(excluded.contains(name)) {
      s"You don't get a hello!"
    }else {
      s"Hello $name, you are $age $years old \n " +
        s"Your account details are $bankAccounts, total balance: $totalBalance"
    }
  }
}
