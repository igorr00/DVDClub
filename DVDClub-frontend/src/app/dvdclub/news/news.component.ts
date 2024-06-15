import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { News } from '../model/news';
import { NewsService } from '../services/news.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  public dataSource = new MatTableDataSource<News>();
  public displayedColumns = ['date', 'title', 'edit'];
  public news: News[] = [];

  constructor(private router:Router, private newsService: NewsService) { }

  ngOnInit(): void {
    this.newsService.getAll().subscribe(res => {
      this.news = res;
      this.dataSource.data = this.news;
    })
  }

  public edit(id: any){
    localStorage.setItem('editNewsId', id);
    window.location.href="news-edit";
  }

  public add(){
    window.location.href="news-add";
  }

}
