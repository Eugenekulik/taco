import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AuthorizationService} from "../authorization.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:string = "";
  password:string = "";
  auth:AuthorizationService

  constructor(auth:AuthorizationService) {this.auth = auth; }

  ngOnInit(): void {
  }

  doLogin(){
     this.auth.generateToken(this.username, this.password);
  }




}
