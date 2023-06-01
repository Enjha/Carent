import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomeComponent} from "./page/home/home.component";
import {CarDetailComponent} from "./page/car-detail/car-detail.component";

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: ':id', component: CarDetailComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
