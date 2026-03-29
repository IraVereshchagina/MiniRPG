package class_game;

public class Info<T, U> {
    private T object;
    private U description;

    public Info (T object, U description){
        this.object = object;
        this.description = description;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public U getDescription() {
        return description;
    }

    public void setDescription(U description) {
        this.description = description;
    }
}
