import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { ConfirmEqualsValidatorDirective } from './Directivas/confirm-equals-validator.directive';
import { FullCalendarModule } from '@fullcalendar/angular';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { BarraComponent } from './barra/barra.component';
import { ProductosComponent } from './productos/productos.component';
import { FooterComponent } from './footer/footer.component';
import { MusicaComponent } from './musica/musica.component';
import { AdministradorComponent } from './administrador/administrador.component';
import { NosotrosComponent } from './nosotros/nosotros.component';
import { SesionComponent } from './componentesHome/sesion/sesion.component';
import { InfoEventComponent } from './componentesHome/info-event/info-event.component';
import { CalendarioEventComponent } from './componentesHome/calendario-event/calendario-event.component';
import { CrearUsuarioComponent } from './subAdmin/usuarios/crear-usuario/crear-usuario.component';
import { EliminarUsuarioComponent } from './subAdmin/usuarios/eliminar-usuario/eliminar-usuario.component';
import { CrearProductosComponent } from './subAdmin/productos/crear-productos/crear-productos.component';
import { EliminarProductosComponent } from './subAdmin/productos/eliminar-productos/eliminar-productos.component';
import { GestorPedidoComponent } from './subAdmin/pedidos/gestor-pedido/gestor-pedido.component';
import { CrearAlbumComponent } from './subAdmin/Musica/crear-album/crear-album.component';
import { EliminarAlbumComponent } from './subAdmin/Musica/eliminar-album/eliminar-album.component';
import { GestorEventosComponent } from './subAdmin/eventos/gestor-eventos/gestor-eventos.component';
import { ReportesComponent } from './subAdmin/reportes/reportes.component';
import { CarritoComprasComponent } from './subProductsCom/carrito-compras/carrito-compras.component';
import { IniSesionProductComponent } from './subProductsCom/ini-sesion-product/ini-sesion-product.component';
import { RegistroProComponent } from './subProductsCom/registro-pro/registro-pro.component';
import { DataTablesModule } from 'angular-datatables';
import { UpdateUsuarioComponent } from './subAdmin/usuarios/update-usuario/update-usuario.component';
import { ActualizarProductosComponent } from './subAdmin/productos/actualizar-productos/actualizar-productos.component';
import { HttpClientModule } from '@angular/common/http';
import { FileUploadModule } from 'ng2-file-upload';
import { ListarEventosComponent } from './subAdmin/eventos/listar-eventos/listar-eventos.component';
import dayGridPlugin from '@fullcalendar/daygrid';
import { ActualizarEventoComponent } from './subAdmin/eventos/actualizar-evento/actualizar-evento.component';

FullCalendarModule.registerPlugins([
  dayGridPlugin
]);

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    BarraComponent,
    ProductosComponent,
    FooterComponent,
    MusicaComponent,
    AdministradorComponent,
    NosotrosComponent,
    SesionComponent,
    InfoEventComponent,
    CalendarioEventComponent,
    CrearUsuarioComponent,
    EliminarUsuarioComponent,
    CrearProductosComponent,
    EliminarProductosComponent,
    GestorPedidoComponent,
    CrearAlbumComponent,
    EliminarAlbumComponent,
    GestorEventosComponent,
    ReportesComponent,
    ConfirmEqualsValidatorDirective,
    CarritoComprasComponent,
    IniSesionProductComponent,
    RegistroProComponent,
    UpdateUsuarioComponent,
    ActualizarProductosComponent,
    ListarEventosComponent,
    ActualizarEventoComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    FullCalendarModule,
    DataTablesModule,
    HttpClientModule,
    FileUploadModule

  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
