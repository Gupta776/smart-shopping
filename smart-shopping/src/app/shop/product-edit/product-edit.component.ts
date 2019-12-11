import { Component, OnInit } from '@angular/core';
import { ProductsService } from 'src/app/services/products.service';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productItem: any;
  editProductForm: FormGroup; 
  id: any;
  constructor(private router: Router,
    private routerActive: ActivatedRoute,
    private productService:ProductsService) { 
      
    }

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
    this.id = parseInt(this.routerActive.snapshot.paramMap.get('id'));
    console.log(this.id);
    this.productService.getProductItem(this.id).subscribe((response)=>{
      this.productItem=response;
      console.log(this.productItem);
      this.editProductForm = new FormGroup({
         'id': new FormControl(this.productItem.id, [Validators.required]),
        // 'productCode': new FormControl(this.productItem.productCode, [Validators.required]),
        'productName': new FormControl(this.productItem.productName, [Validators.required]),
        'productType': new FormControl(this.productItem.productType, [Validators.required]),
        'brand': new FormControl(this.productItem.brand, [Validators.required]),
        'quantityType': new FormControl(this.productItem.quantityType, [Validators.required]),
        'ratePerQuantity': new FormControl(this.productItem.ratePerQuantity, [Validators.required]),
        'stockCount': new FormControl(this.productItem.stockCount, [Validators.required]),
        'addDate': new FormControl(new Date(this.productItem.addDate), [Validators.required]),
        'aisle': new FormControl(this.productItem.aisle, [Validators.required]),
        'shelf': new FormControl(this.productItem.shelf, [Validators.required]),
        'dateOfManufacture': new FormControl(new Date(this.productItem.dateOfManufacture), [Validators.required]),
        'dateOfExpiry': new FormControl(new Date(this.productItem.dateOfExpiry), [Validators.required]),
        'image': new FormControl(this.productItem.image, [Validators.required])
      });
    });
  }
  onSubmit(){
    console.log(this.editProductForm.value);
    this.productService.updateProduct(this.editProductForm.value).subscribe((response)=>{
      
      this.router.navigate(['adminMainView']);
    });
  }
}
