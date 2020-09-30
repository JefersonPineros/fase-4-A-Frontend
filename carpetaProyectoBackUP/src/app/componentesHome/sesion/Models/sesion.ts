export class Sesion {
    public emailSesion: string;
    public contrasenaSesion: string;
    constuctor(
        email: string,
        contrasena: string
    ) {
        this.emailSesion = email;
        this.contrasenaSesion = contrasena;
    }
    getEmail() {
        return this.emailSesion;
    }
    setEmail(email: string) {
        this.emailSesion = email;
    }
    getPass() {
        return this.contrasenaSesion;
    }
    setPass(pass: string) {
        this.contrasenaSesion = pass;
    }
}

