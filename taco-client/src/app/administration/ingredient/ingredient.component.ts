import { Component, OnInit } from '@angular/core';
import {Ingredient} from "../../domain/Ingredient";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-ingredient',
  templateUrl: './ingredient.component.html',
  styleUrls: ['./ingredient.component.css']
})
export class IngredientComponent implements OnInit {
  ingredients: Ingredient[] = new Array<Ingredient>();

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.getAllIngredients().subscribe(resp=>{
      this.ingredients = resp as Ingredient[];
    })
  }

  getAllIngredients(){
    return this.http.get("http://localhost:8080/ingredient");
  }

  deleteIngredient(id:string) {
    this.http.delete("http://localhost:8080/ingredient/" + id).subscribe(console.log);
    window.location.reload();
  }
}
