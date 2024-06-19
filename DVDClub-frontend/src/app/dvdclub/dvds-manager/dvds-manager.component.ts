import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { Dvd } from '../model/dvd';
import { MarketplacesService } from '../services/marketplaces.service';

@Component({
  selector: 'app-dvds-manager',
  templateUrl: './dvds-manager.component.html',
  styleUrls: ['./dvds-manager.component.css']
})
export class DvdsManagerComponent implements OnInit {

  public dataSource = new MatTableDataSource<Dvd>();
  public displayedColumns = ['film', 'format', 'buy', 'rent', 'edit'];
  public dvds: Dvd[] = [];
  public title = '';

  constructor(private router:Router, private marketplacesService: MarketplacesService) { }

  ngOnInit(): void {
    this.marketplacesService.getByManagerId(localStorage.getItem('loggedUserId')).subscribe(res => {
      this.title = res.name;
      localStorage.setItem('marketplaceId', res.id.toString());
      
      this.marketplacesService.getAvailableDvds(localStorage.getItem('marketplaceId')).subscribe(res => {
        this.dvds = res;
        this.dataSource.data = this.dvds;
      })
    })
  }

  public edit(id: any){
    localStorage.setItem('editDvdId', id);
    window.location.href="dvd-edit";
  }

  public add(){
    window.location.href="dvd-add";
  }

}
