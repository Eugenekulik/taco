import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../../domain/User";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users:User[] = new Array<User>;
  constructor(private http:HttpClient, private router:Router) { }

  ngOnInit(): void {
      this.getUsers().subscribe(responce => {
            this.users = responce as User[];
        }
      );
  }

  getUsers(){
    return this.http.get("http://localhost:8080/user");
  }

  delete(id:bigint) {
      this.http.delete("http://localhost:8080/user/" + id).subscribe(resp => {
        console.log(resp);
      })
      window.location.reload();

  }
}
