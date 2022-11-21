import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { TacosComponent } from './tacos/tacos.component';
import { HomeComponent } from './home/home.component';
import {AppRoutingModule} from "./app-routing.module";
import { OrdersComponent } from './orders/orders.component';
import { AboutComponent } from './about/about.component';
import {LoginComponent} from "./login/login.component";
import { HeaderComponent } from './header/header.component';
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {AuthGuard} from "./services/auth.guard";
import {AuthInterceptor} from "./services/auth.interceptor";
import {AuthenticationService} from "./services/authentication.service";
import { AdministrationComponent } from './administration/administration.component';
import { UserComponent } from './administration/user/user.component';
import { TacoComponent } from './administration/taco/taco.component';
import { OrderComponent } from './administration/order/order.component';
import { IngredientComponent } from './administration/ingredient/ingredient.component';


@NgModule({
  declarations: [
    AppComponent,
    TacosComponent,
    HomeComponent,
    OrdersComponent,
    AboutComponent,
    LoginComponent,
    HeaderComponent,
    AdministrationComponent,
    UserComponent,
    TacoComponent,
    OrderComponent,
    IngredientComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    RouterModule
  ],
  providers: [
    AuthGuard,
    {
      provide:HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true
    },
    AuthenticationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
