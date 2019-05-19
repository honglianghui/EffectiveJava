package charapter01;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Build pattern for class hierarchies
 * 
 * @author LENOVO
 *
 */
public abstract class Pizza {
	final Set<Topping> toppings;
	// asfdsadf tttt
	// recursive type parameter
	abstract static class Builder<T extends Builder<T>> {
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}
		
		abstract Pizza build();

		protected abstract T self();
	}
	
	@Override
	public String toString() {
		return "Pizza [toppings=" + toppings + "]";
	}

	public Pizza(Builder<?> builder) {
		toppings = builder.toppings.clone();
	}
}
