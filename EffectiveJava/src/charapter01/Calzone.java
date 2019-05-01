package charapter01;

public class Calzone extends Pizza {

	private final boolean sauceInSide;
	
	public static class Builder extends Pizza.Builder<Builder>{
		private boolean sauceInSide = false; // Default

		@Override
		public Calzone build() {
			return new Calzone(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}
	
	private Calzone(Builder builder) {
		super(builder);
		sauceInSide = builder.sauceInSide;
	}

}
