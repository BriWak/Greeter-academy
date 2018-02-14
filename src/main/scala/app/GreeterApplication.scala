package app

import app.models.{CashISASavingsAccount, Person}
import app.views.Prompt

object GreeterApplication extends App {
  val name = Prompt.ask("What is your name? ")
  val age = Prompt.ask("How old are you? ")
  val cashisa = new CashISASavingsAccount("45676", 0.0, 1000.00)
  val deposited = cashisa.deposit(1000.00)
  val withdrawn = deposited.withdraw(200.00)
  val person = new Person(name, age.toInt, withdrawn)
  Prompt.reply(person.speak())

  //val normalAccount = new CashISASavingsAccount("12334", 100.00)
  //val loyalAccountDeposited = normalAccount.deposit(300.00)
  //val loyal = new Person("Loyal customer", 22, loyalAccountDeposited)
  //Prompt.reply(loyal.speak())
}







