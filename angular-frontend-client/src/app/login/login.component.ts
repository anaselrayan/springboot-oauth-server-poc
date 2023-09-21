import { Component } from '@angular/core';
import { AUTH_URL } from '../shared/constants';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  authUrl = AUTH_URL
  login() {
    window.location.href = this.authUrl
  }
}
