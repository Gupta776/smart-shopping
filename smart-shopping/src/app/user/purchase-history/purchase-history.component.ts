import { Component, OnInit } from '@angular/core';
import { BillService } from 'src/app/services/bill.service';
import { ProductsService } from 'src/app/services/products.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { UserAuthenticationService } from 'src/app/services/user-authentication.service';

@Component({
  selector: 'app-purchase-history',
  templateUrl: './purchase-history.component.html',
  styleUrls: ['./purchase-history.component.css']
})
export class PurchaseHistoryComponent implements OnInit {
billDetails: any[];

  constructor(private billService:BillService,
    private productService:ProductsService,
    private userAuthService:UserAuthenticationService) { }

  ngOnInit() {
    this.billService.getBill(this.userAuthService.getUserName()).subscribe((response)=>{
      console.log(response);
      this.billDetails = response;


      this.billDetails.forEach(resp =>{
        resp.billDetailsList.forEach(resp1 =>{
          this.productService.getProductItem(resp1.id).subscribe(response1 =>{
            resp1['productDetails'] = response1;
        })
        })
        
      })
    })


  }

  productList: any[];
  detailsFlag: boolean;
  currentBillId: number = 0;
  getProductDetails(billDetailsList: any[]){
    this.detailsFlag = true;
    let i = 0;
    this.productList = [];
    billDetailsList.forEach(resp =>{
      this.productList.push(resp.productDetails);
    })
    for(let i=0; i<billDetailsList.length ; i++){
      this.productList[i]['quantity'] = billDetailsList[i].quantity;
    }


  }


}
