import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Categoria } from '../model/categoria';
import { CategoriaService } from '../service/categoria.service';

declare var $: any;

@Component({
    selector: 'app-categoria-form',
    templateUrl: './categoria-form.component.html',
    styleUrls: ['./categoria-form.component.css']
})
export class CategoriaFormComponent implements OnInit, OnChanges {

    @Input() categoria: Categoria = new Categoria();

    @Output() onSalvar: EventEmitter<any> = new EventEmitter;
    @Output() onRemover: EventEmitter<any> = new EventEmitter;

    form: FormGroup;

    constructor(private fb: FormBuilder, private service: CategoriaService) {
        this.form = fb.group({
            id: [''],
            nome: ['', Validators.required],
            descricao: ['', Validators.required]
        });
    }

    ngOnChanges(changes: SimpleChanges) {
        this.form.reset();
        if (changes.categoria && this.categoria) {
            this.form.patchValue(this.categoria);
        } else {
            this.categoria = new Categoria();
            this.form.reset();
        }
    }

    ngOnInit() {
        
    }

    salvar() {
        this.categoria = this.form.value;

        if (this.categoria) {
            this.service.salvar(this.categoria).subscribe(
                (response) => {
                    this.onSalvar.emit();
                },
                (erro) => {
                    console.log('Deu errado', erro);
                }
            );
        }
    }

    remover() {
        this.categoria = this.form.value;
        this.service.remover(this.categoria.id).subscribe(
            (response) => {
                console.log('Deu certo', response);
                this.onRemover.emit();
            },
            (erro) => {
                console.log('Deu errado', erro);
            }
        );
    }

}
