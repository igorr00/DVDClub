import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { SpecialOffer } from '../model/specialoffer';
import { MarketplacesService } from '../services/marketplaces.service';

@Component({
  selector: 'app-specialoffers-manager',
  templateUrl: './specialoffers-manager.component.html',
  styleUrls: ['./specialoffers-manager.component.css']
})
export class SpecialoffersManagerComponent implements OnInit {

  public dataSource = new MatTableDataSource<SpecialOffer>();
  public displayedColumns = ['name', 'startDate', 'endDate', 'price', 'edit'];
  public specialoffers: SpecialOffer[] = [];
  public title = '';
  public marketplaceId = 0;

  constructor(private router:Router, private marketplacesService: MarketplacesService) { }

  ngOnInit(): void {
    this.marketplacesService.getByManagerId(localStorage.getItem('loggedUserId')).subscribe(res => {
      this.title = res.name;
      this.marketplaceId = res.id;
      
      this.marketplacesService.getAvailableSpecialOffers(this.marketplaceId).subscribe(res => {
        this.specialoffers = res;
        this.dataSource.data = this.specialoffers;
      })
    })
  }

  public edit(id: any){
    localStorage.setItem('editSpecialOfferId', id);
    window.location.href="specialoffer-edit";
  }

  public add(){
    localStorage.setItem('marketplaceId', this.marketplaceId.toString());
    window.location.href="specialoffer-add";
  }

}
