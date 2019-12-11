import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from './page-view/signup/signup.component';
import { HeaderComponent } from './page-view/header/header.component';
import { FooterComponent } from './page-view/footer/footer.component';
import { LoginComponent } from './page-view/login/login.component';
import { ShoppingViewComponent } from './shopping-view/shopping-view.component';
import { AdminMainViewComponent } from './admin/admin-main-view/admin-main-view.component';
import { AdminBillingComponent } from './admin/admin-billing/admin-billing.component';
import { ProductDetailsComponent } from './shop/product-details/product-details.component';
import { ProductItemComponent } from './shop/product-item/product-item.component';
import { SearchProductComponent } from './shop/search-product/search-product.component';
import { ProductEditComponent } from './shop/product-edit/product-edit.component';
import { RequestComponent } from './control/request/request.component';
import { ProductAddComponent } from './shop/product-add/product-add.component';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DatePipe } from '@angular/common';
import { PurchaseHistoryComponent } from './user/purchase-history/purchase-history.component';
import { ForgotPasswordComponent } from './control/forgot-password/forgot-password.component';
import { OfferInfoComponent } from './offer/offer-info/offer-info.component';
import { OfferUpdateComponent } from './offer/offer-update/offer-update.component';
import { OfferAddComponent } from './offer/offer-add/offer-add.component';

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    ShoppingViewComponent,
    AdminMainViewComponent,
    AdminBillingComponent,
    ProductDetailsComponent,
    ProductItemComponent,
    SearchProductComponent,
    ProductEditComponent,
    RequestComponent,
    ProductAddComponent,
    PurchaseHistoryComponent,
    ForgotPasswordComponent,
    OfferInfoComponent,
    OfferUpdateComponent,
    OfferAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    BsDatepickerModule.forRoot(),
    BrowserAnimationsModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
