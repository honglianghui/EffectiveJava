package charapter01;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

//优先考虑依赖注入来引用资源
public class SpellChecker {
	private final Lexicn dictionary;

	// dependency injection:依赖注入
	private SpellChecker(Lexicn dictionary) {
		this.dictionary = Objects.requireNonNull(dictionary);
	}// Noninstantiable

	public static boolean isValid(String word) {
		return false;
	}

	public static List<String> suggestions(String typo) {
		return null;
	}

	// bounded wildcard type:有限制的通配符类型
	Mosaic create(Supplier<? extends Tile> tileFactory) {
		//Mosaic mosaic = ((Object) tileFactory).create();
		Mosaic mosaic = null;
		return mosaic;
	}
}

class Tile {

}

class Mosaic extends Tile {

}
