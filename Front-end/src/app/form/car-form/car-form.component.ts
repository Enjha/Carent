import {Component, EventEmitter, Output} from '@angular/core';
import {Router} from "@angular/router";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-car-form',
  templateUrl: './car-form.component.html',
  styleUrls: ['./car-form.component.css']
})
export class CarFormComponent {

  constructor(private router: Router) {
  }

  loading = false;

  @Output()
  onNewCar = new EventEmitter<any>();

  form = new FormGroup({
    brand: new FormControl(),
    model: new FormControl(),
    modelYear: new FormControl(),
    numberOfKilometer: new FormControl(),
    price: new FormControl(),
  });

  onSubmit() {
    this.onNewCar.emit({brand: this.form.value.brand, model: this.form.value.model, modelYear: this.form.value.modelYear, numberOfKilometer: this.form.value.numberOfKilometer, price: this.form.value.price });
    this.loading = true;
    this.form.setValue({
      brand: '',
      model: '',
      modelYear: '',
      numberOfKilometer: '',
      price: ''
    });
    setTimeout(() => {
      this.router.navigate(['/']);
    }, 1000);

  }

}
