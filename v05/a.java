package v05;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a extends ReportDialog {
    Animatable C;
    SlideDetectListView D;
    TextView E;
    Context F;

    public a(Context context) {
        super(context, R.style.f174185s6);
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.al7, (ViewGroup) null);
        setContentView(inflate);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
        setCanceledOnTouchOutside(false);
        TextView textView = (TextView) inflate.findViewById(R.id.ivTitleBtnLeft);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setText(R.string.button_back);
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.ivTitleName);
        this.E = textView2;
        if (textView2 != null) {
            try {
                textView2.setVisibility(0);
                this.E.setText(HardCodeUtil.qqStr(R.string.tjf));
            } catch (Exception unused) {
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("SignatureLoadingDialog", 2, "enter into SignatureLoading");
        }
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Animatable animatable = this.C;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog, android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        TextView textView;
        super.onWindowFocusChanged(z16);
        Animatable animatable = (Animatable) this.F.getResources().getDrawable(R.drawable.common_loading6);
        this.C = animatable;
        if (animatable != null && (textView = this.E) != null) {
            textView.setCompoundDrawablePadding(10);
            this.E.setCompoundDrawablesWithIntrinsicBounds((Drawable) this.C, (Drawable) null, (Drawable) null, (Drawable) null);
            this.C.start();
        }
    }
}
