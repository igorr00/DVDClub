import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { Dvd } from '../model/dvd';
import { MarketplacesService } from '../services/marketplaces.service';

@Component({
  selector: 'app-dvds-customer',
  templateUrl: './dvds-customer.component.html',
  styleUrls: ['./dvds-customer.component.css']
})
export class DvdsCustomerComponent implements OnInit {

  public dataSource = new MatTableDataSource<Dvd>();
  public displayedColumns = ['film', 'format', 'buy', 'rent', 'edit'];
  public dvds: Dvd[] = [];
  public title = '';

  constructor(private router:Router, private marketplacesService: MarketplacesService) { }

  ngOnInit(): void {
    this.marketplacesService.getById(localStorage.getItem('marketplaceId')).subscribe(res => {
      this.title = res.name;
      
      this.marketplacesService.getAvailableDvds(localStorage.getItem('marketplaceId')).subscribe(res => {
        this.dvds = res;
        this.dataSource.data = this.dvds;
      })
    })
  }

  public buy(id: any){
  }

  public rent(id: any){
  }

  public filmView(id: any){
    localStorage.setItem('filmViewId', id);
    window.location.href="film-view";
  }

}
