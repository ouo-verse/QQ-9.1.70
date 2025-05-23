package t9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.reborn.albumx.common.bean.CommonAlbumUploadYellowDiamondShowEvent;
import com.qzone.reborn.base.k;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0019\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00170\u0016j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0017`\u0018H\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001c\u00a8\u0006\""}, d2 = {"Lt9/c;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "E9", "", "isShowBottom", "I9", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumUploadYellowDiamondShowEvent;", "event", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "mYellowDiamondTipsContainerOriginalGv", "e", "mYellowDiamondTipsContainerOriginalBottom", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends k implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mYellowDiamondTipsContainerOriginalGv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mYellowDiamondTipsContainerOriginalBottom;

    private final void E9() {
        Intent intent = new Intent();
        intent.putExtra("aid", "jhan_xcsc");
        intent.putExtra("direct_go", true);
        VipComponentProxy.f50997g.getUiInterface().goOpenYellowVip(getActivity(), intent, -1);
    }

    private final void F9(CommonAlbumUploadYellowDiamondShowEvent event) {
        I9(event.isShowBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I9(boolean isShowBottom) {
        na.c cVar = na.c.f419539a;
        RelativeLayout relativeLayout = null;
        if (cVar.e() && cVar.f()) {
            RelativeLayout relativeLayout2 = this.mYellowDiamondTipsContainerOriginalGv;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondTipsContainerOriginalGv");
                relativeLayout2 = null;
            }
            relativeLayout2.setVisibility(8);
            RelativeLayout relativeLayout3 = this.mYellowDiamondTipsContainerOriginalBottom;
            if (relativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondTipsContainerOriginalBottom");
            } else {
                relativeLayout = relativeLayout3;
            }
            relativeLayout.setVisibility(8);
            return;
        }
        if (LoginData.getInstance().isQzoneVip()) {
            RelativeLayout relativeLayout4 = this.mYellowDiamondTipsContainerOriginalGv;
            if (relativeLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondTipsContainerOriginalGv");
                relativeLayout4 = null;
            }
            relativeLayout4.setVisibility(8);
            RelativeLayout relativeLayout5 = this.mYellowDiamondTipsContainerOriginalBottom;
            if (relativeLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondTipsContainerOriginalBottom");
            } else {
                relativeLayout = relativeLayout5;
            }
            relativeLayout.setVisibility(8);
            return;
        }
        if (isShowBottom) {
            RelativeLayout relativeLayout6 = this.mYellowDiamondTipsContainerOriginalGv;
            if (relativeLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondTipsContainerOriginalGv");
                relativeLayout6 = null;
            }
            relativeLayout6.setVisibility(8);
            RelativeLayout relativeLayout7 = this.mYellowDiamondTipsContainerOriginalBottom;
            if (relativeLayout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondTipsContainerOriginalBottom");
            } else {
                relativeLayout = relativeLayout7;
            }
            relativeLayout.setVisibility(0);
            return;
        }
        RelativeLayout relativeLayout8 = this.mYellowDiamondTipsContainerOriginalGv;
        if (relativeLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondTipsContainerOriginalGv");
            relativeLayout8 = null;
        }
        relativeLayout8.setVisibility(0);
        RelativeLayout relativeLayout9 = this.mYellowDiamondTipsContainerOriginalGv;
        if (relativeLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondTipsContainerOriginalGv");
            relativeLayout9 = null;
        }
        ViewExtKt.c(relativeLayout9, ar.d(10.0f));
        RelativeLayout relativeLayout10 = this.mYellowDiamondTipsContainerOriginalGv;
        if (relativeLayout10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondTipsContainerOriginalGv");
            relativeLayout10 = null;
        }
        ViewExtKt.f(relativeLayout10, ar.d(10.0f));
        RelativeLayout relativeLayout11 = this.mYellowDiamondTipsContainerOriginalBottom;
        if (relativeLayout11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondTipsContainerOriginalBottom");
        } else {
            relativeLayout = relativeLayout11;
        }
        relativeLayout.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.x5d);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(co\u2026d.gv_bottom_vip_text_bar)");
        this.mYellowDiamondTipsContainerOriginalGv = (RelativeLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.vt7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(co\u2026load_bottom_vip_text_bar)");
        this.mYellowDiamondTipsContainerOriginalBottom = (RelativeLayout) findViewById2;
        RelativeLayout relativeLayout = this.mYellowDiamondTipsContainerOriginalGv;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondTipsContainerOriginalGv");
            relativeLayout = null;
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: t9.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.G9(c.this, view);
            }
        });
        RelativeLayout relativeLayout3 = this.mYellowDiamondTipsContainerOriginalBottom;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mYellowDiamondTipsContainerOriginalBottom");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: t9.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.H9(c.this, view);
            }
        });
        I9(true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof CommonAlbumUploadYellowDiamondShowEvent) {
            F9((CommonAlbumUploadYellowDiamondShowEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(CommonAlbumUploadYellowDiamondShowEvent.class);
        return arrayListOf;
    }
}
