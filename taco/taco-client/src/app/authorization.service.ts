import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthorizationService {

  http: HttpClient;

  token: any;

  constructor(http: HttpClient) {
    this.http = http;
  }


  public generateToken(username: string, password: string) {
    let headers = new HttpHeaders().append("username", username).append("password", password);
    let responce = this.http.post("http://localhost:8080/login", headers);
    responce.subscribe(data => this.token = data);
  }

  public getToken(): String {
    if(this.token!=null) {
      return "Bearer " + this.token;
    }
    return "";
  }
}
