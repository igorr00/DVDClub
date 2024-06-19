import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SpecialoffersService } from '../services/specialoffers.service';
import { ToastrService } from 'ngx-toastr';
import { SpecialOfferDTO } from '../dto/specialofferDTO';
import { MarketplacesService } from '../services/marketplaces.service';
import { Dvd } from '../model/dvd';

@Component({
  selector: 'app-specialoffer-add',
  templateUrl: './specialoffer-add.component.html',
  styleUrls: ['./specialoffer-add.component.css']
})
export class SpecialofferAddComponent implements OnInit {
  specialofferDTO = new SpecialOfferDTO();
  dvds: Dvd[] = [];

  constructor(private specialoffersService: SpecialoffersService, private router: Router, private toastr: ToastrService,
    private marketplacesService: MarketplacesService) { }

  ngOnInit(): void {
    const marketplaceIdString = localStorage.getItem('marketplaceId');
    if(marketplaceIdString != null){
      this.specialofferDTO.marketplaceId = parseFloat(marketplaceIdString);
    }
    this.marketplacesService.getAvailableDvds(localStorage.getItem('marketplaceId')).subscribe(res => {
      this.dvds = res;
    })
  }

  submit(){
    if(this.specialofferDTO.name == "" || this.specialofferDTO.price == 0 || this.specialofferDTO.startDate == null || this.specialofferDTO.endDate == null
      || !this.specialofferDTO.dvdIds){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
    if(this.specialofferDTO.startDate > this.specialofferDTO.endDate){
      this.showError('Dates are wrong.', 'DVD Club');
      return;   
    }
    this.specialoffersService.add(this.specialofferDTO).subscribe(
      {
        next: (res) => {
          this.router.navigate(['specialoffers-manager']);
          this.showSuccess();
        },
        error: (e) => {this.showError('Something went wrong', 'DVD Club');
          console.log(e);}
    });
  }
  showSuccess() {
    this.toastr.success('Special Offer Added', 'DVD Club');
  }
  showError(message: string, title: string) {
    this.toastr.error(message, title);
  }

}
