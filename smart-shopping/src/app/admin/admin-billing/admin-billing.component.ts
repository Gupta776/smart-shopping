import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormGroup } from '@angular/forms';
import { user } from 'src/app/models/user';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
import { ProductsService } from 'src/app/services/products.service';
import { BillDetails, TotalBillDetails } from 'src/app/models/bill_details';
import { Bill } from 'src/app/models/bill';
import { DatePipe } from '@angular/common';
import { BillService } from 'src/app/services/bill.service';
import { UserAuthenticationService } from 'src/app/services/user-authentication.service';
import { OfferService } from 'src/app/services/offer.service';
@Component({
  selector: 'app-admin-billing',
  templateUrl: './admin-billing.component.html',
  styleUrls: ['./admin-billing.component.css']
})
export class AdminBillingComponent implements OnInit {
  detailsOfRewardApllied: any;
  userId: any;
  productList: any;
  product: any;
  amount: any;
  name: any;
  rewardCheckBox: number = 0;
  code1: any;
  private billForm: FormGroup;
  private currentDate: string;
  code: number[] = [0];
  productName: string[] = [''];
  productDetailsList: BillDetails[] = [];
  isBillGenerated: boolean;
  isProductAdded: boolean;
  userList: user;
  totalAmount: any = 0;
  finalBill: Bill;
  productFlag: boolean = false;
  finalBillDetail: TotalBillDetails[] = [];
  finalRewardPoints: any;
  originalAmount: any;
  rewardFinal: any;
  finalAmount: any;
  offerProductList: any;
  constructor(private router: Router,
    private userService: UserService,
    private productService: ProductsService,
    private datePipe: DatePipe,
    private billService: BillService,
    private offerService: OfferService) {
  }
  ngOnInit() {
    this.rewardCheckBox = 0;
    this.userService.getUserList().subscribe(response => {
      this.userList = response;
      console.log("userlist");
      console.log(this.userList);
    });

    this.productService.getAllProducts().subscribe(response => {
      this.productList = response;
    });

    this.isBillGenerated = false;
    this.isProductAdded = false;
    this.currentDate = this.datePipe.transform(new Date(), 'dd/MM/yyyy');

    this.billForm = new FormGroup({
      'userId': new FormControl("", [Validators.required]),
      'purchaseDate': new FormControl(this.currentDate, [Validators.required]),
      'item': new FormControl('', [Validators.required]),
      'quantity': new FormControl('1', [Validators.required])
    });
    this.offerService.getAllOffers().subscribe((response) => {
      this.offerProductList = response;
      console.log("offers");
      console.log(response);
    });

  }

  onAddToBill(billForm) {
    console.log(billForm.value);
    // console.log(billForm.value.item);
    this.productService.getProductItem(billForm.value.item).subscribe(response => {
      this.product = response;
      // console.log(this.product.ratePerQuantity);
      console.log("getproduct");
      
      console.log("jhgsafyjkdj");
      if (this.productFlag == false) {
        this.amount = this.product.ratePerQuantity * billForm.value.quantity;
        this.code1 = this.product.id;
        this.name = this.product.productName;
        // console.log(this.amount);
        // console.log(this.code1);
        // console.log(this.name);
        this.productDetailsList.push({ id: this.product.id, productName: this.product.productName, quantity: billForm.value.quantity, amount: this.amount });
        // console.log(this.productDetailsList);
        this.totalAmount = this.totalAmount + this.amount;
        // console.log("aad" + this.totalAmount);
      }

    });
    // console.log(billForm.value.userId);
    this.userService.getUserById(billForm.value.userId).subscribe((response) => {
      // console.log(response);
      this.finalRewardPoints = response.finalRewardPoints;
      // console.log(this.finalRewardPoints);
    });
  }

  rewardPoints: any;

  onGenerateBill(billForm) {
    console.log(billForm.value);
    console.log(this.productDetailsList);
    if (this.rewardCheckBox == 1) {
      console.log("aaaaaaaaaaaaaaaaaa");
      console.log(this.finalRewardPoints);
      console.log(this.totalAmount - this.finalRewardPoints);
      if (this.totalAmount > this.finalRewardPoints) {
        console.log("greater than");
        this.originalAmount = this.totalAmount - this.finalRewardPoints;
        this.rewardFinal =  this.originalAmount / (100);

      } else {
        console.log("less than");
        this.originalAmount = 0;
        this.rewardFinal = this.finalRewardPoints - this.totalAmount;
      }
      for (let i = 0; i < this.productDetailsList.length; i++) {
        this.finalBillDetail.push({ id: this.productDetailsList[i].id, quantity: this.productDetailsList[i].quantity });

        //for (let i = 0; i < this.productDetailsList.length; i++) {
          // console.log("1");
          //here i ahave to calculate the price of the amount of all the productsand apply offer
          console.log("offerList after reward");
          console.log(this.offerProductList);
          for (let j = 0; j < this.offerProductList.length; j++) {
            console.log("j = " + j);
            console.log(this.offerProductList[j]);
            console.log(this.offerProductList[j].productId.id);
            console.log(this.productDetailsList[i].id);
            if (this.offerProductList[j].productId.id == this.productDetailsList[i].id) {
              console.log("offers ")
              console.log(this.offerProductList[j].offerPercentage);
              // console.log(this.offerProductList[j].offerPercentag)
            }
          }
          //
  
  
          if (this.productDetailsList[i].id == billForm.value.item) {
            // console.log("2");
            this.productFlag = true;
          } else {
            this.productFlag = false;
          }
      //  }
        //end ----------
      }
      var dateParts = billForm.value.purchaseDate.split("/");
      var dateObject = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);

      this.finalAmount = this.originalAmount;
      var intvalue = Math.round( this.rewardPoints);
      console.log("jgfdsagjgkdfsa");
      console.log(intvalue);
      this.finalBill = {
        userId: billForm.value.userId,
        totalAmount: this.totalAmount,
        originalAmount: this.originalAmount,
        finalRewardPoints: this.rewardFinal,
        productList: this.finalBillDetail,
        rewardPoints: this.originalAmount  /(100),
        purchaseDate: dateObject
      }
      console.log(this.finalBill);
      this.billService.generateBill(this.finalBill).subscribe((response) => {
        this.isBillGenerated = true;
      });
    } else {
      for (let i = 0; i < this.productDetailsList.length; i++) {
        this.finalBillDetail.push({ id: this.productDetailsList[i].id, quantity: this.productDetailsList[i].quantity });
      }
      var dateParts = billForm.value.purchaseDate.split("/");
      var dateObject = new Date(+dateParts[2], dateParts[1] - 1, +dateParts[0]);
      this.rewardPoints = (this.totalAmount / (100));
      var intvalue = Math.round( this.rewardPoints);
      console.log("jgfdsagjgkdfsa");
      console.log(this.rewardPoints);
      console.log(intvalue);
      console.log(this.finalRewardPoints);
      this.finalRewardPoints = this.finalRewardPoints + this.rewardPoints;
      console.log(this.finalRewardPoints);
      this.finalAmount = this.totalAmount;
      this.finalBill = {
        userId: billForm.value.userId,
        totalAmount: this.totalAmount,
        originalAmount: this.totalAmount,
        finalRewardPoints: this.finalRewardPoints,
        productList: this.finalBillDetail,
        rewardPoints: this.rewardPoints,
        purchaseDate: dateObject
      }
      console.log(this.finalBill);
      this.billService.generateBill(this.finalBill).subscribe((response) => {
        this.isBillGenerated = true;
      });

    }


    // this.productDetailsList = [];
    // this.totalAmount = 0;
    // this.finalRewardPoints=[];

   // this.router.navigate(['./adminMainView']);
  }







  deleteProduct(list) {
    let index = this.productDetailsList.indexOf(list);
    // console.log("index" + index);
    // console.log(list.amount);
    this.totalAmount = this.totalAmount - list.amount;
    // console.log("del" + this.totalAmount);
    this.productDetailsList.splice(index, 1);
  }
  onDropBill() {
    this.productDetailsList = null;
    this.totalAmount = 0;
    this.finalRewardPoints = [];
   this.detailsOfRewardApllied=null;
  //  //this.ngOnInit();
    this.router.navigate(['./adminMainView']);
  }
  checkBoxApply() {
    this.rewardCheckBox = 1;
    this.detailsOfRewardApllied = "Applied";
    console.log(this.rewardCheckBox);
  }
  checkBoxCancle() {
    this.rewardCheckBox = 0;
    this.detailsOfRewardApllied = "Cancelled";
    console.log(this.rewardCheckBox);
  }
}
