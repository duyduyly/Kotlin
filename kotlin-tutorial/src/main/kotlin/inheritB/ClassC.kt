package inheritB

import org.example.inherit.ParentClassA

//can not inherit because use "sealed"
//sealed just allow inheritance in package of Parent class
data object ClassC : ParentClassA() {
}