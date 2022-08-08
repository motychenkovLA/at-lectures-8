package tracker;

// todo * - нигде в коде не используется и не должен использоваться Attachment,
//  всегда используются его наследники.
//  1) зачем оставлять возможность его инстанцировать?
//  2) зачем ему какое-то конкретное поведение?
public class Attachment {

    @Override
    public String toString() {
        return "Комментарий или ссылка";
    }

    // todo * - такие перегрузки вовсе не перегрузки, метод ничего не изменил в поведении
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    // todo * - такие перегрузки вовсе не перегрузки, метод ничего не изменил в поведении
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
