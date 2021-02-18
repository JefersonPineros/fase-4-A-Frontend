import { Component } from '@angular/core';
import { NgForm } from '@angular/forms'
import { environment} from '../environments/environment'
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  envName = environment.name;
  title = 'gaes5Proyect';
}
