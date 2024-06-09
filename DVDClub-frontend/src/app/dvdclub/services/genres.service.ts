import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Genre } from '../model/genre';

@Injectable({
  providedIn: 'root'
})
export class GenresService {

  apiHost: string = 'http://localhost:8091/';
    headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  getAll(): Observable<Genre[]> {
    return this.http.get<Genre[]>(this.apiHost + 'genre/getAll', {headers: this.headers});
  }
}
