import { Component, OnInit } from '@angular/core';
import * as CanvasJS from '../../../assets/js/canvasjs.min.js';

@Component({
  selector: 'app-reportes',
  templateUrl: './reportes.component.html',
  styleUrls: ['./reportes.component.css']
})
export class ReportesComponent implements OnInit {

  constructor() { 

  }

  ngOnInit(): void {
    let chart2 = new CanvasJS.Chart("chartContainer2", {
      theme: "light2",
      animationEnabled: true,
      exportEnabled: true,
      title:{
        text: "Pedidos por semana"
      },
      data: [{
        type: "pie",
        showInLegend: true,
        toolTipContent: "<b>{name}</b>: ${y} (#percent%)",
        indexLabel: "{name} - #percent%",
        dataPoints: [
          { y: 120, name: "Primera semana" },
          { y: 300, name: "Segunda Semana" },
          { y: 800, name: "Tercera Semana" },
          { y: 150, name: "Cuarta Semana" }
        ]
      }]
    });
    let chart = new CanvasJS.Chart("chartContainer", {
      animationEnabled: true,
      exportEnabled: true,
      title: {
        text: "Productos vendidos mes julio"
      },
      data: [{
        type: "column",
        dataPoints: [
          { y: 71, label: "Cervezas" },
          { y: 55, label: "Cocteles" },
          { y: 50, label: "Whyskys" },
          { y: 65, label: "Comidas" },
          { y: 95, label: "Aguardientes" }
        ]
      }]
    }
    
    );
    let dataPoints = [];
	let y = 0;		
	for ( var i = 0; i < 5000; i++ ) {		  
		y += Math.round(5 + Math.random() * (-5 - 5));	
		dataPoints.push({ y: y});
	}
	let chart3 = new CanvasJS.Chart("chartContainer3", {
		zoomEnabled: true,
		animationEnabled: true,
		exportEnabled: true,
		title: {
      text: "Crecimiento en ventas"
		},
		subtitles:[{
			text: ""
		}],
		data: [
		{
			type: "line",                
			dataPoints: dataPoints
		}]
	});
      
    chart.render();
    chart2.render();
    chart3.render();
  }

}
