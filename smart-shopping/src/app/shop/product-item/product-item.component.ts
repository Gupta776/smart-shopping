import { Component, OnInit } from '@angular/core';
import { UserAuthenticationService } from 'src/app/services/user-authentication.service';
import { ProductsService } from 'src/app/services/products.service';
import { product } from 'src/app/models/product';

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {
productList: any;
filterProductData: any;
userType: any;
userName: any;
  constructor(private userAuthService:UserAuthenticationService,
    private productService:ProductsService) { 
      
  }

  ngOnInit() {
    this.getAllProducts();
  }
  getAllProducts(){
    this.productService.getAllProducts().subscribe((response)=>{
      this.productList = response;
      this.filterProductData = this.productList;
      this.userName = this.userAuthService.getUserName();
      this.userType=this.userAuthService.getUserType();
    },(error)=>{
      console.log(error);
    });
  }
  deleteProduct($event){
    this.productService.deleteProduct($event).subscribe((response)=>{
      // this.router.navigate(['productListView']);
      this. getAllProducts();
    });
  }

  searchProduct($event) {
    this.filterProductData = this.productList.filter(
      (item:product) => item.productName.toLocaleLowerCase().indexOf($event) != -1);
  }
  sort($event){
    if($event == "name"){
      this.filterProductData =   this.filterProductData.sort((obj1, obj2) => {
        if (obj1.productName > obj2.productName) {
            return 1;
        }
        if (obj1.productName < obj2.productName) {
            return -1;
        }
        return 0;
    });
    }
    if($event == "price"){
      this.filterProductData =   this.filterProductData.sort((obj1, obj2) => {
        if (obj1.ratePerQuantity > obj2.ratePerQuantity) {
            return 1;
        }
        if (obj1.ratePerQuantity < obj2.ratePerQuantity) {
            return -1;
        }
        return 0;
    });
    }
    if($event == "stock"){
      this.filterProductData =   this.filterProductData.sort((obj1, obj2) => {
        if (obj1.stockCount > obj2.stockCount) {
            return 1;
        }
        if (obj1.stockCount < obj2.stockCount) {
            return -1;
        }
        return 0;
    });
    }
    if($event == "popular"){
      this.productService.getProductByPopularity().subscribe(response =>{
        console.log("sort by popularuity");
        console.log(response);
        this.filterProductData = response;
      })
    }
  }

}
