package ifpb.ads.pdm.atividadecolaborativa.component;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;

public class ButtonComponent extends LinearLayout {

    private String label;
    private Button button;

    public ButtonComponent(Context context, String label) {
        super(context);
        this.label = label;
        init();
    }

    private void init() {
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
        setOrientation(VERTICAL);
        button = new Button(getContext());
        button.setText(label);
        addView(button);
    }

    public void setOnClickAction(OnClickListener onClickListener){
        button.setOnClickListener(onClickListener);
    }
}
