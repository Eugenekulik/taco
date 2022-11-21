import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Taco} from "../../domain/Taco";

@Component({
  selector: 'app-taco',
  templateUrl: './taco.component.html',
  styleUrls: ['./taco.component.css']
})
export class TacoComponent implements OnInit {

  tacos: Taco[] = new Array<Taco>();

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.getAllTacos().subscribe(resp=>{
      this.tacos = resp as Taco[];
    });
  }

  getAllTacos(){
    return this.http.get<Taco[]>("http://localhost:8080/taco");
  }

  deleteTaco(id:bigint) {
    this.http.delete("http://localhost:8080/taco/" + id).subscribe(console.log);
    window.location.reload();
  }
}

