import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-shopping-view',
  templateUrl: './shopping-view.component.html',
  styleUrls: ['./shopping-view.component.css']
})
export class ShoppingViewComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  redirectToProductList(){
    this.router.navigate(["productListView"]);
  }

}
