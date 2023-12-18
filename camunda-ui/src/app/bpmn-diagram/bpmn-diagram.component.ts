import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bpmn-diagram',
  templateUrl: './bpmn-diagram.component.html',
  styleUrls: ['./bpmn-diagram.component.css'],
})
export class BpmnDiagramComponent implements OnInit {
  private bpmnJS: BpmnJS;

  ngOnInit(): void {
    this.bpmnJS = new BpmnJS({
      container: '#bpmn-container', // Replace with the ID or class of your container element
    });

    // Load a BPMN diagram (optional)
    this.loadBpmnDiagram();
  }

  private loadBpmnDiagram(): void {
    // Example: Load a BPMN diagram from a file
    this.bpmnJS.importXML('<your-bpmn-xml>', (err) => {
      if (err) {
        console.error('Error importing BPMN diagram', err);
      } else {
        console.log('BPMN diagram loaded successfully');
      }
    });
  }
}
