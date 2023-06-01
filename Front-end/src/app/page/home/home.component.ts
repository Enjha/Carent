import { Component } from '@angular/core';
import {Cars} from "../../model/car";
import {CarService} from "../../service/car.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  cars: Cars = [];
  constructor(private service: CarService) {
  }

  ngOnInit() {
    this.service
      .findAll()
      .subscribe((cars) => this.cars = cars)
  }

}
