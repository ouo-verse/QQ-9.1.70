package yj;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.base.k;
import com.qzone.reborn.intimate.bean.QZoneAlbumSyncBean;
import com.qzone.reborn.intimate.event.QZoneIntimateAlbumSyncEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.ae;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u001e\u0010\n\u001a\u00020\u00032\u0014\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006H\u0002J\u001e\u0010\u000b\u001a\u00020\u00032\u0014\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lyj/h;", "Lcom/qzone/reborn/base/k;", "Lqj/d;", "", "K9", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumSyncBean;", "listUIStateData", "F9", "H9", "G9", "M9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "bean", "F2", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "mAlbumFooterView", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "e", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mAlbumSyncButton", "Lnk/ae;", "f", "Lnk/ae;", "mAlbumViewModel", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h extends k implements qj.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mAlbumFooterView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUIButton mAlbumSyncButton;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ae mAlbumViewModel;

    private final void G9() {
        ae aeVar = this.mAlbumViewModel;
        ae aeVar2 = null;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar = null;
        }
        if (bl.b(aeVar.X1())) {
            RFWLog.e("QZoneIntimateAlbumSyncOperatePart", RFWLog.USR, "[handleAlbumSyncClick] select none album");
            return;
        }
        ae aeVar3 = this.mAlbumViewModel;
        if (aeVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar3 = null;
        }
        ae aeVar4 = this.mAlbumViewModel;
        if (aeVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            aeVar2 = aeVar4;
        }
        aeVar3.g2(aeVar2.X1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(h this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F9(uIStateData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(h this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            this$0.M9();
        }
    }

    private final void K9() {
        registerIoc(this, qj.d.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void M9() {
        ae aeVar = this.mAlbumViewModel;
        ae aeVar2 = null;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar = null;
        }
        if (bl.b(aeVar.X1())) {
            RFWLog.e("QZoneIntimateAlbumSyncOperatePart", RFWLog.USR, "[handleAlbumSyncClick] select none album");
            return;
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        ae aeVar3 = this.mAlbumViewModel;
        if (aeVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar3 = null;
        }
        String spaceId = aeVar3.U1().getSpaceId();
        ae aeVar4 = this.mAlbumViewModel;
        if (aeVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            aeVar2 = aeVar4;
        }
        simpleEventBus.dispatchEvent(new QZoneIntimateAlbumSyncEvent(aeVar2.X1(), spaceId));
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void initData() {
        ViewModel viewModel = getViewModel(ae.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026yncViewModel::class.java)");
        ae aeVar = (ae) viewModel;
        this.mAlbumViewModel = aeVar;
        ae aeVar2 = null;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            aeVar = null;
        }
        aeVar.S1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: yj.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.I9(h.this, (UIStateData) obj);
            }
        });
        ae aeVar3 = this.mAlbumViewModel;
        if (aeVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            aeVar2 = aeVar3;
        }
        aeVar2.T1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: yj.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                h.J9(h.this, (Boolean) obj);
            }
        });
    }

    @Override // qj.d
    public void F2(QZoneAlbumSyncBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        QUIButton qUIButton = this.mAlbumSyncButton;
        ae aeVar = null;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumSyncButton");
            qUIButton = null;
        }
        ae aeVar2 = this.mAlbumViewModel;
        if (aeVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            aeVar = aeVar2;
        }
        qUIButton.setEnabled(!bl.b(aeVar.W1()));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.f162880n42);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.qzo\u2026timate_album_sync_footer)");
            this.mAlbumFooterView = (FrameLayout) findViewById;
            View findViewById2 = rootView.findViewById(R.id.n3x);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.qzo\u2026timate_album_sync_button)");
            QUIButton qUIButton = (QUIButton) findViewById2;
            this.mAlbumSyncButton = qUIButton;
            if (qUIButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumSyncButton");
                qUIButton = null;
            }
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: yj.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.L9(h.this, view);
                }
            });
        }
        K9();
        initData();
    }

    private final void F9(UIStateData<List<QZoneAlbumSyncBean>> listUIStateData) {
        if (listUIStateData == null) {
            return;
        }
        int state = listUIStateData.getState();
        if (state == 2 || state == 3) {
            H9(listUIStateData);
        }
    }

    private final void H9(UIStateData<List<QZoneAlbumSyncBean>> listUIStateData) {
        if (listUIStateData == null) {
            QLog.e("QZoneIntimateAlbumSyncOperatePart", 1, "ui state data is null");
            return;
        }
        FrameLayout frameLayout = this.mAlbumFooterView;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumFooterView");
            frameLayout = null;
        }
        frameLayout.setVisibility(new ArrayList(listUIStateData.getData()).size() > 0 ? 0 : 8);
    }
}
