import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RatingsService } from '../services/ratings.service';
import { ToastrService } from 'ngx-toastr';
import { Rating } from '../model/rating';

@Component({
  selector: 'app-rating-edit',
  templateUrl: './rating-edit.component.html',
  styleUrls: ['./rating-edit.component.css']
})
export class RatingEditComponent implements OnInit {
  rating : Rating = new Rating();

  constructor(private ratingsService: RatingsService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.ratingsService.getById(localStorage.getItem('editRatingId')).subscribe(res => {
      this.rating = res;
    })
  }

  submit(){
    if(this.rating.score == 0 || this.rating.comment == ""){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
      this.ratingsService.edit(this.rating).subscribe(
        {
          next: (res) => {
            this.router.navigate(['ratings']);
            this.showSuccess('Rating Edited', 'DVD Club');
          },
          error: (e) => {this.showError('Something went wrong', 'DVD Club');
            console.log(e);}
      });
    }
    showSuccess(message: string, title: string) {
      this.toastr.success(message, title);
    }
    showError(message: string, title: string) {
      this.toastr.error(message, title);
    }
  
    delete(){
      this.ratingsService.delete(this.rating.id).subscribe(
        {
          next: (res) => {
            this.router.navigate(['ratings']);
            this.showSuccess('Rating Deleted', 'DVD Club');
          },
          error: (e) => {this.showError('Something went wrong', 'DVD Club');
            console.log(e);}
      });
    }

}
