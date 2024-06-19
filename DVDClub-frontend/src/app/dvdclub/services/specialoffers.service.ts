import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SpecialOffer } from '../model/specialoffer';
import { SpecialOfferDTO } from '../dto/specialofferDTO';

@Injectable({
  providedIn: 'root'
})
export class SpecialoffersService {

  apiHost: string = 'http://localhost:8091/';
    headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  getAll(): Observable<SpecialOffer[]> {
    return this.http.get<SpecialOffer[]>(this.apiHost + 'specialOffer/getAll', {headers: this.headers});
  }

  add(specialOfferDTO: SpecialOfferDTO): Observable<any> {
    return this.http.post<any>(this.apiHost + 'specialOffer/add', specialOfferDTO, {headers: this.headers});
  }

  getById(id: any): Observable<SpecialOffer> {
    return this.http.get<SpecialOffer>(this.apiHost + 'specialOffer/getById?id=' + id, {headers: this.headers});
  }

  edit(specialOffer: SpecialOffer): Observable<any> {
    return this.http.post<any>(this.apiHost + 'specialOffer/edit', specialOffer, {headers: this.headers});
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(this.apiHost + 'specialOffer/delete?id=' + id, {headers: this.headers});
  }
}
