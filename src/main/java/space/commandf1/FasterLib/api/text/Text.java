package space.commandf1.FasterLib.api.text;


import net.md_5.bungee.api.chat.*;

import java.io.Serializable;

@SuppressWarnings("unused")
public class Text implements Serializable {
    private final TextComponent textComponent;

    public Text(String message) {
        this.textComponent = new TextComponent(message);
    }

    public Text setHoverEvent(HoverEvent.Action action, String hover) {
        this.textComponent.setHoverEvent(new HoverEvent(action, new ComponentBuilder(hover).create()));
        return this;
    }

    public Text setClickEvent(ClickEvent.Action action, String value) {
        this.textComponent.setClickEvent(new ClickEvent(action, value));
        return this;
    }

    public TextComponent getTextComponent() {
        return this.textComponent;
    }
}
