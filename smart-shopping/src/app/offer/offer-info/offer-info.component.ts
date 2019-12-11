import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OfferService } from 'src/app/services/offer.service';
import { Offer } from 'src/app/models/offer';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { product } from 'src/app/models/product';
import { DatePipe } from '@angular/common';
import { ProductsService } from 'src/app/services/products.service';

@Component({
  selector: 'app-offer-info',
  templateUrl: './offer-info.component.html',
  styleUrls: ['./offer-info.component.css']
})
export class OfferInfoComponent implements OnInit {

  constructor(private route: ActivatedRoute, private offerService: OfferService, private datePipe: DatePipe, private productService: ProductsService) { }
  offer: Offer;
  offerForm: FormGroup;
  productList: any;
  errorMessage: string;
  errorFlag:boolean;

  ngOnInit() {
    this.errorFlag = false;
    this.offerForm = new FormGroup({
      'offerPercentage': new FormControl('', [Validators.required, Validators.pattern('[0-9]+')]),
      'offerDetails': new FormControl('', [Validators.required])
    });
    this.route.paramMap.subscribe(params => {
      this.offerService.getOfferById(params.get('id')).subscribe((response) => {
        this.offer = response;
        let offerDate = this.datePipe.transform(this.offer.offerDate , 'dd/MM/yyyy');
        this.productService.getAllProducts().subscribe(response =>{
          this.productList = response;
        });
        this.offerForm = new FormGroup({
          'offerPercentage': new FormControl(this.offer.offerPercentage, [Validators.required, Validators.pattern('[0-9]+')]),
          'offerDetails': new FormControl(this.offer.offerDetails, [Validators.required])
        });
      });
      });
  }

  update(offerForm){
    this.offer.offerDetails = offerForm.value.offerDetails;
    this.offer.offerPercentage = offerForm.value.offerPercentage;
    this.offerService.updateOffer(this.offer, this.offer.productId.id).subscribe(response=>{
    }, error =>{
      this.errorMessage = error.error.message;
      this.errorFlag = true;
    });
  }

}
