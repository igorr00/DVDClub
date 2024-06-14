import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { UserDTO } from '../dto/userDTO';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  apiHost: string = 'http://localhost:8091/';
    headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  getAllManagers(): Observable<User[]> {
    return this.http.get<User[]>(this.apiHost + 'user/getAllManagers', {headers: this.headers});
  }

  getAllFreeManagers(): Observable<User[]> {
    return this.http.get<User[]>(this.apiHost + 'user/getAllFreeManagers', {headers: this.headers});
  }

  add(userDTO: UserDTO): Observable<any> {
    return this.http.post<any>(this.apiHost + 'user/add', userDTO, {headers: this.headers});
  }

  edit(user: User): Observable<any> {
    return this.http.post<any>(this.apiHost + 'user/edit', user, {headers: this.headers});
  }

  delete(id: any): Observable<any> {
    return this.http.delete<any>(this.apiHost + 'user/delete?id=' + id, {headers: this.headers});
  }
}
