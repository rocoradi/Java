import { Component, OnInit } from '@angular/core';
import { CategoriaService } from '../service/categoria.service';
import { Categoria } from '../model/categoria';

declare var $: any;

@Component({
    selector: 'app-categoria-grid',
    templateUrl: './categoria-grid.component.html',
    styleUrls: ['./categoria-grid.component.css']
})
export class CategoriaGridComponent implements OnInit {

    categorias: Array<Categoria>;
    categoriaSelecionada: Categoria;

    constructor(private service: CategoriaService) { }

    ngOnInit() {
        this.listar();
    }

    nova() {
        this.categoriaSelecionada = new Categoria();
        $('#modalNova').modal('show');
    }

    onSalvarCategoria(event) {
        $('#modalNova').modal('hide');
        this.listar();
    }

    onRemoverCategoria(event) {
        $('#modalNova').modal('hide');
        this.listar();
    }

    listar() {
        this.service.listar().subscribe(
            (response) => {
                this.categorias = response;
            },
            (erro) => {
                console.log('Falha na requisição: ', erro);
            }
        );
    }

    editar(obj: Categoria) {
        this.categoriaSelecionada = obj;

        if (this.categoriaSelecionada) {
            $('#modalNova').modal('show');
        }
    }

}
