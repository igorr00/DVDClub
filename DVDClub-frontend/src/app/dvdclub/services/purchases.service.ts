import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Purchase } from '../model/purchase';
import { PurchaseDTO } from '../dto/purchaseDTO';

@Injectable({
  providedIn: 'root'
})
export class PurchasesService {

  apiHost: string = 'http://localhost:8091/';
    headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  getByUserId(id: any): Observable<Purchase[]> {
    return this.http.get<Purchase[]>(this.apiHost + 'purchase/getByUserId?id=' + id, {headers: this.headers});
  }

  add(purchaseDTO: PurchaseDTO): Observable<any> {
    return this.http.post<any>(this.apiHost + 'purchase/add', purchaseDTO, {headers: this.headers});
  }
}
