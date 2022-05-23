package XML;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersXML {

    @XmlElement(name = "user")
    private List<UserXML> userxml;

    public List<UserXML> getUser() {
        return userxml;
    }

    public void setUser(List<UserXML> user) {
        this.userxml = user;
    }
}