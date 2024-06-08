import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MarketplacesService } from '../services/marketplaces.service';
import { ToastrService } from 'ngx-toastr';
import { MarketplaceDTO } from '../dto/marketplaceDTO';

@Component({
  selector: 'app-marketplace-add',
  templateUrl: './marketplace-add.component.html',
  styleUrls: ['./marketplace-add.component.css']
})
export class MarketplaceAddComponent implements OnInit {
  marketplaceDTO = new MarketplaceDTO();

  constructor(private marketplacesService: MarketplacesService, private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  submit(){
    if(this.marketplaceDTO.name == "" || this.marketplaceDTO.street == "" || this.marketplaceDTO.number == "" || this.marketplaceDTO.city == "" || this.marketplaceDTO.country == ""){
        this.showError('Fill out all fields.', 'DVD Club');
        return;   
      }
    this.marketplacesService.add(this.marketplaceDTO).subscribe(
      {
        next: (res) => {
          this.router.navigate(['marketplaces']);
          this.showSuccess();
        },
        error: (e) => {this.showError('Something went wrong', 'DVD Club');
          console.log(e);}
    });
  }
  showSuccess() {
    this.toastr.success('Marketplace Added', 'DVD Club');
  }
  showError(message: string, title: string) {
    this.toastr.error(message, title);
  }

}
