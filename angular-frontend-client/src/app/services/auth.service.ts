import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { TOKEN_URL } from "../shared/constants";
import { HttpService } from "./http.service";

@Injectable({
    providedIn: 'root'
})
export class AuthService {
    authCode!: string;
    constructor(private httpService: HttpService) {}

    getAccessToken(): Observable<any> {
        const clientId = 'spa';
        const clientSecret = 'secret1';
        const basicAuth = `Basic ` + btoa(`${clientId}:${clientSecret}`)
        
        return this.httpService.doPost(`${TOKEN_URL}&code=${this.authCode}`, null, {
            headers: {'content-type': 'application/json', 'Authorization': basicAuth}
        })
    }
}