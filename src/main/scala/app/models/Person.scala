package app.models

class Person(name : String, age : Int, val bankAccounts: Seq[BankAccount] = Nil) {
  //Secondary Constructor
  def this(name : String, age: Int) = this(name, age, Seq(new SavingsAccount("12345", 0.00)))

  private val years : String = if(age > 1) "years" else "year"

  private val excluded = List("adam", "daniel")

  //Anonymous Function
  //an anonymous function is a function that has no name assigned
  //Partial Function
  //A partial function is applied to each element in a collection
  val	add	=	(acc	:	Double,	account	:	BankAccount)	=>	acc	+	account.balance
  bankAccounts.foldLeft(0.00)(add)

  //calling	map()	on an Iterable collection will apply that function to each and every element in that list
  //Underscore _ tells Scala that we want to apply the expression
  //after the _ operator to every element in the collection
  def totalBalance = bankAccounts.map(_.balance).sum

  //Higher Order Function
  //functions that take other functions as parameters, or whose result is a function
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
