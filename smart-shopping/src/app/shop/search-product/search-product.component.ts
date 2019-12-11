import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search-product',
  templateUrl: './search-product.component.html',
  styleUrls: ['./search-product.component.css']
})
export class SearchProductComponent implements OnInit {
@Output() newProductList: any;
@Output() sortEmitter: any;
searchData: String;
sortType: String;

  constructor() { 
    this.newProductList = new EventEmitter;
    this.sortEmitter = new EventEmitter;
  }

  ngOnInit() {
  }
  filterData() {
    this.newProductList.emit(this.searchData);
  }
  sort(){
    this.sortEmitter.emit(this.sortType);
  }
}
