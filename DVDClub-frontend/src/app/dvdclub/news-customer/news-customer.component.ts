import { Component, OnInit } from '@angular/core';
import { News } from '../model/news';
import { NewsService } from '../services/news.service';

@Component({
  selector: 'app-news-customer',
  templateUrl: './news-customer.component.html',
  styleUrls: ['./news-customer.component.css']
})
export class NewsCustomerComponent implements OnInit {

  public news: News[] = [];

  constructor(private newsService: NewsService) { }

  ngOnInit(): void {
    this.newsService.getAll().subscribe(res => {
      this.news = res;
    })
  }

}
