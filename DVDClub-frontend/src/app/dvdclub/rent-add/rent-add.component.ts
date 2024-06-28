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
  selector: 'app-rent-add',
  templateUrl: './rent-add.component.html',
  styleUrls: ['./rent-add.component.css']
})
export class RentAddComponent implements OnInit {

  public rentDTO: RentDTO = new RentDTO();

  constructor(private router:Router, private marketplacesService: MarketplacesService,
    private purchasesService: PurchasesService, private rentsService: RentsService, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.rentDTO.userId = localStorage.getItem('loggedUserId');
    this.rentDTO.dvdId = localStorage.getItem('dvdId');
  }

  public submit(){
    this.rentsService.add(this.rentDTO).subscribe(res => {
      this.toastr.success('Rent request sent', 'DVD Club');
      this.router.navigate(['rents-customer']);
    })
  }

}
