import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { PacienteService } from 'src/app/services/paciente.service';
import { Paciente } from 'src/app/models/paciente';
import { NgForm } from '@angular/forms';
import { tap } from 'rxjs';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss']
})

export class TableComponent implements OnInit, AfterViewInit {

  paciente = {} as Paciente;
  pacientes: Paciente[];

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
      // .pipe(
      //   tap(() => this.getPacientes())
      // )
      .subscribe((pacientes: Paciente[]) => {
        this.pacientes = pacientes;
      });
  }

  deletePaciente(paciente: Paciente){
    this.pacienteService.deletePaciente(paciente).subscribe(() => {
      this.getPacientes();
    });
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




  



