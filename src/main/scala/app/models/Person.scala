package app.models

class Person(name : String, age : Int, private val bankAccount: BankAccount) {
  //Secondary Constructor
  def this(name : String, age: Int) = this(name,  age, new SavingsAccount("12345",0.00))

  private val years : String = if(age > 1) "years" else "year"

  private val excluded = List("adam", "daniel")

  def speak() : String = {
    if(excluded.contains(name)) {
      s"You don't get a hello!"
    }else {
      s"Hello $name, you are $age $years old \n " +
        s"Your account details are $bankAccount"
    }
  }
}
