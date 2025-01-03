import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserLoginService {
  apiHost: string = 'http://localhost:8091/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  login(email: string, password: string): Observable<any>{

    let userDTO = {
      name: "",
      surname: "",
      email: email,
      password: password,
      jmbg: "",
      phone: "",
      gender: 0
    };

    return this.http.post<any>(this.apiHost + 'user/login', userDTO, {headers: this.headers});
  }
}
