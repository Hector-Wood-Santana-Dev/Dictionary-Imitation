public class Element {
    private Object key;
    private Object value;
    /**
     * The variable "flag" can have 3 states:
     * 0 for free
     * 1 for occupied
     * 2 for liberated
     */
    protected int flag;

    public Element(Object key, Object value, int flag) {
        this.key = key;
        this.value = value;
        this.flag = flag;
    }

    public Object getKey() {
        return key;
    }

    protected void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    protected void setValue(Object value) {
        this.value = value;
    }

    public int getFlag() {
        return flag;
    }

    protected void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Element{" +
                "key=" + key +
                ", value=" + value +
                ", flag=" + flag +
                '}';
    }
}
