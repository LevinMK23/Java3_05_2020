package lesson1;

public class Converter<From, To> {

    @SuppressWarnings("unchecked")
    To func(From param) {
        return (To) param;
    }

}
