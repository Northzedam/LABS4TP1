import { HttpClient } from '@angular/common/http';
import { EmpresaService } from './../../services/empresa.service';
import { Empresa } from './../../model/empresa';
import { NoticiaService } from './../../services/noticia.service';
import { Component, OnInit } from '@angular/core';
import { Noticia } from 'src/app/model/noticia';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-elementonoticia',
  templateUrl: './elementonoticia.component.html',
  styleUrls: ['./elementonoticia.component.css']
})
export class ElementonoticiaComponent implements OnInit {

  public empresas: Empresa[];
  _url = 'http://localhost:9000/api/v1/noticia/upload';
  uploadForm: FormGroup;

  noticia: Noticia = {
    id: 0,
    titulo_de_la_noticia: '',
    resumen_de_la_noticia: '',
    imagen_noticia: '',
    contenido_html: '',
    publicada: '',
    fecha_publicacion: null,
    idEmpresa: null
  };

  constructor(private noticiaService: NoticiaService, private router: Router,
              private actRoute: ActivatedRoute, private empresaService: EmpresaService,
              private formBuilder: FormBuilder, private http: HttpClient) {
      this.actRoute.params.subscribe((data) => {
      if (data['id'] !== 'nueva') {
        this.getOne(data['id']);
      }
    });
  }

  ngOnInit() {
    this.getAllEmpresas();
    this.uploadForm = this.formBuilder.group({
      file: ['']
    });
  }

  save() {
    this.actRoute.params.subscribe((data) => {
      if (data['id'] === 'nueva') {
        this.add();
      } else {
        this.update(data['id']);
      }
    });
  }

  add() {
    this.noticiaService.post(this.noticia).subscribe(
      res => {
        alert('Noticia agregada correctamente');
        this.router.navigate(['tabla/noticia']);
      },
      err => {
        alert('Ocurrió un error al agregar la noticia. Verifique los campos.');
      }
    );
  }

  update(id: number) {
    this.noticiaService.put(id, this.noticia).subscribe(
      res => {
        alert('La noticia fue actualizada con éxito');
        this.router.navigate(['tabla/noticia']);
      },
      err => {
        alert('Ocurrió un error al actualizar noticia. Verifique los campos.');
      }
    );
  }

  getOne(id: number) {
    this.noticiaService.getOne(id).subscribe((data) => {
      this.noticia = data;
    }, err => {
      alert('Error al traer los datos de noticia: getOne');
    });
  }

  getAllEmpresas() {
    this.empresaService.getAll().subscribe(res => {
      this.empresas = res;
    },
      err => {
        alert('Error al traer todas las empresas para vincular la noticia: ' + err);
      });
  }

  onFileSelect(event) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.uploadForm.get('file').setValue(file);
    }
  }

  onSubmit() {
    const formData = new FormData();
    formData.append('file', this.uploadForm.get('file').value);
    this.http.post<any>(this._url, formData).subscribe(
      res => console.log(res),
      err => console.log(err)
    );
  }

}
