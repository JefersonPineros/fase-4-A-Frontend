import { Component, OnInit, Input, forwardRef} from '@angular/core';
import { Form, FormBuilder, FormGroup, FormArray, Validators, NG_VALUE_ACCESSOR } from '@angular/forms';
import { AlbumesMusicaModel } from 'src/app/Models/model-musica';
import { MusicaServiciosService } from 'src/app/services/admin/musica/musica-servicios.service';
import { CreateAlbumModel } from '../../../Models/model-create-album';
import { CancionesModel } from '../../../Models/model-musica-canciones';
interface HtmlInputEvent extends Event {
  target: HTMLInputElement & EventTarget;
}

@Component({
  selector: 'app-crear-album',
  templateUrl: './crear-album.component.html',
  styleUrls: ['./crear-album.component.css'],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => CrearAlbumComponent),
      multi: true
    }
  ]
})
export class CrearAlbumComponent implements OnInit {
  public createAlbum: AlbumesMusicaModel;
  public canciones: Array<CancionesModel>;
  public generos:any[];
  public imagen: File;
  public nombreImg: string;
  createAlbumForm:FormGroup;
  constructor(private fb: FormBuilder, private musicaService: MusicaServiciosService) { 
    this.nombreImg = 'Seleccione una imagen';
    this.createAlbum = new AlbumesMusicaModel();
    this.generos = [
      {id:"1",genero:"Metal"},
      {id:"2",genero:"Rock"},
      {id:"3",genero:"Rock en español"},
      {id:"4",genero:"Heavy metal"}
    ];
  }
  
  ngOnInit(): void {
    this.createAlbumForm = this.fb.group({
      cancion_group:this.fb.array([this.fb.group({id: null,nombreCancion:'',duracion:''})],Validators.required)
    })
  }
  
  get canciongroup() {
    return this.createAlbumForm.get('cancion_group') as FormArray;
  }

  addCancionGroup(){
    this.canciongroup.push(this.fb.group({id: null,nombreCancion:'',duracion:''}));
  }

  deleteCancionGroup(index:any){
    if(index == 0){
      console.log("No puede eliminar mas");
    }else{
      this.canciongroup.removeAt(index);
    }
    
  }

  
  filesChangeEvent(fileInput: HtmlInputEvent): void{
    this.imagen = fileInput.target.files[0];
    if (
      this.imagen.type === 'image/jpeg' ||
      this.imagen.type === 'image/png' ||
      this.imagen.type === 'image/jpg'
      ) {
        
        if (fileInput.target.files && fileInput.target.files[0]) {
          this.imagen = fileInput.target.files[0];
          this.nombreImg = this.imagen.name;
          const reader = new FileReader();
          reader.readAsDataURL(this.imagen);
          reader.onload = (): void => {
            const base64String: string = (reader.result as string).match(/.+;base64,(.+)/)[1];
            this.createAlbum.urlImagen = 'data:' + this.imagen.type + ';base64,' + base64String;          
            this.createAlbum.nombreImagen = this.nombreImg;
          }
        }
      }
  }

  onSubmit(){
    
    this.createAlbum.canciones = new Array<CancionesModel>();
    this.canciones = new Array<CancionesModel>();
    this.canciongroup.value.forEach(element => {
      this.canciones.push(element);
    });
    let idUsuario = sessionStorage.getItem('idUsuario');
    this.createAlbum.canciones = this.canciones;
    this.createAlbum.UsuarioId = parseInt(idUsuario);
    
    this.musicaService.crearAlbum(this.createAlbum).subscribe(
      resp => {
        console.log(resp)
      },
      err => {
        console.log(err);
        
      }
    );
  }
}
