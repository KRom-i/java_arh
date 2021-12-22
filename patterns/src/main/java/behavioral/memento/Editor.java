package behavioral.memento;

public class Editor {

    private String content = "";

    public void write(String words){
        this.content = this.content + " " + words;
    }

    public String getContent () {
        return content;
    }

    public EditorMemento save(){
        return  new EditorMemento (this.content);
    }

    public void restore(EditorMemento editorMemento){
        this.content = editorMemento.getContent ();
    }

    @Override
    public String toString () {
        return "Editor{" +
                "content='" + content + '\'' +
                '}';
    }
}
