import { Component, OnInit } from '@angular/core';
import {AuthorizationService} from "../services/authorization.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public authorizationService:AuthorizationService,
  private router:Router) { }

  ngOnInit(): void {
  }

  logout() {
    this.authorizationService.clear();
    this.router.navigate(['/home']);
  }
}
