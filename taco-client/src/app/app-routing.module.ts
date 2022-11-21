import {NgModule} from '@angular/core';
import {Routes, RouterModule} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {TacosComponent} from "./tacos/tacos.component";
import {AboutComponent} from "./about/about.component";
import {OrdersComponent} from "./orders/orders.component";
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./services/auth.guard";
import {AdministrationComponent} from "./administration/administration.component";
import {UserComponent} from "./administration/user/user.component";
import {TacoComponent} from "./administration/taco/taco.component";
import {IngredientComponent} from "./administration/ingredient/ingredient.component";
import {OrderComponent} from "./administration/order/order.component";


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'tacos', component: TacosComponent, canActivate:[AuthGuard],data:{roles:['USER','ADMIN']}},
  {path: 'orders', component: OrdersComponent, canActivate:[AuthGuard],data:{roles:['USER']}},
  {path: 'about', component: AboutComponent},
  {path: 'administration', component: AdministrationComponent, canActivate:[AuthGuard],data:{roles:['ADMIN']},
  children:[
    {path: 'user',component:UserComponent},
    {path: 'taco',component:TacoComponent},
    {path: 'order',component:OrderComponent},
    {path: 'ingredient',component:IngredientComponent}
  ]}
];

@NgModule(
  {
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  }
)
export class AppRoutingModule{}

