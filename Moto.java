/**
 * Represents a motorcycle with basic properties.
 * This class follows the Model-Context-Protocol pattern for data encapsulation.
 */
public class Moto {
    // Private fields with proper encapsulation
    private final String licensePlate;
    private final String color;
    private final String brand;

    /**
     * Constructs a new Moto instance.
     *
     * @param licensePlate The license plate of the motorcycle (cannot be null or empty)
     * @param color The color of the motorcycle (cannot be null or empty)
     * @param brand The brand of the motorcycle (cannot be null or empty)
     * @throws IllegalArgumentException if any parameter is null or empty
     */
    public Moto(String licensePlate, String color, String brand) {
        if (licensePlate == null || licensePlate.trim().isEmpty()) {
            throw new IllegalArgumentException("License plate cannot be null or empty");
        }
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color cannot be null or empty");
        }
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Brand cannot be null or empty");
        }
        
        this.licensePlate = licensePlate.trim();
        this.color = color.trim();
        this.brand = brand.trim();
    }

    /**
     * @return The license plate of the motorcycle
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * @return The color of the motorcycle
     */
    public String getColor() {
        return color;
    }

    /**
     * @return The brand of the motorcycle
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Returns a string representation of the motorcycle.
     * 
     * @return A string in the format "Moto{licensePlate='...', color='...', brand='...'}"
     */
    @Override
    public String toString() {
        return String.format("Moto{licensePlate='%s', color='%s', brand='%s'}", 
                           licensePlate, color, brand);
    }

    /**
     * Compares this motorcycle to another object for equality.
     * Two motorcycles are considered equal if they have the same license plate.
     * 
     * @param obj The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Moto moto = (Moto) obj;
        return licensePlate.equals(moto.licensePlate);
    }

    /**
     * Returns a hash code value for this motorcycle.
     * 
     * @return A hash code value based on the license plate
     */
    @Override
    public int hashCode() {
        return licensePlate.hashCode();
    }
}
