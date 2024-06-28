import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { Rent } from '../model/rent';
import { RentsService } from '../services/rents.service';

@Component({
  selector: 'app-rents-manager',
  templateUrl: './rents-manager.component.html',
  styleUrls: ['./rents-manager.component.css']
})
export class RentsManagerComponent implements OnInit {

  public dataSource = new MatTableDataSource<Rent>();
  public displayedColumns = ['dvd', 'price', 'date', 'due', 'returned', 'status', 'user'];
  public rents: Rent[] = [];

  constructor(private router:Router, private rentsService: RentsService) { }

  ngOnInit(): void {
    this.rentsService.getByMarketplaceId(localStorage.getItem('marketplaceId')).subscribe(res => {
      this.rents = res;
      this.dataSource.data = this.rents;
    })
  }

}
