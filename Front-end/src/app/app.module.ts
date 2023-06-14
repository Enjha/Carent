import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './page/home/home.component';
import {CarService} from "./service/car.service";
import {HttpClientModule} from "@angular/common/http";
import { CarDetailComponent } from './page/car-detail/car-detail.component';
import { CarCreateComponent } from './page/car-create/car-create.component';
import { CarFormComponent } from './form/car-form/car-form.component';
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    CarDetailComponent,
    CarCreateComponent,
    CarFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [CarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
