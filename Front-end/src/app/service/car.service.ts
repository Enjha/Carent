import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Car, Cars} from "../model/car";

const BASE_URL = 'http://localhost:8080/api/cars';
@Injectable()
export class CarService {

  constructor(private http: HttpClient) {
  }

  findOne(id: number): Observable<Car> {
    return this.http.get<Car>(BASE_URL + '/' + id, {
      headers: {
        "Content-Type": "application/json",
        Prefer: "return=representation"
      }
    });
  }


  findAll(): Observable<Cars> {
    return this.http.get<Cars>(BASE_URL, {
      headers: {
        "Content-Type": "application/json"
      }
    });
  }

  create(obj: any): Observable<Cars> {
    return this.http.post<Cars>(BASE_URL, {
      brand: obj.brand,
      model: obj.model,
      modelYear: obj.modelYear,
      numberOfKilometer: obj.numberOfKilometer,
      price: obj.price
    }, {
      headers: {
        "Content-Type": "application/json",
        Prefer: "return=representation"
      }
    });
  }
}
