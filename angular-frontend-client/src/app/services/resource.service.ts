import { Injectable } from "@angular/core";
import { RESOURCE_URL } from "../shared/constants";
import { HttpService } from "./http.service";

@Injectable({
    providedIn: 'root'
})
export class ResourceService {
    baseUrl = RESOURCE_URL

    constructor(private http: HttpService) {}

    public callHelloAdminEndpoint() {
        return this.http.doGet(`${this.baseUrl}/hello-admin`, this.getReqAuthOptions())
    }

    public callHelloEndpoint() {
        return this.http.doGet(`${this.baseUrl}/hello`, this.getReqAuthOptions())
    }

    public callPublicEndpoint() {
        return this.http.doGet(`${this.baseUrl}/hello-admin`)
    }

    private getReqAuthOptions() {
        const token = sessionStorage.getItem('access_token');
        const bearerToken = `Bearer ${token}`;
        const options = {headers: { 'Authorization': bearerToken}, responseType: 'text'}
        return options;
    }
}