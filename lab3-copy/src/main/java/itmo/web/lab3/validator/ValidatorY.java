package itmo.web.lab3.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author Romariok on 21.11.2023
 */
@FacesValidator("validatorY")
public class ValidatorY implements Validator {
    private static final float MAX_Y = 3;
    private static final float MIN_Y = -5;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        if (o == null) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                            "Поле Y не может быть пустым!"));
        }
        double y = Double.parseDouble(String.valueOf(o));
        if (y < MIN_Y || y > MAX_Y) throw new ValidatorException(
                new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
                        String.format("Значение Y должно находиться в отрезке [%s ... %s].", MIN_Y, MAX_Y))
        );
    }
}