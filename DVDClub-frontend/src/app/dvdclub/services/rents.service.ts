import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Rent } from '../model/rent';
import { RentDTO } from '../dto/rentDTO';

@Injectable({
  providedIn: 'root'
})
export class RentsService {

  apiHost: string = 'http://localhost:8091/';
    headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  getByUserId(id: any): Observable<Rent[]> {
    return this.http.get<Rent[]>(this.apiHost + 'rent/getByUserId?id=' + id, {headers: this.headers});
  }

  getByMarketplaceId(id: any): Observable<Rent[]> {
    return this.http.get<Rent[]>(this.apiHost + 'rent/getByMarketplaceId?id=' + id, {headers: this.headers});
  }

  add(rentDTO: RentDTO): Observable<any> {
    return this.http.post<any>(this.apiHost + 'rent/add', rentDTO, {headers: this.headers});
  }

  changeStatus(id: any, status: any): Observable<any> {
    return this.http.post<any>(this.apiHost + 'rent/changeStatus?id=' + id + '&status=' + status, {headers: this.headers});
  }
}
