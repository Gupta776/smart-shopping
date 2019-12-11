import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './page-view/login/login.component';
import { SignupComponent } from './page-view/signup/signup.component';
import { ShoppingViewComponent } from './shopping-view/shopping-view.component';
import { AdminMainViewComponent } from './admin/admin-main-view/admin-main-view.component';
import { ProductItemComponent } from './shop/product-item/product-item.component';
import { RequestComponent } from './control/request/request.component';
import { ProductEditComponent } from './shop/product-edit/product-edit.component';
import { ProductAddComponent } from './shop/product-add/product-add.component';
import { AdminBillingComponent } from './admin/admin-billing/admin-billing.component';
import { PurchaseHistoryComponent } from './user/purchase-history/purchase-history.component';
import { AuthGuard } from './guard/auth.guard';
import { ForgotPasswordComponent } from './control/forgot-password/forgot-password.component';
import { OfferAddComponent } from './offer/offer-add/offer-add.component';
import { OfferUpdateComponent } from './offer/offer-update/offer-update.component';
import { OfferInfoComponent } from './offer/offer-info/offer-info.component';


const routes: Routes = [
  {path: "", component:ShoppingViewComponent},
  {path:"login", component:LoginComponent},
  {path:"signup", component:SignupComponent},
  {path:"shoppingView", component:ShoppingViewComponent},
  {path: "productListView", component:ProductItemComponent},
  {path:"forgotPassword",component:ForgotPasswordComponent},
  {path:"forgotPassword/:forgot",component:ForgotPasswordComponent},
  {path:"adminMainView", component:AdminMainViewComponent , canActivate:[AuthGuard]},
  {path: "requestPage", component: RequestComponent, canActivate:[AuthGuard]},
  {path: "editProduct/:id", component:ProductEditComponent, canActivate:[AuthGuard]},
  {path: "addProduct", component:ProductAddComponent, canActivate:[AuthGuard]},
  {path:"billPage",component:AdminBillingComponent, canActivate:[AuthGuard]},
  {path:"purchaseHistory",component:PurchaseHistoryComponent, canActivate:[AuthGuard]},
  {path:'offer-add', component: OfferAddComponent, canActivate: [AuthGuard]},
  {path:'offer-update', component: OfferUpdateComponent, canActivate: [AuthGuard]},
  {path:'offer-info/:id', component: OfferInfoComponent, canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
