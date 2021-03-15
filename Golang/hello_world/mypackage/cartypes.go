package mypackage

import "fmt"

// Car Represents a Car
type Car struct {
	Brand string
	Year int
	owner string
}

func (carInstance Car) Drive() {
	message := fmt.Sprintf("I'm driving my %s!!!!", carInstance.Brand)
	fmt.Println(message)
}

func (carInstance *Car) ChangeBrand(newBrand string) {
	carInstance.Brand = newBrand
}

func (carInstance Car) String() string {
	return fmt.Sprintf("My car is a %s from %d\n", carInstance.Brand, carInstance.Year)
}

// NoCar Example for unpublished elements
type NoCar struct {
	owner string
}
