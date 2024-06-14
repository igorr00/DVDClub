import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { Film } from '../model/film';
import { FilmsService } from '../services/films.service';

@Component({
  selector: 'app-films',
  templateUrl: './films.component.html',
  styleUrls: ['./films.component.css']
})
export class FilmsComponent implements OnInit {

  public dataSource = new MatTableDataSource<Film>();
  public displayedColumns = ['image', 'name', 'year', 'director', 'country', 'edit'];
  public films: Film[] = [];

  constructor(private router:Router, private filmsService: FilmsService) { }

  ngOnInit(): void {
    this.filmsService.getAll().subscribe(res => {
      this.films = res;
      this.dataSource.data = this.films;
    })
  }

  public edit(id: any){
    localStorage.setItem('editFilmId', id);
    window.location.href="film-edit";
  }

  public add(){
    window.location.href="film-add";
  }

}
