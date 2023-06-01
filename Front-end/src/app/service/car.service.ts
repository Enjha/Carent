import {HttpClient} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {Car, Cars} from "../model/car";

const BASE_URL = 'http://localhost:8080/api/cars';
@Injectable()
export class CarService {

  constructor(private http: HttpClient) {
  }

  findOne(id: number): Observable<Cars> {
    return this.http.get<Cars>(BASE_URL + '?id=eq.' + id, {
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
      fullName: obj.fullName,
      email: obj.email
    }, {
      headers: {
        "Content-Type": "application/json",
        Prefer: "return=representation"
      }
    });
  }
}
