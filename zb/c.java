package zb;

import android.text.TextUtils;
import android.view.View;
import com.qzone.reborn.albumx.qzone.vas.event.QZonePhotoDegradeEvent;
import com.qzone.reborn.albumx.qzone.vas.widget.QZoneVasTopTipsView;
import com.qzone.reborn.base.l;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ho.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZonePhotoDegrade$Button;
import qzone.QZonePhotoDegrade$QueryNotifyMsgRsp;
import qzone.QZonePhotoDegrade$Text;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J*\u0010\u0015\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0014R\u0014\u0010\u0018\u001a\u00020\u00038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lzb/c;", "Lcom/qzone/reborn/base/l;", "Lqzone/QZonePhotoDegrade$QueryNotifyMsgRsp;", "", "content", "buttonText", "url", "", "y", "w", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "queryNotifyMsgRsp", "", "position", "", "", "payload", HippyTKDListViewAdapter.X, "e", "Ljava/lang/String;", "TAG", "Lcom/qzone/reborn/albumx/qzone/vas/widget/QZoneVasTopTipsView;", "f", "Lcom/qzone/reborn/albumx/qzone/vas/widget/QZoneVasTopTipsView;", "mTipsView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends l<QZonePhotoDegrade$QueryNotifyMsgRsp> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZAlbumxPhotoDegradeSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneVasTopTipsView mTipsView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(c this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        na.c.f419539a.c(1);
        this$0.w();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void w() {
        QZoneVasTopTipsView qZoneVasTopTipsView = this.mTipsView;
        if (qZoneVasTopTipsView != null) {
            qZoneVasTopTipsView.setVisibility(8);
        }
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        QZonePhotoDegradeEvent qZonePhotoDegradeEvent = new QZonePhotoDegradeEvent();
        qZonePhotoDegradeEvent.setForceClose(true);
        simpleEventBus.dispatchEvent(qZonePhotoDegradeEvent);
    }

    private final void y(String content, String buttonText, final String url) {
        QZoneVasTopTipsView qZoneVasTopTipsView = this.mTipsView;
        if (qZoneVasTopTipsView != null) {
            qZoneVasTopTipsView.setContent(content);
        }
        QZoneVasTopTipsView qZoneVasTopTipsView2 = this.mTipsView;
        if (qZoneVasTopTipsView2 != null) {
            qZoneVasTopTipsView2.setActionText(buttonText);
        }
        QZoneVasTopTipsView qZoneVasTopTipsView3 = this.mTipsView;
        if (qZoneVasTopTipsView3 != null) {
            qZoneVasTopTipsView3.setJumpListener(new View.OnClickListener() { // from class: zb.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.z(c.this, url, view);
                }
            });
        }
        QZoneVasTopTipsView qZoneVasTopTipsView4 = this.mTipsView;
        if (qZoneVasTopTipsView4 != null) {
            qZoneVasTopTipsView4.setCloseListener(new View.OnClickListener() { // from class: zb.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.A(c.this, view);
                }
            });
        }
        QZoneVasTopTipsView qZoneVasTopTipsView5 = this.mTipsView;
        if (qZoneVasTopTipsView5 == null) {
            return;
        }
        qZoneVasTopTipsView5.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(c this$0, String url, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        i.q(this$0.p(), url);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindData(QZonePhotoDegrade$QueryNotifyMsgRsp queryNotifyMsgRsp, int position, List<Object> payload) {
        if ((queryNotifyMsgRsp != null ? queryNotifyMsgRsp.f430342msg : null) != null) {
            na.c cVar = na.c.f419539a;
            List<QZonePhotoDegrade$Text> list = queryNotifyMsgRsp.f430342msg.texts.get();
            Intrinsics.checkNotNullExpressionValue(list, "queryNotifyMsgRsp.msg.texts.get()");
            String j3 = cVar.j(list);
            List<QZonePhotoDegrade$Button> list2 = queryNotifyMsgRsp.f430342msg.buttons.get();
            RFWLog.d(this.TAG, RFWLog.USR, "requestPhotoDegradeNotify onSuccess: " + j3 + ", button: " + list2.size());
            if (!TextUtils.isEmpty(j3) && list2.size() > 0) {
                QZonePhotoDegrade$Button qZonePhotoDegrade$Button = list2.get(0);
                String str = qZonePhotoDegrade$Button.f430341msg.get();
                Intrinsics.checkNotNullExpressionValue(str, "button.msg.get()");
                String str2 = qZonePhotoDegrade$Button.url.get();
                Intrinsics.checkNotNullExpressionValue(str2, "button.url.get()");
                y(j3, str, str2);
                return;
            }
            w();
            return;
        }
        w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        this.mTipsView = containerView != null ? (QZoneVasTopTipsView) containerView.findViewById(R.id.f162767mj0) : null;
    }
}
