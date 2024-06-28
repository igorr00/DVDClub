import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { Dvd } from '../model/dvd';
import { MarketplacesService } from '../services/marketplaces.service';
import { PurchaseDTO } from '../dto/purchaseDTO';
import { PurchasesService } from '../services/purchases.service';
import { ToastrService } from 'ngx-toastr';
import { RentDTO } from '../dto/rentDTO';
import { RentsService } from '../services/rents.service';

@Component({
  selector: 'app-dvds-customer',
  templateUrl: './dvds-customer.component.html',
  styleUrls: ['./dvds-customer.component.css']
})
export class DvdsCustomerComponent implements OnInit {

  public dataSource = new MatTableDataSource<Dvd>();
  public displayedColumns = ['film', 'format', 'pricebuy', 'pricerent', 'buy'];
  public dvds: Dvd[] = [];
  public title = '';
  public isMember: boolean = false;
  public purchaseDTO: PurchaseDTO = new PurchaseDTO();
  public rentDTO: RentDTO = new RentDTO();

  constructor(private router:Router, private marketplacesService: MarketplacesService,
    private purchasesService: PurchasesService, private rentsService: RentsService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.marketplacesService.checkUser(localStorage.getItem('marketplaceId'), localStorage.getItem('loggedUserId')).subscribe({
      next: (res) => {
        this.isMember = true;
      },
      error: (e) => { this.isMember = false; }
  });

    this.marketplacesService.getById(localStorage.getItem('marketplaceId')).subscribe(res => {
      this.title = res.name;
      
      this.marketplacesService.getAvailableDvds(localStorage.getItem('marketplaceId')).subscribe(res => {
        this.dvds = res;
        this.dataSource.data = this.dvds;
      })
    })
  }

  public buy(id: any){
    this.purchaseDTO.userId = localStorage.getItem('loggedUserId');
    this.purchaseDTO.dvdId = id;
    this.purchasesService.add(this.purchaseDTO).subscribe(res => {
      this.toastr.success('Dvd purchased', 'DVD Club');
      this.router.navigate(['purchases']);
    })
  }

  public rent(id: any){
    localStorage.setItem('dvdId', id);
    this.router.navigate(['rent-add']);
  }

  public filmView(id: any){
    localStorage.setItem('filmViewId', id);
    this.router.navigate(['film-view']);
  }

  public membership(){
    this.marketplacesService.membership(localStorage.getItem('marketplaceId'), localStorage.getItem('loggedUserId')).subscribe(res => {
      window.location.reload();
    })
  }
}
