package yi;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.qzone.reborn.groupalbum.selectmedia.data.model.SearchMediaItemModel;
import com.qzone.reborn.util.r;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J/\u0010\r\u001a\u00020\u00042%\u0010\f\u001a!\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0007H\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016Jh\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000e26\u0010\u001b\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u001fH\u0016R\"\u0010'\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00150(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00130(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010*R\u0014\u00101\u001a\u00020/8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u00100\u00a8\u00064"}, d2 = {"Lyi/i;", "", "", "msgId", "", "i", "f", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "choose", "", "callBack", "e", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "cb", "d", "Landroid/view/View;", "itemView", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lzi/b;", "msgItemModel", TuxQuestionType.QUESTION_OPTION_CHECKBOX, "Lkotlin/Function2;", "isEnabled", "isFavEnabled", "setBottomBarState", "Landroid/view/View$OnClickListener;", "listener", "k", "", tl.h.F, "a", "Z", "g", "()Z", "j", "(Z)V", "chooseModel", "", "b", "Ljava/util/List;", "chooseListData", "c", "chooseItemModelList", "chooseRecordList", "", "I", "MULTI_SELECT_LIMIT", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean chooseModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private List<Long> chooseListData = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private List<zi.b> chooseItemModelList = new ArrayList();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<MsgRecord> chooseRecordList = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int MULTI_SELECT_LIMIT = 20;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"yi/i$a", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "onInitializeAccessibilityNodeInfo", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a extends View.AccessibilityDelegate {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MsgRecord f450394b;

        a(MsgRecord msgRecord) {
            this.f450394b = msgRecord;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(host, info);
            if (info != null) {
                info.setCheckable(true);
            }
            if (info == null) {
                return;
            }
            info.setChecked(i.this.i(this.f450394b.msgId));
        }
    }

    private final boolean f() {
        return this.chooseListData.size() >= this.MULTI_SELECT_LIMIT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i(long msgId) {
        return this.chooseListData.contains(Long.valueOf(msgId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(View.OnClickListener listener, View view) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(i this$0, MsgRecord msgRecord, zi.b msgItemModel, Function2 setBottomBarState, View itemView, QUICheckBox checkbox, View view) {
        String qqStr;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgRecord, "$msgRecord");
        Intrinsics.checkNotNullParameter(msgItemModel, "$msgItemModel");
        Intrinsics.checkNotNullParameter(setBottomBarState, "$setBottomBarState");
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(checkbox, "$checkbox");
        if (this$0.chooseListData.contains(Long.valueOf(msgRecord.msgId))) {
            this$0.chooseListData.remove(Long.valueOf(msgRecord.msgId));
            this$0.chooseItemModelList.remove(msgItemModel);
            this$0.chooseRecordList.remove(msgRecord);
            if (this$0.chooseRecordList.isEmpty()) {
                Boolean bool = Boolean.FALSE;
                setBottomBarState.invoke(bool, bool);
            } else {
                Boolean bool2 = Boolean.TRUE;
                setBottomBarState.invoke(bool2, bool2);
            }
        } else {
            if (this$0.f()) {
                try {
                    if (msgItemModel instanceof SearchMediaItemModel) {
                        qqStr = HardCodeUtil.qqStr(R.string.a1i);
                    } else {
                        qqStr = HardCodeUtil.qqStr(R.string.a1g);
                    }
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String qqStr2 = HardCodeUtil.qqStr(R.string.zka);
                    Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.chat_history_multi_select_limit)");
                    String format = String.format(qqStr2, Arrays.copyOf(new Object[]{qqStr}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    QQToast.makeText(itemView.getContext(), format, 0).show();
                    Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.biz.qui.quicheckbox.QUICheckBox");
                    ((QUICheckBox) view).setChecked(false);
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            this$0.chooseListData.add(Long.valueOf(msgRecord.msgId));
            this$0.chooseItemModelList.add(msgItemModel);
            this$0.chooseRecordList.add(msgRecord);
            Boolean bool3 = Boolean.TRUE;
            setBottomBarState.invoke(bool3, bool3);
        }
        this$0.d(checkbox, msgRecord.msgId);
    }

    public boolean d(QUICheckBox cb5, long msgId) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (getChooseModel()) {
            cb5.setVisibility(0);
            r rVar = r.f59560a;
            rVar.b(cb5, rVar.e(10));
            cb5.setChecked(i(msgId));
        } else {
            cb5.setVisibility(8);
        }
        return cb5.getVisibility() == 0;
    }

    public boolean e(Function1<? super Boolean, Unit> callBack) {
        j(!getChooseModel());
        if (callBack != null) {
            callBack.invoke(Boolean.valueOf(getChooseModel()));
        }
        if (!getChooseModel()) {
            this.chooseListData.clear();
            this.chooseItemModelList.clear();
            this.chooseRecordList.clear();
        }
        return getChooseModel();
    }

    /* renamed from: g, reason: from getter */
    public boolean getChooseModel() {
        return this.chooseModel;
    }

    public List<MsgRecord> h() {
        return this.chooseRecordList;
    }

    public void j(boolean z16) {
        this.chooseModel = z16;
    }

    public void k(final View itemView, final MsgRecord msgRecord, final zi.b msgItemModel, final QUICheckBox checkbox, final Function2<? super Boolean, ? super Boolean, Unit> setBottomBarState, final View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(msgItemModel, "msgItemModel");
        Intrinsics.checkNotNullParameter(checkbox, "checkbox");
        Intrinsics.checkNotNullParameter(setBottomBarState, "setBottomBarState");
        Intrinsics.checkNotNullParameter(listener, "listener");
        itemView.setOnClickListener(new View.OnClickListener() { // from class: yi.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.l(listener, view);
            }
        });
        checkbox.setOnClickListener(new View.OnClickListener() { // from class: yi.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.m(i.this, msgRecord, msgItemModel, setBottomBarState, itemView, checkbox, view);
            }
        });
        itemView.setAccessibilityDelegate(new a(msgRecord));
    }
}
