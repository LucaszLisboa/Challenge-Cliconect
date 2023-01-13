import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { PacienteService } from 'src/app/services/paciente.service';
import { Paciente } from 'src/app/models/paciente';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss']
})

export class TableComponent implements OnInit, AfterViewInit {

  paciente = {} as Paciente;
  pacientes: Paciente[] = [];

  searchText = '';

  pageSlice: any;

  displayedColumns: string[] = ['id', 'nome','sexo', 'cpf', 'celular', 'email', 'dataNascimento','informacoesAtendimento','rua',
  'numero', 'bairro', 'cidade', 'estado'];
  dataSource: MatTableDataSource<Paciente>;

  @ViewChild(MatPaginator) 
  paginator: MatPaginator; 

  constructor(private pacienteService: PacienteService) {   
  }

  onPageChange(event: PageEvent) {
    console.log(event);
    const startIndex = event.pageIndex * event.pageSize;
    let endIndex = startIndex + event.pageSize;
    if (endIndex > this.pacientes.length) {
      endIndex = this.pacientes.length;
    }
    
    this.pageSlice = this.pacientes.slice(startIndex, endIndex);
  } 
  
  ngAfterViewInit(): void {
    this.dataSource = new MatTableDataSource(this.pacientes);
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit(): void {
    this.getPacientes();
  }

  verificaEmailCadastro() {
    this.pacienteService.getPacientes().subscribe((pacientes: Paciente[]) => {
      pacientes.forEach(paciente => {
        if (paciente.email == this.paciente.email) {
          alert('Email já cadastrado!');
          this.paciente.email = '';
        }
      });
    }
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
      .subscribe((pacientes: Paciente[]) => {
        this.pacientes = pacientes;
        this.pageSlice = this.pacientes.slice(0, 10);
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




  



