import { Validator, NG_VALIDATORS, AbstractControl } from '@angular/forms';
import { Directive, Input } from '@angular/core';

@Directive({
    selector:'[appConfirmEqualsValidator]',
    providers:[{
        provide: NG_VALIDATORS,
        useExisting: ConfirmEqualsValidatorDirective,
        multi: true
    }]
    
})
export class ConfirmEqualsValidatorDirective implements Validator{
    @Input() appConfirmEqualsValidator:string;

    validate(control:AbstractControl):{[key: string]:any} | null{
        const controlToCompare = control.parent.get(this.appConfirmEqualsValidator); 
        if(controlToCompare && controlToCompare.value !== control.value){
            return { 'notEquals':true};
        }
        return null;
    }
}