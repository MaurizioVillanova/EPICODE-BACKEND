package it.epicode.gestione_incendi.application.models;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MioCanaleDiComunicazione implements CanaleDiComunicazione{

    @Override
    public void inviaMessaggio(String messaggio) {
        System.out.println("Invio messaggio: " + messaggio);
    }

}
