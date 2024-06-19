import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DvdsService } from '../services/dvds.service';
import { ToastrService } from 'ngx-toastr';
import { Dvd } from '../model/dvd';

@Component({
  selector: 'app-dvd-edit',
  templateUrl: './dvd-edit.component.html',
  styleUrls: ['./dvd-edit.component.css']
})
export class DvdEditComponent implements OnInit {
  dvd: Dvd = new Dvd();

  constructor(private dvdsService: DvdsService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.dvdsService.getById(localStorage.getItem('editDvdId')).subscribe(res => {
      this.dvd = res;
    })
  }

  submit(){
    if(this.dvd.format == "" || this.dvd.priceBuy == 0 || this.dvd.priceRent == 0){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
      this.dvdsService.edit(this.dvd).subscribe(
        {
          next: (res) => {
            this.router.navigate(['dvds-manager']);
            this.showSuccess('Dvd Edited', 'DVD Club');
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
      this.dvdsService.delete(this.dvd.id).subscribe(
        {
          next: (res) => {
            this.router.navigate(['dvds-manager']);
            this.showSuccess('Dvd Deleted', 'DVD Club');
          },
          error: (e) => {this.showError('Something went wrong', 'DVD Club');
            console.log(e);}
      });
    }

}
