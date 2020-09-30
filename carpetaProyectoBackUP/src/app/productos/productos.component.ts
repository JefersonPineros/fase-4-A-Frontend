import { Component, OnInit } from '@angular/core';
import { PedidosCarritoService } from '../services/pedidos-carrito.service'
import Swal from 'sweetalert2';
import { IdiomaServiceService } from '../services/idioma-service.service';
import * as Cookie from 'js-cookie';
import { ThrowStmt } from '@angular/compiler';
import { CarritoComprasComponent } from '../subProductsCom/carrito-compras/carrito-compras.component';
@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css'],
  providers: [CarritoComprasComponent]
})
export class ProductosComponent implements OnInit {
  public countPedidos: string;
  public listaProductosIN: Array<any>;
  public listaProductosESP: Array<any>;
  public ProduuctosSeleccionados: Array<any>;
  public idiomaSelected: string;
  constructor(private sendProductoServices: PedidosCarritoService, private idiomaService: IdiomaServiceService) {
    this.ProduuctosSeleccionados = new Array();
    this.countPedidos = "0";
    this.listaProductosESP = [
      { idProducto: 1, nombrePro: "Aguila light", descripcionPro: "Es una cerveza muy refrescante, con un sabor suave y menos porcentaje de alcohol...", valorProdu: 2500, imagen: "../../assets/imagenes/productos/aguilaLight.jpeg" },
      { idProducto: 2, nombrePro: "Poker", descripcionPro: "Está elaborada por la Cervecería Bavaria, sin duda la más importante de Colombia...", valorProdu: 2500, imagen: "../../assets/imagenes/productos/poker.jpg" },
      { idProducto: 3, nombrePro: "Costeña", descripcionPro: "Con la promesa de ser una cerveza con un único y característico sabor seco y amargo. Ofrece a ...", valorProdu: 2800, imagen: "../../assets/imagenes/productos/costeña.jpg" },
      { idProducto: 4, nombrePro: "Club Colombia - Golden", descripcionPro: " Esta Club Colombia tiene el color dorado de las cervezas elaboradas con cebada malteada y malta caramelo...", valorProdu: 2800, imagen: "../../assets/imagenes/productos/clubDorada.jpg" },
      { idProducto: 5, nombrePro: "Club Colombia - Red", descripcionPro: " Esta Club Colombia tiene el color dorado de las cervezas elaboradas con cebada malteada y malta caramelo.", valorProdu: 2800, imagen: "../../assets/imagenes/productos/clubRoja.jpg" },
      { idProducto: 6, nombrePro: "Heineken", descripcionPro: " La familia Heineken entró al negocio de la cerveza y comenzaron a fermentarla en tanques horizontales...", valorProdu: 3500, imagen: "../../assets/imagenes/productos/heineken.jpg" },
      { idProducto: 7, nombrePro: "Budweicer", descripcionPro: "Budweiser (Anheuser-Busch) es una cerveza de origen checa, patentada en los Estados Unidos y una de las más populares en dicho país.", valorProdu: 3000, imagen: "../../assets/imagenes/productos/budweiser.jpg" },
      { idProducto: 8, nombrePro: "Jack Daniels", descripcionPro: "Una de las botellas más vendidas de la destilería Jack Daniel, la mashbill está compuesta por 80% de maíz..", valorProdu: 120000, imagen: "../../assets/imagenes/productos/jackDaniels.jpg" },
      { idProducto: 9, nombrePro: "Something special", descripcionPro: "Su sabor es suave, tiene notas de malta dulce y chocolate amargo, con un final seco y sensaciones de humo, cuero y especias.", valorProdu: 180000, imagen: "../../assets/imagenes/productos/something.png" },
      { idProducto: 10, nombrePro: "Margarita", descripcionPro: "Trituramos el limón, la lima, las naranjas y la piña. Si lo hacemos con la Thermomix, ponemos estos...", valorProdu: 15000, imagen: "../../assets/imagenes/productos/margarita.jpg" },
      { idProducto: 11, nombrePro: "Limonada Turca", descripcionPro: "Elaboración: Para hacer esta peculiar y refrescante limonada turca, comenzamos exprimiendo...", valorProdu: 35000, imagen: "../../assets/imagenes/productos/limonada.jpg" }
    ]
    this.listaProductosIN = [
      { idProducto: 1, nombrePro: "Aguila light", descripcionPro: "It is a refreshing beer, with a mild flavor and a lower amount in percentage of alcohol", valorProdu: 2500, imagen: "../../assets/imagenes/productos/aguilaLight.jpeg" },
      { idProducto: 2, nombrePro: "Poker beer", descripcionPro: "Lager type with malt character, grain flavor, moderate fruity aroma, moderate bitter taste and robust body", valorProdu: 2500, imagen: "../../assets/imagenes/productos/poker.jpg" },
      { idProducto: 3, nombrePro: "Costeña beer", descripcionPro: "Beer with malt content of barley, rice, corn syrup and hops make it an alcoholic fermentation drink with a touch of sweet flavor", valorProdu: 2800, imagen: "../../assets/imagenes/productos/costeña.jpg" },
      { idProducto: 4, nombrePro: "Club Colombia - Golden beer", descripcionPro: "Premium lager-type beer with an intense golden color, good carbonation and white foam, highlighting the crystal-like malt flavor", valorProdu: 2800, imagen: "../../assets/imagenes/productos/clubDorada.jpg" },
      { idProducto: 5, nombrePro: "Club Colombia - Red beer", descripcionPro: "Intriguing beer for its sweet notes, a little softer than golden, perfectly combines the flavor of caramel and roasted malt, has a creamy foam that contrasts the color of the beer", valorProdu: 2800, imagen: "../../assets/imagenes/productos/clubRoja.jpg" },
      { idProducto: 6, nombrePro: "Heineken beer", descripcionPro: "Pale lager type beer with a light sweet taste of pilsen malt and mild bitterness, it is a dry beer with a light body that provides a bitter and fresh finish", valorProdu: 3500, imagen: "../../assets/imagenes/productos/heineken.jpg" },
      { idProducto: 7, nombrePro: "Budweicer beer", descripcionPro: "American lager beer composed of hops, barley and rice, refreshing and not very robust", valorProdu: 3000, imagen: "../../assets/imagenes/productos/budweiser.jpg" },
      //{ idProducto: 8, nombrePro: "Jack Daniels", descripcionPro: "Una de las botellas más vendidas de la destilería Jack Daniel, la mashbill está compuesta por 80% de maíz..", valorProdu: 120000, imagen: "../../assets/imagenes/productos/jackDaniels.jpg" },
      { idProducto: 9, nombrePro: "Tecate beer", descripcionPro: "Tecate beer with a robust body with a balanced flavor, contains barley malt, yeast and hops", valorProdu: 180000, imagen: "../../assets/imagenes/productos/Tecate.png" },
      { idProducto: 10, nombrePro: "Pilsen beer", descripcionPro: "Light colored, translucent and bright lager, made with low fermentation, it has complex flavors with malt tones accompanied by types of hops, Czech barley and yeast", valorProdu: 15000, imagen: "../../assets/imagenes/productos/pilsen.png" },
      { idProducto: 11, nombrePro: "Limonada Turca", descripcionPro: "Elaboración: Para hacer esta peculiar y refrescante limonada turca, comenzamos exprimiendo...", valorProdu: 35000, imagen: "../../assets/imagenes/productos/limonada.jpg" }
    ]
    this.sendProductoServices.clearList().subscribe(
      limpiar => {
        if (limpiar) {
          this.ProduuctosSeleccionados = [];
          this.countPedidos = "0";
        }
      }
    );
  }
  ngOnInit(): void {
    this.idiomaService.getIdioma().subscribe(
      idioma => {
        let idm = idioma;
        this.idiomaSelected = idm;
      }
    )
    let getIdiomaCookie = Cookie.get('idioma');
    if (getIdiomaCookie != null) {
      if (getIdiomaCookie == "espanol") {
        this.idiomaSelected = getIdiomaCookie;
      } else {
        this.idiomaSelected = getIdiomaCookie;
      }
    } else {
      this.idiomaSelected = "espanol"
    }
  }

  agregarProducto(idPro: string) {
    let idPr: string = idPro;
    let contador: number = parseInt(this.countPedidos);

    if (this.ProduuctosSeleccionados.length > 0) {
      if (this.ProduuctosSeleccionados.find(x => x.idProducto === idPr)) {
        const Toast = Swal.mixin({
          toast: true,
          position: 'top-end',
          showConfirmButton: false,
          timer: 3000,
          timerProgressBar: true,
          onOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer);
            toast.addEventListener('mouseleave', Swal.resumeTimer);
          }
        })

        Toast.fire({
          icon: 'error',
          title: 'Producto ya seleccionado'

        })
      } else {
        for (let x = 0; x < this.listaProductosESP.length; x++) {
          if (this.listaProductosESP[x].idProducto === idPr) {
            contador = contador + 1;
            this.countPedidos = contador.toString();
            this.ProduuctosSeleccionados.push(this.listaProductosESP[x]);
            console.log(this.ProduuctosSeleccionados);
          }
        }
      }
    } else {
      for (let i = 0; i < this.listaProductosESP.length; i++) {
        if (this.listaProductosESP[i].idProducto === idPr) {
          contador = contador + 1;
          this.countPedidos = contador.toString();
          this.ProduuctosSeleccionados.push(this.listaProductosESP[i]);
        }
      }
    }
  }
  sendProductos() {
    this.sendProductoServices.sendProducto(this.ProduuctosSeleccionados);
  }
}
