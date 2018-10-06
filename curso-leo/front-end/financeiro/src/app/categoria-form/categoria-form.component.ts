import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Categoria } from '../model/categoria';
import { CategoriaService } from '../service/categoria.service';
import { MessageService } from 'primeng/api';
import { AppComponent } from '../app.component';

declare var $: any;

@Component({
    selector: 'app-categoria-form',
    templateUrl: './categoria-form.component.html',
    styleUrls: ['./categoria-form.component.css']
})
export class CategoriaFormComponent implements OnInit, OnChanges {

    @Input() categoria: Categoria = new Categoria();

    // tslint:disable-next-line:no-output-on-prefix
    @Output() onSalvar: EventEmitter<any> = new EventEmitter;
    // tslint:disable-next-line:no-output-on-prefix
    @Output() onRemover: EventEmitter<any> = new EventEmitter;

    form: FormGroup;

    constructor(private fb: FormBuilder,
        private service: CategoriaService,
        private mensagem: MessageService) {
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
        AppComponent.onConfirmar.subscribe(
            (response) => {
                if (response) {
                    this.remover();
                }
            }
        );
    }

    salvar() {
        this.categoria = this.form.value;

        if (this.categoria) {
            this.service.salvar(this.categoria).subscribe(
                (response) => {
                    this.onSalvar.emit();
                    this.mensagem.add({
                        severity: 'success',
                        summary: 'Sucesso',
                        detail: 'Categoria salva com sucesso'
                    });
                },
                (erro) => {
                    this.mensagem.add({
                        severity: 'error',
                        summary: 'Atenção',
                        detail: 'Não foi possível salvar a categoria'
                    });
                }
            );
        }
    }

    private remover() {
        this.categoria = this.form.value;
        this.service.remover(this.categoria.id).subscribe(
            (response) => {
                this.mensagem.add({
                    severity: 'success',
                    summary: 'Sucesso',
                    detail: 'Categoria removida com sucesso'
                });
                this.onRemover.emit();
            },
            (erro) => {
                console.log('Deu errado', erro);
            }
        );
    }

    confirmarRemover() {
        this.mensagem.clear();

        this.mensagem.add({
            key: 'c',
            sticky: true,
            severity: 'warn',
            summary: 'Atenção',
            detail: 'Deseja remover essa categoria?'
        });
    }

}
