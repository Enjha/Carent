import { Component } from '@angular/core';
import {Cars} from "../../model/car";
import {CarService} from "../../service/car.service";

@Component({
  selector: 'app-car-create',
  templateUrl: './car-create.component.html',
  styleUrls: ['./car-create.component.css']
})
export class CarCreateComponent {
  cars: Cars = [];

  constructor(private carService: CarService) {
  }

  addCar(obj:any){
    this.carService
      .create(obj)
      .subscribe((cars) => this.cars.push(cars[0]));
  }
}
