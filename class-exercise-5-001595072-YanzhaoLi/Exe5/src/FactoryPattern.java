/**
 * factory pattern
 *
 * @author Yanzhao Li
 * @date 2021/11/15
 */
public class FactoryPattern {
    public static class PersonFactory {
        /**
         * get person info
         *
         * @param name   name of person
         * @param gender gender of person
         * @return {@link Person}
         */
        public static Person getPerson(String name, String gender) {
            if(gender.equalsIgnoreCase("M")) {
                return new Male(name);
            } else if(gender.equalsIgnoreCase("F")) {
                return new Female(name);
            } // So on
            return null;
        }
    }

    /**
     * show
     */
    public static void show() {
        Person Male = PersonFactory.getPerson("Robinhood","M");
        System.out.println(Male.getNameAndSalutation());

        Person Female = PersonFactory.getPerson("Mary","F");
        System.out.println(Female.getNameAndSalutation());
    }
}

/**
 * person
 *
 * @author Yanzhao Li
 * @date 2021/11/15
 */
abstract class Person {
    Person(String name) {
        this.name = name;
    }

    private String name;

    /**
     * get salutation
     *
     * @return {@link String}
     */
    abstract String getSalutation();

    /**
     * get name and salutation
     *
     * @return {@link String}
     */
    String getNameAndSalutation(){
        return getSalutation() +" "+ name;
    }

}

/**
 * Male
 *
 * @author Yanzhao Li
 * @date 2021/11/15
 */
class Male extends Person {
    /**
     * Male
     *
     * @param name name Of man
     */
    public Male(String name) {
        super(name);
    }

    /**
     * get salutation
     *
     * @return {@link String}
     */
    @Override
    String getSalutation() {
        return"Mr";
    }
}

/**
 * female
 *
 * @author Yanzhao Li
 * @date 2021/11/15
 */
class Female extends Person {
    /**
     * female
     *
     * @param name 的名字
     */
    public Female(String name) {
        super(name);
    }

    /**
     * get salutation
     *
     * @return {@link String}
     */
    @Override
    String getSalutation() {
        return"Miss/Mrs";
    }
}

