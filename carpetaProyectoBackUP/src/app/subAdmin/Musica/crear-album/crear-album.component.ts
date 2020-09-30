import { Component, OnInit, Input, forwardRef} from '@angular/core';
import { Form, FormBuilder, FormGroup, FormArray, FormControl,Validators,ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms';
import { CreateAlbumModel } from '../../../Models/model-create-album';


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
  public createAlbum: CreateAlbumModel;
  public generos:any[];
  createAlbumForm:FormGroup;
  constructor(private fb: FormBuilder) { 
    this.createAlbum = new CreateAlbumModel("","","","",[]);
    this.generos = [
      {id:"1",genero:"Metal"},
      {id:"2",genero:"Rock"},
      {id:"3",genero:"Rock en español"},
      {id:"4",genero:"Heavy metal"}
    ];
  }
  
  ngOnInit(): void {
    this.createAlbumForm = this.fb.group({
      cancion_group:this.fb.array([this.fb.group({cancion:'',duracion:''})],Validators.required)
    })
  }
  get canciongroup() {
    return this.createAlbumForm.get('cancion_group') as FormArray;
  }
  addCancionGroup(){
    this.canciongroup.push(this.fb.group({cancion:'',duracion:''}));
  }
  deleteCancionGroup(index:any){
    if(index == 0){
      console.log("No puede eliminar mas");
    }else{
      this.canciongroup.removeAt(index);
    }
    
  }
  public filesToUpload;
  public resultUpload;
  filesChangeEvent(fileInput:any){
    this.filesToUpload = <Array<File>>fileInput.target.files;
    console.log(this.filesToUpload);
  }
  onSubmit(){
    this.createAlbum.musicaAlbum.push(this.canciongroup.value);
    this.createAlbum.imagenAlbum = this.filesToUpload[0].name
    console.log(this.canciongroup.value);
    console.log(this.createAlbum);
  }
  

}
