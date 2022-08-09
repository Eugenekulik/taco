import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Taco} from "../domain/Taco";

@Component({
  selector: 'app-tacos',
  templateUrl: './tacos.component.html',
  styleUrls: ['./tacos.component.css']
})
export class TacosComponent implements OnInit {
  http: HttpClient;
  tacos: Taco[] = new Array();

  constructor(http: HttpClient) {
    this.http = http;
  }

  ngOnInit(): void {
    if(this.tacos.length == 0)
      this.getAllTaco().subscribe((response:Taco[])=>{
        this.tacos = response;
      })
  }

  getAllTaco(): Observable<Taco[]> {
      return  this.http.get<Taco[]>("http://localhost:8080/designs/recent");
  }

}
