import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { News } from '../model/news';
import { NewsDTO } from '../dto/newsDTO';

@Injectable({
  providedIn: 'root'
})
export class NewsService {

  apiHost: string = 'http://localhost:8091/';
    headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  constructor(private http: HttpClient) { }

  getAll(): Observable<News[]> {
    return this.http.get<News[]>(this.apiHost + 'news/getAll', {headers: this.headers});
  }

  add(newsDTO: NewsDTO): Observable<any> {
    return this.http.post<any>(this.apiHost + 'news/add', newsDTO, {headers: this.headers});
  }

  getById(id: any): Observable<News> {
    return this.http.get<News>(this.apiHost + 'news/getById?id=' + id, {headers: this.headers});
  }

  edit(news: News): Observable<any> {
    return this.http.post<any>(this.apiHost + 'news/edit', news, {headers: this.headers});
  }

  delete(id: number): Observable<any> {
    return this.http.delete<any>(this.apiHost + 'news/delete?id=' + id, {headers: this.headers});
  }
}
