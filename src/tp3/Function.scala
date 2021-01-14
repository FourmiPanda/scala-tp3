package tp3

object Function {

  def decorate(left: String, s: String, right: String) = left + s + right;

  def fact(n: Int, soFar: Int): Int =
    if (n <= 1) soFar else fact(n-1, soFar * n)

  def main(args: Array[String]) = {
    System.out.println("TEST")

    //val decorateQ = (s: String) => tp3.Function.decorate("\"", s,"\"");
    //val decorateQ2 = (s => tp3.Function.decorate("\"", s,"\"")) : String => String;
    //val decorateQ3 : String => String =  s => tp3.Function.decorate("\"", s, "\"");
    //val decorateQ = (s: String) => decorate("\"", s,"\"");


    //val decorateC : String => (String => String) = x => (implicit y => decorate("\"", x, "\""));

    //System.out.println(decorateQ("foo"));

    System.out.println(fact(5, 5));

  }
}
