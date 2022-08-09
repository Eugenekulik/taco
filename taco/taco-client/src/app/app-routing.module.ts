import {NgModule} from '@angular/core';
import {Routes, RouterModule} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {TacosComponent} from "./tacos/tacos.component";
import {AboutComponent} from "./about/about.component";
import {OrdersComponent} from "./orders/orders.component";
import {DesignComponent} from "./design/design.component";
/*import {LoginComponent} from "./login/login.component";*/


const routes: Routes = [
  {path: '/', component: HomeComponent},
  /*{path: 'login', component: LoginComponent},*/
  {path: 'tacos', component: TacosComponent},
  {path: 'design', component: DesignComponent},
  {path: 'orders', component: OrdersComponent},
  {path: 'about', component: AboutComponent}
];

@NgModule(
  {
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  }
)
export class AppRoutingModule{}

