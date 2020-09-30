import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
// importar componentes
import { HomeComponent } from './home/home.component';
import { ProductosComponent } from './productos/productos.component';
import { MusicaComponent } from './musica/musica.component';
import { AdministradorComponent } from './administrador/administrador.component';
import { NosotrosComponent } from './nosotros/nosotros.component';

const routes: Routes = [
  {path:'',redirectTo: '/home', pathMatch: 'full'},
  {path:'home',component: HomeComponent},
  {path:'musica',component: MusicaComponent},
  {path:'productos',component: ProductosComponent},
  {path:'admin',component: AdministradorComponent},
  {path:'nosotros',component: NosotrosComponent}
  
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes,{useHash:true}),
    ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
