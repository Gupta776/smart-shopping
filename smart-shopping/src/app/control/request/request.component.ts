import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent implements OnInit {
adminList: any;
pendingList: any;
  constructor(private router :Router,
    private userService:UserService) { }

  ngOnInit() {
    console.log("request")
    this.getAllAdmins();
  }
  getAllAdmins(){
    this.userService.getALLAdmins().subscribe((response)=>{
      console.log(response);
      this.adminList = response;
      // if(this.adminList.status == 'P'){
      //   this.pendingList = this.adminList;
      // }
      console.log(this.adminList);
      // var count = Object.keys(this.adminList).length;

    });
  }
  approve(property: any){
    // if()
    console.log("hi");
    // this.adminList.status = 'A';
    console.log(property);
    this.userService.approveAdmin(property).subscribe((response)=>{
      this.getAllAdmins();
    }
    );
  }
  decline(property: any){
    // if()
    console.log("hi");
    // this.adminList.status = 'A';
    console.log(property);
    this.userService.declineAdmin(property).subscribe((response)=>{
      this.getAllAdmins();
    });
  }


}
