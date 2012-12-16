package ifml2.om;

import ca.odell.glazedlists.BasicEventList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import java.util.List;

class RoleDefinition
{
    @XmlAttribute(name = "name")
    @XmlID
    private String name;
    public String getName()
    {
        return name;
    }

    @XmlAttribute(name = "description")
    public String description;

    @XmlElementWrapper(name = "properties")
    @XmlElement(name = "property")
    public List<PropertyDefinition> propertyDefinitions = new BasicEventList<PropertyDefinition>();

    @XmlElementWrapper(name = "triggers")
    @XmlElement(name = "trigger")
    public List<Trigger> triggers = new BasicEventList<Trigger>();

    @Override
    public String toString()
    {
        return "определение роли " + name;
    }

    public PropertyDefinition getPropertyDefinitionByName(String name)
    {
        assert name != null;
        for(PropertyDefinition propertyDefinition : propertyDefinitions)
        {
            if(name.equalsIgnoreCase(propertyDefinition.getName()))
            {
               return propertyDefinition;
            }
        }
        return null;
    }

    public Trigger getTrigger(Trigger.TriggerTypeEnum triggerType)
    {
        for (Trigger trigger : triggers)
        {
            if(triggerType.equals(trigger.getType()))
            {
                return trigger;
            }
        }

        return null;
    }
}
