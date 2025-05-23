package u82;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SoftKeyboardStateHelper;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import h53.QUIInputCountCalculateStrategy;
import h53.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\t*\u0001%\u0018\u0000 +2\u00020\u0001:\u0001,B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lu82/b;", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper$SoftKeyboardStateListener;", "", "e", "", "draft", "f", h.F, "", "keyboardHeightInPx", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "Lu82/c;", "Lu82/c;", "listener", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper;", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper;", "keyboardStateHelper", "Landroid/app/Dialog;", "Landroid/app/Dialog;", "dialog", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "i", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "inputView", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "contentView", BdhLogUtil.LogTag.Tag_Conn, "dismissLayout", "D", "Ljava/lang/String;", "u82/b$b", "E", "Lu82/b$b;", "inputWatcher", "<init>", "(Landroid/content/Context;Lu82/c;)V", UserInfo.SEX_FEMALE, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements SoftKeyboardStateHelper.SoftKeyboardStateListener {

    /* renamed from: C, reason: from kotlin metadata */
    private View dismissLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private String draft;

    /* renamed from: E, reason: from kotlin metadata */
    private final C11329b inputWatcher;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final c listener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private SoftKeyboardStateHelper keyboardStateHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Dialog dialog;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QUISingleLineInputView inputView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View contentView;

    public b(Context context, c listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.context = context;
        this.listener = listener;
        this.draft = "";
        this.inputWatcher = new C11329b();
    }

    private final void e() {
        Dialog dialog = this.dialog;
        if (dialog != null) {
            if (dialog != null) {
                dialog.dismiss();
            }
            SoftKeyboardStateHelper softKeyboardStateHelper = this.keyboardStateHelper;
            if (softKeyboardStateHelper != null) {
                softKeyboardStateHelper.removeAllSoftKeyboardStateListeners();
            }
            this.keyboardStateHelper = null;
            this.dialog = null;
        }
    }

    private final void f(String draft) {
        Window window;
        e();
        QUISingleLineInputView qUISingleLineInputView = null;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.cw7, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026ating_input_dialog, null)");
        this.contentView = inflate;
        Dialog dialog = new Dialog(this.context, R.style.f173448dl);
        this.dialog = dialog;
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.requestFeature(1);
            try {
                ImmersiveUtils.clearCoverForStatus(window2, true);
            } catch (Exception e16) {
                QLog.e("FloatingInputDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
            }
            window2.setSoftInputMode(20);
        }
        Dialog dialog2 = this.dialog;
        if (dialog2 != null) {
            View view = this.contentView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentView");
                view = null;
            }
            dialog2.setContentView(view);
        }
        View view2 = this.contentView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view2 = null;
        }
        SoftKeyboardStateHelper softKeyboardStateHelper = new SoftKeyboardStateHelper(view2);
        this.keyboardStateHelper = softKeyboardStateHelper;
        softKeyboardStateHelper.addSoftKeyboardStateListener(this);
        Dialog dialog3 = this.dialog;
        if (dialog3 != null && (window = dialog3.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
        View view3 = this.contentView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view3 = null;
        }
        View findViewById = view3.findViewById(R.id.ojn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.dismiss_layout)");
        this.dismissLayout = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dismissLayout");
            findViewById = null;
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: u82.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                b.g(b.this, view4);
            }
        });
        View view4 = this.contentView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view4 = null;
        }
        View findViewById2 = view4.findViewById(R.id.ojr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById(R.id.edit_text)");
        QUISingleLineInputView qUISingleLineInputView2 = (QUISingleLineInputView) findViewById2;
        this.inputView = qUISingleLineInputView2;
        if (qUISingleLineInputView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputView");
            qUISingleLineInputView2 = null;
        }
        qUISingleLineInputView2.setCalculateStrategy(new QUIInputCountCalculateStrategy(2.0d, 2.0d, 1.0d, 1.0d));
        QUISingleLineInputView qUISingleLineInputView3 = this.inputView;
        if (qUISingleLineInputView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputView");
            qUISingleLineInputView3 = null;
        }
        qUISingleLineInputView3.setFocusableInTouchMode(true);
        QUISingleLineInputView qUISingleLineInputView4 = this.inputView;
        if (qUISingleLineInputView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputView");
            qUISingleLineInputView4 = null;
        }
        qUISingleLineInputView4.setContentText(draft);
        QUISingleLineInputView qUISingleLineInputView5 = this.inputView;
        if (qUISingleLineInputView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputView");
            qUISingleLineInputView5 = null;
        }
        qUISingleLineInputView5.setImeOptions(6);
        if (draft != null) {
            QUISingleLineInputView qUISingleLineInputView6 = this.inputView;
            if (qUISingleLineInputView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputView");
                qUISingleLineInputView6 = null;
            }
            qUISingleLineInputView6.setTextSelection(draft.length());
        }
        QUISingleLineInputView qUISingleLineInputView7 = this.inputView;
        if (qUISingleLineInputView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputView");
        } else {
            qUISingleLineInputView = qUISingleLineInputView7;
        }
        qUISingleLineInputView.setInputViewWatcher(this.inputWatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(b this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.e();
    }

    public final void h(String draft) {
        try {
            f(draft);
            Dialog dialog = this.dialog;
            if (dialog != null) {
                dialog.show();
            }
            QUISingleLineInputView qUISingleLineInputView = this.inputView;
            if (qUISingleLineInputView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputView");
                qUISingleLineInputView = null;
            }
            qUISingleLineInputView.q();
        } catch (Throwable th5) {
            QLog.e("FloatingInputDialog", 1, "try show dialog error. ", th5);
        }
    }

    @Override // com.tencent.mobileqq.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
    public void onSoftKeyboardClosed() {
        QUISingleLineInputView qUISingleLineInputView = this.inputView;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputView");
            qUISingleLineInputView = null;
        }
        ViewGroup.LayoutParams layoutParams = qUISingleLineInputView.getLayoutParams();
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.bottomMargin = 0;
            qUISingleLineInputView.setLayoutParams(layoutParams2);
            e();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    @Override // com.tencent.mobileqq.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
    public void onSoftKeyboardOpened(int keyboardHeightInPx) {
        QUISingleLineInputView qUISingleLineInputView = this.inputView;
        if (qUISingleLineInputView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputView");
            qUISingleLineInputView = null;
        }
        ViewGroup.LayoutParams layoutParams = qUISingleLineInputView.getLayoutParams();
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.bottomMargin = keyboardHeightInPx;
            qUISingleLineInputView.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"u82/b$b", "Lh53/q;", "", "title", "", "A4", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u82.b$b, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11329b implements q {
        C11329b() {
        }

        @Override // h53.k
        public void afterTextChanged(Editable s16) {
            c cVar = b.this.listener;
            QUISingleLineInputView qUISingleLineInputView = b.this.inputView;
            if (qUISingleLineInputView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputView");
                qUISingleLineInputView = null;
            }
            cVar.a(String.valueOf(qUISingleLineInputView.d()));
        }

        @Override // h53.k
        public void f8(boolean z16) {
            q.a.a(this, z16);
        }

        @Override // h53.k
        public void onTextChanged(CharSequence s16, int start, int before, int count) {
            QUISingleLineInputView qUISingleLineInputView = b.this.inputView;
            QUISingleLineInputView qUISingleLineInputView2 = null;
            if (qUISingleLineInputView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputView");
                qUISingleLineInputView = null;
            }
            int e16 = qUISingleLineInputView.e();
            QUISingleLineInputView qUISingleLineInputView3 = b.this.inputView;
            if (qUISingleLineInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputView");
            } else {
                qUISingleLineInputView2 = qUISingleLineInputView3;
            }
            if (e16 > qUISingleLineInputView2.l()) {
                QQToast.makeText(b.this.context, R.string.x3g, 0).show();
            }
        }

        @Override // h53.q
        public void A4(String title) {
        }

        @Override // h53.k
        public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
        }
    }
}
