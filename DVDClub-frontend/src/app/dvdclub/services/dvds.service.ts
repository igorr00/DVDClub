import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Dvd } from '../model/dvd';
import { DvdDTO } from '../dto/dvdDTO';

@Injectable({
  providedIn: 'root'
})
export class DvdsService {
  
  apiHost: string = 'http://localhost:8091/';
    headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  getAll(): Observable<Dvd[]> {
    return this.http.get<Dvd[]>(this.apiHost + 'dvd/getAll', {headers: this.headers});
  }

  add(dvdDTO: DvdDTO): Observable<any> {
    return this.http.post<any>(this.apiHost + 'dvd/add', dvdDTO, {headers: this.headers});
  }

  getById(id: any): Observable<Dvd> {
    return this.http.get<Dvd>(this.apiHost + 'dvd/getById?id=' + id, {headers: this.headers});
  }

  edit(dvd: Dvd): Observable<any> {
    return this.http.post<any>(this.apiHost + 'dvd/edit', dvd, {headers: this.headers});
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(this.apiHost + 'dvd/delete?id=' + id, {headers: this.headers});
  }
}
