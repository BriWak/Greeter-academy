package app

import scala.io.StdIn

object Prompt {
  def ask(message : String) = StdIn.readLine(message)
}

class Person(name : String, age : Int) {
  private val years : String = if(age > 1) "years" else "year"
  def speak() : String = {
    if(name == "brian") {
      s"You don't get a hello!"
    }else {
      s"Hello $name, you are $age $years old"
    }
  }
}

object GreeterApplication extends App {
  val name = Prompt.ask("What is your name? ")
  val age = Prompt.ask("How old are you? ")
  val person = new Person(name, age.toInt)
  println(person.speak())
}

abstract class BankAccount(accountNumber : String,
                           balance : Double){
  def withdraw(amount : Double) : BankAccount
  def deposit(amount : Double) : BankAccount
}

final class SavingsAccount(accountNumber: String,
                           balance: Double) extends BankAccount(accountNumber, balance){
  override def withdraw(amount: Double): BankAccount = {
    if((balance - amount) < 0) {
      println(s"You have insufficient funds")
      this
    } else {
      val deducted = balance - amount
      println(s"Balance after deductions: $deducted")
      new SavingsAccount(accountNumber, deducted)
    }
  }
  override def deposit(amount: Double): BankAccount = {
    new SavingsAccount(accountNumber, balance + amount)
  }
}

final class CashISASavingsAccount(accountNumber: String,
                                  balance: Double) extends BankAccount(accountNumber, balance){
  override def withdraw(amount: Double): BankAccount = {
    println(s"You can not withdraw from this account yet")
    this
  }
  override def deposit(amount: Double): BankAccount = {
    new CashISASavingsAccount(accountNumber, balance + amount)
  }
}

test