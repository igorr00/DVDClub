import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { Marketplace } from '../model/marketplace';
import { MarketplacesService } from '../services/marketplaces.service';

@Component({
  selector: 'app-marketplaces-customer',
  templateUrl: './marketplaces-customer.component.html',
  styleUrls: ['./marketplaces-customer.component.css']
})
export class MarketplacesCustomerComponent implements OnInit {

  public dataSource = new MatTableDataSource<Marketplace>();
  public displayedColumns = ['name', 'street', 'number', 'city', 'country', 'edit'];
  public marketplaces: Marketplace[] = [];

  constructor(private router:Router, private marketplacesService: MarketplacesService) { }

  ngOnInit(): void {
    this.marketplacesService.getAll().subscribe(res => {
      this.marketplaces = res;
      this.dataSource.data = this.marketplaces;
    })
  }

  public visit(id: any){
    localStorage.setItem('marketplaceId', id);
    window.location.href="dvds-customer";
  }

}
