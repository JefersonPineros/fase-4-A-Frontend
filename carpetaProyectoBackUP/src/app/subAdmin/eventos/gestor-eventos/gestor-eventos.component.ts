import { Component, OnInit } from '@angular/core';
import { Form, FormGroup, FormArray, FormControl, Validator, FormBuilder, Validators} from '@angular/forms'
import { CreateEvent } from 'src/app/Models/model-create-event';

@Component({
  selector: 'app-gestor-eventos',
  templateUrl: './gestor-eventos.component.html',
  styleUrls: ['./gestor-eventos.component.css']
})
export class GestorEventosComponent implements OnInit {
  formEvent:FormGroup;
  public evento:any[];
  public createEvent:CreateEvent;
  public allTypes:[];
  public fechaEvent:Date;
  constructor(
    private fb : FormBuilder
  ) { 
    this.evento = [
      {id:"1",tipo:"Promoción"},
      {id:"2",tipo:"Descuentos"},
      {id:"3",tipo:"Tematico"},
      {id:"4",tipo:"Toque"},
    ]
    this.createEvent = new CreateEvent(null,"","","","","");
  }

  ngOnInit(): void {
    this.fechaEvent = new Date();
    this.formEvent = this.fb.group(
      {
        fecha_event:['',Validators.required],
        typeEvent:[null,Validators.required]
      }
    );
  }
  public fileToUpdate;
  updateFile(fileInput:any){
    this.fileToUpdate = <Array<File>>fileInput.target.files;
    console.log(this.fileToUpdate)
  }
  onSubmit(){
    this.createEvent.typeEvent = this.formEvent.value.typeEvent;
    this.createEvent.imageEvent = this.fileToUpdate[0].name;
    console.log(this.createEvent);
  }
  get typeEvent(){
    return this.formEvent.get('typeEvent');
  }

}
