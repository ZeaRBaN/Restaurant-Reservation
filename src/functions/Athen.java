package functions;

import GUI.Alertbox;
import inhertance.*;

import java.util.ArrayList;
import java.util.List;

public class Athen {

    List<User> user=new ArrayList<>();
    User found=null;
  private String nameofclient;

    public String getNameofclient() {
        return nameofclient;
    }

    public void setNameofclient(String nameofclient) {
        this.nameofclient = nameofclient;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public String check(String username, String password){
        for (User u : user){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                nameofclient=u.getName();
                found=u;
                break;
            }
        }
        if (found==null){
            Alertbox.display("Wrong Username or Password");
        }
        if(found instanceof Client){
            return "Client";
        }else if(found instanceof Manager){
            return "Manager";
        }else if(found instanceof Cooker){
            return "Cooker";
        }else if(found instanceof Waiter){
            return "Waiter";
        }
        return "ERROR";
    }

}
