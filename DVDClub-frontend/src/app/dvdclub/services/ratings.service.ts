import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Rating } from '../model/rating';
import { RatingDTO } from '../dto/ratingDTO';

@Injectable({
  providedIn: 'root'
})
export class RatingsService {

  apiHost: string = 'http://localhost:8091/';
    headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  getByUserId(id: any): Observable<Rating[]> {
    return this.http.get<Rating[]>(this.apiHost + 'rating/getByUserId?id=' + id, {headers: this.headers});
  }

  getByFilmId(id: any): Observable<Rating[]> {
    return this.http.get<Rating[]>(this.apiHost + 'rating/getByFilmId?id=' + id, {headers: this.headers});
  }

  add(ratingDTO: RatingDTO): Observable<any> {
    return this.http.post<any>(this.apiHost + 'rating/add', ratingDTO, {headers: this.headers});
  }

  getById(id: any): Observable<Rating> {
    return this.http.get<Rating>(this.apiHost + 'rating/getById?id=' + id, {headers: this.headers});
  }

  edit(rating: Rating): Observable<any> {
    return this.http.post<any>(this.apiHost + 'rating/edit', rating, {headers: this.headers});
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(this.apiHost + 'rating/delete?id=' + id, {headers: this.headers});
  }
}
