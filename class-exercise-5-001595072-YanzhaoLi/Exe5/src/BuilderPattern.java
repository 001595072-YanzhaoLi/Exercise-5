/**
 * builderPattern
 *
 * @author Yanzhao Li
 * @date 2021/11/15
 */
public class BuilderPattern {
    /**
     * coffee
     *
     * @author Yanzhao Li
     * @date 2021/11/15
     */
    static class COffee {
        private COffee(Builder Builder) {
            this.type = Builder.type;
            this.sugar = Builder.sugar;
            this.milk = Builder.milk;
            this.size = Builder.size;
        }

        private String type;
        private boolean sugar;
        private boolean milk;
        private String size;

        /**
         * builder
         *
         * @author Yanzhao Li
         * @date 2021/11/15
         */
        public static class Builder {
            private String type;
            private boolean sugar;
            private boolean milk;
            private String size;

            /**
             * builder
             *
             * @param type type
             */
            public Builder(String type) {
                this.type = type;
            }

            /**
             * sugar
             *
             * @param value value of sugar
             * @return {@link Builder}
             */
            public Builder sugar(boolean value) {
                this.sugar = value;
                return this;
            }

            /**
             * milk
             *
             * @param value value of milk
             * @return {@link Builder}
             */
            public Builder milk(boolean value) {
                this.milk = value;
                return this;
            }

            /**
             * size
             *
             * @param value size
             * @return {@link Builder}
             */
            public Builder size(String value) {
                this.size = value;
                return this;
            }

            /**
             * build
             *
             * @return {@link COffee}
             */
            public COffee build() {
                return new COffee(this);
            }
        }

        /**
         * toString
         *
         * @return {@link String}
         */
        @Override
        public String toString() {
            return String.format("COffee [type=%s, sugar=%s, milk=%s, size=%s]", this.type, sugar, milk, size);
        }

    }

    /**
     * show
     */
    public static void show() {
        COffee COffee = new BuilderPattern.COffee.Builder("Mocha").milk(true).sugar(false).size("Large").build();
        System.out.println(COffee);

    }
}