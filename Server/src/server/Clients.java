package server;

public class Clients {
    ClientForm[] clients = new ClientForm[1000];
    int count=0;
    
    void addClient(ClientForm f){
        clients[count] = f;
        clients[count].c = this;
        clients[count].index = count;
        count++;
    }
    
    void removeClient(int i){
        count--;
        for(int j=i;j<count;j++){
            clients[j] = clients[j+1];
        }
    }
    
}
