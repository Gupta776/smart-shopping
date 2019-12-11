import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserAuthenticationService } from './user-authentication.service';
import { environment } from 'src/environments/environment.prod';
import { Offer } from '../models/offer';

@Injectable({
  providedIn: 'root'
})
export class OfferService {
  baseUrl = environment.baseUrl;
  constructor( private httpClient : HttpClient,
    private userAuthService: UserAuthenticationService) { }

  addOffer(offer){
    let token = "Bearer "+ this.userAuthService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.post<any[]>(this.baseUrl+'/offer/'+offer.product,offer ,  httpOption);
  }

  updateOffer(offer: Offer,id){
    let token = "Bearer "+ this.userAuthService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.put<any[]>(this.baseUrl+'/offer/'+id ,offer ,  httpOption);
  }

  deleteOffer(id){
    let token = "Bearer "+ this.userAuthService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.delete(this.baseUrl+'/offer/'+id ,  httpOption);
  }

  getOfferByDate(date){
    let token = "Bearer "+ this.userAuthService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.get<any[]>(this.baseUrl+'/offer-list/'+date , httpOption);
  }

  getOfferById(id){
    let token = "Bearer "+ this.userAuthService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.get<any>(this.baseUrl+'/offer/'+id , httpOption);
  }

  getCurrentOffer(){
    let token = "Bearer "+ this.userAuthService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.get<any>(this.baseUrl+'/offer', httpOption);
  }
  getAllOffers(){
    let token = "Bearer "+ this.userAuthService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.get<any>(this.baseUrl+'/allOffers', httpOption);
  }
}
