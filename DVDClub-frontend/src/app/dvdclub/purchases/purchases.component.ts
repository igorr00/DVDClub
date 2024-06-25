import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { Purchase } from '../model/purchase';
import { PurchasesService } from '../services/purchases.service';

@Component({
  selector: 'app-purchases',
  templateUrl: './purchases.component.html',
  styleUrls: ['./purchases.component.css']
})
export class PurchasesComponent implements OnInit {
  
  public dataSource = new MatTableDataSource<Purchase>();
  public displayedColumns = ['product', 'price', 'date', 'time'];
  public purchases: Purchase[] = [];

  constructor(private router:Router, private purchasesService: PurchasesService) { }

  ngOnInit(): void {
    this.purchasesService.getByUserId(localStorage.getItem('loggedUserId')).subscribe(res => {
      this.purchases = res;
      this.dataSource.data = this.purchases;
    })
  }

  public getProductName(purchase: Purchase){
    if(purchase.dvd){
      return purchase.dvd.film.name + " " + "(" + purchase.dvd.film.year + ")"
    }
    return purchase.specialOffer.name
  }

  public getPrice(purchase: Purchase){
    if(purchase.dvd){
      return purchase.dvd.priceBuy
    }
    return purchase.specialOffer.price
  }

  public formatTime(time: string): string {
    return time.split(',').join(':');
  }

}
