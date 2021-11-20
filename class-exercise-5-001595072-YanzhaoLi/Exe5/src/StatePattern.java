/**
 * state pattern
 *
 * @author Yanzhao Li
 * @date 2021/11/15
 */
public class StatePattern {
    /**
     * show
     */
    public static void show() {
        FanControl a = new FanControl();
        System.out.println(a);
        a.rotate();
        System.out.println(a);
        a.rotate();
        System.out.println(a);
        a.rotate();
        System.out.println(a);
        a.rotate();
        System.out.println(a);
    }

    static class FanControl {
        private SpeedLevel current;

        /**
         * controller of fan
         */
        public FanControl() {
            current = new Off();
        }

        /**
         * set the State
         *
         * @param state state
         */
        public void set_state(SpeedLevel state) {
            current = state;
        }

        /**
         * rotate the controller
         */
        public void rotate() {
            current.rotate(this);
        }

        /**
         * toString
         *
         * @return {@link String}
         */
        @Override
        public String toString() {
            return String.format("Fan Wall Control [current = %s]", current);
        }
    }

    /**
     * speed level of fan
     *
     * @author Yanzhao Li
     * @date 2021/11/15
     */
    interface SpeedLevel {
        int level = 0;

        /**
         * rotate the controller
         *
         * @param FanwallControl fanwall控制
         */
        void rotate(FanControl FanwallControl);
    }

    /**
     * speed level off
     *
     * @author Yanzhao Li
     * @date 2021/11/15
     */
    static class Off implements SpeedLevel {
        /**
         * rotate the controller
         *
         * @param FanwallControl controller
         */
        @Override
        public void rotate(FanControl FanwallControl) {
            FanwallControl.set_state(new SpeedLevel1());
        }
    }

    /**
     * speed level 1
     *
     * @author Yanzhao Li
     * @date 2021/11/15
     */
    static class SpeedLevel1 implements SpeedLevel {
        /**
         * rotate the controller
         *
         * @param FanwallControl controller
         */
        @Override
        public void rotate(FanControl FanwallControl) {
            FanwallControl.set_state(new SpeedLevel2());
        }
    }

    /**
     * speed level 2
     *
     * @author Yanzhao Li
     * @date 2021/11/15
     */
    static class SpeedLevel2 implements SpeedLevel {
        /**
         * rotate the controller
         *
         * @param FanwallControl controller
         */
        @Override
        public void rotate(FanControl FanwallControl) {
            FanwallControl.set_state(new SpeedLevel3());
        }
    }

    /**
     * speed level 3
     *
     * @author Yanzhao Li
     * @date 2021/11/15
     */
    static class SpeedLevel3 implements SpeedLevel {
        /**
         * rotate the controller
         *
         * @param FanwallControl controller
         */
        @Override
        public void rotate(FanControl FanwallControl) {
            FanwallControl.set_state(new Off());
        }
    }
}