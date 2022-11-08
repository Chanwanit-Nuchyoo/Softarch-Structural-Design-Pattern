import java.util.Map;
import java.util.LinkedHashMap;
public class HealthcareWorkerTeam implements HealthcareServiceable{
    private Map<String,HealthcareWorker> children = new LinkedHashMap<String, HealthcareWorker>();
    private double totalPrice;

    public void addMember(HealthcareWorker member){
        this.children.put(member.getName(),member);
    }

    public void addMember(HealthcareWorkerTeam team){
        team.children.forEach((key,value) -> { this.children.put(key,value); });
    }

    public Map<String,HealthcareWorker> getChildren(){
        return this.children;
    }

    public void removeMember(HealthcareWorker m){
        children.remove(m.getName());
    }

    public void service(){
        children.forEach((key,value) -> value.service());
    }
    public double getPrice(){
        this.totalPrice = 0;
        this.children.forEach((key,value) -> { this.totalPrice += value.getPrice(); });
        return this.totalPrice;
    }
}
