import { Component, OnInit } from '@angular/core';
import {Taco} from "../domain/Taco";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-tacos',
  templateUrl: './tacos.component.html',
  styleUrls: ['./tacos.component.css']
})
export class TacosComponent implements OnInit {

  tacos: Taco[] = new Array<Taco>;

  constructor(private http:HttpClient) {}

  ngOnInit(): void {
    if(this.tacos.length == 0)
      this.getAllTaco().subscribe(response => {
        this.tacos = response as Taco[];
      });
  }

  getAllTaco(){
    return this.http.get<Taco[]>("http://localhost:8080/taco");
  }

}
