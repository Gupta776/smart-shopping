import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-main-view',
  templateUrl: './admin-main-view.component.html',
  styleUrls: ['./admin-main-view.component.css']
})
export class AdminMainViewComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }
billing(){
  this.router.navigate(['/billPage']);
}
}
