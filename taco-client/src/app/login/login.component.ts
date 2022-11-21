import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {AuthenticationService} from "../services/authentication.service";
import {NgForm} from "@angular/forms";
import {AuthorizationService} from "../services/authorization.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authenticationService: AuthenticationService,
              private authorizationService:AuthorizationService,
              private router:Router) {}

  ngOnInit(): void {
  }

  doLogin(loginForm: NgForm) {
    console.log(loginForm.value);
    this.authenticationService.generateToken(loginForm.value).subscribe(
      (response:any) => {
        this.authorizationService.setToken(response.token);
        this.authorizationService.setRoles(response.roles);
        this.authorizationService.setUsername(response.username);
        this.router.navigate(['/home']);
      }, (error) => {
        console.log(error)
      }
    );
  }

  registrate(registrateForm: NgForm){
    this.authenticationService.registrate(registrateForm.value).subscribe((data:any)=> {
          this.authorizationService.setToken(data.token);
          this.authorizationService.setRoles(data.roles);
          this.authorizationService.setUsername(data.username);
          document.getElementById('closeModal')?.click();
          this.router.navigate(['/home']);
        }, (error) => {
          console.log(error)
        });
  }


}
