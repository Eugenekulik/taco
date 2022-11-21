import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Order} from "../../domain/Order";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  orders: Order[] = new Array<Order>();

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.getAllOrders().subscribe(resp=>{
      this.orders = resp as Order[];
    })
  }

  getAllOrders(){
    return this.http.get("http://localhost:8080/order")
  }

  deleteOrder(id:bigint) {
    this.http.delete("http://localhost:8080/order/" + id).subscribe(console.log);
    window.location.reload();
  }
}
