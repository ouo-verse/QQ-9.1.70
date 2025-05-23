package se3;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import gw4.g;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.Foreground;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006*"}, d2 = {"Lse3/d;", "Landroid/app/Dialog;", "", h.F, "d", "g", "i", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/Window;", "window", "j", "Lgw4/g;", "forceUpdateInfo", "k", "onBackPressed", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "contentView", "f", "exitButton", "updateButton", "Lgw4/g;", "Lid3/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lid3/d;", "dtReporter", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reporter", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "D", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d extends Dialog {

    /* renamed from: C, reason: from kotlin metadata */
    private final ZplanViewReportHelper reporter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView iconView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView contentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView exitButton;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView updateButton;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private g forceUpdateInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final id3.d dtReporter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context, R.style.f2432107);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dtReporter = new id3.d(null, 1, null);
        this.reporter = new ZplanViewReportHelper();
        Window window = getWindow();
        if (window != null) {
            j(window);
        }
    }

    private final void d() {
        g gVar = this.forceUpdateInfo;
        URLDrawable drawable = URLDrawable.getDrawable(gVar != null ? gVar.f403476b : null, URLDrawable.URLDrawableOptions.obtain());
        ImageView imageView = this.iconView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
        g gVar2 = this.forceUpdateInfo;
        Spanned fromHtml = Html.fromHtml(gVar2 != null ? gVar2.f403477c : null);
        TextView textView = this.contentView;
        if (textView != null) {
            textView.setText(fromHtml);
        }
        TextView textView2 = this.contentView;
        if (textView2 != null) {
            textView2.setMovementMethod(ScrollingMovementMethod.getInstance());
        }
        TextView textView3 = this.exitButton;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: se3.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.e(d.this, view);
                }
            });
        }
        g gVar3 = this.forceUpdateInfo;
        boolean z16 = false;
        if (gVar3 != null && gVar3.f403475a) {
            z16 = true;
        }
        if (z16) {
            TextView textView4 = this.exitButton;
            if (textView4 != null) {
                textView4.setText("\u9000\u51fa");
            }
        } else {
            TextView textView5 = this.exitButton;
            if (textView5 != null) {
                textView5.setText("\u53d6\u6d88");
            }
        }
        TextView textView6 = this.updateButton;
        if (textView6 != null) {
            textView6.setOnClickListener(new View.OnClickListener() { // from class: se3.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.f(d.this, view);
                }
            });
        }
        g gVar4 = this.forceUpdateInfo;
        String str = gVar4 != null ? gVar4.f403476b : null;
        Boolean valueOf = gVar4 != null ? Boolean.valueOf(gVar4.f403475a) : null;
        g gVar5 = this.forceUpdateInfo;
        QLog.i("ForceUpdateDialog", 1, "bindData :: backgroundUrl == " + str + " , isForceUpdate == " + valueOf + " ,scheme == " + (gVar5 != null ? gVar5.f403478d : null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(d this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
        id3.d dVar = this$0.dtReporter;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        dVar.c("clck", it, new LinkedHashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(d this$0, View it) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g gVar = this$0.forceUpdateInfo;
        if (gVar != null && (str = gVar.f403478d) != null) {
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            iSchemeApi.launchScheme(context, str);
        }
        id3.d dVar = this$0.dtReporter;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        dVar.c("clck", it, new LinkedHashMap());
    }

    private final void i() {
        Activity topActivity = Foreground.getTopActivity();
        g gVar = this.forceUpdateInfo;
        boolean z16 = false;
        if (gVar != null && gVar.f403475a) {
            z16 = true;
        }
        if (z16 && topActivity != null) {
            topActivity.finish();
        } else {
            dismiss();
        }
    }

    public final void j(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        window.setAttributes(attributes);
    }

    public final void k(g forceUpdateInfo) {
        Intrinsics.checkNotNullParameter(forceUpdateInfo, "forceUpdateInfo");
        this.forceUpdateInfo = forceUpdateInfo;
        show();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        i();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d9y);
        h();
        d();
        g();
    }

    private final void g() {
        String str;
        View rootView = findViewById(R.id.pvm);
        HashMap hashMap = new HashMap();
        ZootopiaSource b16 = ag.f373258a.b();
        if (b16 == null || (str = ah.b(b16)) == null) {
            str = "";
        }
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
        ZplanViewReportHelper zplanViewReportHelper = this.reporter;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        zplanViewReportHelper.a(this, rootView, "pg_zplan_paradise", hashMap);
        TextView textView = this.exitButton;
        if (textView != null) {
            ZplanViewReportHelper.h(this.reporter, textView, "em_zplan_update_win_backtoqq", hashMap, false, null, false, 48, null);
        }
        TextView textView2 = this.updateButton;
        if (textView2 != null) {
            ZplanViewReportHelper.h(this.reporter, textView2, "em_zplan_update_win_jumptoupdate", hashMap, false, null, false, 48, null);
        }
    }

    private final void h() {
        this.iconView = (ImageView) findViewById(R.id.pvp);
        this.contentView = (TextView) findViewById(R.id.pvn);
        this.exitButton = (TextView) findViewById(R.id.pvo);
        this.updateButton = (TextView) findViewById(R.id.pvl);
    }
}
