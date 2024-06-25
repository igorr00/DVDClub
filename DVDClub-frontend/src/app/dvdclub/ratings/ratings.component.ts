import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { Rating } from '../model/rating';
import { RatingsService } from '../services/ratings.service';

@Component({
  selector: 'app-ratings',
  templateUrl: './ratings.component.html',
  styleUrls: ['./ratings.component.css']
})
export class RatingsComponent implements OnInit {

  public dataSource = new MatTableDataSource<Rating>();
  public displayedColumns = ['film', 'score', 'comment', 'edit'];
  public ratings: Rating[] = [];

  constructor(private router:Router, private ratingsService: RatingsService) { }

  ngOnInit(): void {
    this.ratingsService.getByUserId(localStorage.getItem('loggedUserId')).subscribe(res => {
      this.ratings = res;
      this.dataSource.data = this.ratings;
    })
  }

  public edit(id: any){
    localStorage.setItem('editRatingId', id);
    window.location.href="rating-edit";
  }

}
