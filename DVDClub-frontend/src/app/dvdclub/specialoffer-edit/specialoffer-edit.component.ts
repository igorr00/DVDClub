import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SpecialoffersService } from '../services/specialoffers.service';
import { ToastrService } from 'ngx-toastr';
import { SpecialOffer } from '../model/specialoffer';

@Component({
  selector: 'app-specialoffer-edit',
  templateUrl: './specialoffer-edit.component.html',
  styleUrls: ['./specialoffer-edit.component.css']
})
export class SpecialofferEditComponent implements OnInit {
  specialoffer: SpecialOffer = new SpecialOffer();

  constructor(private specialoffersService: SpecialoffersService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.specialoffersService.getById(localStorage.getItem('editSpecialOfferId')).subscribe(res => {
      this.specialoffer = res;
    })
  }

  submit(){
    if(this.specialoffer.name == "" || this.specialoffer.price == 0 || this.specialoffer.startDate == null || this.specialoffer.endDate == null){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
    if(this.specialoffer.startDate > this.specialoffer.endDate){
      this.showError('Dates are wrong.', 'DVD Club');
      return;   
    }
    this.specialoffersService.edit(this.specialoffer).subscribe(
      {
        next: (res) => {
          this.router.navigate(['specialoffers-manager']);
          this.showSuccess('Special Offer Edited', 'DVD Club');
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
    this.specialoffersService.delete(this.specialoffer.id).subscribe(
      {
        next: (res) => {
          this.router.navigate(['specialoffers-manager']);
          this.showSuccess('Special Offer Deleted', 'DVD Club');
        },
        error: (e) => {this.showError('Something went wrong', 'DVD Club');
          console.log(e);}
    });
  }

}
