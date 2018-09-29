import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Lancamento } from '../model/lancamento';

@Injectable({
    providedIn: 'root'
})
export class LancamentoService {

    constructor(private http: HttpClient) { }

    public listar(): Observable<any> {
        return this.http.get('http://localhost:8080/lancamentos');
    }

    public salvar(obj: Lancamento): Observable<void> {
        if (!obj) {
            return throwError('Lançamento inválido');
        }

        if (!obj.valor || obj.valor <= 0) {
            return throwError('Valor inválido');
        }

        if (!obj.data) {
            return throwError('Data inválida');
        }

        if (!obj.tipo) {
            throwError('Tipo inválido');
        }

        return this.http.post<void>('http://localhost:8080/lancamentos', obj);
    }

    public remover(id: number): Observable<any> {
        if (!id || id <= 0) {
            return throwError('Lançamento inválido');
        }

        return this.http.post<any>('http://localhost:8080/lancamentos/remover', id);
    }
}
