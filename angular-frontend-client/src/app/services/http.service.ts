import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class HttpService {
    constructor(private http: HttpClient) {}

    doGet(url: string, options?: {}) {
        return this.http.get(url, options)
    }

    doPost(url: string, body: any, options: {}) {
        return this.http.post(url, body, options);
    }
}