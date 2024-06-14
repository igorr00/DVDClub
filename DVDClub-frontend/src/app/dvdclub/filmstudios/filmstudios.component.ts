import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatTableDataSource } from '@angular/material/table';
import { FilmStudio } from '../model/filmstudio';
import { FilmstudiosService } from '../services/filmstudios.service';

@Component({
  selector: 'app-filmstudios',
  templateUrl: './filmstudios.component.html',
  styleUrls: ['./filmstudios.component.css']
})
export class FilmstudiosComponent implements OnInit {

  public dataSource = new MatTableDataSource<FilmStudio>();
  public displayedColumns = ['name', 'country', 'edit'];
  public filmstudios: FilmStudio[] = [];

  constructor(private router:Router, private filmstudiosService: FilmstudiosService) { }

  ngOnInit(): void {
    this.filmstudiosService.getAll().subscribe(res => {
      this.filmstudios = res;
      this.dataSource.data = this.filmstudios;
    })
  }

  public edit(id: any){
    localStorage.setItem('editFilmStudioId', id);
    window.location.href="filmstudio-edit";
  }

  public add(){
    window.location.href="filmstudio-add";
  }

}
