import { Component, OnInit } from '@angular/core';

import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UserAuthenticationService } from 'src/app/services/user-authentication.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  errorFlag: boolean = false;
  userFlag:boolean = false;
  loginFlag:boolean =false;
  pendingFlag:boolean=false;
  error : any;
  constructor(private router: Router,
    private routerActive:ActivatedRoute,
    private userAuthService: UserAuthenticationService,
    private authService: AuthenticationService) {
  }
  ngOnInit() {
    
    this.errorFlag = false;
    this.userFlag = false;
    this.loginFlag =false;
    this.pendingFlag=false;
    this.loginForm = new FormGroup({
           'userName': new FormControl(null, [Validators.required,
           ]),
           'password': new FormControl(null, [Validators.required])
         });
  }
  goToForgotUserID(){
    this.router.navigate(['/forgotPassword','id']);
  }

  goToForgotPassword(){
    this.router.navigate(['/forgotPassword','password']);
  }
  onSubmit(){
    console.log(this.loginForm.value);
    this.userAuthService.authenticate(this.loginForm.value.userName,
                                      this.loginForm.value.password)
    .subscribe((response)=>{
      if(response.status == 'P'){
        this.pendingFlag=true;
        this.userAuthService.setToken(null);
        this.userAuthService.setUserType(null);
        this.userAuthService.setUserName(null);
        this.userAuthService.setStatus(null);
        this.userAuthService.setFirstName(null);
      }else{
        this.pendingFlag=false;
      console.log("inside the service");
      console.log(response);
      this.loginFlag = true;
      this.userAuthService.setToken(response.token);
      this.userAuthService.setUserType(response.userType);
      this.userAuthService.setUserName(response.userName);
      this.userAuthService.setStatus(response.status);
      this.userAuthService.setFirstName(response.firstName);
      this.authService.login(this.loginForm.value.userName);//just ask ramesh wheather we need to use the authservice
      if(response.userType == 'A' && response.status=='A'){
      this.router.navigate(["./adminMainView"]);
      }else if(response.userType == 'U' && response.status=='A'){
        this.router.navigate(["shoppingView"]);
      }else if(response.userType == 'O' && response.status=='A'){
        this.router.navigate(["requestPage"]);
      }}
    },(error)=>{
      this.error = "invalid username/ password";
      this.errorFlag = true;
    });
  }
  getStatus(){
    return this.userAuthService.getStatus();
  }
  
}
