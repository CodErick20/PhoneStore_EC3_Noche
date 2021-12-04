import { Component, OnInit } from '@angular/core';
import {Categoria} from "./categoria";

@Component({
  selector: 'app-categorias',
  templateUrl: './categorias.component.html'

})
export class CategoriasComponent implements OnInit {

  categoria: Categoria[] = [
    {id_categoria: 1, nombre: 'telefono', estado:'Activo' },
    {id_categoria: 2, nombre: 'sonido', estado:'Inactivo' }
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
