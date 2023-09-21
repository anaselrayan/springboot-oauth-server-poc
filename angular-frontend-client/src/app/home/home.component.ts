import { Component } from '@angular/core';
import { take } from 'rxjs';
import { ResourceService } from '../services/resource.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  responseMsg = ''
  constructor(private resourceService: ResourceService) {}

  callHelloAdmin() {
    this.resourceService
        .callHelloAdminEndpoint()
        .pipe(take(1))
        .subscribe(res => {
          console.log(res)
          this.responseMsg = res.toString()
        },
        error => {
          this.responseMsg = error.status
        }
      )
  }

  callHello() {
    this.resourceService
        .callHelloEndpoint()
        .pipe(take(1))
        .subscribe(res => {
          console.log(res)
          this.responseMsg = res.toString()
        })
  }
}
