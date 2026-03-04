import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AzureDemo {
 
    private String serviceName;
 
    private String region;
    
    private boolean isRunning;

    public AzureDemo(String serviceName, String region) {
        this.serviceName = serviceName;
        this.region = region;
        this.isRunning = false;
    }

    public void start() {
        this.isRunning = true;
        System.out.println(serviceName + " started in " + region);
    }

    public void stop() {
        this.isRunning = false;
        System.out.println(serviceName + " stopped.");
    }

    public String getStatus() {
        return isRunning ? "Running" : "Stopped";
    }

    public static Map<String, String> getAzureRegions() {
        Map<String, String> regions = new HashMap<>();
        regions.put("eastus", "East US");
        regions.put("westus", "West US");
        regions.put("northeurope", "North Europe");
        regions.put("eastasia", "East Asia");
        return regions;
    }

    public static List<String> getAzureServices() {
        List<String> services = new ArrayList<>();
        services.add("Azure App Service");
        services.add("Azure Blob Storage");
        services.add("Azure SQL Database");
        services.add("Azure Functions");
        services.add("Azure Kubernetes Service");
        return services;
    }

    public static void main(String[] args) {
        System.out.println("=== Azure Services ===");
        getAzureServices().forEach(s -> System.out.println("- " + s));

        System.out.println("\n=== Azure Regions ===");
        getAzureRegions().forEach((k, v) -> System.out.println(k + " -> " + v));

        System.out.println("\n=== Demo Service ===");
        AzureDemo demo = new AzureDemo("Azure App Service", "East US");
        System.out.println("Status: " + demo.getStatus());
        demo.start();
        System.out.println("Status: " + demo.getStatus());
        demo.stop();
        System.out.println("Status: " + demo.getStatus());
    }
}
