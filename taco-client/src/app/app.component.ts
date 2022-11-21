import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  image: any;
  http: HttpClient;
  title = "taco-client";

  constructor(http: HttpClient) {
    this.http = http;
  }

}
