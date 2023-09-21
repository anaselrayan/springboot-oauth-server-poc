import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { take } from 'rxjs';
import { AuthService } from '../services/auth.service';
import { TokenResponse } from '../shared/token-response';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  
  constructor(private activeRoute: ActivatedRoute,
     private authService: AuthService,
     private router: Router) {}

  ngOnInit(): void {
    this.fetchAuthorizationCode()
    this.authService
        .getAccessToken()
        .pipe(take(1))
        .subscribe(res => {
          console.log(res)
          this.storeToken(res)
          this.router.navigate(['home'])
        })
  }

  fetchAuthorizationCode() {
    this.activeRoute.queryParams.subscribe((params) => {
      if (params?.['code'])
        this.authService.authCode = params['code'];
    })  
  }

  storeToken(res: TokenResponse) {
    sessionStorage.setItem('access_token', res.access_token);
  }

}
