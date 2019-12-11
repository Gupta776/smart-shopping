import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { user } from 'src/app/models/user';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signupForm: FormGroup;
  user:user[];
  newUser:user;
  passwordFlag: boolean;
  newUserFlag: boolean =  false;
  existFlag:boolean = false;
  constructor(private userService:UserService) { 

  }

  ngOnInit() {
    this.existFlag = false;
    this.signupForm = new FormGroup(
      {
        'firstName': new FormControl(null, [Validators.required,Validators.maxLength(15),Validators.minLength(2)]),
        'lastName': new FormControl(null, [Validators.required,Validators.maxLength(15),Validators.minLength(2)]),
        'age': new FormControl(null, [Validators.required, Validators.maxLength(2), Validators.pattern('[0-9]+')]),//,Validators.pattern('1[2-9]|0[0-9]'),]),
        'gender': new FormControl(null, [Validators.required]),
        'contactNumber': new FormControl(null, [Validators.required, Validators.maxLength(10), Validators.minLength(10), Validators.pattern("^[0-9]*$")]),
        'userName': new FormControl(null, [Validators.required,Validators.maxLength(15),Validators.minLength(2)]),
        'password': new FormControl(null, [Validators.required]),
        'confirmPassword': new FormControl(null, [Validators.required]),
        'userType': new FormControl(null, [Validators.required]),
        'secretQuestion1': new FormControl(null, [Validators.required]),
        'secretAnswer1': new FormControl(null, [Validators.required]),
        'secretQuestion2': new FormControl(null, [Validators.required]),
        'secretAnswer2': new FormControl(null, [Validators.required]),
        'secretQuestion3': new FormControl(null, [Validators.required]),
        'secretAnswer3': new FormControl(null, [Validators.required])
      });
  }

  onSubmit(){
    console.log("successful submit ");
    if(this.signupForm.value.userType == "U"){
      this.signupForm.value.status = "A";
    }else{
      this.signupForm.value.status = "P";
    }
    this.newUser ={
    firstName: this.signupForm.value.firstName,
    lastName: this.signupForm.value.lastName,
    age: this.signupForm.value.age,
    gender: this.signupForm.value.gender,
    contactNumber: this.signupForm.value.contactNumber,
    userName: this.signupForm.value.userName,
    password: this.signupForm.value.password,
    userType: this.signupForm.value.userType,
    status: this.signupForm.value.status,
    secretQuestion1: this.signupForm.value.secretQuestion1,
    secretAnswer1: this.signupForm.value.secretAnswer1,
    secretQuestion2: this.signupForm.value.secretQuestion2,
    secretAnswer2: this.signupForm.value.secretAnswer2,
    secretQuestion3: this.signupForm.value.secretQuestion3,
    secretAnswer3: this.signupForm.value.secretAnswer3,
    finalRewardPoints: 0
    };
    // this.newUser = this.signupForm.value;
    console.log(this.newUser);
    this.userService.addUser(this.newUser).subscribe((response)=>{
      //console.log(response);
      this.newUserFlag = true;
    },(error)=>{
      console.log("--<signUp component --> error on submit");
      this.existFlag = true;
    });
  }

  passwordMatch() {
    if (this.signupForm.value.password == this.signupForm.value.confirmPassword) {
      this.passwordFlag = true;
    } else {
      this.passwordFlag = false;
    }
  }

}
