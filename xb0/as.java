package xb0;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QFSLayerFloatShowEvent;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;
import p40.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014\u00a8\u0006\u000b"}, d2 = {"Lxb0/as;", "Lcom/tencent/biz/qqcircle/share/QCircleBaseShareOperation;", "", "M", "G", "", "y", "Lcom/tencent/biz/qqcircle/share/QCircleBaseShareOperation$a;", "builder", "<init>", "(Lcom/tencent/biz/qqcircle/share/QCircleBaseShareOperation$a;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class as extends QCircleBaseShareOperation {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"xb0/as$a", "Lp40/f$d;", "", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class a extends f.d {
        a() {
        }

        @Override // p40.f.d
        public void a() {
            as.this.M();
        }
    }

    public as(@Nullable QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        if (((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(MobileQQ.sMobileQQ) && !p40.u.H().l0()) {
            p40.u.H().B();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        d(QCircleDaTongConstant.ElementParamValue.SMALL_WINDOW, null);
        QCircleShareInfo t16 = t();
        if (t16 != null) {
            if (!p40.o.d(QCirclePluginUtil.getQCircleInitBean(f())) && !p40.o.f(QCirclePluginUtil.getQCircleInitBean(f()))) {
                p40.u.H().I0(t16.feed, f(), "share", m(), new a());
            } else if (((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(MobileQQ.sMobileQQ)) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSLayerFloatShowEvent(QFSLayerFloatShowEvent.EVENT_TYPE_SHARE_PANEL_TRIGGER));
            } else {
                ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialog(f());
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
