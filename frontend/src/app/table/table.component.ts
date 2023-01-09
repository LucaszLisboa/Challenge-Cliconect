import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { PacienteService } from 'src/app/services/paciente.service';
import { Paciente } from 'src/app/models/paciente';
import { NgForm } from '@angular/forms';
import { tap } from 'rxjs';

/**
 * @title Basic use of `<table mat-table>`
 */

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss']
})

export class TableComponent implements OnInit, AfterViewInit {

  paciente = {} as Paciente;
  pacientes: Paciente[];

  // displayedColumns: string[] = ['position', 'nome', 'sexo', 'cpf', 'celular', 'dataDeNascimento', 'email', 'informacoes'];
  // dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA);

  @ViewChild(MatPaginator) 
  paginator: MatPaginator; 
  

  constructor(
    private pacienteService: PacienteService
  ) { }
  
  ngAfterViewInit(): void {
    this.paginator.page
      .pipe(
        tap(() => this.getPacientes())
      )
      .subscribe();
  }

  ngOnInit(): void {

    this.getPacientes();
    console.log();
    this.pacienteService.getPacientes().subscribe(
      (data) => {
        console.log(data);
      },
    );
  
  }

  savePaciente (form: NgForm) {
    if(this.paciente.id !== undefined) {
      this.pacienteService.updatePaciente(this.paciente).subscribe(() => {
        this.cleanForm(form);
      });
    }
    else {
      this.pacienteService.createPaciente(this.paciente).subscribe(() => {
        this.cleanForm(form);
      });
    }
  }

  getPacientes(){
    this.pacienteService.getPacientes()
      .pipe(
        tap(() => this.getPacientes())
      )
      .subscribe((pacientes: any) => {
        this.pacientes = pacientes;
      }
      );
  }

  deletePaciente(id: number){
    this.pacienteService.deletePaciente(id).subscribe(() => {
      this.getPacientes();
    }
    );
  }

  editPaciente(paciente: Paciente){
    this.paciente = { ...paciente };
  }

  cleanForm(form: NgForm) {
    this.getPacientes();
    form.resetForm();
    this.paciente = {} as Paciente;
  }

  handlePageEvent(event: any){
    console.log(event);
  }
}

// export interface PeriodicElement {
//   name: string;
//   position: number;
//   weight: number;
//   symbol: string;
// }

// const ELEMENT_DATA: PeriodicElement[] = [
//   {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
//   {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
// ];


  



