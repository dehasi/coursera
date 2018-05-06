package quickcheck

import common._

import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  //  lazy val genHeap: Gen[H] = Gen.const(empty)
  lazy val genHeap: Gen[H] = for {
    a <- arbitrary[Int]
    h <- oneOf(const(empty), genHeap)
  } yield insert(a, h)


  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("gen111") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    val k = m+1
    insert(m,h)
    insert(k,h)
    findMin(h) == m
  }

  property("min1") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }


//  property("min2") = forAll { a: Int =>
//    val h = insert(a, empty)
//    deleteMin(h)
//
//    isEmpty(h)
//  }

  property("gen12") = forAll { (h: H) =>
   if (!isEmpty(h)) {
     val  m = findMin(h)
     insert(m-1, h)
     findMin(h) !=  m
   }
    true
  }

  property("melt") = forAll { (h1:H, h2:H) => {
    val m1 = findMin(h1)
    val m2 = findMin(h2)
    val h = meld(h1,h2)
    findMin(h)== Math.min(m1,m2)
  }

  }


}
