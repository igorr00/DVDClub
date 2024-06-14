import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FilmStudio } from '../model/filmstudio';
import { FilmStudioDTO } from '../dto/filmstudioDTO';

@Injectable({
  providedIn: 'root'
})
export class FilmstudiosService {

  apiHost: string = 'http://localhost:8091/';
    headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  getAll(): Observable<FilmStudio[]> {
    return this.http.get<FilmStudio[]>(this.apiHost + 'filmStudio/getAll', {headers: this.headers});
  }

  add(filmstudioDTO: FilmStudioDTO): Observable<any> {
    return this.http.post<any>(this.apiHost + 'filmStudio/add', filmstudioDTO, {headers: this.headers});
  }

  getById(id: any): Observable<FilmStudio> {
    return this.http.get<FilmStudio>(this.apiHost + 'filmStudio/getById?id=' + id, {headers: this.headers});
  }

  edit(filmStudio: FilmStudio): Observable<any> {
    return this.http.post<any>(this.apiHost + 'filmStudio/edit', filmStudio, {headers: this.headers});
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(this.apiHost + 'filmStudio/delete?id=' + id, {headers: this.headers});
  }
}
