import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Actor } from '../model/actor';
import { ActorDTO } from '../dto/actorDTO';

@Injectable({
  providedIn: 'root'
})
export class ActorsService {

  apiHost: string = 'http://localhost:8091/';
    headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  getAll(): Observable<Actor[]> {
    return this.http.get<Actor[]>(this.apiHost + 'actor/getAll', {headers: this.headers});
  }

  add(actorDTO: ActorDTO): Observable<any> {
    return this.http.post<any>(this.apiHost + 'actor/add', actorDTO, {headers: this.headers});
  }
}
