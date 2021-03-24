package main

import (
	"fmt"
	"math"
	"reflect"

	myPk "curso_platzi/mypackage"
)

type Figure interface {
	calculateArea() float64
}

type Rectangle struct {
	base float64
	height float64
}

type Circle struct {
	radius float64
}

func (c Circle) calculateArea() float64 {
	return math.Pi * math.Pow(c.radius, 2)
}

func (r Rectangle) calculateArea() float64 {
	return r.base * r.height
}

func describeArea(f Figure) {
	fmt.Printf("The area of this %s is of %.2f square units\n",
			   reflect.TypeOf(f).Name(), f.calculateArea())
}

func main() {
	var foo float64 = 10.0
	var bar int = 2
	fmt.Println("Hello World", foo/float64(bar))

	fmt.Println("\n-----------------------------------------\n")

	car := myPk.Car{Brand: "Ford", Year: 2011}
	fmt.Println(car)

	car.ChangeBrand("Mercedes")
	car.Drive()

	fmt.Println("\n-----------------------------------------\n")

	square := Rectangle{5, 5}
	circle := Circle{10}

	describeArea(square)
	describeArea(circle)

	list := []interface{} {1, 2.0, true, nil, square, &circle}
	fmt.Println(list)
}
