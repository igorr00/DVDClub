import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DvdsService } from '../services/dvds.service';
import { ToastrService } from 'ngx-toastr';
import { DvdDTO } from '../dto/dvdDTO';
import { FilmsService } from '../services/films.service';
import { Film } from '../model/film';

@Component({
  selector: 'app-dvd-add',
  templateUrl: './dvd-add.component.html',
  styleUrls: ['./dvd-add.component.css']
})
export class DvdAddComponent implements OnInit {
  dvdDTO = new DvdDTO();
  films: Film[] = [];

  constructor(private dvdsService: DvdsService, private router: Router, private toastr: ToastrService,
    private filmsService: FilmsService) { }

  ngOnInit(): void {
    const marketplaceIdString = localStorage.getItem('marketplaceId');
    if(marketplaceIdString != null){
      this.dvdDTO.marketplaceId = parseFloat(marketplaceIdString);
    }
    this.filmsService.getAll().subscribe(res => {
      this.films = res;
    })
  }

  submit(){
    if(this.dvdDTO.format == "" || this.dvdDTO.priceBuy == 0 || this.dvdDTO.priceRent == 0 || this.dvdDTO.filmId == 0){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
    this.dvdsService.add(this.dvdDTO).subscribe(
      {
        next: (res) => {
          this.router.navigate(['dvds-manager']);
          this.showSuccess();
        },
        error: (e) => {this.showError('Something went wrong', 'DVD Club');
          console.log(e);}
    });
  }
  showSuccess() {
    this.toastr.success('Dvd Ordered', 'DVD Club');
  }
  showError(message: string, title: string) {
    this.toastr.error(message, title);
  }

}
