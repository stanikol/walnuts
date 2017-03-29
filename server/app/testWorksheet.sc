case class C1(f1: Int, f2: Int)

val comments = Seq(C1(1, 11), C1(1, 2), C1(2,1), C1(1,1))

comments.groupBy{c1:C1 =>(c1.f1, c1.f1)}.keys