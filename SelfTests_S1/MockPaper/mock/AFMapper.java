package mock;

/**
 * Interface which provides  a {@code doMap} method that applies a transformation on the input object
 * and returns the result of the transformation.
 *
 * Created by saile on 1/20/17.
 */
public interface  AFMapper {
    /**
     * Applies a transformation on {@code Object o} and return the result of the transformation.
     *
     * @param o object to transform
     * @return transformed object
     */
    public Object doMap(Object o);
}
