import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { user } from '../models/user';
import { UserAuthenticationService } from './user-authentication.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
    // private authenticationUrl = "http://localhost:8100/smart-shopping/authentication";
    private signupUrl = "http://localhost:8099/authentication-service/smart-shopping/users";

  user = new Array<user>();
  baseUrl = environment.baseUrl
  constructor(private httpClient:HttpClient,
    private userAuthService :UserAuthenticationService) { }

getUser(){
  return this.getUser;
}

addUser(newUser: user) {
  console.log(newUser);
  return this.httpClient.post<any>(this.signupUrl,newUser);
}

getALLAdmins(){
  let token = "Bearer "+ this.userAuthService.getToken();
    const httpOptions = {
      headers : new HttpHeaders ({
        'Content-Type' : 'application/json',
        'Authorization' : token
      })
    };
    return this.httpClient.get<any>(this.baseUrl+"/users/all-admins",httpOptions);
  
}

getUserList(){
  let token = "Bearer " + this.userAuthService.getToken();
  const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': token
    })
  };
  return this.httpClient.get<any>(this.baseUrl + '/users/all-users', httpOptions);
}
approveAdmin(admin: user){
  admin.status = 'A';
  let token = "Bearer "+ this.userAuthService.getToken();
  const httpOptions = {
    headers : new HttpHeaders ({
      'Content-Type' : 'application/json',
      'Authorization' : token
    })
  };
  console.log(admin);
  return this.httpClient.put<any>(this.baseUrl+"/users/approve",admin,httpOptions);

}

declineAdmin(admin: user){
  admin.status = 'D';
  let token = "Bearer "+ this.userAuthService.getToken();
  const httpOptions = {
    headers : new HttpHeaders ({
      'Content-Type' : 'application/json',
      'Authorization' : token
    })
  };
  console.log(admin);
  return this.httpClient.put<any>(this.baseUrl+"/users/approve",admin,httpOptions);

}

getUserByUserName(userName: any){
  let token = "Bearer "+ this.userAuthService.getToken();
  const httpOptions = {
    headers : new HttpHeaders ({
      'Content-Type' : 'application/json',
      'Authorization' : token
    })
  };
  console.log(userName);
  return this.httpClient.get<any>(this.baseUrl+"/users/"+userName,httpOptions);

}
getUserById(id){
  let token = "Bearer "+ this.userAuthService.getToken();
  const httpOptions = {
    headers : new HttpHeaders ({
      'Content-Type' : 'application/json',
      'Authorization' : token
    })
  };
  console.log(id);
  return this.httpClient.get<any>(this.baseUrl+"/users/user/"+id,httpOptions);
}
getUserById1(userName){
 
  console.log(userName);
  return this.httpClient.get<any>(this.baseUrl+"/users/user1/"+userName);
}
getUserByContactNumber(contactNumber){
  console.log(contactNumber);
  return this.httpClient.get<any>("http://localhost:8099/product-service/smart-shopping/users/contact-number/"+ contactNumber);
}

updateUserWithNewPassword(user: user){
  return this.httpClient.put<any>(this.baseUrl+"/users/new-password", user);
}

}
