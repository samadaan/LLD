package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Box implements Package {

    List<Package> packageList;
    public Box(){
        packageList=new ArrayList<>();
    }
    public void addPackage(Package p){
        packageList.add(p);
    }
    public void removePackage(int index){
        if(packageList.isEmpty() || packageList.size()<index){
            System.out.println("No Package To Remove");
            return;
        }
        packageList.remove(index);
    }
    @Override
    public int cost() {
        int ans=0;
        for(Package p:packageList){
            ans+=p.cost();
        }
        return ans;
    }
}
