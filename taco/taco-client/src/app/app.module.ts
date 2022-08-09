import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { TacosComponent } from './tacos/tacos.component';
import { HomeComponent } from './home/home.component';
import {AppRoutingModule} from "./app-routing.module";
import { DesignComponent } from './design/design.component';
import { OrdersComponent } from './orders/orders.component';
import { AboutComponent } from './about/about.component';
//import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    TacosComponent,
    HomeComponent,
    DesignComponent,
    OrdersComponent,
    AboutComponent,
    //LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
