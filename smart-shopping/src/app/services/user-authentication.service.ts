import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserAuthenticationService {
  private authenticationUrl = "http://localhost:8099/authentication-service/smart-shopping/authentication";
  // private authenticationUrl = "http://localhost:8100/smart-shopping/authentication";
  private token: String;
  private userName :String;
  private userType:String;
  private status:String;
  private firstName: String;

  constructor(private httpClient: HttpClient) { }

  authenticate(user: String, password: String): Observable<any> {
    let credentials = btoa(user + ":" + password);
    let headers = new HttpHeaders();
    headers = headers.set("Authorization", "Basic " + credentials);
    return this.httpClient.get(this.authenticationUrl, {headers});
  }
  public setToken(token: String) {
    this.token = token;
  }
  public getToken() {
    return this.token;
  }
  public setUserName(userName:String){
    this.userName=userName;
  }
  public getUserName() {
    return this.userName;
  }
  public setUserType(userType:String){
    this.userType=userType;
  }
  public getUserType() {
    return this.userType;
  }
  public setStatus(status:String){
    this.status=status;
  }
  public getStatus() {
    return this.status;
  }
  public setFirstName(firstName:String){
    this.firstName=firstName;
  }
  public getFirstName() {
    return this.firstName;
  }

}
