import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { Rent } from '../model/rent';
import { RentsService } from '../services/rents.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-rents-manager',
  templateUrl: './rents-manager.component.html',
  styleUrls: ['./rents-manager.component.css']
})
export class RentsManagerComponent implements OnInit {

  public dataSource = new MatTableDataSource<Rent>();
  public displayedColumns = ['dvd', 'price', 'date', 'due', 'returned', 'user', 'status', 'changeStatus'];
  public rents: Rent[] = [];

  constructor(private router:Router, private rentsService: RentsService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.rentsService.getByMarketplaceId(localStorage.getItem('marketplaceId')).subscribe(res => {
      this.rents = res;
      this.dataSource.data = this.rents;
    })
  }

  public changeStatus(id: any, status: any){
    this.rentsService.changeStatus(id, status).subscribe(res => {
      this.toastr.success('Rent status changed', 'DVD Club');
      window.location.reload();
    })
  }

}
