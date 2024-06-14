import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Marketplace } from '../model/marketplace';
import { MarketplaceDTO } from '../dto/marketplaceDTO';

@Injectable({
  providedIn: 'root'
})
export class MarketplacesService {

  apiHost: string = 'http://localhost:8091/';
    headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  getAll(): Observable<Marketplace[]> {
    return this.http.get<Marketplace[]>(this.apiHost + 'marketplace/getAll', {headers: this.headers});
  }

  add(marketplaceDTO: MarketplaceDTO): Observable<any> {
    return this.http.post<any>(this.apiHost + 'marketplace/add', marketplaceDTO, {headers: this.headers});
  }

  getById(id: any): Observable<Marketplace> {
    return this.http.get<Marketplace>(this.apiHost + 'marketplace/getById?id=' + id, {headers: this.headers});
  }

  edit(marketplace: Marketplace): Observable<any> {
    return this.http.post<any>(this.apiHost + 'marketplace/edit', marketplace, {headers: this.headers});
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(this.apiHost + 'marketplace/delete?id=' + id, {headers: this.headers});
  }
}
