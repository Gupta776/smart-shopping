import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment.prod';
import { UserAuthenticationService } from './user-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class BillService {

  baseUrl = environment.baseUrl;
  constructor(private httpClient: HttpClient, private authService: UserAuthenticationService) { }

  generateBill(finalBill){
    console.log(finalBill);
    console.log(this.authService.getToken());
    let token = "Bearer " + this.authService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.post<any>(this.baseUrl + '/bills', finalBill, httpOptions);
  }

  getBill(userName){
    console.log(userName);
    let token = "Bearer " + this.authService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': token
      })

    };
    return this.httpClient.get<any>(this.baseUrl + '/bills/'+userName, httpOptions);

  }
}
