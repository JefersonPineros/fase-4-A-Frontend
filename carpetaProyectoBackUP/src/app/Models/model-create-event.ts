export class CreateEvent{
    constructor(
        public eventDate:Date,
        public nameEvent:string,
        public resposableEvent:string,
        public typeEvent:string,
        public serviceOferedEvent:string,
        public imageEvent
    ){

    }
}