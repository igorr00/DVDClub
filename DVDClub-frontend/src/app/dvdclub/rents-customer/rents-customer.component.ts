import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { Rent } from '../model/rent';
import { RentsService } from '../services/rents.service';

@Component({
  selector: 'app-rents-customer',
  templateUrl: './rents-customer.component.html',
  styleUrls: ['./rents-customer.component.css']
})
export class RentsCustomerComponent implements OnInit {

  public dataSource = new MatTableDataSource<Rent>();
  public displayedColumns = ['dvd', 'price', 'date', 'due', 'returned', 'status'];
  public rents: Rent[] = [];

  constructor(private router:Router, private rentsService: RentsService) { }

  ngOnInit(): void {
    this.rentsService.getByUserId(localStorage.getItem('loggedUserId')).subscribe(res => {
      this.rents = res;
      this.dataSource.data = this.rents;
    })
  }
}
