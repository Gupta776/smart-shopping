import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserAuthenticationService } from './user-authentication.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  baseUrl = environment.baseUrl;
  constructor(private httpClient:HttpClient, private userAuthService:UserAuthenticationService) { }

  httpOptions = {
    headers : new HttpHeaders ({
      'Content-Type' : 'application/json'
    })
  };

  getAllProducts(){
    let token = "Bearer "+ this.userAuthService.getToken();
    const httpOptions = {
      headers : new HttpHeaders ({
        'Content-Type' : 'application/json',
        'Authorization' : token
      })
    };
    return this.httpClient.get(this.baseUrl+"/products",httpOptions);
  }

  getProductItem(id: any){
    let token = "Bearer "+ this.userAuthService.getToken();
    const httpOptions = {
      headers : new HttpHeaders ({
        'Content-Type' : 'application/json',
        'Authorization' : token
      })
    };
    return this.httpClient.get(this.baseUrl+"/products/"+id,httpOptions);
  }
  updateProduct(productItem : any){
    console.log("updateProduct")
    let token = "Bearer "+ this.userAuthService.getToken();
    const httpOptions = {
      headers : new HttpHeaders ({
        'Content-Type' : 'application/json',
        'Authorization' : token
        
      })
    };
    return this.httpClient.put<any>(this.baseUrl+"/products",productItem,httpOptions);
  }

  addProduct(productItem :any){
    console.log("addProduct")
    let token = "Bearer "+ this.userAuthService.getToken();
    const httpOptions = {
      headers : new HttpHeaders ({
        'Content-Type' : 'application/json',
        'Authorization' : token
        
      })
    };
    return this.httpClient.post<any>(this.baseUrl+"/products",productItem,httpOptions);
  }

  deleteProduct(id:any){
    console.log("delete")
    let token = "Bearer "+ this.userAuthService.getToken();
    const httpOptions = {
      headers : new HttpHeaders ({
        'Content-Type' : 'application/json',
        'Authorization' : token
        
      })
    };
    return this.httpClient.delete<any>(this.baseUrl+"/products/"+id,httpOptions);
  }
  getProductByPopularity(){
    let token = "Bearer "+ this.userAuthService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.get<any>(this.baseUrl+"/products/sort-by-popularity", httpOption);
  }
}
