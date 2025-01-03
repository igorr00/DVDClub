import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Director } from '../model/director';
import { DirectorDTO } from '../dto/directorDTO';

@Injectable({
  providedIn: 'root'
})
export class DirectorsService {
  
  apiHost: string = 'http://localhost:8091/';
    headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  getAll(): Observable<Director[]> {
    return this.http.get<Director[]>(this.apiHost + 'director/getAll', {headers: this.headers});
  }

  add(directorDTO: DirectorDTO): Observable<any> {
    return this.http.post<any>(this.apiHost + 'director/add', directorDTO, {headers: this.headers});
  }

  getById(id: any): Observable<Director> {
    return this.http.get<Director>(this.apiHost + 'director/getById?id=' + id, {headers: this.headers});
  }

  edit(director: Director): Observable<any> {
    return this.http.post<any>(this.apiHost + 'director/edit', director, {headers: this.headers});
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(this.apiHost + 'director/delete?id=' + id, {headers: this.headers});
  }
}
