package ts3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import us3.r;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends ReportDialog {
    private Activity C;
    private TextView D;
    private ImageView E;
    private View.OnClickListener F;

    public b(Activity activity) {
        super(activity, R.style.aya);
        this.C = activity;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(View.OnClickListener onClickListener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        dismiss();
        onClickListener.onClick(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private void initView() {
        View inflate = LayoutInflater.from(this.C).inflate(R.layout.f168280fi1, (ViewGroup) null);
        super.setContentView(inflate);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.D = (TextView) inflate.findViewById(R.id.f108936eg);
        this.E = (ImageView) inflate.findViewById(R.id.xkv);
        r.f440004a.d(getContext(), this.E, "https://minigame.gtimg.cn/public/appicon/minibox_guide_dialog_image_v1.png");
    }

    public void P(final View.OnClickListener onClickListener) {
        this.F = onClickListener;
        this.D.setOnClickListener(new View.OnClickListener() { // from class: ts3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.this.O(onClickListener, view);
            }
        });
    }
}
