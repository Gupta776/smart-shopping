import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductsService } from 'src/app/services/products.service';
import { FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {
  productItem: any;
  editProductForm: FormGroup; 
  id: any;
  constructor(private router: Router,
    private routerActive: ActivatedRoute,
    private productService:ProductsService) { }

  ngOnInit() {
    this.editProductForm = new FormGroup({
      'id': new FormControl("", [Validators.required]),
     // 'productCode': new FormControl("", [Validators.required]),
     'productName': new FormControl("", [Validators.required]),
     'productType': new FormControl("", [Validators.required]),
     'brand': new FormControl("", [Validators.required]),
     'quantityType': new FormControl("", [Validators.required]),
     'ratePerQuantity': new FormControl("", [Validators.required]),
     'stockCount': new FormControl("", [Validators.required]),
     'addDate': new FormControl("", [Validators.required]),
     'aisle': new FormControl("", [Validators.required]),
     'shelf': new FormControl("", [Validators.required]),
     'dateOfManufacture': new FormControl("", [Validators.required]),
     'dateOfExpiry': new FormControl("", [Validators.required]),
     'image': new FormControl("", [Validators.required])
   });
  }
  onSubmit(){
    console.log(this.editProductForm.value);
    this.productService.addProduct(this.editProductForm.value).subscribe((response)=>{
      this.router.navigate(['productListView']);
    });
  }

}
