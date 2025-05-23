package yd3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.SoftKeyboardStateHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.aigc.data.Imagery;
import com.tencent.mobileqq.zplan.aigc.vm.SuitCreateTechFragmentViewModel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.aigc.view.SuitPagView;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 22\u00020\u00012\u00020\u0002:\u0001=B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\tH\u0014J\u0006\u0010\u0012\u001a\u00020\u0007J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0014J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006>"}, d2 = {"Lyd3/d;", "Lyd3/e;", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper$SoftKeyboardStateListener;", "", "prompt", "", "J9", "", "K9", "Landroid/view/View;", "view", "P9", "M9", "", "z9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "initAfterInflation", "initViewModel", "Landroid/os/Bundle;", "args", "B9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onDismiss", "keyboardHeightInPx", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel;", "mSuitTechViewModel", "Landroid/widget/EditText;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/EditText;", "mPromptEditText", "D", "Landroid/view/View;", "mPromptRootView", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "mBackBtn", "Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", "mBackgroundPag", "", "G", "J", "mUgcId", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper;", "H", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper;", "mKeyboardStateHelper", "I", "Ljava/lang/String;", "mSelectDescription", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d extends e implements SoftKeyboardStateHelper.SoftKeyboardStateListener {
    private static final Regex K = new Regex("^[\\u4e00-\\u9fa5\uff0c\u3002,.]+$");

    /* renamed from: C, reason: from kotlin metadata */
    private EditText mPromptEditText;

    /* renamed from: D, reason: from kotlin metadata */
    private View mPromptRootView;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mBackBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private SuitPagView mBackgroundPag;

    /* renamed from: G, reason: from kotlin metadata */
    private long mUgcId;

    /* renamed from: H, reason: from kotlin metadata */
    private SoftKeyboardStateHelper mKeyboardStateHelper;

    /* renamed from: I, reason: from kotlin metadata */
    private String mSelectDescription;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private SuitCreateTechFragmentViewModel mSuitTechViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"yd3/d$b", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "", "d", "Ljava/lang/String;", "getBeforeText", "()Ljava/lang/String;", "setBeforeText", "(Ljava/lang/String;)V", "beforeText", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements TextWatcher {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private String beforeText;

        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s16) {
            boolean endsWith$default;
            CharSequence trim;
            QLog.d(d.this.TAG, 1, "afterTextChanged " + ((Object) s16) + " ");
            String valueOf = String.valueOf(s16);
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(valueOf, "\n", false, 2, null);
            if (endsWith$default && d.this.J9(valueOf)) {
                d dVar = d.this;
                trim = StringsKt__StringsKt.trim((CharSequence) valueOf);
                dVar.K9(trim.toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s16, int start, int count, int after) {
            QLog.d(d.this.TAG, 1, "beforeTextChanged " + ((Object) s16) + " start:" + start + ", count:" + count + ", after:" + after);
            this.beforeText = s16 != null ? s16.toString() : null;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s16, int start, int before, int count) {
            QLog.d(d.this.TAG, 1, "onTextChanged " + ((Object) s16) + " start:" + start + ", count:" + count + ", before:" + before);
            if ((s16 != null ? s16.length() : 0) <= 30 || before != 0) {
                return;
            }
            QQToastUtil.showQQToast(0, "\u6700\u591a\u8f93\u516530\u4e2a\u5b57");
            String str = this.beforeText;
            if (str != null && str.length() == 30) {
                EditText editText = d.this.mPromptEditText;
                if (editText != null) {
                    String str2 = this.beforeText;
                    if (str2 == null) {
                        str2 = "";
                    }
                    editText.setText(str2);
                }
                EditText editText2 = d.this.mPromptEditText;
                if (editText2 != null) {
                    editText2.setSelection(start);
                    return;
                }
                return;
            }
            EditText editText3 = d.this.mPromptEditText;
            if (editText3 != null) {
                editText3.setText(s16 != null ? s16.subSequence(0, 30) : null);
            }
            EditText editText4 = d.this.mPromptEditText;
            if (editText4 != null) {
                editText4.setSelection(30);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"yd3/d$c", "Landroid/widget/TextView$OnEditorActionListener;", "Landroid/widget/TextView;", "v", "", "actionId", "Landroid/view/KeyEvent;", "event", "", "onEditorAction", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class c implements TextView.OnEditorActionListener {
        c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView v3, int actionId, KeyEvent event) {
            String str;
            CharSequence trim;
            Editable text;
            QLog.d(d.this.TAG, 1, "IME_ACTION_DONE ~~~~" + actionId);
            if (actionId != 0 && actionId != 6) {
                return false;
            }
            EditText editText = d.this.mPromptEditText;
            if (editText == null || (text = editText.getText()) == null || (str = text.toString()) == null) {
                str = "";
            }
            if (d.this.J9(str)) {
                d dVar = d.this;
                trim = StringsKt__StringsKt.trim((CharSequence) str);
                dVar.K9(trim.toString());
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean J9(String prompt) {
        CharSequence trim;
        if (!TextUtils.isEmpty(prompt)) {
            trim = StringsKt__StringsKt.trim((CharSequence) prompt);
            if (K.matches(trim.toString())) {
                return true;
            }
            QQToastUtil.showQQToast(-1, "\u8bf7\u52ff\u8f93\u5165\u82f1\u6587\u5b57\u6bcd\u6216\u8005\u7279\u6b8a\u7b26\u53f7");
            return false;
        }
        QQToastUtil.showQQToast(-1, "\u8bf7\u8f93\u5165\u5173\u952e\u8bcd");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(final String prompt) {
        runOnActivityUiThread(new Runnable() { // from class: yd3.a
            @Override // java.lang.Runnable
            public final void run() {
                d.L9(prompt, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(String prompt, d this$0) {
        MutableLiveData<Imagery> p26;
        SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel;
        Intrinsics.checkNotNullParameter(prompt, "$prompt");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Imagery imagery = null;
        if (Intrinsics.areEqual(prompt, this$0.mSelectDescription) && (suitCreateTechFragmentViewModel = this$0.mSuitTechViewModel) != null) {
            imagery = suitCreateTechFragmentViewModel.getSelectImagery();
        }
        if (imagery == null) {
            imagery = new Imagery(0, 0, null, prompt, null, null, null, null, 246, null);
        }
        SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel2 = this$0.mSuitTechViewModel;
        if (suitCreateTechFragmentViewModel2 != null) {
            suitCreateTechFragmentViewModel2.D3(imagery);
        }
        SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel3 = this$0.mSuitTechViewModel;
        if (suitCreateTechFragmentViewModel3 != null && (p26 = suitCreateTechFragmentViewModel3.p2()) != null) {
            p26.postValue(imagery);
        }
        this$0.M9(this$0.mPromptEditText);
        this$0.x9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(d this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M9(this$0.mPromptRootView);
        this$0.x9();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // yd3.e
    public void B9(Bundle args) {
        String str;
        Editable text;
        MutableLiveData<Boolean> w26;
        super.B9(args);
        QLog.i(this.TAG, 1, "onShow ~~~~");
        SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel = this.mSuitTechViewModel;
        if (suitCreateTechFragmentViewModel != null && (w26 = suitCreateTechFragmentViewModel.w2()) != null) {
            w26.postValue(Boolean.TRUE);
        }
        this.mUgcId = args != null ? args.getLong("ugcid") : 0L;
        if (args == null || (str = args.getString("description")) == null) {
            str = "";
        }
        this.mSelectDescription = str;
        QLog.d(this.TAG, 1, "mSelectDescription ~~~~" + str);
        EditText editText = this.mPromptEditText;
        if (editText != null) {
            String str2 = this.mSelectDescription;
            editText.setText(str2 != null ? str2 : "");
        }
        EditText editText2 = this.mPromptEditText;
        if (editText2 != null && (text = editText2.getText()) != null) {
            int length = text.length();
            EditText editText3 = this.mPromptEditText;
            if (editText3 != null) {
                editText3.setSelection(length);
            }
        }
        SuitPagView suitPagView = this.mBackgroundPag;
        if (suitPagView != null) {
            SuitPagView.v(suitPagView, "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_loading_bg_slow.pag", false, 2, null);
        }
        View view = this.mPromptRootView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: yd3.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    d.N9(view2);
                }
            });
        }
        EditText editText4 = this.mPromptEditText;
        if (editText4 != null) {
            editText4.setCursorVisible(true);
        }
        EditText editText5 = this.mPromptEditText;
        if (editText5 != null) {
            editText5.setOnEditorActionListener(new c());
        }
        if (this.mKeyboardStateHelper == null) {
            SoftKeyboardStateHelper softKeyboardStateHelper = new SoftKeyboardStateHelper(getPartRootView());
            softKeyboardStateHelper.addSoftKeyboardStateListener(this);
            this.mKeyboardStateHelper = softKeyboardStateHelper;
        }
        P9(this.mPromptEditText);
        ImageView imageView = this.mBackBtn;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: yd3.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    d.O9(d.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // yd3.e, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        QLog.i(this.TAG, 1, "initAfterInflation ~~~~");
        this.mPromptEditText = (EditText) rootView.findViewById(R.id.qoh);
        this.mPromptRootView = rootView.findViewById(R.id.qoi);
        this.mBackBtn = (ImageView) rootView.findViewById(R.id.qof);
        this.mBackgroundPag = (SuitPagView) rootView.findViewById(R.id.qov);
        View findViewById = rootView.findViewById(R.id.qog);
        if (findViewById != null) {
            com.tencent.mobileqq.zplan.aigc.utils.a aVar = com.tencent.mobileqq.zplan.aigc.utils.a.f330690a;
            Context context = rootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
            findViewById.setPadding(0, aVar.c(context), 0, 0);
        }
        EditText editText = this.mPromptEditText;
        if (editText != null) {
            editText.addTextChangedListener(new b());
        }
    }

    public final void initViewModel() {
        Fragment parentFragment;
        Fragment hostFragment = getHostFragment();
        if (hostFragment == null || (parentFragment = hostFragment.getParentFragment()) == null) {
            return;
        }
        SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel = (SuitCreateTechFragmentViewModel) new ViewModelProvider(parentFragment).get(SuitCreateTechFragmentViewModel.class);
        this.mSuitTechViewModel = suitCreateTechFragmentViewModel;
        QLog.d(this.TAG, 1, "mSuitTechViewModel instance is " + suitCreateTechFragmentViewModel + ", parentFragment instance is " + parentFragment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // yd3.e
    public void onDismiss() {
        MutableLiveData<Boolean> w26;
        super.onDismiss();
        EditText editText = this.mPromptEditText;
        if (editText != null) {
            editText.setText((CharSequence) null);
        }
        SoftKeyboardStateHelper softKeyboardStateHelper = this.mKeyboardStateHelper;
        if (softKeyboardStateHelper != null) {
            softKeyboardStateHelper.removeAllSoftKeyboardStateListeners();
        }
        this.mKeyboardStateHelper = null;
        SuitCreateTechFragmentViewModel suitCreateTechFragmentViewModel = this.mSuitTechViewModel;
        if (suitCreateTechFragmentViewModel != null && (w26 = suitCreateTechFragmentViewModel.w2()) != null) {
            w26.postValue(Boolean.FALSE);
        }
        SuitPagView suitPagView = this.mBackgroundPag;
        if (suitPagView != null) {
            suitPagView.w();
        }
    }

    @Override // yd3.e, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        QLog.i(this.TAG, 1, "onInitView ~~~~");
        super.onInitView(rootView);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QLog.i(this.TAG, 1, "onPartResume ~~~~");
    }

    @Override // com.tencent.mobileqq.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
    public void onSoftKeyboardClosed() {
        x9();
    }

    @Override // yd3.e
    public int z9() {
        return R.id.qqb;
    }

    private final void M9(View view) {
        if (view != null) {
            Object systemService = BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private final void P9(View view) {
        if (view != null) {
            Object systemService = BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            view.requestFocus();
            ((InputMethodManager) systemService).showSoftInput(view, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(View view) {
    }

    @Override // com.tencent.mobileqq.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
    public void onSoftKeyboardOpened(int keyboardHeightInPx) {
    }
}
