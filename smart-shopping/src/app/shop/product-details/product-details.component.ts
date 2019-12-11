import { Component, OnInit, Input, Output ,EventEmitter} from '@angular/core';
import { product } from 'src/app/models/product';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { UserAuthenticationService } from 'src/app/services/user-authentication.service';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  @Input() item: product;
  @Output() deleteEmitter:any;
  userName: String;
  userType: any;
 
  constructor(private router: Router,private userAuthService:UserAuthenticationService,
    private productService:ProductsService) {
      this.deleteEmitter = new EventEmitter();
    this.userName = this.userAuthService.getUserName();
    this.userType=this.userAuthService.getUserType();
   }

  ngOnInit() {


  }
  editProduct(id){
    console.log(id);
    this.router.navigate(["/editProduct",id]);
  }
  deleteProduct(id){
    this.deleteEmitter.emit(id);
  }
}
