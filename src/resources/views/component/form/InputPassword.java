package resources.views.component.form;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;


public class InputPassword extends JPasswordField {

    /**
     * @return the borderFocusColor
     */
    public Color getBorderFocusColor() {
        return borderFocusColor;
    }

    /**
     * @param borderFocusColor the borderFocusColor to set
     */
    public void setBorderFocusColor(Color borderFocusColor) {
        this.borderFocusColor = borderFocusColor;
    }

    /**
     * @return the fontColor
     */
    public Color getFontColor() {
        return fontColor;
    }

    /**
     * @param fontColor the fontColor to set
     */
    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    /**
     * @return the placeholderColor
     */
    public Color getPlaceholderColor() {
        return placeholderColor;
    }

    /**
     * @param placeholderColor the placeholderColor to set
     */
    public void setPlaceholderColor(Color placeholderColor) {
        this.placeholderColor = placeholderColor;
        setForeground(placeholderColor);
    }

    /**
     * @return the inputNotNull
     */
    public boolean isInputNotNull() {
        return inputNotNull;
    }

    /**
     * @param inputNotNull the inputNotNull to set
     */
    public void setInputNotNull(boolean inputNotNull) {
        this.inputNotNull = inputNotNull;
    }

    /**
     * @return the placeholder
     */
    public String getPlaceholder() {
        return placeholder;
    }

    /**
     * @param placeholder the placeholder to set
     */
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        setText(placeholder);
    }

    /**
     * @return the backgroundTransparent
     */
    public boolean isBackgroundTransparent() {
        return backgroundTransparent;
    }

    /**
     * @param backgroundTransparent the backgroundTransparent to set
     */
    public void setBackgroundTransparent(boolean backgroundTransparent) {
        this.backgroundTransparent = backgroundTransparent;
        if(backgroundTransparent) {
            setBackground(new Color(0, 0, 0, 1));
        } else {
            setBackground(getBackground());
        }
    }
    
    private void eventFocusListener() {
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(
                                1, 1, 1, 1, 
                                borderFocusColor
                        ), 
                        BorderFactory.createEmptyBorder(5, 10, 5, 10)
                ));
                
                setForeground(getFontColor());
                
                setEchoChar('\u2022');
                
                if(getText().equals(getPlaceholder())) {
                    setText(null);
                    requestFocus();
                } else {
                    requestFocus();
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(
                                1, 1, 1, 1, 
                                borderColor
                        ), 
                        BorderFactory.createEmptyBorder(5, 10, 5, 10)
                ));
                
                if(getText().equals("")) {
                    setEchoChar('\u0000');
                    setText(getPlaceholder());
                    setInputNotNull(false);
                    setForeground(placeholderColor);
                } else {
                    setEchoChar('\u2022');
                    setInputNotNull(true);
                    setForeground(fontColor);
                }
            }
        });
    }

    public InputPassword() {
        // Init background
        backgroundTransparent = false;
        
        setBackground(Color.decode("#FFFFFF"));
        
        //init foreground
        fontColor = Color.decode("#AAAAAA");
        
        // Init Placeholder
        placeholder = "Placeholder";
        placeholderColor = Color.decode("#DDDDDD");
        
        // Init Border
        borderColor = Color.decode("#DDDDDD");
        borderFocusColor = Color.decode("#48703A");
        
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(
                        1, 1, 1, 1, 
                        borderColor
                ), 
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        
        setText(placeholder);
        setForeground(placeholderColor);
        setEchoChar('\u0000');
        
        // add event focus
        eventFocusListener();
    }
    
    private boolean backgroundTransparent;
    private Color borderColor;
    private Color borderFocusColor;
    private String placeholder;
    private Color placeholderColor;
    private Color fontColor;
    private boolean inputNotNull;
}
