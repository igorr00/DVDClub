import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Film } from '../model/film';
import { FilmDTO } from '../dto/filmDTO';

@Injectable({
  providedIn: 'root'
})
export class FilmsService {

  apiHost: string = 'http://localhost:8091/';
    headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  getAll(): Observable<Film[]> {
    return this.http.get<Film[]>(this.apiHost + 'film/getAll', {headers: this.headers});
  }

  add(filmDTO: FilmDTO): Observable<any> {
    return this.http.post<any>(this.apiHost + 'film/add', filmDTO, {headers: this.headers});
  }
}
