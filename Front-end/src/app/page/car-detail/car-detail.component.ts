import {Component} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CarService} from "../../service/car.service";
import {Car} from "../../model/car";

@Component({
  selector: 'app-car-detail',
  templateUrl: './car-detail.component.html',
  styleUrls: ['./car-detail.component.css']
})
export class CarDetailComponent {
  car?: Car;
  constructor(private route: ActivatedRoute, private carService: CarService) {
  }

  ngOnInit() {
    const id: number = Number(this.route.snapshot.paramMap.get('id'));

    this.carService
      .findOne(id)
      .subscribe(cars => this.car = cars[0]);
  }
}
