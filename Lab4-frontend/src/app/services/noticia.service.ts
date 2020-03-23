import { Injectable } from '@angular/core';
import { CommonService } from './common.service';
import { Noticia } from '../model/noticia';
@Injectable({
  providedIn: 'root'
})

export class NoticiaService extends CommonService<Noticia> {

  protected miUrl = 'http://localhost:9000/api/v1/noticia/';

}
