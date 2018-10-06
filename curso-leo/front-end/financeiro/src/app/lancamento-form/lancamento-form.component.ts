import { Component, OnInit, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { Lancamento } from '../model/lancamento';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LancamentoService } from '../service/lancamento.service';
import { Categoria } from '../model/categoria';
import { CategoriaService } from '../service/categoria.service';
import { CustomValidators } from 'ng2-validation';

@Component({
    selector: 'app-lancamento-form',
    templateUrl: './lancamento-form.component.html',
    styleUrls: ['./lancamento-form.component.css']
})
export class LancamentoFormComponent implements OnInit, OnChanges {

    @Input() lancamento: Lancamento = new Lancamento();

    // tslint:disable-next-line:no-output-on-prefix
    @Output() onSalvar: EventEmitter<any> = new EventEmitter;
    // tslint:disable-next-line:no-output-on-prefix
    @Output() onRemover: EventEmitter<any> = new EventEmitter;

    form: FormGroup;
    listaCategoria: Categoria[];
    br: any;

    constructor(private fb: FormBuilder,
        private service: LancamentoService,
        private serviceCategoria: CategoriaService) {
        this.form = fb.group({
            id: [''],
            nome: ['', Validators.required],
            tipo: ['DESPESA'],
            valor: ['', [Validators.required, CustomValidators.number]],
            data: ['', Validators.required],
            categoria: ['']
        });
    }

    ngOnChanges(changes: SimpleChanges) {
        this.form.reset();
        if (changes.lancamento && this.lancamento) {

            if (!this.lancamento.data) {
                this.lancamento.data = new Date();
            }

            this.form.patchValue(this.lancamento);
        } else {
            this.lancamento = new Lancamento();
            this.lancamento.data = new Date();
            this.form.reset();
        }
    }

    ngOnInit() {

        this.br = {
            firstDayOfWeek: 1,
            dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
            dayNamesShort: ['dom', 'seg', 'ter', 'qua', 'qui', 'sex', 'sáb'],
            dayNamesMin: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'],
            monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho',
                'Julio', 'Agosto', 'Setembro', 'Ourubro', 'Novembro', 'Dezembro'],
            monthNamesShort: ['jan', 'fev', 'mar', 'abr', 'mai', 'jun', 'jul', 'ago', 'set', 'out', 'nov', 'dez'],
            today: 'Hoje',
            clear: 'Limpar'
        };
    }

    salvar() {
        this.lancamento = this.form.value;

        if (this.lancamento) {
            this.service.salvar(this.lancamento).subscribe(
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
        this.lancamento = this.form.value;
        this.service.remover(this.lancamento.id).subscribe(
            (response) => {
                console.log('Deu certo', response);
                this.onRemover.emit();
            },
            (erro) => {
                console.log('Deu errado', erro);
            }
        );
    }

    buscarCategoria(event) {
        this.serviceCategoria.listarPorNome(event.query).subscribe(
            (response) => {
                this.listaCategoria = response;
            },
            (erro) => {
                console.log('erro', erro);
            }
        );
    }

}
