import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserDTO } from '../dto/userDTO';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {
  apiHost: string = 'http://localhost:8091/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  register(userDTO: UserDTO): Observable<any> {
    userDTO.type = 1;
    return this.http.post<any>(this.apiHost + 'user/registration', userDTO, {headers: this.headers});
  }
}
