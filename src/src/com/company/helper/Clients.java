package com.company.helper;

import java.util.ArrayList;

public class Clients {
    ArrayList<Client> Clients = new ArrayList<>();

    public void addClient(Client client){
        this.Clients.add(client);
    }

    public ArrayList<Client> getClients() {
        return Clients;
    }

    public Client getClient(int clientId) {
        for(int i = 0; i < Clients.size(); i++) {
            if (Clients.get(i).getClientId() == clientId) {
                return Clients.get(i);
            }
        }
        return null;
    }

    public int getSize() {
        return Clients.size();
    }

}
