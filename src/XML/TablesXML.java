package XML;

import functions.Orders;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tables")
@XmlAccessorType(XmlAccessType.FIELD)
public class TablesXML {
    @XmlElement(name = "table")
    private List<TableXML> tablexml;



    public List<TableXML> getTable() {
        return tablexml;
    }

    public void setTable(List<TableXML> table) {
        this.tablexml = table;
    }
}
